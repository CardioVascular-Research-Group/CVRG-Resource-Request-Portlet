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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the transaction local service. This utility wraps {@link com.jhu.cvrg.portal.resourcerequest.service.impl.TransactionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.jhu.cvrg.portal.resourcerequest.service.impl.TransactionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Chris Jurado
 * @see TransactionLocalService
 * @see com.jhu.cvrg.portal.resourcerequest.service.base.TransactionLocalServiceBaseImpl
 * @see com.jhu.cvrg.portal.resourcerequest.service.impl.TransactionLocalServiceImpl
 * @generated
 */
public class TransactionLocalServiceUtil {
	/**
	* Adds the transaction to the database. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction to add
	* @return the transaction that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction addTransaction(
		com.jhu.cvrg.portal.resourcerequest.model.Transaction transaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTransaction(transaction);
	}

	/**
	* Creates a new transaction with the primary key. Does not add the transaction to the database.
	*
	* @param transactionId the primary key for the new transaction
	* @return the new transaction
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction createTransaction(
		long transactionId) {
		return getService().createTransaction(transactionId);
	}

	/**
	* Deletes the transaction with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the transaction to delete
	* @throws PortalException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTransaction(long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTransaction(transactionId);
	}

	/**
	* Deletes the transaction from the database. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTransaction(
		com.jhu.cvrg.portal.resourcerequest.model.Transaction transaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTransaction(transaction);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the transaction with the primary key.
	*
	* @param transactionId the primary key of the transaction to get
	* @return the transaction
	* @throws PortalException if a transaction with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction getTransaction(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTransaction(transactionId);
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
	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> getTransactions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTransactions(start, end);
	}

	/**
	* Gets the number of transactions.
	*
	* @return the number of transactions
	* @throws SystemException if a system exception occurred
	*/
	public static int getTransactionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTransactionsCount();
	}

	/**
	* Updates the transaction in the database. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction to update
	* @return the transaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction updateTransaction(
		com.jhu.cvrg.portal.resourcerequest.model.Transaction transaction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTransaction(transaction);
	}

	/**
	* Updates the transaction in the database. Also notifies the appropriate model listeners.
	*
	* @param transaction the transaction to update
	* @param merge whether to merge the transaction with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the transaction that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction updateTransaction(
		com.jhu.cvrg.portal.resourcerequest.model.Transaction transaction,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTransaction(transaction, merge);
	}

	public static com.jhu.cvrg.portal.resourcerequest.model.Transaction addTransaction(
		long approverId, java.lang.String action, long memberId, long teamId,
		java.lang.String comment, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTransaction(approverId, action, memberId, teamId,
			comment, ip);
	}

	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findTransactionsByApprover(
		long approverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findTransactionsByApprover(approverId);
	}

	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findTransactionsByMember(
		long memberId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findTransactionsByMember(memberId);
	}

	public static java.util.List<com.jhu.cvrg.portal.resourcerequest.model.Transaction> findTransactionsByStudy(
		long teamId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findTransactionsByStudy(teamId);
	}

	public static void clearService() {
		_service = null;
	}

	public static TransactionLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					TransactionLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new TransactionLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(TransactionLocalService service) {
		_service = service;
	}

	private static TransactionLocalService _service;
}