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

package edu.jhu.cvrg.portal.resourcerequest.service.persistence;

import com.jhu.cvrg.portal.resourcerequest.service.persistence.ResourceRequestPersistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest;
import edu.jhu.cvrg.portal.resourcerequest.service.persistence.ResourceRequestPersistenceImpl;

import java.util.List;

/**
 * The persistence utility for the resource request service. This utility wraps {@link ResourceRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see ResourceRequestPersistence
 * @see ResourceRequestPersistenceImpl
 * @generated
 */
public class ResourceRequestUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ResourceRequest resourceRequest) {
		getPersistence().clearCache(resourceRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ResourceRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ResourceRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ResourceRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static ResourceRequest remove(ResourceRequest resourceRequest)
		throws SystemException {
		return getPersistence().remove(resourceRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ResourceRequest update(ResourceRequest resourceRequest,
		boolean merge) throws SystemException {
		return getPersistence().update(resourceRequest, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ResourceRequest update(ResourceRequest resourceRequest,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(resourceRequest, merge, serviceContext);
	}

	/**
	* Caches the resource request in the entity cache if it is enabled.
	*
	* @param resourceRequest the resource request to cache
	*/
	public static void cacheResult(
		edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest resourceRequest) {
		getPersistence().cacheResult(resourceRequest);
	}

	/**
	* Caches the resource requests in the entity cache if it is enabled.
	*
	* @param resourceRequests the resource requests to cache
	*/
	public static void cacheResult(
		java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest> resourceRequests) {
		getPersistence().cacheResult(resourceRequests);
	}

	/**
	* Creates a new resource request with the primary key. Does not add the resource request to the database.
	*
	* @param requestId the primary key for the new resource request
	* @return the new resource request
	*/
	public static edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest create(
		long requestId) {
		return getPersistence().create(requestId);
	}

	/**
	* Removes the resource request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the resource request to remove
	* @return the resource request that was removed
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException if a resource request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest remove(
		long requestId)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(requestId);
	}

	public static edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest updateImpl(
		edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest resourceRequest,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(resourceRequest, merge);
	}

	/**
	* Finds the resource request with the primary key or throws a {@link edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException} if it could not be found.
	*
	* @param requestId the primary key of the resource request to find
	* @return the resource request
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException if a resource request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest findByPrimaryKey(
		long requestId)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(requestId);
	}

	/**
	* Finds the resource request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestId the primary key of the resource request to find
	* @return the resource request, or <code>null</code> if a resource request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest fetchByPrimaryKey(
		long requestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(requestId);
	}

	/**
	* Finds all the resource requests where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the matching resource requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest> findByStudy(
		long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy(studyId);
	}

	/**
	* Finds a range of all the resource requests where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param start the lower bound of the range of resource requests to return
	* @param end the upper bound of the range of resource requests to return (not inclusive)
	* @return the range of matching resource requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest> findByStudy(
		long studyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy(studyId, start, end);
	}

	/**
	* Finds an ordered range of all the resource requests where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param start the lower bound of the range of resource requests to return
	* @param end the upper bound of the range of resource requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching resource requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest> findByStudy(
		long studyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudy(studyId, start, end, orderByComparator);
	}

	/**
	* Finds the first resource request in the ordered set where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching resource request
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException if a matching resource request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest findByStudy_First(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy_First(studyId, orderByComparator);
	}

	/**
	* Finds the last resource request in the ordered set where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching resource request
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException if a matching resource request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest findByStudy_Last(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy_Last(studyId, orderByComparator);
	}

	/**
	* Finds the resource requests before and after the current resource request in the ordered set where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current resource request
	* @param studyId the study id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next resource request
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException if a resource request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest[] findByStudy_PrevAndNext(
		long requestId, long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudy_PrevAndNext(requestId, studyId,
			orderByComparator);
	}

	/**
	* Finds all the resource requests.
	*
	* @return the resource requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the resource requests.
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
	public static java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the resource requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of resource requests to return
	* @param end the upper bound of the range of resource requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of resource requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the resource requests where studyId = &#63; from the database.
	*
	* @param studyId the study id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStudy(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStudy(studyId);
	}

	/**
	* Removes all the resource requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the resource requests where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the number of matching resource requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStudy(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStudy(studyId);
	}

	/**
	* Counts all the resource requests.
	*
	* @return the number of resource requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ResourceRequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ResourceRequestPersistence)PortletBeanLocatorUtil.locate(edu.jhu.cvrg.portal.resourcerequest.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					ResourceRequestPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(ResourceRequestPersistence persistence) {
		_persistence = persistence;
	}

	private static ResourceRequestPersistence _persistence;
}