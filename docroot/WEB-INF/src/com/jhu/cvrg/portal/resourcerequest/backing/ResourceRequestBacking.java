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
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import org.portletfaces.liferay.faces.context.LiferayFacesContext;

import com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest;
import com.jhu.cvrg.portal.resourcerequest.service.ResourceRequestLocalServiceUtil;
import com.jhu.cvrg.portal.resourcerequest.utility.ResourceUtility;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Team;
import com.liferay.portal.model.User;
import com.liferay.portal.service.TeamLocalServiceUtil;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

@ManagedBean(name = "resourceRequestBacking")
@ViewScoped
public class ResourceRequestBacking {
	
	private String greeting, DEFAULT_TYPE, saved, thankyou;
	private PortletPreferences prefs;
	private String message, type;
	private ArrayList<SelectItem> studyList;
	private boolean storeCopy, copyUser, reminderSent;
	private long selectedStudyId;
	private User currentUser;
	private boolean formVisible, thanksVisible, duplicateVisible;
	private enum ShowPanel {MAIN, THANKS, DUPLICATE};
	private String originalRequestDate;
	
	public ResourceRequestBacking(){

		DEFAULT_TYPE = "Please choose...";
		
		setCurrentUser(ResourceUtility.getCurrentUser());
		LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
		PortletPreferences prefs = liferayFacesContext.getPortletPreferences();

		greeting = prefs.getValue("greeting", "To request access, please complete this form.");
		thankyou = prefs.getValue("thankyou", "Thanks!");
		saved = "";
		
		clearForm();		

		buildStudyList();	

		
	}
	
	private void switchView(ShowPanel panel){
		formVisible = false;
		thanksVisible = false;
		duplicateVisible = false;
		
		switch (panel){
		case MAIN: 		formVisible = true; 			break;
		case THANKS:	thanksVisible = true;			break;
		case DUPLICATE: duplicateVisible = true;		break;
		default:		switchView(ShowPanel.MAIN);		break;
		}
	}
	
	private void buildStudyList(){
		studyList = new ArrayList<SelectItem>();
		List<Team> studies;
		int teamCount;
		try {
			teamCount = TeamLocalServiceUtil.getTeamsCount();
			studies = TeamLocalServiceUtil.getTeams(0, teamCount);
			studyList.add(new SelectItem(0, DEFAULT_TYPE));
			for(Team study : studies){
				SelectItem item = new SelectItem(study.getTeamId(), study.getName());
				studyList.add(item);
			}
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Request Bean");
			e.printStackTrace();
		}

	}
	
	public void back(ActionEvent event){
		clearForm();
	}
	
	public void save(ActionEvent event) {

		try {
			prefs.setValue("greeting", greeting);
			prefs.setValue("thankyou", thankyou);
			prefs.store();
		} catch (ReadOnlyException e) {
			e.printStackTrace();
		} catch (ValidatorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		saved = "Preferences Saved.";
	}
	
	public void submit(ActionEvent event){
		if(isDuplicateRequest()){
			switchView(ShowPanel.DUPLICATE);
			return;
		}
		storeRequest();
		emailRecipients();
		switchView(ShowPanel.THANKS);
	}
	
	public void sendReminder(ActionEvent event){
		emailRecipients();
		reminderSent = true;
	}
	
	private boolean isDuplicateRequest(){
		boolean duplicate = false;
		try {
			List<ResourceRequest> requests = ResourceRequestLocalServiceUtil.findByStudy(selectedStudyId);
			for(ResourceRequest request : requests){
				if(request.getRequesterId() == currentUser.getUserId()){
					duplicate = true;
					originalRequestDate = DateFormat.getInstance().format(request.getDateSent());
				}
			}
		
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Request Bean");
			e.printStackTrace();
		}
		
		return duplicate;
	}
	
	
	
	private void storeRequest(){
		try {
			ResourceRequestLocalServiceUtil.addResourceRequest(currentUser.getUserId(), selectedStudyId, message, "");
		} catch (PortalException e) {
			ResourceUtility.printErrorMessage("Request Bean");
			e.printStackTrace();
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Request Bean");
			e.printStackTrace();
		}
	}
	
	private void clearForm(){
		setCurrentUser(ResourceUtility.getCurrentUser());
		message = "";
		reminderSent = false;
		switchView(ShowPanel.MAIN);
	}
	
	private void emailRecipients(){
		
		InternetAddress[] to;
		InternetAddress from;
		
		User approver = ResourceUtility.getApprover(selectedStudyId);
		try {		
		if(copyUser){

				to = new InternetAddress[]{new InternetAddress(approver.getEmailAddress()), 
						new InternetAddress(currentUser.getEmailAddress())};

		}else{
			to = new InternetAddress[]{new InternetAddress(approver.getEmailAddress())};
		}

		from = new InternetAddress(currentUser.getEmailAddress());

		String subject =
			currentUser.getFirstName() + " " + currentUser.getLastName() + " has requested access to " + ResourceUtility.convertToStudyName(selectedStudyId);

		StringBuffer body = new StringBuffer();

		body.append("First Name: " + currentUser.getFirstName() + "\n");
		body.append("Last Name: " + currentUser.getLastName() + "\n");
		body.append("Email:" + currentUser.getEmailAddress() + "\n");
		body.append("Requested Resource:" + ResourceUtility.convertToStudyName(selectedStudyId) + "\n");
		body.append("Message:\n");
		body.append(message);

		MailEngine.send(from, to, subject, body.toString());
		
		} catch (AddressException e) {
			ResourceUtility.printErrorMessage("Request Bean");
			e.printStackTrace();
		}
		catch (MailEngineException e) {
			ResourceUtility.printErrorMessage("Request Bean");
			e.printStackTrace();
		}

	}

	public String getStudyName(){
		return ResourceUtility.convertToStudyName(selectedStudyId);
	}
	
	public String getOriginalRequestDate(){
		return originalRequestDate;
	}
	
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getSaved() {
		return saved;
	}

	public void setSaved(String saved) {
		this.saved = saved;
	}

	public PortletPreferences getPrefs() {
		return prefs;
	}

	public void setPrefs(PortletPreferences prefs) {
		this.prefs = prefs;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public ArrayList<SelectItem> getStudyList() {
		return studyList;
	}

	public void setStudyList(ArrayList<SelectItem> studyList) {
		this.studyList = studyList;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStoreCopy(String storeCopy) {
		this.storeCopy = storeCopy.equals("true");
	}

	public String getStoreCopy() {
		if(storeCopy)
			return "true";
		else
			return "false";
	}

	public String getThankyou() {
		return thankyou;
	}

	public boolean isCopyUser() {
		return copyUser;
	}

	public void setCopyUser(boolean copyUser) {
		this.copyUser = copyUser;
	}

	public void setSelectedStudyId(long selectedStudyId) {
		this.selectedStudyId = selectedStudyId;
	}

	public long getSelectedStudyId() {
		return selectedStudyId;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public boolean isThanksVisible() {
		return thanksVisible;
	}

	public boolean isFormVisible() {
		return formVisible;
	}

	public boolean isDuplicateVisible() {
		return duplicateVisible;
	}

	public boolean isReminderSent() {
		return reminderSent;
	}
}
