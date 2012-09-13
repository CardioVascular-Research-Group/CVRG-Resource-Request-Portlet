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

/*Implementation Copyright 2011 Johns Hopkins University Institute for Computational Medicine

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
 
package edu.jhu.cvrg.portal.resourcerequest.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import edu.jhu.cvrg.portal.resourcerequest.model.Transaction;
import edu.jhu.cvrg.portal.resourcerequest.service.base.TransactionLocalServiceBaseImpl;

/**
 * The implementation of the transaction local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link edu.jhu.cvrg.portal.resourcerequest.service.TransactionLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link edu.jhu.cvrg.portal.resourcerequest.service.TransactionLocalServiceUtil} to access the transaction local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Chris Jurado
 * @see edu.jhu.cvrg.portal.resourcerequest.service.base.TransactionLocalServiceBaseImpl
 * @see edu.jhu.cvrg.portal.resourcerequest.service.TransactionLocalServiceUtil
 */
public class TransactionLocalServiceImpl extends TransactionLocalServiceBaseImpl {
	
	public Transaction addTransaction(long approverId, String action, long memberId, long teamId, String comment, String ip)								
													throws SystemException, PortalException {

		Date now = new Date();
		Transaction newTransaction = transactionPersistence.create(counterLocalService.increment(Transaction.class.getName()));
		newTransaction.setApproverId(approverId);
		newTransaction.setDate(now);
		newTransaction.setAction(action);
		newTransaction.setMemberId(memberId);
		newTransaction.setStudyId(teamId);
		newTransaction.setComment(comment);
		newTransaction.setIp(ip);

		return transactionPersistence.update(newTransaction, false);
	}

	public List<Transaction> findTransactionsByApprover(long approverId) throws SystemException {
		List<Transaction> transactions = transactionPersistence.findByApprover(approverId);
		return transactions;
	}
	
	public List<Transaction> findTransactionsByMember(long memberId) throws SystemException {
		List<Transaction> transactions = transactionPersistence.findByMember(memberId);
		return transactions;
	}
	
	public List<Transaction> findTransactionsByStudy(long teamId) throws SystemException {
		List<Transaction> transactions = transactionPersistence.findByStudy(teamId);
		return transactions;
	}
}