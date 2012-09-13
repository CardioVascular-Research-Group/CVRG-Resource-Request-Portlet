/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package edu.jhu.cvrg.portal.resourcerequest.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException;
import edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest;
import edu.jhu.cvrg.portal.resourcerequest.service.base.ResourceRequestLocalServiceBaseImpl;

/**
 * The implementation of the resource request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link edu.jhu.cvrg.portal.resourcerequest.service.ResourceRequestLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link edu.jhu.cvrg.portal.resourcerequest.service.ResourceRequestLocalServiceUtil} to access the resource request local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Chris Jurado
 * @see edu.jhu.cvrg.portal.resourcerequest.service.base.ResourceRequestLocalServiceBaseImpl
 * @see edu.jhu.cvrg.portal.resourcerequest.service.ResourceRequestLocalServiceUtil
 */
public class ResourceRequestLocalServiceImpl
	extends ResourceRequestLocalServiceBaseImpl {
	
	public ResourceRequest addResourceRequest(long requesterId, long teamId, String message, String ip)								
	throws SystemException, PortalException {

		Date now = new Date();
		ResourceRequest newResourceRequest = resourceRequestPersistence.create(counterLocalService.increment(ResourceRequest.class.getName()));
		newResourceRequest.setRequesterId(requesterId);
		newResourceRequest.setApproved(false);
		newResourceRequest.setDeclined(false);
		newResourceRequest.setStudyId(teamId);
		newResourceRequest.setMessage(message);
		newResourceRequest.setDateSent(now);

		return resourceRequestPersistence.update(newResourceRequest, false);
}
	
	public void updateStatus(long requestId, boolean approved)
	throws NoSuchResourceRequestException, SystemException, PortalException{
		
		ResourceRequest resourceRequest = resourceRequestPersistence.create(requestId);
		resourceRequest.setApproved(approved);
		resourceRequest.setDeclined(!approved);
		
		resourceRequestPersistence.updateImpl(resourceRequest, true);	
	}

public List<ResourceRequest> findByStudy(long studyId) throws SystemException {
	List<ResourceRequest> transactions = resourceRequestPersistence.findByStudy(studyId);
	return transactions;
}

}