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

import com.jhu.cvrg.portal.resourcerequest.service.persistence.TransactionUtil;

import com.liferay.portal.service.persistence.BasePersistence;

import edu.jhu.cvrg.portal.resourcerequest.model.Transaction;
import edu.jhu.cvrg.portal.resourcerequest.service.persistence.TransactionPersistenceImpl;

/**
 * The persistence interface for the transaction service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link TransactionUtil} to access the transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see TransactionPersistenceImpl
 * @see TransactionUtil
 * @generated
 */
public interface TransactionPersistence extends BasePersistence<Transaction> {
	/**
	* Caches the transaction in the entity cache if it is enabled.
	*
	* @param transaction the transaction to cache
	*/
	public void cacheResult(
		edu.jhu.cvrg.portal.resourcerequest.model.Transaction transaction);

	/**
	* Caches the transactions in the entity cache if it is enabled.
	*
	* @param transactions the transactions to cache
	*/
	public void cacheResult(
		java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> transactions);

	/**
	* Creates a new transaction with the primary key. Does not add the transaction to the database.
	*
	* @param transactionId the primary key for the new transaction
	* @return the new transaction
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction create(
		long transactionId);

	/**
	* Removes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the transaction to remove
	* @return the transaction that was removed
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction remove(
		long transactionId)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction updateImpl(
		edu.jhu.cvrg.portal.resourcerequest.model.Transaction transaction,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the transaction with the primary key or throws a {@link edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException} if it could not be found.
	*
	* @param transactionId the primary key of the transaction to find
	* @return the transaction
	* @throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction findByPrimaryKey(
		long transactionId)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the transaction with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transactionId the primary key of the transaction to find
	* @return the transaction, or <code>null</code> if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction fetchByPrimaryKey(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the transactions where approverId = &#63;.
	*
	* @param approverId the approver id to search with
	* @return the matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findByApprover(
		long approverId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findByApprover(
		long approverId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findByApprover(
		long approverId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction findByApprover_First(
		long approverId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction findByApprover_Last(
		long approverId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction[] findByApprover_PrevAndNext(
		long transactionId, long approverId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the transactions where memberId = &#63;.
	*
	* @param memberId the member id to search with
	* @return the matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findByMember(
		long memberId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findByMember(
		long memberId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findByMember(
		long memberId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction findByMember_First(
		long memberId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction findByMember_Last(
		long memberId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction[] findByMember_PrevAndNext(
		long transactionId, long memberId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the transactions where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findByStudy(
		long studyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findByStudy(
		long studyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findByStudy(
		long studyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction findByStudy_First(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction findByStudy_Last(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction[] findByStudy_PrevAndNext(
		long transactionId, long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws edu.jhu.cvrg.portal.resourcerequest.NoSuchTransactionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the transactions.
	*
	* @return the transactions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the transactions where approverId = &#63; from the database.
	*
	* @param approverId the approver id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApprover(long approverId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the transactions where memberId = &#63; from the database.
	*
	* @param memberId the member id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMember(long memberId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the transactions where studyId = &#63; from the database.
	*
	* @param studyId the study id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStudy(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the transactions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the transactions where approverId = &#63;.
	*
	* @param approverId the approver id to search with
	* @return the number of matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public int countByApprover(long approverId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the transactions where memberId = &#63;.
	*
	* @param memberId the member id to search with
	* @return the number of matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public int countByMember(long memberId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the transactions where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the number of matching transactions
	* @throws SystemException if a system exception occurred
	*/
	public int countByStudy(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the transactions.
	*
	* @return the number of transactions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}