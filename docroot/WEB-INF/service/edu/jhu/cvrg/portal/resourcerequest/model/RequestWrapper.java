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

import com.jhu.cvrg.portal.resourcerequest.model.Request;

/**
 * <p>
 * This class is a wrapper for {@link Request}.
 * </p>
 *
 * @author    Chris Jurado
 * @see       Request
 * @generated
 */
public class RequestWrapper implements Request {
	public RequestWrapper(Request request) {
		_request = request;
	}

	public long getPrimaryKey() {
		return _request.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_request.setPrimaryKey(pk);
	}

	public long getRequestId() {
		return _request.getRequestId();
	}

	public void setRequestId(long requestId) {
		_request.setRequestId(requestId);
	}

	public long getRequesterId() {
		return _request.getRequesterId();
	}

	public void setRequesterId(long requesterId) {
		_request.setRequesterId(requesterId);
	}

	public long getApproverId() {
		return _request.getApproverId();
	}

	public void setApproverId(long approverId) {
		_request.setApproverId(approverId);
	}

	public boolean getApproved() {
		return _request.getApproved();
	}

	public boolean isApproved() {
		return _request.isApproved();
	}

	public void setApproved(boolean approved) {
		_request.setApproved(approved);
	}

	public boolean getDeclined() {
		return _request.getDeclined();
	}

	public boolean isDeclined() {
		return _request.isDeclined();
	}

	public void setDeclined(boolean declined) {
		_request.setDeclined(declined);
	}

	public long getStudyId() {
		return _request.getStudyId();
	}

	public void setStudyId(long studyId) {
		_request.setStudyId(studyId);
	}

	public java.lang.String getMessage() {
		return _request.getMessage();
	}

	public void setMessage(java.lang.String message) {
		_request.setMessage(message);
	}

	public java.lang.String getDateSent() {
		return _request.getDateSent();
	}

	public void setDateSent(java.lang.String dateSent) {
		_request.setDateSent(dateSent);
	}

	public java.lang.String getDateHandled() {
		return _request.getDateHandled();
	}

	public void setDateHandled(java.lang.String dateHandled) {
		_request.setDateHandled(dateHandled);
	}

	public long getGroupId() {
		return _request.getGroupId();
	}

	public void setGroupId(long groupId) {
		_request.setGroupId(groupId);
	}

	public long getCompanyId() {
		return _request.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_request.setCompanyId(companyId);
	}

	public edu.jhu.cvrg.portal.resourcerequest.model.Request toEscapedModel() {
		return _request.toEscapedModel();
	}

	public boolean isNew() {
		return _request.isNew();
	}

	public void setNew(boolean n) {
		_request.setNew(n);
	}

	public boolean isCachedModel() {
		return _request.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_request.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _request.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_request.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _request.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _request.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_request.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _request.clone();
	}

	public int compareTo(
		edu.jhu.cvrg.portal.resourcerequest.model.Request request) {
		return _request.compareTo(request);
	}

	public int hashCode() {
		return _request.hashCode();
	}

	public java.lang.String toString() {
		return _request.toString();
	}

	public java.lang.String toXmlString() {
		return _request.toXmlString();
	}

	public Request getWrappedRequest() {
		return _request;
	}

	private Request _request;
}