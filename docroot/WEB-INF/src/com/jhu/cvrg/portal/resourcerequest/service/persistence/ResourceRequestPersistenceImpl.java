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

import com.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException;
import com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest;
import com.jhu.cvrg.portal.resourcerequest.model.impl.ResourceRequestImpl;
import com.jhu.cvrg.portal.resourcerequest.model.impl.ResourceRequestModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the resource request service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ResourceRequestUtil} to access the resource request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see ResourceRequestPersistence
 * @see ResourceRequestUtil
 * @generated
 */
public class ResourceRequestPersistenceImpl extends BasePersistenceImpl<ResourceRequest>
	implements ResourceRequestPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ResourceRequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_STUDY = new FinderPath(ResourceRequestModelImpl.ENTITY_CACHE_ENABLED,
			ResourceRequestModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByStudy",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDY = new FinderPath(ResourceRequestModelImpl.ENTITY_CACHE_ENABLED,
			ResourceRequestModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByStudy",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ResourceRequestModelImpl.ENTITY_CACHE_ENABLED,
			ResourceRequestModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ResourceRequestModelImpl.ENTITY_CACHE_ENABLED,
			ResourceRequestModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the resource request in the entity cache if it is enabled.
	 *
	 * @param resourceRequest the resource request to cache
	 */
	public void cacheResult(ResourceRequest resourceRequest) {
		EntityCacheUtil.putResult(ResourceRequestModelImpl.ENTITY_CACHE_ENABLED,
			ResourceRequestImpl.class, resourceRequest.getPrimaryKey(),
			resourceRequest);
	}

	/**
	 * Caches the resource requests in the entity cache if it is enabled.
	 *
	 * @param resourceRequests the resource requests to cache
	 */
	public void cacheResult(List<ResourceRequest> resourceRequests) {
		for (ResourceRequest resourceRequest : resourceRequests) {
			if (EntityCacheUtil.getResult(
						ResourceRequestModelImpl.ENTITY_CACHE_ENABLED,
						ResourceRequestImpl.class,
						resourceRequest.getPrimaryKey(), this) == null) {
				cacheResult(resourceRequest);
			}
		}
	}

	/**
	 * Clears the cache for all resource requests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ResourceRequestImpl.class.getName());
		EntityCacheUtil.clearCache(ResourceRequestImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the resource request.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ResourceRequest resourceRequest) {
		EntityCacheUtil.removeResult(ResourceRequestModelImpl.ENTITY_CACHE_ENABLED,
			ResourceRequestImpl.class, resourceRequest.getPrimaryKey());
	}

	/**
	 * Creates a new resource request with the primary key. Does not add the resource request to the database.
	 *
	 * @param requestId the primary key for the new resource request
	 * @return the new resource request
	 */
	public ResourceRequest create(long requestId) {
		ResourceRequest resourceRequest = new ResourceRequestImpl();

		resourceRequest.setNew(true);
		resourceRequest.setPrimaryKey(requestId);

		return resourceRequest;
	}

	/**
	 * Removes the resource request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resource request to remove
	 * @return the resource request that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a resource request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResourceRequest remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the resource request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the resource request to remove
	 * @return the resource request that was removed
	 * @throws com.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException if a resource request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResourceRequest remove(long requestId)
		throws NoSuchResourceRequestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ResourceRequest resourceRequest = (ResourceRequest)session.get(ResourceRequestImpl.class,
					new Long(requestId));

			if (resourceRequest == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + requestId);
				}

				throw new NoSuchResourceRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					requestId);
			}

			return remove(resourceRequest);
		}
		catch (NoSuchResourceRequestException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ResourceRequest removeImpl(ResourceRequest resourceRequest)
		throws SystemException {
		resourceRequest = toUnwrappedModel(resourceRequest);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, resourceRequest);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ResourceRequestModelImpl.ENTITY_CACHE_ENABLED,
			ResourceRequestImpl.class, resourceRequest.getPrimaryKey());

		return resourceRequest;
	}

	public ResourceRequest updateImpl(
		com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest resourceRequest,
		boolean merge) throws SystemException {
		resourceRequest = toUnwrappedModel(resourceRequest);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, resourceRequest, merge);

			resourceRequest.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ResourceRequestModelImpl.ENTITY_CACHE_ENABLED,
			ResourceRequestImpl.class, resourceRequest.getPrimaryKey(),
			resourceRequest);

		return resourceRequest;
	}

	protected ResourceRequest toUnwrappedModel(ResourceRequest resourceRequest) {
		if (resourceRequest instanceof ResourceRequestImpl) {
			return resourceRequest;
		}

		ResourceRequestImpl resourceRequestImpl = new ResourceRequestImpl();

		resourceRequestImpl.setNew(resourceRequest.isNew());
		resourceRequestImpl.setPrimaryKey(resourceRequest.getPrimaryKey());

		resourceRequestImpl.setRequestId(resourceRequest.getRequestId());
		resourceRequestImpl.setRequesterId(resourceRequest.getRequesterId());
		resourceRequestImpl.setApproverId(resourceRequest.getApproverId());
		resourceRequestImpl.setApproved(resourceRequest.isApproved());
		resourceRequestImpl.setDeclined(resourceRequest.isDeclined());
		resourceRequestImpl.setStudyId(resourceRequest.getStudyId());
		resourceRequestImpl.setMessage(resourceRequest.getMessage());
		resourceRequestImpl.setDateSent(resourceRequest.getDateSent());
		resourceRequestImpl.setDateHandled(resourceRequest.getDateHandled());
		resourceRequestImpl.setGroupId(resourceRequest.getGroupId());
		resourceRequestImpl.setCompanyId(resourceRequest.getCompanyId());

		return resourceRequestImpl;
	}

	/**
	 * Finds the resource request with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the resource request to find
	 * @return the resource request
	 * @throws com.liferay.portal.NoSuchModelException if a resource request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResourceRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the resource request with the primary key or throws a {@link com.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException} if it could not be found.
	 *
	 * @param requestId the primary key of the resource request to find
	 * @return the resource request
	 * @throws com.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException if a resource request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResourceRequest findByPrimaryKey(long requestId)
		throws NoSuchResourceRequestException, SystemException {
		ResourceRequest resourceRequest = fetchByPrimaryKey(requestId);

		if (resourceRequest == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + requestId);
			}

			throw new NoSuchResourceRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				requestId);
		}

		return resourceRequest;
	}

	/**
	 * Finds the resource request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resource request to find
	 * @return the resource request, or <code>null</code> if a resource request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResourceRequest fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the resource request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the resource request to find
	 * @return the resource request, or <code>null</code> if a resource request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResourceRequest fetchByPrimaryKey(long requestId)
		throws SystemException {
		ResourceRequest resourceRequest = (ResourceRequest)EntityCacheUtil.getResult(ResourceRequestModelImpl.ENTITY_CACHE_ENABLED,
				ResourceRequestImpl.class, requestId, this);

		if (resourceRequest == null) {
			Session session = null;

			try {
				session = openSession();

				resourceRequest = (ResourceRequest)session.get(ResourceRequestImpl.class,
						new Long(requestId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (resourceRequest != null) {
					cacheResult(resourceRequest);
				}

				closeSession(session);
			}
		}

		return resourceRequest;
	}

	/**
	 * Finds all the resource requests where studyId = &#63;.
	 *
	 * @param studyId the study id to search with
	 * @return the matching resource requests
	 * @throws SystemException if a system exception occurred
	 */
	public List<ResourceRequest> findByStudy(long studyId)
		throws SystemException {
		return findByStudy(studyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ResourceRequest> findByStudy(long studyId, int start, int end)
		throws SystemException {
		return findByStudy(studyId, start, end, null);
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
	public List<ResourceRequest> findByStudy(long studyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				studyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ResourceRequest> list = (List<ResourceRequest>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STUDY,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_RESOURCEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_STUDY_STUDYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ResourceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studyId);

				list = (List<ResourceRequest>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_STUDY,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STUDY,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	 * @throws com.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException if a matching resource request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResourceRequest findByStudy_First(long studyId,
		OrderByComparator orderByComparator)
		throws NoSuchResourceRequestException, SystemException {
		List<ResourceRequest> list = findByStudy(studyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studyId=");
			msg.append(studyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchResourceRequestException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	 * @throws com.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException if a matching resource request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResourceRequest findByStudy_Last(long studyId,
		OrderByComparator orderByComparator)
		throws NoSuchResourceRequestException, SystemException {
		int count = countByStudy(studyId);

		List<ResourceRequest> list = findByStudy(studyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studyId=");
			msg.append(studyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchResourceRequestException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	 * @throws com.jhu.cvrg.portal.resourcerequest.NoSuchResourceRequestException if a resource request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResourceRequest[] findByStudy_PrevAndNext(long requestId,
		long studyId, OrderByComparator orderByComparator)
		throws NoSuchResourceRequestException, SystemException {
		ResourceRequest resourceRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			ResourceRequest[] array = new ResourceRequestImpl[3];

			array[0] = getByStudy_PrevAndNext(session, resourceRequest,
					studyId, orderByComparator, true);

			array[1] = resourceRequest;

			array[2] = getByStudy_PrevAndNext(session, resourceRequest,
					studyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ResourceRequest getByStudy_PrevAndNext(Session session,
		ResourceRequest resourceRequest, long studyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESOURCEREQUEST_WHERE);

		query.append(_FINDER_COLUMN_STUDY_STUDYID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ResourceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(resourceRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ResourceRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the resource requests.
	 *
	 * @return the resource requests
	 * @throws SystemException if a system exception occurred
	 */
	public List<ResourceRequest> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ResourceRequest> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<ResourceRequest> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ResourceRequest> list = (List<ResourceRequest>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESOURCEREQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESOURCEREQUEST.concat(ResourceRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ResourceRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ResourceRequest>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the resource requests where studyId = &#63; from the database.
	 *
	 * @param studyId the study id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStudy(long studyId) throws SystemException {
		for (ResourceRequest resourceRequest : findByStudy(studyId)) {
			remove(resourceRequest);
		}
	}

	/**
	 * Removes all the resource requests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ResourceRequest resourceRequest : findAll()) {
			remove(resourceRequest);
		}
	}

	/**
	 * Counts all the resource requests where studyId = &#63;.
	 *
	 * @param studyId the study id to search with
	 * @return the number of matching resource requests
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStudy(long studyId) throws SystemException {
		Object[] finderArgs = new Object[] { studyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STUDY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESOURCEREQUEST_WHERE);

			query.append(_FINDER_COLUMN_STUDY_STUDYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STUDY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the resource requests.
	 *
	 * @return the number of resource requests
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RESOURCEREQUEST);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the resource request persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ResourceRequest>> listenersList = new ArrayList<ModelListener<ResourceRequest>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ResourceRequest>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ResourceRequestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = ResourceRequestPersistence.class)
	protected ResourceRequestPersistence resourceRequestPersistence;
	@BeanReference(type = TransactionPersistence.class)
	protected TransactionPersistence transactionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_RESOURCEREQUEST = "SELECT resourceRequest FROM ResourceRequest resourceRequest";
	private static final String _SQL_SELECT_RESOURCEREQUEST_WHERE = "SELECT resourceRequest FROM ResourceRequest resourceRequest WHERE ";
	private static final String _SQL_COUNT_RESOURCEREQUEST = "SELECT COUNT(resourceRequest) FROM ResourceRequest resourceRequest";
	private static final String _SQL_COUNT_RESOURCEREQUEST_WHERE = "SELECT COUNT(resourceRequest) FROM ResourceRequest resourceRequest WHERE ";
	private static final String _FINDER_COLUMN_STUDY_STUDYID_2 = "resourceRequest.studyId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "resourceRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ResourceRequest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ResourceRequest exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ResourceRequestPersistenceImpl.class);
}