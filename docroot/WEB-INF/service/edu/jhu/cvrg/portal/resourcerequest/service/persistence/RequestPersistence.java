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

import com.jhu.cvrg.portal.resourcerequest.service.persistence.RequestUtil;

import com.liferay.portal.service.persistence.BasePersistence;

import edu.jhu.cvrg.portal.resourcerequest.model.Request;
import edu.jhu.cvrg.portal.resourcerequest.service.persistence.RequestPersistenceImpl;

/**
 * The persistence interface for the request service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link RequestUtil} to access the request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see RequestPersistenceImpl
 * @see RequestUtil
 * @generated
 */
public interface RequestPersistence extends BasePersistence<Request> {
	/**
	* Caches the request in the entity cache if it is enabled.
	*
	* @param request the request to cache
	*/
	public void cacheResult(
		edu.jhu.cvrg.portal.resourcerequest.model.Request request);

	/**
	* Caches the requests in the entity cache if it is enabled.
	*
	* @param requests the requests to cache
	*/
	public void cacheResult(
		java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Request> requests);

	/**
	* Creates a new request with the primary key. Does not add the request to the database.
	*
	* @param requestId the primary key for the new request
	* @return the new request
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Request create(
		long requestId);

	/**
	* Removes the request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requestId the primary key of the request to remove
	* @return the request that was removed
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Request remove(
		long requestId)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	public edu.jhu.cvrg.portal.resourcerequest.model.Request updateImpl(
		edu.jhu.cvrg.portal.resourcerequest.model.Request request, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the request with the primary key or throws a {@link edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException} if it could not be found.
	*
	* @param requestId the primary key of the request to find
	* @return the request
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Request findByPrimaryKey(
		long requestId)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requestId the primary key of the request to find
	* @return the request, or <code>null</code> if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Request fetchByPrimaryKey(
		long requestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the requests where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the matching requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Request> findByStudy(
		long studyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Request> findByStudy(
		long studyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Request> findByStudy(
		long studyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Request findByStudy_First(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException;

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
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException if a matching request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Request findByStudy_Last(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException;

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
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException if a request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Request[] findByStudy_PrevAndNext(
		long requestId, long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the requests.
	*
	* @return the requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Request> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Request> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Request> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the requests where studyId = &#63; from the database.
	*
	* @param studyId the study id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStudy(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the requests where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the number of matching requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByStudy(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the requests.
	*
	* @return the number of requests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}