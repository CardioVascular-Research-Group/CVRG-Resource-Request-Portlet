package com.jhu.cvrg.portal.resourcerequest.utility;

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

import javax.portlet.PortletRequest;

import org.portletfaces.liferay.faces.context.LiferayFacesContext;
import org.portletfaces.liferay.faces.helper.LongHelper;

import com.jhu.cvrg.portal.resourcerequest.backing.ResourceResponseBacking;
import com.jhu.cvrg.portal.resourcerequest.backing.StudyCurrentBacking;
import com.jhu.cvrg.portal.resourcerequest.backing.TransactionHistoryBacking;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.Team;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.TeamLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class ResourceUtility {

	private final static String APPROVER = "Approver";
	private final static String PI = "PI";
	private final static LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();

	public static void printErrorMessage(String source) {
		System.err.println("*************************** Error in " + source
				+ " ******************************");
	}

	public static boolean isApprover() {
		List<Role> roleList;
		User user = getCurrentUser();
		if (user != null) {
			try {
				roleList = RoleLocalServiceUtil.getUserGroupRoles(user.getUserId(), getCurrentGroupId());
				for (Role role : roleList) {
					String roleName = role.getName();
					if (roleName.split(" ").length > 1) {
						if (roleName.split(" ")[1].equals(APPROVER)	|| roleName.split(" ")[1].equals(PI)) {
							return true;
						}
					}
				}
			} catch (NumberFormatException e) {
				printErrorMessage("Resource Utility");
				e.printStackTrace();
			} catch (SystemException e) {
				printErrorMessage("Resource Utility");
				e.printStackTrace();
			}
		}

		return false;
	}

	public static void changeTab() {
		TransactionHistoryBacking transaction = (TransactionHistoryBacking) liferayFacesContext
				.getApplication()
				.getELResolver()
				.getValue(liferayFacesContext.getELContext(), null,
						"transactionHistoryBacking");

		StudyCurrentBacking current = (StudyCurrentBacking) liferayFacesContext
				.getApplication()
				.getELResolver()
				.getValue(liferayFacesContext.getELContext(), null,
						"studyCurrentBacking");

		ResourceResponseBacking response = (ResourceResponseBacking) liferayFacesContext
				.getApplication()
				.getELResolver()
				.getValue(liferayFacesContext.getELContext(), null,
						"resourceResponseBacking");

		if (transaction != null)
			transaction.initialize();

		if (current != null)
			current.initialize();

		if (response != null)
			response.initialize();
	}

	public static long getIdParameter(String param) {
		return LongHelper.toLong(liferayFacesContext.getExternalContext()
				.getRequestParameterMap().get(param), 0L);
	}

	public static User getUser(long userId) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);

		} catch (PortalException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}
		return user;
	}

	public static long getCurrentGroupId() {

		PortletRequest request = (PortletRequest) liferayFacesContext.getExternalContext().getRequest();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		return themeDisplay.getLayout().getGroupId();
	}

	public static User getCurrentUser() {

		User currentUser = null;
		try {
			currentUser = UserLocalServiceUtil.getUser(Long
					.parseLong(liferayFacesContext.getPortletRequest().getRemoteUser()));
		} catch (NumberFormatException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (PortalException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}
		return currentUser;
	}

	public static User getApprover(long teamId) {

		try {
			Team thisTeam = TeamLocalServiceUtil.getTeam(teamId);
			List<User> allUsers = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
			for (User user : allUsers) {
				if (checkApprover(thisTeam, user)) {
					return user;
				}
			}
		} catch (SystemException e1) {
			printErrorMessage("Resource Utility");
			e1.printStackTrace();
		} catch (PortalException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}

		return null;
	}

	public static boolean checkApprover(Team team, User user) {
		List<Role> roleList;
		try {

			roleList = RoleLocalServiceUtil.getUserGroupRoles(user.getUserId(), getCurrentGroupId());
			for (Role role : roleList) {
				String roleName = role.getName();
				if (roleName.split(" ").length > 1) {
					if (roleName.split(" ")[1].equals(APPROVER) || roleName.split(" ")[1].equals(PI)) {
						if (roleName.split(" ")[0].equals(team.getName())) {
							return true;
						}
					}
				}
			}
		} catch (NumberFormatException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}

		return false;
	}

	public static boolean checkApprover(Team team) {
		return checkApprover(team, getCurrentUser());
	}

	public static boolean isUserTeamMember(long userId, long teamId) {
		try {
			List<Team> userTeams = TeamLocalServiceUtil.getUserTeams(userId);

			for (Team team : userTeams) {
				if (team.getTeamId() == teamId) {
					return true;
				}
			}
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}
		return false;

	}

	public static boolean isUserCommunityMember(long userId, long communityId) {

		try {
			List<Group> userGroups = GroupLocalServiceUtil.getUserGroups(userId);

			for (Group group : userGroups) {
				if (group.getGroupId() == communityId) {
					return true;
				}
			}
		} catch (PortalException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}
		return false;
	}

	private static ArrayList<String> getMyStudyNames(long userId, long groupId) {
		List<Role> roleList;
		ArrayList<String> studyNames = new ArrayList<String>();

		try {
			roleList = RoleLocalServiceUtil.getUserGroupRoles(userId, groupId);
			for (Role role : roleList) {
				String roleName = role.getName();
				if (roleName.split(" ").length > 1) {
					if (roleName.split(" ")[1].equals(APPROVER) || roleName.split(" ")[1].equals(PI)) {
						String study = roleName.split(" ")[0];
						studyNames.add(study);
					}
				}
			}
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}

		return studyNames;
	}

	public static ArrayList<String> getMyStudyNames(long userId) {

		return getMyStudyNames(userId, getCurrentGroupId());
	}

	public static long getGroupId(String communityName) {
		long groupId = 0L;
		List<Group> groupList;
		try {
			groupList = GroupLocalServiceUtil.getGroups(0, GroupLocalServiceUtil.getGroupsCount());
			for (Group group : groupList) {
				if (group.getName().equals(communityName)) {
					groupId = group.getGroupId();
				}
			}
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}

		return groupId;
	}

	public static String convertToUserName(long userId) {
		String userFullName = "";

		try {
			User user = UserLocalServiceUtil.getUser(userId);
			userFullName = user.getFullName();
		} catch (PortalException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}

		return userFullName;
	}

	public static String convertToStudyName(long studyId) {
		String studyName = "";

		try {
			Team team = TeamLocalServiceUtil.getTeam(studyId);
			studyName = team.getName();
		} catch (PortalException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}

		return studyName;
	}

	public static long convertToStudyId(long currentUserId, String name) {
		long studyId = 0L;
		try {
			List<Team> myTeams = TeamLocalServiceUtil.getUserTeams(currentUserId);
			for (Team team : myTeams) {
				if (team.getName().equals(name)) {
					return team.getTeamId();
				}
			}

		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}
		return studyId;
	}

}
