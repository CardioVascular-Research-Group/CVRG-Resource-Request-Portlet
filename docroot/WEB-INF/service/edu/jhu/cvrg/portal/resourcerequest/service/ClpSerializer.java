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

import com.jhu.cvrg.portal.resourcerequest.service.ClpSerializer;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import edu.jhu.cvrg.portal.resourcerequest.model.ResourceRequestClp;
import edu.jhu.cvrg.portal.resourcerequest.model.TransactionClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "ice2-resource-request-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ResourceRequestClp.class.getName())) {
			ResourceRequestClp oldCplModel = (ResourceRequestClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("edu.jhu.cvrg.portal.resourcerequest.model.impl.ResourceRequestImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setRequestId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getRequestId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRequesterId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getRequesterId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setApproverId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getApproverId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setApproved",
							new Class[] { Boolean.TYPE });

					Boolean value3 = new Boolean(oldCplModel.getApproved());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDeclined",
							new Class[] { Boolean.TYPE });

					Boolean value4 = new Boolean(oldCplModel.getDeclined());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setStudyId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getStudyId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setMessage",
							new Class[] { String.class });

					String value6 = oldCplModel.getMessage();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setDateSent",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getDateSent();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setDateHandled",
							new Class[] { String.class });

					String value8 = oldCplModel.getDateHandled();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value9 = new Long(oldCplModel.getGroupId());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value10 = new Long(oldCplModel.getCompanyId());

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(TransactionClp.class.getName())) {
			TransactionClp oldCplModel = (TransactionClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("edu.jhu.cvrg.portal.resourcerequest.model.impl.TransactionImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setTransactionId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getTransactionId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setDate",
							new Class[] { Date.class });

					Date value1 = oldCplModel.getDate();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setMemberId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getMemberId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setAction",
							new Class[] { String.class });

					String value3 = oldCplModel.getAction();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setStudyId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getStudyId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setApproverId",
							new Class[] { Long.TYPE });

					Long value5 = new Long(oldCplModel.getApproverId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setComment",
							new Class[] { String.class });

					String value6 = oldCplModel.getComment();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setIp",
							new Class[] { String.class });

					String value7 = oldCplModel.getIp();

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"edu.jhu.cvrg.portal.resourcerequest.model.impl.ResourceRequestImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ResourceRequestClp newModel = new ResourceRequestClp();

					Method method0 = oldModelClass.getMethod("getRequestId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setRequestId(value0);

					Method method1 = oldModelClass.getMethod("getRequesterId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setRequesterId(value1);

					Method method2 = oldModelClass.getMethod("getApproverId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setApproverId(value2);

					Method method3 = oldModelClass.getMethod("getApproved");

					Boolean value3 = (Boolean)method3.invoke(oldModel,
							(Object[])null);

					newModel.setApproved(value3);

					Method method4 = oldModelClass.getMethod("getDeclined");

					Boolean value4 = (Boolean)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDeclined(value4);

					Method method5 = oldModelClass.getMethod("getStudyId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setStudyId(value5);

					Method method6 = oldModelClass.getMethod("getMessage");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setMessage(value6);

					Method method7 = oldModelClass.getMethod("getDateSent");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setDateSent(value7);

					Method method8 = oldModelClass.getMethod("getDateHandled");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setDateHandled(value8);

					Method method9 = oldModelClass.getMethod("getGroupId");

					Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value9);

					Method method10 = oldModelClass.getMethod("getCompanyId");

					Long value10 = (Long)method10.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyId(value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"edu.jhu.cvrg.portal.resourcerequest.model.impl.TransactionImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					TransactionClp newModel = new TransactionClp();

					Method method0 = oldModelClass.getMethod("getTransactionId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setTransactionId(value0);

					Method method1 = oldModelClass.getMethod("getDate");

					Date value1 = (Date)method1.invoke(oldModel, (Object[])null);

					newModel.setDate(value1);

					Method method2 = oldModelClass.getMethod("getMemberId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setMemberId(value2);

					Method method3 = oldModelClass.getMethod("getAction");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setAction(value3);

					Method method4 = oldModelClass.getMethod("getStudyId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setStudyId(value4);

					Method method5 = oldModelClass.getMethod("getApproverId");

					Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

					newModel.setApproverId(value5);

					Method method6 = oldModelClass.getMethod("getComment");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setComment(value6);

					Method method7 = oldModelClass.getMethod("getIp");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setIp(value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}