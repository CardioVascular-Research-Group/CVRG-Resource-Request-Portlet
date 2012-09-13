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

package com.jhu.cvrg.portal.resourcerequest.model;

/**
 * <p>
 * This class is a wrapper for {@link Transaction}.
 * </p>
 *
 * @author    Chris Jurado
 * @see       Transaction
 * @generated
 */
public class TransactionWrapper implements Transaction {
	public TransactionWrapper(Transaction transaction) {
		_transaction = transaction;
	}

	public long getPrimaryKey() {
		return _transaction.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_transaction.setPrimaryKey(pk);
	}

	public long getTransactionId() {
		return _transaction.getTransactionId();
	}

	public void setTransactionId(long transactionId) {
		_transaction.setTransactionId(transactionId);
	}

	public java.util.Date getDate() {
		return _transaction.getDate();
	}

	public void setDate(java.util.Date date) {
		_transaction.setDate(date);
	}

	public long getMemberId() {
		return _transaction.getMemberId();
	}

	public void setMemberId(long memberId) {
		_transaction.setMemberId(memberId);
	}

	public java.lang.String getAction() {
		return _transaction.getAction();
	}

	public void setAction(java.lang.String action) {
		_transaction.setAction(action);
	}

	public long getStudyId() {
		return _transaction.getStudyId();
	}

	public void setStudyId(long studyId) {
		_transaction.setStudyId(studyId);
	}

	public long getApproverId() {
		return _transaction.getApproverId();
	}

	public void setApproverId(long approverId) {
		_transaction.setApproverId(approverId);
	}

	public java.lang.String getComment() {
		return _transaction.getComment();
	}

	public void setComment(java.lang.String comment) {
		_transaction.setComment(comment);
	}

	public java.lang.String getIp() {
		return _transaction.getIp();
	}

	public void setIp(java.lang.String ip) {
		_transaction.setIp(ip);
	}

	public com.jhu.cvrg.portal.resourcerequest.model.Transaction toEscapedModel() {
		return _transaction.toEscapedModel();
	}

	public boolean isNew() {
		return _transaction.isNew();
	}

	public void setNew(boolean n) {
		_transaction.setNew(n);
	}

	public boolean isCachedModel() {
		return _transaction.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_transaction.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _transaction.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_transaction.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _transaction.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _transaction.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_transaction.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _transaction.clone();
	}

	public int compareTo(
		com.jhu.cvrg.portal.resourcerequest.model.Transaction transaction) {
		return _transaction.compareTo(transaction);
	}

	public int hashCode() {
		return _transaction.hashCode();
	}

	public java.lang.String toString() {
		return _transaction.toString();
	}

	public java.lang.String toXmlString() {
		return _transaction.toXmlString();
	}

	public Transaction getWrappedTransaction() {
		return _transaction;
	}

	private Transaction _transaction;
}