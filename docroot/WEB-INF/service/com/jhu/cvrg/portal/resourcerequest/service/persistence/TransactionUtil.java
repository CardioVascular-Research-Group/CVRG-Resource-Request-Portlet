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

import com.jhu.cvrg.portal.resourcerequest.model.Transaction;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the transaction service. This utility wraps {@link TransactionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see TransactionPersistence
 * @see TransactionPersistenceImpl
 * @generated
 */
public class TransactionUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Transaction transaction) {
		getPersistence().clearCache(transaction);
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
	public static List<Transaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Transaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Transaction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Transaction remove(Transaction transaction)
		throws SystemException {
		return getPersistence().remove(transaction);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Transaction update(Transaction transaction, boolean merge)
		throws SystemException {
		return getPersistence().update(transaction, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Transaction update(Transaction transaction, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(transaction, merge, serviceContext);
	}

	/**
	* Caches the transaction in the entity cache if it is enabled.
	*
	* @param transaction the transaction to cache
	*/
	public static void cacheResult(
		com.jhu.cvrg.portal.resourcerequest.model.Transaction transaction) {
		getPersistence().cacheResult(transaction);
	}

	/**
	* Caches the transactions in the entity cache if it is enabled.
	*
	* @param transactions the transactions to cache
	*/
	public static void cacheResult(
		java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> transactions) {
		getPersistence().cacheResult(transactions);
	}

	/**
	* Creates a new transaction with the primary key. Does not add the transaction to the database.
	*
	* @param transactionId the primary key for the new transaction
	* @return the new transaction
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction create(
		long transactionId) {
		return getPersistence().create(transactionId);
	}

	/**
	* Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the transaction to remove
	* @return the transaction that was removed
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction remove(
		long transactionId)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(transactionId);
	}

	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction updateImpl(
		com.jhu.cvrg.portal.resourcerequest.model.Transaction transaction,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(transaction, merge);
	}

	/**
	* Finds the transaction with the primary key or throws a {@link com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException} if it could not be found.
	*
	* @param transactionId the primary key of the transaction to find
	* @return the transaction
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction findByPrimaryKey(
		long transactionId)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(transactionId);
	}

	/**
	* Finds the transaction with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transactionId the primary key of the transaction to find
	* @return the transaction, or <code>null</code> if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction fetchByPrimaryKey(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(transactionId);
	}

	/**
	* Finds all the transactions where approverId = &#63;.
	*
	* @param approverId the approver id to search with
	* @return the matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findByApprover(
		long approverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApprover(approverId);
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
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findByApprover(
		long approverId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApprover(approverId, start, end);
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
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findByApprover(
		long approverId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApprover(approverId, start, end, orderByComparator);
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
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction findByApprover_First(
		long approverId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApprover_First(approverId, orderByComparator);
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
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction findByApprover_Last(
		long approverId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApprover_Last(approverId, orderByComparator);
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
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction[] findByApprover_PrevAndNext(
		long transactionId, long approverId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApprover_PrevAndNext(transactionId, approverId,
			orderByComparator);
	}

	/**
	* Finds all the transactions where memberId = &#63;.
	*
	* @param memberId the member id to search with
	* @return the matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findByMember(
		long memberId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMember(memberId);
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
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findByMember(
		long memberId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMember(memberId, start, end);
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
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findByMember(
		long memberId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMember(memberId, start, end, orderByComparator);
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
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction findByMember_First(
		long memberId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMember_First(memberId, orderByComparator);
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
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction findByMember_Last(
		long memberId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMember_Last(memberId, orderByComparator);
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
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction[] findByMember_PrevAndNext(
		long transactionId, long memberId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMember_PrevAndNext(transactionId, memberId,
			orderByComparator);
	}

	/**
	* Finds all the transactions where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findByStudy(
		long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy(studyId);
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
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findByStudy(
		long studyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy(studyId, start, end);
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
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findByStudy(
		long studyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudy(studyId, start, end, orderByComparator);
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
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction findByStudy_First(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy_First(studyId, orderByComparator);
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
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a matching transaction could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction findByStudy_Last(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudy_Last(studyId, orderByComparator);
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
	* @throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction[] findByStudy_PrevAndNext(
		long transactionId, long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudy_PrevAndNext(transactionId, studyId,
			orderByComparator);
	}

	/**
	* Finds all the transactions.
	*
	* @return the transactions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the transactions where approverId = &#63; from the database.
	*
	* @param approverId the approver id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByApprover(long approverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByApprover(approverId);
	}

	/**
	* Removes all the transactions where memberId = &#63; from the database.
	*
	* @param memberId the member id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMember(long memberId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMember(memberId);
	}

	/**
	* Removes all the transactions where studyId = &#63; from the database.
	*
	* @param studyId the study id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStudy(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStudy(studyId);
	}

	/**
	* Removes all the transactions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the transactions where approverId = &#63;.
	*
	* @param approverId the approver id to search with
	* @return the number of matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByApprover(long approverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByApprover(approverId);
	}

	/**
	* Counts all the transactions where memberId = &#63;.
	*
	* @param memberId the member id to search with
	* @return the number of matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMember(long memberId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMember(memberId);
	}

	/**
	* Counts all the transactions where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the number of matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStudy(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStudy(studyId);
	}

	/**
	* Counts all the transactions.
	*
	* @return the number of transactions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TransactionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TransactionPersistence)PortletBeanLocatorUtil.locate(com.jhu.cvrg.portal.resourcerequest.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					TransactionPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(TransactionPersistence persistence) {
		_persistence = persistence;
	}

	private static TransactionPersistence _persistence;
}