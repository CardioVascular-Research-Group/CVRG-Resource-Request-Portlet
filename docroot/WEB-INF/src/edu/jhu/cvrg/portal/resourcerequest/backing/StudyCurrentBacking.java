package edu.jhu.cvrg.portal.resourcerequest.backing;
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
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Team;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import edu.jhu.cvrg.portal.resourcerequest.service.TransactionLocalServiceUtil;
import edu.jhu.cvrg.portal.resourcerequest.utility.ResourceUtility;

@ManagedBean(name = "studyCurrentBacking")
@ViewScoped
public class StudyCurrentBacking {

	//View/general members
	private User currentUser;
	private boolean mainPanelVisible;
	private enum ShowPanel {MAIN, REVOKE, DETAIL, THANKS}
	
	//Revoke Members
	private String revokeComment = "";
	private String revokeMessage = "";
	private User revokedMember;
	private boolean revokePanelVisible;
	private final String REVOKE_ACCESS = "Access Revoked";
	private Team revokedStudy;
	private long revokedStudyId;
	private ArrayList<SelectItem> revokableStudies;
	
	//Detail Members
	private User viewedMember;
	private boolean showCurrentDetail;
	
	//Confirmation Panel members
	private boolean showConfirmationPanel;

	public StudyCurrentBacking(){
		currentUser = ResourceUtility.getCurrentUser();
		initialize();
	}
	
	public void initialize(){
		revokedMember = null;
		revokedStudy = null;
		setRevokeMessage("");
		setRevokeComment("");
		switchView(ShowPanel.MAIN);
	}
	
	private void switchView(ShowPanel panel){
		showCurrentDetail = false;
		revokePanelVisible = false;
		mainPanelVisible = false;
		showConfirmationPanel = false;
		
		switch (panel){
		case MAIN: 		mainPanelVisible = true; 		break;
		case REVOKE: 	revokePanelVisible = true;		break;
		case DETAIL: 	showCurrentDetail = true;		break;
		case THANKS:	showConfirmationPanel = true;	break;
		default:		switchView(ShowPanel.MAIN);		break;
		}
	}
	
	public void revoke(ActionEvent event){
	
		long revokedMemberId = ResourceUtility.getIdParameter("revokeUserId");
		revokedMember = ResourceUtility.getUser(revokedMemberId);
		
		try {
			List<Team> teamList = revokedMember.getTeams();
			for(Team team : teamList){
				if(ResourceUtility.checkApprover(team)){
					revokedStudy = team;
			}
		}

		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Study Current Bean");
			e.printStackTrace();
		}
		switchView(ShowPanel.REVOKE);
	}
	
	public void viewCurrentDetails(ActionEvent event){
		long userId = ResourceUtility.getIdParameter("detailUserId");
		viewedMember = ResourceUtility.getUser(userId);
		switchView(ShowPanel.DETAIL);
	}
	
	
	public void showCurrentMembers(ActionEvent event){
		switchView(ShowPanel.MAIN);
	}
	
	public void confirmRevoke(ActionEvent event){

		try {
			UserLocalServiceUtil.unsetTeamUsers(revokedStudy.getTeamId(), new long[]{revokedMember.getUserId()});
			TransactionLocalServiceUtil.addTransaction(currentUser.getUserId(), REVOKE_ACCESS, revokedMember.getUserId(), revokedStudy.getTeamId(), revokeComment, "");
		} catch (PortalException e) {
			ResourceUtility.printErrorMessage("Study Current Bean");
			e.printStackTrace();
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Study Current Bean");
			e.printStackTrace();
		}
		
		setRevokeMessage("Access revoked for " + revokedMember.getFullName());	
		switchView(ShowPanel.THANKS);
	}

	public void cancelRevoke(ActionEvent event){
		initialize();
	}

	public void setRevokeMessage(String revokeMessage) {
		this.revokeMessage = revokeMessage;
	}

	public String getRevokeMessage() {
		return revokeMessage;
	}

	public void setRevokeComment(String revokeComment) {
		this.revokeComment = revokeComment;
	}

	public String getRevokeComment() {
		return revokeComment;
	}

	public boolean isShowCurrentDetail() {
		return showCurrentDetail;
	}

	public boolean isRevokePanelVisible() {
		return revokePanelVisible;
	}

	public void setViewedMember(User viewedMember) {
		this.viewedMember = viewedMember;
	}

	public User getViewedMember() {
		return viewedMember;
	}

	public boolean isMultipleStudies() {
		try {
			if(revokedMember.getTeams().size() > 1){
				return true;
			}
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Study Current Bean");
			e.printStackTrace();
		}
		return false;
	}

	public void setRevokedStudy(Team revokedStudy) {
		this.revokedStudy = revokedStudy;
	}

	public Team getRevokedStudy() {
		return revokedStudy;
	}

	public void setRevokableStudies(ArrayList<SelectItem> revokableStudies) {
		this.revokableStudies = revokableStudies;
	}

	public ArrayList<SelectItem> getRevokableStudies() {
		return revokableStudies;
	}
	
	public User getRevokedMember() {
		return revokedMember;
	}

	public void setRevokedMember(User revokedMember) {
		this.revokedMember = revokedMember;
	}

	public void setRevokedStudyId(long revokedStudyId) {
		this.revokedStudyId = revokedStudyId;
	}

	public long getRevokedStudyId() {
		return revokedStudyId;
	}
	
	public boolean isMainPanelVisible() {
		return mainPanelVisible;
	}

	public boolean isShowConfirmationPanel() {
		return showConfirmationPanel;
	}

}
