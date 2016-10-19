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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.sohlman.liferay.perm.integ.model.IntegrationInfo;
import com.sohlman.liferay.perm.integ.service.base.IntegrationInfoLocalServiceBaseImpl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the integration info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sohlman.liferay.perm.integ.service.IntegrationInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IntegrationInfoLocalServiceBaseImpl
 * @see com.sohlman.liferay.perm.integ.service.IntegrationInfoLocalServiceUtil
 */
@ProviderType
public class IntegrationInfoLocalServiceImpl
	extends IntegrationInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.sohlman.liferay.perm.integ.service.IntegrationInfoLocalServiceUtil} to access the integration info local service.
	 */
	@Override
	public IntegrationInfo addIntegrationInfo(long groupId, String className) throws PortalException {
		
		IntegrationInfo integrationInfo = integrationInfoPersistence.fetchByG_CN(groupId, className);
		
		if (integrationInfo==null) {
			Group group = groupLocalService.getGroup(groupId);
			long integrationInfoId = counterLocalService.increment(IntegrationInfo.class.getName());
			integrationInfo = createIntegrationInfo(integrationInfoId);
			integrationInfo.setIntegrationInfoId(integrationInfoId);
			integrationInfo.setCompanyId(group.getCompanyId());
			integrationInfo.setGroupId(group.getGroupId());
			integrationInfo.setClassName(className);
			integrationInfo.setUserId(0L);
			integrationInfo.setCreateDate(DateUtil.newDate());
			integrationInfo.setModifiedDate(integrationInfo.getCreateDate());
			
			ServiceContext serviceContext = new ServiceContext();
			
			serviceContext.setCompanyId(group.getCompanyId());
			serviceContext.setScopeGroupId(group.getGroupId());
			
			resourceLocalService.addModelResources(integrationInfo, serviceContext);
			integrationInfo = super.addIntegrationInfo(integrationInfo);
		} 
		return integrationInfo;
	}
	
	@Override
	public void updateIntegrationInfoByClassname(String className) throws PortalException {
		List<Group> groups = groupLocalService.getGroups(-1, -1);
		for (Group group : groups ) {
			addIntegrationInfo(group.getGroupId(), className);
		}
	}	
	
	@Override
	public void updateIntegrationInfoForGroup(long groupId) throws PortalException {
		List<String> classNames = integrationInfoFinder.findIntegrationClassNames();
		for ( String className : classNames)  {
			addIntegrationInfo(groupId, className);
		}
	}
	
	@Override
	public IntegrationInfo addIntegrationInfo(IntegrationInfo integrationInfo) {
		
		return super.addIntegrationInfo(integrationInfo);
	}
}