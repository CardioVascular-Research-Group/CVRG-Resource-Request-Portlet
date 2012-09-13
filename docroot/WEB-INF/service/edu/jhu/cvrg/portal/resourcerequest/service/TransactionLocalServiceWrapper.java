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

package edu.jhu.cvrg.portal.resourcerequest.service;

import com.jhu.cvrg.portal.resourcerequest.service.TransactionLocalService;

/**
 * <p>
 * This class is a wrapper for {@link TransactionLocalService}.
 * </p>
 *
 * @author    Chris Jurado
 * @see       TransactionLocalService
 * @generated
 */
public class TransactionLocalServiceWrapper implements TransactionLocalService {
	public TransactionLocalServiceWrapper(
		TransactionLocalService transactionLocalService) {
		_transactionLocalService = transactionLocalService;
	}

	/**
	* Adds the transaction to the database. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction to add
	* @return the transaction that was added
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction addTransaction(
		edu.jhu.cvrg.portal.resourcerequest.model.Transaction transaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.addTransaction(transaction);
	}

	/**
	* Creates a new transaction with the primary key. Does not add the transaction to the database.
	*
	* @param transactionId the primary key for the new transaction
	* @return the new transaction
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction createTransaction(
		long transactionId) {
		return _transactionLocalService.createTransaction(transactionId);
	}

	/**
	* Deletes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the transaction to delete
	* @throws PortalException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTransaction(long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_transactionLocalService.deleteTransaction(transactionId);
	}

	/**
	* Deletes the transaction from the database. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTransaction(
		edu.jhu.cvrg.portal.resourcerequest.model.Transaction transaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		_transactionLocalService.deleteTransaction(transaction);
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
		return _transactionLocalService.dynamicQuery(dynamicQuery);
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
		return _transactionLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _transactionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _transactionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the transaction with the primary key.
	*
	* @param transactionId the primary key of the transaction to get
	* @return the transaction
	* @throws PortalException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction getTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.getTransaction(transactionId);
	}

	/**
	* Gets a range of all the transactions.
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
	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> getTransactions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.getTransactions(start, end);
	}

	/**
	* Gets the number of transactions.
	*
	* @return the number of transactions
	* @throws SystemException if a system exception occurred
	*/
	public int getTransactionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.getTransactionsCount();
	}

	/**
	* Updates the transaction in the database. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction to update
	* @return the transaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction updateTransaction(
		edu.jhu.cvrg.portal.resourcerequest.model.Transaction transaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.updateTransaction(transaction);
	}

	/**
	* Updates the transaction in the database. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction to update
	* @param merge whether to merge the transaction with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the transaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction updateTransaction(
		edu.jhu.cvrg.portal.resourcerequest.model.Transaction transaction,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.updateTransaction(transaction, merge);
	}

	public edu.jhu.cvrg.portal.resourcerequest.model.Transaction addTransaction(
		long approverId, java.lang.String action, long memberId, long teamId,
		java.lang.String comment, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.addTransaction(approverId, action,
			memberId, teamId, comment, ip);
	}

	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findTransactionsByApprover(
		long approverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.findTransactionsByApprover(approverId);
	}

	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findTransactionsByMember(
		long memberId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.findTransactionsByMember(memberId);
	}

	public java.util.List<edu.jhu.cvrg.portal.resourcerequest.model.Transaction> findTransactionsByStudy(
		long teamId) throws com.liferay.portal.kernel.exception.SystemException {
		return _transactionLocalService.findTransactionsByStudy(teamId);
	}

	public TransactionLocalService getWrappedTransactionLocalService() {
		return _transactionLocalService;
	}

	private TransactionLocalService _transactionLocalService;
}