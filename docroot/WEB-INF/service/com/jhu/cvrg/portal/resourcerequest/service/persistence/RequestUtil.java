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

package com.jhu.cvrg.portal.resourcerequest.service.persistence;

import com.jhu.cvrg.portal.resourcerequest.model.Request;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the request service. This utility wraps {@link RequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see RequestPersistence
 * @see RequestPersistenceImpl
 * @generated
 */
public class RequestUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Request request) {
		getPersistence().clearCache(request);
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
	public static List<Request> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Request> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Request> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Request remove(Request request) throws SystemException {
		return getPersistence().remove(request);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Request update(Request request, boolean merge)
		throws SystemException {
		return getPersistence().update(request, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Request update(Request request, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(request, merge, serviceContext);
	}

	/**
	* Caches the request in the entity cache if it is enabled.
	*
	* @param request the request to cache
	*/
	public static void cacheResult(
		com.jhu.cvrg.portal.resourcerequest.model.Request request) {
		getPersistence().cacheResult(request);
	}

	/**
	* Caches the requests in the entity cache if it is enabled.
	*
	* @param requests the requests to cache
	*/
	public static void cacheResult(
		java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Request> requests) {
		getPersistence().cacheResult(requests);
	}

	/**
	* Creates a new request with the primary key. Does not add the request to the database.
	*
	* @param requestId the primary key for the new request
	* @return the new request
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Request create(
		long requestId) {
		return getPersistence().create(requestId);
	}

	/**
	* Removes the request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the request to remove
	* @return the request that was removed
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Request remove(
		long requestId)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(requestId);
	}

	public static com.jhu.cvrg.portal.resourcerequest.model.Request updateImpl(
		com.jhu.cvrg.portal.resourcerequest.model.Request request, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(request, merge);
	}

	/**
	* Finds the request with the primary key or throws a {@link com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException} if it could not be found.
	*
	* @param requestId the primary key of the request to find
	* @return the request
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Request findByPrimaryKey(
		long requestId)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(requestId);
	}

	/**
	* Finds the request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestId the primary key of the request to find
	* @return the request, or <code>null</code> if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Request fetchByPrimaryKey(
		long requestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(requestId);
	}

	/**
	* Finds all the requests where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Request> findByStudy(
		long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy(studyId);
	}

	/**
	* Finds a range of all the requests where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param start the lower bound of the range of requests to return
	* @param end the upper bound of the range of requests to return (not inclusive)
	* @return the range of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Request> findByStudy(
		long studyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy(studyId, start, end);
	}

	/**
	* Finds an ordered range of all the requests where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param start the lower bound of the range of requests to return
	* @param end the upper bound of the range of requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Request> findByStudy(
		long studyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudy(studyId, start, end, orderByComparator);
	}

	/**
	* Finds the first request in the ordered set where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching request
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Request findByStudy_First(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy_First(studyId, orderByComparator);
	}

	/**
	* Finds the last request in the ordered set where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching request
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Request findByStudy_Last(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy_Last(studyId, orderByComparator);
	}

	/**
	* Finds the requests before and after the current request in the ordered set where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param requestId the primary key of the current request
	* @param studyId the study id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next request
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Request[] findByStudy_PrevAndNext(
		long requestId, long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudy_PrevAndNext(requestId, studyId,
			orderByComparator);
	}

	/**
	* Finds all the requests.
	*
	* @return the requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Request> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of requests to return
	* @param end the upper bound of the range of requests to return (not inclusive)
	* @return the range of requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Request> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of requests to return
	* @param end the upper bound of the range of requests to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Request> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the requests where studyId = &#63; from the database.
	*
	* @param studyId the study id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStudy(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStudy(studyId);
	}

	/**
	* Removes all the requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the requests where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the number of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStudy(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStudy(studyId);
	}

	/**
	* Counts all the requests.
	*
	* @return the number of requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RequestPersistence)PortletBeanLocatorUtil.locate(com.jhu.cvrg.portal.resourcerequest.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					RequestPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(RequestPersistence persistence) {
		_persistence = persistence;
	}

	private static RequestPersistence _persistence;
}