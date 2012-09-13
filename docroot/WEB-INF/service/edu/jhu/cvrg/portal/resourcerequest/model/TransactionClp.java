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

package edu.jhu.cvrg.portal.resourcerequest.model;

import com.jhu.cvrg.portal.resourcerequest.model.Transaction;
import com.jhu.cvrg.portal.resourcerequest.model.TransactionClp;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Chris Jurado
 */
public class TransactionClp extends BaseModelImpl<Transaction>
	implements Transaction {
	public TransactionClp() {
	}

	public long getPrimaryKey() {
		return _transactionId;
	}

	public void setPrimaryKey(long pk) {
		setTransactionId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_transactionId);
	}

	public long getTransactionId() {
		return _transactionId;
	}

	public void setTransactionId(long transactionId) {
		_transactionId = transactionId;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public long getStudyId() {
		return _studyId;
	}

	public void setStudyId(long studyId) {
		_studyId = studyId;
	}

	public long getApproverId() {
		return _approverId;
	}

	public void setApproverId(long approverId) {
		_approverId = approverId;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public String getIp() {
		return _ip;
	}

	public void setIp(String ip) {
		_ip = ip;
	}

	public Transaction toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Transaction)Proxy.newProxyInstance(Transaction.class.getClassLoader(),
				new Class[] { Transaction.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		TransactionClp clone = new TransactionClp();

		clone.setTransactionId(getTransactionId());
		clone.setDate(getDate());
		clone.setMemberId(getMemberId());
		clone.setAction(getAction());
		clone.setStudyId(getStudyId());
		clone.setApproverId(getApproverId());
		clone.setComment(getComment());
		clone.setIp(getIp());

		return clone;
	}

	public int compareTo(Transaction transaction) {
		long pk = transaction.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TransactionClp transaction = null;

		try {
			transaction = (TransactionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = transaction.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{transactionId=");
		sb.append(getTransactionId());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", memberId=");
		sb.append(getMemberId());
		sb.append(", action=");
		sb.append(getAction());
		sb.append(", studyId=");
		sb.append(getStudyId());
		sb.append(", approverId=");
		sb.append(getApproverId());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append(", ip=");
		sb.append(getIp());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("edu.jhu.cvrg.portal.resourcerequest.model.Transaction");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>transactionId</column-name><column-value><![CDATA[");
		sb.append(getTransactionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberId</column-name><column-value><![CDATA[");
		sb.append(getMemberId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>action</column-name><column-value><![CDATA[");
		sb.append(getAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studyId</column-name><column-value><![CDATA[");
		sb.append(getStudyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approverId</column-name><column-value><![CDATA[");
		sb.append(getApproverId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ip</column-name><column-value><![CDATA[");
		sb.append(getIp());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _transactionId;
	private Date _date;
	private long _memberId;
	private String _action;
	private long _studyId;
	private long _approverId;
	private String _comment;
	private String _ip;
}