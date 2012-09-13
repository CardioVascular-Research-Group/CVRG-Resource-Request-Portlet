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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Chris Jurado
 */
public class ResourceRequestClp extends BaseModelImpl<ResourceRequest>
	implements ResourceRequest {
	public ResourceRequestClp() {
	}

	public long getPrimaryKey() {
		return _requestId;
	}

	public void setPrimaryKey(long pk) {
		setRequestId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_requestId);
	}

	public long getRequestId() {
		return _requestId;
	}

	public void setRequestId(long requestId) {
		_requestId = requestId;
	}

	public long getRequesterId() {
		return _requesterId;
	}

	public void setRequesterId(long requesterId) {
		_requesterId = requesterId;
	}

	public long getApproverId() {
		return _approverId;
	}

	public void setApproverId(long approverId) {
		_approverId = approverId;
	}

	public boolean getApproved() {
		return _approved;
	}

	public boolean isApproved() {
		return _approved;
	}

	public void setApproved(boolean approved) {
		_approved = approved;
	}

	public boolean getDeclined() {
		return _declined;
	}

	public boolean isDeclined() {
		return _declined;
	}

	public void setDeclined(boolean declined) {
		_declined = declined;
	}

	public long getStudyId() {
		return _studyId;
	}

	public void setStudyId(long studyId) {
		_studyId = studyId;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public Date getDateSent() {
		return _dateSent;
	}

	public void setDateSent(Date dateSent) {
		_dateSent = dateSent;
	}

	public String getDateHandled() {
		return _dateHandled;
	}

	public void setDateHandled(String dateHandled) {
		_dateHandled = dateHandled;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public ResourceRequest toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (ResourceRequest)Proxy.newProxyInstance(ResourceRequest.class.getClassLoader(),
				new Class[] { ResourceRequest.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ResourceRequestClp clone = new ResourceRequestClp();

		clone.setRequestId(getRequestId());
		clone.setRequesterId(getRequesterId());
		clone.setApproverId(getApproverId());
		clone.setApproved(getApproved());
		clone.setDeclined(getDeclined());
		clone.setStudyId(getStudyId());
		clone.setMessage(getMessage());
		clone.setDateSent(getDateSent());
		clone.setDateHandled(getDateHandled());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());

		return clone;
	}

	public int compareTo(ResourceRequest resourceRequest) {
		int value = 0;

		value = DateUtil.compareTo(getDateSent(), resourceRequest.getDateSent());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ResourceRequestClp resourceRequest = null;

		try {
			resourceRequest = (ResourceRequestClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = resourceRequest.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{requestId=");
		sb.append(getRequestId());
		sb.append(", requesterId=");
		sb.append(getRequesterId());
		sb.append(", approverId=");
		sb.append(getApproverId());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append(", declined=");
		sb.append(getDeclined());
		sb.append(", studyId=");
		sb.append(getStudyId());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", dateSent=");
		sb.append(getDateSent());
		sb.append(", dateHandled=");
		sb.append(getDateHandled());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>requestId</column-name><column-value><![CDATA[");
		sb.append(getRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requesterId</column-name><column-value><![CDATA[");
		sb.append(getRequesterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approverId</column-name><column-value><![CDATA[");
		sb.append(getApproverId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved</column-name><column-value><![CDATA[");
		sb.append(getApproved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>declined</column-name><column-value><![CDATA[");
		sb.append(getDeclined());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studyId</column-name><column-value><![CDATA[");
		sb.append(getStudyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateSent</column-name><column-value><![CDATA[");
		sb.append(getDateSent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateHandled</column-name><column-value><![CDATA[");
		sb.append(getDateHandled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _requestId;
	private long _requesterId;
	private long _approverId;
	private boolean _approved;
	private boolean _declined;
	private long _studyId;
	private String _message;
	private Date _dateSent;
	private String _dateHandled;
	private long _groupId;
	private long _companyId;
}