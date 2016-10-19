/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.sohlman.liferay.perm.integ.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.sohlman.liferay.perm.integ.service.IntegrationInfoServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link IntegrationInfoServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IntegrationInfoServiceSoap
 * @see HttpPrincipal
 * @see IntegrationInfoServiceUtil
 * @generated
 */
@ProviderType
public class IntegrationInfoServiceHttp {
	public static com.sohlman.liferay.perm.integ.model.IntegrationInfo fetchIntegrationInfo(
		HttpPrincipal httpPrincipal, long groupId, java.lang.String className) {
		try {
			MethodKey methodKey = new MethodKey(IntegrationInfoServiceUtil.class,
					"fetchIntegrationInfo", _fetchIntegrationInfoParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					className);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.sohlman.liferay.perm.integ.model.IntegrationInfo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.sohlman.liferay.perm.integ.model.IntegrationInfo> findByGroupId(
		HttpPrincipal httpPrincipal, long groupId, int start, int end) {
		try {
			MethodKey methodKey = new MethodKey(IntegrationInfoServiceUtil.class,
					"findByGroupId", _findByGroupIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.sohlman.liferay.perm.integ.model.IntegrationInfo>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static long countByGroupId(HttpPrincipal httpPrincipal, long groupId) {
		try {
			MethodKey methodKey = new MethodKey(IntegrationInfoServiceUtil.class,
					"countByGroupId", _countByGroupIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(IntegrationInfoServiceHttp.class);
	private static final Class<?>[] _fetchIntegrationInfoParameterTypes0 = new Class[] {
			long.class, java.lang.String.class
		};
	private static final Class<?>[] _findByGroupIdParameterTypes1 = new Class[] {
			long.class, int.class, int.class
		};
	private static final Class<?>[] _countByGroupIdParameterTypes2 = new Class[] {
			long.class
		};
}