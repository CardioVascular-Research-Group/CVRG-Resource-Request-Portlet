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

package com.jhu.cvrg.portal.resourcerequest.service;

/**
 * <p>
 * This class is a wrapper for {@link ResourceRequestLocalService}.
 * </p>
 *
 * @author    Chris Jurado
 * @see       ResourceRequestLocalService
 * @generated
 */
public class ResourceRequestLocalServiceWrapper
	implements ResourceRequestLocalService {
	public ResourceRequestLocalServiceWrapper(
		ResourceRequestLocalService resourceRequestLocalService) {
		_resourceRequestLocalService = resourceRequestLocalService;
	}

	/**
	* Adds the resource request to the database. Also notifies the appropriate model listeners.
	*
	* @param resourceRequest the resource request to add
	* @return the resource request that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest addResourceRequest(
		com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest resourceRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.addResourceRequest(resourceRequest);
	}

	/**
	* Creates a new resource request with the primary key. Does not add the resource request to the database.
	*
	* @param requestId the primary key for the new resource request
	* @return the new resource request
	*/
	public com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest createResourceRequest(
		long requestId) {
		return _resourceRequestLocalService.createResourceRequest(requestId);
	}

	/**
	* Deletes the resource request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the resource request to delete
	* @throws PortalException if a resource request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteResourceRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceRequestLocalService.deleteResourceRequest(requestId);
	}

	/**
	* Deletes the resource request from the database. Also notifies the appropriate model listeners.
	*
	* @param resourceRequest the resource request to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteResourceRequest(
		com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest resourceRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		_resourceRequestLocalService.deleteResourceRequest(resourceRequest);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the resource request with the primary key.
	*
	* @param requestId the primary key of the resource request to get
	* @return the resource request
	* @throws PortalException if a resource request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest getResourceRequest(
		long requestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.getResourceRequest(requestId);
	}

	/**
	* Gets a range of all the resource requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of resource requests to return
	* @param end the upper bound of the range of resource requests to return (not inclusive)
	* @return the range of resource requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest> getResourceRequests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.getResourceRequests(start, end);
	}

	/**
	* Gets the number of resource requests.
	*
	* @return the number of resource requests
	* @throws SystemException if a system exception occurred
	*/
	public int getResourceRequestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.getResourceRequestsCount();
	}

	/**
	* Updates the resource request in the database. Also notifies the appropriate model listeners.
	*
	* @param resourceRequest the resource request to update
	* @return the resource request that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest updateResourceRequest(
		com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest resourceRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.updateResourceRequest(resourceRequest);
	}

	/**
	* Updates the resource request in the database. Also notifies the appropriate model listeners.
	*
	* @param resourceRequest the resource request to update
	* @param merge whether to merge the resource request with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the resource request that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest updateResourceRequest(
		com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest resourceRequest,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.updateResourceRequest(resourceRequest,
			merge);
	}

	public com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest addResourceRequest(
		long requesterId, long teamId, java.lang.String message,
		java.lang.String ip)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.addResourceRequest(requesterId,
			teamId, message, ip);
	}

	public void updateStatus(long requestId, boolean approved)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_resourceRequestLocalService.updateStatus(requestId, approved);
	}

	public java.util.List<com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest> findByStudy(
		long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceRequestLocalService.findByStudy(studyId);
	}

	public ResourceRequestLocalService getWrappedResourceRequestLocalService() {
		return _resourceRequestLocalService;
	}

	private ResourceRequestLocalService _resourceRequestLocalService;
}