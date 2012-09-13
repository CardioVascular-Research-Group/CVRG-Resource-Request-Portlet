package com.jhu.cvrg.portal.resourcerequest.backing;
/*
Copyright 2011 Johns Hopkins University Institute for Computational Medicine

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
/**
* @author Chris Jurado
* 
*/
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.portletfaces.liferay.faces.context.LiferayFacesContext;
import org.portletfaces.liferay.faces.helper.LongHelper;

import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException;
import com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest;
import com.jhu.cvrg.portal.resourcerequest.model.TransactionList;
import com.jhu.cvrg.portal.resourcerequest.service.ResourceRequestLocalServiceUtil;
import com.jhu.cvrg.portal.resourcerequest.service.TransactionLocalServiceUtil;
import com.jhu.cvrg.portal.resourcerequest.utility.ResourceUtility;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Team;
import com.liferay.portal.model.User;
import com.liferay.portal.service.TeamLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

@ManagedBean(name = "resourceResponseBacking")
@ViewScoped
public class ResourceResponseBacking {

	private boolean pendingMainVisible;
	private boolean responseFormVisible;
	private boolean finalPanelVisible;

	private LiferayFacesContext liferayFacesContext;
	
	private User requestingUser;
	private User currentUser;
	private Team requestedStudy;
	private ResourceRequest resourceRequest;
	long resourceRequestId;
	
	private boolean allowAccess = false;
	private String comment;

	private final String DENY_ACCESS = "Access Denied";
	private final String APPROVE_ACCESS = "Access Approved";
	
	private enum ShowPanel {MAIN, RESPONSE, THANKS}
	
	public ResourceResponseBacking(){
		initialize();
	}
	
	public void initialize(){
		
		switchView(ShowPanel.MAIN);
		
		comment="";
		requestingUser = null;
		requestedStudy = null;
	}
	
	private void switchView(ShowPanel panel){
		pendingMainVisible = false;
		responseFormVisible = false;
		finalPanelVisible = false;
		
		switch (panel){
		case MAIN: 		pendingMainVisible = true; 		break;
		case RESPONSE: 	responseFormVisible = true;		break;
		case THANKS:	finalPanelVisible = true;		break;
		default:		switchView(ShowPanel.MAIN);		break;
		}
	}
	
	public void processTabChange(TabChangeEvent e){
		ResourceUtility.changeTab();
	}

	//User submits decision to Allow or Deny Access on selected request.
	public void submit(ActionEvent event){	
		try {
			currentUser = ResourceUtility.getCurrentUser();

			if(allowAccess){
				addMemberToTeam();
			}else{
				denyAccess();
			}	
			addTransaction(allowAccess);
			emailRecipients(allowAccess);

		} catch (NumberFormatException e) {
			ResourceUtility.printErrorMessage("Response Bean");
			e.printStackTrace();
		} 
		switchView(ShowPanel.THANKS);
	}
	

	private void emailRecipients(boolean allowAccess){
		
		String message;
		InternetAddress[] to;
		InternetAddress from;

		try {
		to = new InternetAddress[]{new InternetAddress(currentUser.getEmailAddress())};

		from = new InternetAddress(currentUser.getEmailAddress());

		String subject = "Access to " + ResourceUtility.convertToStudyName(requestedStudy.getTeamId()) + " has been ";
		
		if(allowAccess){
			subject = subject + "approved.";
			message = "Welcome!";
		}
		else{
			subject = subject + "denied.";
			message = comment;
		}

		StringBuffer body = new StringBuffer();

		body.append("First Name: " + currentUser.getFirstName() + "\n");
		body.append("Last Name: " + currentUser.getLastName() + "\n");
		body.append("Email:" + currentUser.getEmailAddress() + "\n");
		body.append("Requested Resource:" + ResourceUtility.convertToStudyName(requestedStudy.getTeamId()) + "\n");
		body.append("Message:\n");
		body.append(message);

		MailEngine.send(from, to, subject, body.toString());
		} catch (MailEngineException e) {
			ResourceUtility.printErrorMessage("Request Bean");
			e.printStackTrace();
		} catch (AddressException e) {
			ResourceUtility.printErrorMessage("Request Bean");
			e.printStackTrace();
		}


	}

	
	//Access Denied.  Update status of request record.
	private void denyAccess(){
		try {
			ResourceRequestLocalServiceUtil.updateStatus(resourceRequestId, false);
		} catch (NoSuchResourceRequestException e) {
			ResourceUtility.printErrorMessage("Response Bean");
			e.printStackTrace();
		} catch (PortalException e) {
			ResourceUtility.printErrorMessage("Response Bean");
			e.printStackTrace();
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Response Bean");
			e.printStackTrace();
		}
	}
	
