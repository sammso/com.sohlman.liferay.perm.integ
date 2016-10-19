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

package com.sohlman.liferay.perm.integ.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IntegrationInfoService}.
 *
 * @author Brian Wing Shun Chan
 * @see IntegrationInfoService
 * @generated
 */
@ProviderType
public class IntegrationInfoServiceWrapper implements IntegrationInfoService,
	ServiceWrapper<IntegrationInfoService> {
	public IntegrationInfoServiceWrapper(
		IntegrationInfoService integrationInfoService) {
		_integrationInfoService = integrationInfoService;
	}

	@Override
	public com.sohlman.liferay.perm.integ.model.IntegrationInfo fetchIntegrationInfo(
		long groupId, java.lang.String className) {
		return _integrationInfoService.fetchIntegrationInfo(groupId, className);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _integrationInfoService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.sohlman.liferay.perm.integ.model.IntegrationInfo> findByGroupId(
		long groupId, int start, int end) {
		return _integrationInfoService.findByGroupId(groupId, start, end);
	}

	@Override
	public long countByGroupId(long groupId) {
		return _integrationInfoService.countByGroupId(groupId);
	}

	@Override
	public IntegrationInfoService getWrappedService() {
		return _integrationInfoService;
	}

	@Override
	public void setWrappedService(IntegrationInfoService integrationInfoService) {
		_integrationInfoService = integrationInfoService;
	}

	private IntegrationInfoService _integrationInfoService;
}