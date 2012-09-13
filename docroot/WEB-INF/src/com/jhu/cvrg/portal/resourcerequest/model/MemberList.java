package com.jhu.cvrg.portal.resourcerequest.model;

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

import com.jhu.cvrg.portal.resourcerequest.utility.ResourceUtility;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Team;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

@ManagedBean(name = "memberList")
@ViewScoped
public class MemberList {

	ArrayList<User> list;
	User currentUser;
	List<User> userList;

	public MemberList() {
		initialize();
	}

	public void initialize(){
		list = new ArrayList<User>();
		
		try {
		
			currentUser = ResourceUtility.getCurrentUser();
			userList = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());

			if(currentUser != null){
			List<Team> myTeams = currentUser.getTeams();
			
			for(Team team : myTeams){
				if(ResourceUtility.checkApprover(team)){
					for(User user : userList){
						if(ResourceUtility.isUserTeamMember(user.getUserId(), team.getTeamId())){
						list.add(user);
						}
					}
				}
			}
			}

		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Member List Bean");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			ResourceUtility.printErrorMessage("Member List Bean");
			e.printStackTrace();
		}
		
	}

	public ArrayList<User> getList() {
		return list;
	}
}