	//Access granted.  Update Status of request record and member access
	private void addMemberToTeam(){
		
		long groupId = ResourceUtility.getCurrentGroupId();
		long[] userArray = new long[]{requestingUser.getUserId()};
		
		try {
		if(!ResourceUtility.isUserCommunityMember(requestingUser.getUserId(), groupId)){
			UserLocalServiceUtil.addGroupUsers(groupId, userArray);
		}
		UserLocalServiceUtil.addTeamUsers(requestedStudy.getTeamId(), userArray);
		ResourceRequestLocalServiceUtil.updateStatus(resourceRequestId, true);
		
		} catch (PortalException e) {
			ResourceUtility.printErrorMessage("Response Bean");
			e.printStackTrace();
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Response Bean");
			e.printStackTrace();
		}
	}
	
	//Add decision to transaction database record
	private void addTransaction(boolean allow){
		String accessAllowed;
		if(allow){
			accessAllowed = APPROVE_ACCESS;
		}else{
			accessAllowed = DENY_ACCESS;
		}
		try {
		
			TransactionLocalServiceUtil.addTransaction(currentUser.getUserId(), accessAllowed, requestingUser.getUserId(), requestedStudy.getTeamId(), comment, "");
		} catch (PortalException e) {
			ResourceUtility.printErrorMessage("Response Bean");
			e.printStackTrace();
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Response Bean");
			e.printStackTrace();
		}
		
		refreshHistoryView();
	}
	
	private void refreshHistoryView(){
		TransactionList transactionList = (TransactionList) liferayFacesContext
		.getApplication().getELResolver().getValue(
				liferayFacesContext.getELContext(), null, "transactionList");
		transactionList.init();
	}

	//Cancel current activity and return to main view.
	public void cancel(ActionEvent event){
		initialize();
	}
	
	//Select record from table
	public void respond(ActionEvent event){

		liferayFacesContext = LiferayFacesContext.getInstance();

		long requestingUserId = LongHelper.toLong(liferayFacesContext.getExternalContext().getRequestParameterMap().get("requestingUserId"), 0L);
		long teamId = LongHelper.toLong(liferayFacesContext.getExternalContext().getRequestParameterMap().get("requestedStudyId"), 0L);
		resourceRequestId = LongHelper.toLong(liferayFacesContext.getExternalContext().getRequestParameterMap().get("resourceRequestId"), 0L);

		try {
			requestingUser = UserLocalServiceUtil.getUser(requestingUserId);
			requestedStudy = TeamLocalServiceUtil.getTeam(teamId);
			comment = "";
			setResourceRequest(ResourceRequestLocalServiceUtil.getResourceRequest(resourceRequestId));
		} catch (PortalException e) {
			ResourceUtility.printErrorMessage("Response Bean");
			e.printStackTrace();
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Response Bean");
			e.printStackTrace();
		}	
		switchView(ShowPanel.RESPONSE);
	}

	//Setters and getters
	public boolean isPendingMainVisible() {
		return pendingMainVisible;
	}
	
	public boolean isResponseFormVisible() {
		return responseFormVisible;
	}

	public boolean isFinalPanelVisible() {
		return finalPanelVisible;
	}

	public void setAllowAccess(boolean allowAccess) {
		this.allowAccess = allowAccess;
	}

	public boolean isAllowAccess() {
		return allowAccess;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public long getRequestedStudyId() {
		return requestedStudy.getTeamId();
	}
	
	public String getRequestedStudyName() {
		return requestedStudy.getName();
	}
	
	public User getRequestingUser() {
		return requestingUser;
	}

	public void setRequestingUser(User requestingUser) {
		this.requestingUser = requestingUser;
	}

	public void setResourceRequest(ResourceRequest resourceRequest) {
		this.resourceRequest = resourceRequest;
	}

	public ResourceRequest getResourceRequest() {
		return resourceRequest;
	}
}
