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

package com.sohlman.liferay.perm.integ.service.impl;

import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.sohlman.liferay.perm.integ.model.IntegrationInfo;
import com.sohlman.liferay.perm.integ.service.base.IntegrationInfoServiceBaseImpl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the integration info remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sohlman.liferay.perm.integ.service.IntegrationInfoService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IntegrationInfoServiceBaseImpl
 * @see com.sohlman.liferay.perm.integ.service.IntegrationInfoServiceUtil
 */
@ProviderType
public class IntegrationInfoServiceImpl extends IntegrationInfoServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.sohlman.liferay.perm.integ.service.IntegrationInfoServiceUtil} to access the integration info remote service.
	 */
	
	@Override
	public IntegrationInfo fetchIntegrationInfo(long groupId, String className)  {
		IntegrationInfo integrationInfo = integrationInfoPersistence.fetchByG_CN(groupId, className);
		
		try {
			getPermissionChecker().
				hasPermission(groupId, IntegrationInfo.class.getName(), 
					integrationInfo.getIntegrationInfoId(), "EXECUTE");

			return integrationInfo;
		} catch (PrincipalException e) {
			return null;
		}
	}
	
	@Override
	public List<IntegrationInfo> findByGroupId(long groupId, int start, int end) {
		return integrationInfoPersistence.filterFindByGroupId(groupId, start, end);
	}
	
	@Override
	public long countByGroupId(long groupId) {
		return integrationInfoPersistence.filterCountByGroupId(groupId);
	}
}