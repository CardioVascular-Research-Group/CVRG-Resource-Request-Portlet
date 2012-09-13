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

package com.jhu.cvrg.portal.resourcerequest.model.impl;

import com.jhu.cvrg.portal.resourcerequest.model.Request;

/**
 * The model implementation for the Request service. Represents a row in the &quot;JHU_Request&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jhu.cvrg.portal.resourcerequest.model.Request} interface.
 * </p>
 *
 * <p>
 * Never reference this class directly. All methods that expect a request model instance should use the {@link Request} interface instead.
 * </p>
 */
public class RequestImpl extends RequestModelImpl implements Request {
	public RequestImpl() {
	}
}