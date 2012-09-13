package edu.jhu.cvrg.portal.resourcerequest.model;

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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest;
import edu.jhu.cvrg.portal.resourcerequest.service.ResourceRequestLocalServiceUtil;
import edu.jhu.cvrg.portal.resourcerequest.utility.ResourceUtility;

@ManagedBean(name = "requestList")
@RequestScoped
public class RequestList {

	private ArrayList<ResourceRequest> requests;
	private boolean noPending;

	public RequestList() {

		requests = new ArrayList<ResourceRequest>();
		ArrayList<Long> studyList = new ArrayList<Long>();
		User currentUser = ResourceUtility.getCurrentUser();

		if (currentUser != null) {

			try {
				// Find all study names for which I am an approver or PI
				ArrayList<String> studyNames = ResourceUtility.getMyStudyNames(currentUser.getUserId());

				if (studyNames.size() > 0) {
					for (String studyName : studyNames) {
						long studyId = ResourceUtility.convertToStudyId(currentUser.getUserId(), studyName);
						if (studyId != 0L) {
							studyList.add(studyId);
						}
					}
				}

				if (studyList.size() > 0) {
					for (Long studyId : studyList) {
						for (ResourceRequest resourceRequest : ResourceRequestLocalServiceUtil.findByStudy(studyId.longValue())) {
							if (!resourceRequest.isApproved() && !resourceRequest.isDeclined()) {
								requests.add(resourceRequest);
							}
						}
					}
				}

			} catch (NumberFormatException e) {
				ResourceUtility.printErrorMessage("Request List Bean");
				e.printStackTrace();
			} catch (SystemException e) {
				ResourceUtility.printErrorMessage("Request List Bean");
				e.printStackTrace();
			}

			if (requests.size() > 0) {
				noPending = false;
			} else {
				noPending = true;
			}
		}

	}

	public ArrayList<ResourceRequest> getRequests() {
		return requests;
	}

	public boolean isNoPending() {
		return noPending;
	}
}
