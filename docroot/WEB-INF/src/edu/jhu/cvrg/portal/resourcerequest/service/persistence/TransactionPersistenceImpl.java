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

import edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException;
import edu.jhu.cvrg.portal.resourcerequest.model.Transaction;
import edu.jhu.cvrg.portal.resourcerequest.model.impl.TransactionImpl;
import edu.jhu.cvrg.portal.resourcerequest.model.impl.TransactionModelImpl;
import edu.jhu.cvrg.portal.resourcerequest.service.persistence.ResourceRequestPersistence;
import edu.jhu.cvrg.portal.resourcerequest.service.persistence.TransactionPersistence;
import edu.jhu.cvrg.portal.resourcerequest.service.persistence.TransactionUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the transaction service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link TransactionUtil} to access the transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see TransactionPersistence
 * @see TransactionUtil
 * @generated
 */
public class TransactionPersistenceImpl extends BasePersistenceImpl<Transaction>
	implements TransactionPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = TransactionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_APPROVER = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByApprover",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVER = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByApprover", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_MEMBER = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByMember",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBER = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByMember", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_STUDY = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByStudy",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDY = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByStudy", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the transaction in the entity cache if it is enabled.
	 *
	 * @param transaction the transaction to cache
	 */
	public void cacheResult(Transaction transaction) {
		EntityCacheUtil.putResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionImpl.class, transaction.getPrimaryKey(), transaction);
	}

	/**
	 * Caches the transactions in the entity cache if it is enabled.
	 *
	 * @param transactions the transactions to cache
	 */
	public void cacheResult(List<Transaction> transactions) {
		for (Transaction transaction : transactions) {
			if (EntityCacheUtil.getResult(
						TransactionModelImpl.ENTITY_CACHE_ENABLED,
						TransactionImpl.class, transaction.getPrimaryKey(), this) == null) {
				cacheResult(transaction);
			}
		}
	}

	/**
	 * Clears the cache for all transactions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(TransactionImpl.class.getName());
		EntityCacheUtil.clearCache(TransactionImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the transaction.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Transaction transaction) {
		EntityCacheUtil.removeResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionImpl.class, transaction.getPrimaryKey());
	}

	/**
	 * Creates a new transaction with the primary key. Does not add the transaction to the database.
	 *
	 * @param transactionId the primary key for the new transaction
	 * @return the new transaction
	 */
	public Transaction create(long transactionId) {
		Transaction transaction = new TransactionImpl();

		transaction.setNew(true);
		transaction.setPrimaryKey(transactionId);

		return transaction;
	}

	/**
	 * Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the transaction to remove
	 * @return the transaction that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transactionId the primary key of the transaction to remove
	 * @return the transaction that was removed
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction remove(long transactionId)
		throws NoSuchTransactionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Transaction transaction = (Transaction)session.get(TransactionImpl.class,
					new Long(transactionId));

			if (transaction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + transactionId);
				}

				throw new NoSuchTransactionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					transactionId);
			}

			return remove(transaction);
		}
		catch (NoSuchTransactionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Transaction removeImpl(Transaction transaction)
		throws SystemException {
		transaction = toUnwrappedModel(transaction);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, transaction);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionImpl.class, transaction.getPrimaryKey());

		return transaction;
	}

	public Transaction updateImpl(
		edu.jhu.cvrg.portal.resourcerequest.model.Transaction transaction,
		boolean merge) throws SystemException {
		transaction = toUnwrappedModel(transaction);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, transaction, merge);

			transaction.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
			TransactionImpl.class, transaction.getPrimaryKey(), transaction);

		return transaction;
	}

	protected Transaction toUnwrappedModel(Transaction transaction) {
		if (transaction instanceof TransactionImpl) {
			return transaction;
		}

		TransactionImpl transactionImpl = new TransactionImpl();

		transactionImpl.setNew(transaction.isNew());
		transactionImpl.setPrimaryKey(transaction.getPrimaryKey());

		transactionImpl.setTransactionId(transaction.getTransactionId());
		transactionImpl.setDate(transaction.getDate());
		transactionImpl.setMemberId(transaction.getMemberId());
		transactionImpl.setAction(transaction.getAction());
		transactionImpl.setStudyId(transaction.getStudyId());
		transactionImpl.setApproverId(transaction.getApproverId());
		transactionImpl.setComment(transaction.getComment());
		transactionImpl.setIp(transaction.getIp());

		return transactionImpl;
	}

	/**
	 * Finds the transaction with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the transaction to find
	 * @return the transaction
	 * @throws com.liferay.portal.NoSuchModelException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the transaction with the primary key or throws a {@link edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException} if it could not be found.
	 *
	 * @param transactionId the primary key of the transaction to find
	 * @return the transaction
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction findByPrimaryKey(long transactionId)
		throws NoSuchTransactionException, SystemException {
		Transaction transaction = fetchByPrimaryKey(transactionId);

		if (transaction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + transactionId);
			}

			throw new NoSuchTransactionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				transactionId);
		}

		return transaction;
	}

	/**
	 * Finds the transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the transaction to find
	 * @return the transaction, or <code>null</code> if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transactionId the primary key of the transaction to find
	 * @return the transaction, or <code>null</code> if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction fetchByPrimaryKey(long transactionId)
		throws SystemException {
		Transaction transaction = (Transaction)EntityCacheUtil.getResult(TransactionModelImpl.ENTITY_CACHE_ENABLED,
				TransactionImpl.class, transactionId, this);

		if (transaction == null) {
			Session session = null;

			try {
				session = openSession();

				transaction = (Transaction)session.get(TransactionImpl.class,
						new Long(transactionId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (transaction != null) {
					cacheResult(transaction);
				}

				closeSession(session);
			}
		}

		return transaction;
	}

	/**
	 * Finds all the transactions where approverId = &#63;.
	 *
	 * @param approverId the approver id to search with
	 * @return the matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findByApprover(long approverId)
		throws SystemException {
		return findByApprover(approverId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the transactions where approverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param approverId the approver id to search with
	 * @param start the lower bound of the range of transactions to return
	 * @param end the upper bound of the range of transactions to return (not inclusive)
	 * @return the range of matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findByApprover(long approverId, int start, int end)
		throws SystemException {
		return findByApprover(approverId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the transactions where approverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param approverId the approver id to search with
	 * @param start the lower bound of the range of transactions to return
	 * @param end the upper bound of the range of transactions to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findByApprover(long approverId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				approverId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Transaction> list = (List<Transaction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPROVER,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_TRANSACTION_WHERE);

			query.append(_FINDER_COLUMN_APPROVER_APPROVERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approverId);

				list = (List<Transaction>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_APPROVER,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPROVER,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first transaction in the ordered set where approverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param approverId the approver id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching transaction
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction findByApprover_First(long approverId,
		OrderByComparator orderByComparator)
		throws NoSuchTransactionException, SystemException {
		List<Transaction> list = findByApprover(approverId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("approverId=");
			msg.append(approverId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTransactionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last transaction in the ordered set where approverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param approverId the approver id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching transaction
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction findByApprover_Last(long approverId,
		OrderByComparator orderByComparator)
		throws NoSuchTransactionException, SystemException {
		int count = countByApprover(approverId);

		List<Transaction> list = findByApprover(approverId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("approverId=");
			msg.append(approverId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTransactionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the transactions before and after the current transaction in the ordered set where approverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current transaction
	 * @param approverId the approver id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next transaction
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction[] findByApprover_PrevAndNext(long transactionId,
		long approverId, OrderByComparator orderByComparator)
		throws NoSuchTransactionException, SystemException {
		Transaction transaction = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			Transaction[] array = new TransactionImpl[3];

			array[0] = getByApprover_PrevAndNext(session, transaction,
					approverId, orderByComparator, true);

			array[1] = transaction;

			array[2] = getByApprover_PrevAndNext(session, transaction,
					approverId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Transaction getByApprover_PrevAndNext(Session session,
		Transaction transaction, long approverId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANSACTION_WHERE);

		query.append(_FINDER_COLUMN_APPROVER_APPROVERID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(approverId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(transaction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Transaction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the transactions where memberId = &#63;.
	 *
	 * @param memberId the member id to search with
	 * @return the matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findByMember(long memberId)
		throws SystemException {
		return findByMember(memberId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the transactions where memberId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param memberId the member id to search with
	 * @param start the lower bound of the range of transactions to return
	 * @param end the upper bound of the range of transactions to return (not inclusive)
	 * @return the range of matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findByMember(long memberId, int start, int end)
		throws SystemException {
		return findByMember(memberId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the transactions where memberId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param memberId the member id to search with
	 * @param start the lower bound of the range of transactions to return
	 * @param end the upper bound of the range of transactions to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findByMember(long memberId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				memberId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Transaction> list = (List<Transaction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MEMBER,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_TRANSACTION_WHERE);

			query.append(_FINDER_COLUMN_MEMBER_MEMBERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(memberId);

				list = (List<Transaction>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_MEMBER,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MEMBER,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first transaction in the ordered set where memberId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param memberId the member id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching transaction
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction findByMember_First(long memberId,
		OrderByComparator orderByComparator)
		throws NoSuchTransactionException, SystemException {
		List<Transaction> list = findByMember(memberId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("memberId=");
			msg.append(memberId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTransactionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last transaction in the ordered set where memberId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param memberId the member id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching transaction
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction findByMember_Last(long memberId,
		OrderByComparator orderByComparator)
		throws NoSuchTransactionException, SystemException {
		int count = countByMember(memberId);

		List<Transaction> list = findByMember(memberId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("memberId=");
			msg.append(memberId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTransactionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the transactions before and after the current transaction in the ordered set where memberId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current transaction
	 * @param memberId the member id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next transaction
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction[] findByMember_PrevAndNext(long transactionId,
		long memberId, OrderByComparator orderByComparator)
		throws NoSuchTransactionException, SystemException {
		Transaction transaction = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			Transaction[] array = new TransactionImpl[3];

			array[0] = getByMember_PrevAndNext(session, transaction, memberId,
					orderByComparator, true);

			array[1] = transaction;

			array[2] = getByMember_PrevAndNext(session, transaction, memberId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Transaction getByMember_PrevAndNext(Session session,
		Transaction transaction, long memberId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANSACTION_WHERE);

		query.append(_FINDER_COLUMN_MEMBER_MEMBERID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(memberId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(transaction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Transaction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the transactions where studyId = &#63;.
	 *
	 * @param studyId the study id to search with
	 * @return the matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findByStudy(long studyId)
		throws SystemException {
		return findByStudy(studyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the transactions where studyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param studyId the study id to search with
	 * @param start the lower bound of the range of transactions to return
	 * @param end the upper bound of the range of transactions to return (not inclusive)
	 * @return the range of matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findByStudy(long studyId, int start, int end)
		throws SystemException {
		return findByStudy(studyId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the transactions where studyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param studyId the study id to search with
	 * @param start the lower bound of the range of transactions to return
	 * @param end the upper bound of the range of transactions to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findByStudy(long studyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				studyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Transaction> list = (List<Transaction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STUDY,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_TRANSACTION_WHERE);

			query.append(_FINDER_COLUMN_STUDY_STUDYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studyId);

				list = (List<Transaction>)QueryUtil.list(q, getDialect(),
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
	 * Finds the first transaction in the ordered set where studyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param studyId the study id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching transaction
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction findByStudy_First(long studyId,
		OrderByComparator orderByComparator)
		throws NoSuchTransactionException, SystemException {
		List<Transaction> list = findByStudy(studyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studyId=");
			msg.append(studyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTransactionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last transaction in the ordered set where studyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param studyId the study id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching transaction
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction findByStudy_Last(long studyId,
		OrderByComparator orderByComparator)
		throws NoSuchTransactionException, SystemException {
		int count = countByStudy(studyId);

		List<Transaction> list = findByStudy(studyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studyId=");
			msg.append(studyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTransactionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the transactions before and after the current transaction in the ordered set where studyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current transaction
	 * @param studyId the study id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next transaction
	 * @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Transaction[] findByStudy_PrevAndNext(long transactionId,
		long studyId, OrderByComparator orderByComparator)
		throws NoSuchTransactionException, SystemException {
		Transaction transaction = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			Transaction[] array = new TransactionImpl[3];

			array[0] = getByStudy_PrevAndNext(session, transaction, studyId,
					orderByComparator, true);

			array[1] = transaction;

			array[2] = getByStudy_PrevAndNext(session, transaction, studyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Transaction getByStudy_PrevAndNext(Session session,
		Transaction transaction, long studyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANSACTION_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(transaction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Transaction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the transactions.
	 *
	 * @return the transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of transactions to return
	 * @param end the upper bound of the range of transactions to return (not inclusive)
	 * @return the range of transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of transactions to return
	 * @param end the upper bound of the range of transactions to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of transactions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Transaction> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Transaction> list = (List<Transaction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRANSACTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANSACTION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Transaction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Transaction>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the transactions where approverId = &#63; from the database.
	 *
	 * @param approverId the approver id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByApprover(long approverId) throws SystemException {
		for (Transaction transaction : findByApprover(approverId)) {
			remove(transaction);
		}
	}

	/**
	 * Removes all the transactions where memberId = &#63; from the database.
	 *
	 * @param memberId the member id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMember(long memberId) throws SystemException {
		for (Transaction transaction : findByMember(memberId)) {
			remove(transaction);
		}
	}

	/**
	 * Removes all the transactions where studyId = &#63; from the database.
	 *
	 * @param studyId the study id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStudy(long studyId) throws SystemException {
		for (Transaction transaction : findByStudy(studyId)) {
			remove(transaction);
		}
	}

	/**
	 * Removes all the transactions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Transaction transaction : findAll()) {
			remove(transaction);
		}
	}

	/**
	 * Counts all the transactions where approverId = &#63;.
	 *
	 * @param approverId the approver id to search with
	 * @return the number of matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByApprover(long approverId) throws SystemException {
		Object[] finderArgs = new Object[] { approverId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPROVER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANSACTION_WHERE);

			query.append(_FINDER_COLUMN_APPROVER_APPROVERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approverId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPROVER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the transactions where memberId = &#63;.
	 *
	 * @param memberId the member id to search with
	 * @return the number of matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMember(long memberId) throws SystemException {
		Object[] finderArgs = new Object[] { memberId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MEMBER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANSACTION_WHERE);

			query.append(_FINDER_COLUMN_MEMBER_MEMBERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(memberId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MEMBER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the transactions where studyId = &#63;.
	 *
	 * @param studyId the study id to search with
	 * @return the number of matching transactions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStudy(long studyId) throws SystemException {
		Object[] finderArgs = new Object[] { studyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STUDY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANSACTION_WHERE);

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
	 * Counts all the transactions.
	 *
	 * @return the number of transactions
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

				Query q = session.createQuery(_SQL_COUNT_TRANSACTION);

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
	 * Initializes the transaction persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jhu.cvrg.portal.resourcerequest.model.Transaction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Transaction>> listenersList = new ArrayList<ModelListener<Transaction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Transaction>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TransactionImpl.class.getName());
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
	private static final String _SQL_SELECT_TRANSACTION = "SELECT transaction FROM Transaction transaction";
	private static final String _SQL_SELECT_TRANSACTION_WHERE = "SELECT transaction FROM Transaction transaction WHERE ";
	private static final String _SQL_COUNT_TRANSACTION = "SELECT COUNT(transaction) FROM Transaction transaction";
	private static final String _SQL_COUNT_TRANSACTION_WHERE = "SELECT COUNT(transaction) FROM Transaction transaction WHERE ";
	private static final String _FINDER_COLUMN_APPROVER_APPROVERID_2 = "transaction.approverId = ?";
	private static final String _FINDER_COLUMN_MEMBER_MEMBERID_2 = "transaction.memberId = ?";
	private static final String _FINDER_COLUMN_STUDY_STUDYID_2 = "transaction.studyId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "transaction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Transaction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Transaction exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(TransactionPersistenceImpl.class);
}