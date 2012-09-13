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
 * This class is a wrapper for {@link ResourceRequest}.
 * </p>
 *
 * @author    Chris Jurado
 * @see       ResourceRequest
 * @generated
 */
public class ResourceRequestWrapper implements ResourceRequest {
	public ResourceRequestWrapper(ResourceRequest resourceRequest) {
		_resourceRequest = resourceRequest;
	}

	public long getPrimaryKey() {
		return _resourceRequest.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_resourceRequest.setPrimaryKey(pk);
	}

	public long getRequestId() {
		return _resourceRequest.getRequestId();
	}

	public void setRequestId(long requestId) {
		_resourceRequest.setRequestId(requestId);
	}

	public long getRequesterId() {
		return _resourceRequest.getRequesterId();
	}

	public void setRequesterId(long requesterId) {
		_resourceRequest.setRequesterId(requesterId);
	}

	public long getApproverId() {
		return _resourceRequest.getApproverId();
	}

	public void setApproverId(long approverId) {
		_resourceRequest.setApproverId(approverId);
	}

	public boolean getApproved() {
		return _resourceRequest.getApproved();
	}

	public boolean isApproved() {
		return _resourceRequest.isApproved();
	}

	public void setApproved(boolean approved) {
		_resourceRequest.setApproved(approved);
	}

	public boolean getDeclined() {
		return _resourceRequest.getDeclined();
	}

	public boolean isDeclined() {
		return _resourceRequest.isDeclined();
	}

	public void setDeclined(boolean declined) {
		_resourceRequest.setDeclined(declined);
	}

	public long getStudyId() {
		return _resourceRequest.getStudyId();
	}

	public void setStudyId(long studyId) {
		_resourceRequest.setStudyId(studyId);
	}

	public java.lang.String getMessage() {
		return _resourceRequest.getMessage();
	}

	public void setMessage(java.lang.String message) {
		_resourceRequest.setMessage(message);
	}

	public java.util.Date getDateSent() {
		return _resourceRequest.getDateSent();
	}

	public void setDateSent(java.util.Date dateSent) {
		_resourceRequest.setDateSent(dateSent);
	}

	public java.lang.String getDateHandled() {
		return _resourceRequest.getDateHandled();
	}

	public void setDateHandled(java.lang.String dateHandled) {
		_resourceRequest.setDateHandled(dateHandled);
	}

	public long getGroupId() {
		return _resourceRequest.getGroupId();
	}

	public void setGroupId(long groupId) {
		_resourceRequest.setGroupId(groupId);
	}

	public long getCompanyId() {
		return _resourceRequest.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_resourceRequest.setCompanyId(companyId);
	}

	public com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest toEscapedModel() {
		return _resourceRequest.toEscapedModel();
	}

	public boolean isNew() {
		return _resourceRequest.isNew();
	}

	public void setNew(boolean n) {
		_resourceRequest.setNew(n);
	}

	public boolean isCachedModel() {
		return _resourceRequest.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_resourceRequest.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _resourceRequest.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_resourceRequest.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _resourceRequest.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _resourceRequest.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_resourceRequest.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _resourceRequest.clone();
	}

	public int compareTo(
		com.jhu.cvrg.portal.resourcerequest.model.ResourceRequest resourceRequest) {
		return _resourceRequest.compareTo(resourceRequest);
	}

	public int hashCode() {
		return _resourceRequest.hashCode();
	}

	public java.lang.String toString() {
		return _resourceRequest.toString();
	}

	public java.lang.String toXmlString() {
		return _resourceRequest.toXmlString();
	}

	public ResourceRequest getWrappedResourceRequest() {
		return _resourceRequest;
	}

	private ResourceRequest _resourceRequest;
}