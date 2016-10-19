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

package com.sohlman.liferay.perm.integ.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link IntegrationInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IntegrationInfo
 * @generated
 */
@ProviderType
public class IntegrationInfoWrapper implements IntegrationInfo,
	ModelWrapper<IntegrationInfo> {
	public IntegrationInfoWrapper(IntegrationInfo integrationInfo) {
		_integrationInfo = integrationInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return IntegrationInfo.class;
	}

	@Override
	public String getModelClassName() {
		return IntegrationInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("integrationInfoId", getIntegrationInfoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("resourceBlockId", getResourceBlockId());
		attributes.put("className", getClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long integrationInfoId = (Long)attributes.get("integrationInfoId");

		if (integrationInfoId != null) {
			setIntegrationInfoId(integrationInfoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long resourceBlockId = (Long)attributes.get("resourceBlockId");

		if (resourceBlockId != null) {
			setResourceBlockId(resourceBlockId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}
	}

	@Override
	public IntegrationInfo toEscapedModel() {
		return new IntegrationInfoWrapper(_integrationInfo.toEscapedModel());
	}

	@Override
	public IntegrationInfo toUnescapedModel() {
		return new IntegrationInfoWrapper(_integrationInfo.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _integrationInfo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _integrationInfo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _integrationInfo.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _integrationInfo.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<IntegrationInfo> toCacheModel() {
		return _integrationInfo.toCacheModel();
	}

	@Override
	public int compareTo(IntegrationInfo integrationInfo) {
		return _integrationInfo.compareTo(integrationInfo);
	}

	@Override
	public int hashCode() {
		return _integrationInfo.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _integrationInfo.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new IntegrationInfoWrapper((IntegrationInfo)_integrationInfo.clone());
	}

	/**
	* Returns the class name of this integration info.
	*
	* @return the class name of this integration info
	*/
	@Override
	public java.lang.String getClassName() {
		return _integrationInfo.getClassName();
	}

	/**
	* Returns the user name of this integration info.
	*
	* @return the user name of this integration info
	*/
	@Override
	public java.lang.String getUserName() {
		return _integrationInfo.getUserName();
	}

	/**
	* Returns the user uuid of this integration info.
	*
	* @return the user uuid of this integration info
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _integrationInfo.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _integrationInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _integrationInfo.toXmlString();
	}

	/**
	* Returns the create date of this integration info.
	*
	* @return the create date of this integration info
	*/
	@Override
	public Date getCreateDate() {
		return _integrationInfo.getCreateDate();
	}

	/**
	* Returns the modified date of this integration info.
	*
	* @return the modified date of this integration info
	*/
	@Override
	public Date getModifiedDate() {
		return _integrationInfo.getModifiedDate();
	}

	/**
	* Returns the company ID of this integration info.
	*
	* @return the company ID of this integration info
	*/
	@Override
	public long getCompanyId() {
		return _integrationInfo.getCompanyId();
	}

	/**
	* Returns the group ID of this integration info.
	*
	* @return the group ID of this integration info
	*/
	@Override
	public long getGroupId() {
		return _integrationInfo.getGroupId();
	}

	/**
	* Returns the integration info ID of this integration info.
	*
	* @return the integration info ID of this integration info
	*/
	@Override
	public long getIntegrationInfoId() {
		return _integrationInfo.getIntegrationInfoId();
	}

	/**
	* Returns the primary key of this integration info.
	*
	* @return the primary key of this integration info
	*/
	@Override
	public long getPrimaryKey() {
		return _integrationInfo.getPrimaryKey();
	}

	/**
	* Returns the resource block ID of this integration info.
	*
	* @return the resource block ID of this integration info
	*/
	@Override
	public long getResourceBlockId() {
		return _integrationInfo.getResourceBlockId();
	}

	/**
	* Returns the user ID of this integration info.
	*
	* @return the user ID of this integration info
	*/
	@Override
	public long getUserId() {
		return _integrationInfo.getUserId();
	}

	@Override
	public void persist() {
		_integrationInfo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_integrationInfo.setCachedModel(cachedModel);
	}

	/**
	* Sets the class name of this integration info.
	*
	* @param className the class name of this integration info
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_integrationInfo.setClassName(className);
	}

	/**
	* Sets the company ID of this integration info.
	*
	* @param companyId the company ID of this integration info
	*/
	@Override
	public void setCompanyId(long companyId) {
		_integrationInfo.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this integration info.
	*
	* @param createDate the create date of this integration info
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_integrationInfo.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_integrationInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_integrationInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_integrationInfo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this integration info.
	*
	* @param groupId the group ID of this integration info
	*/
	@Override
	public void setGroupId(long groupId) {
		_integrationInfo.setGroupId(groupId);
	}

	/**
	* Sets the integration info ID of this integration info.
	*
	* @param integrationInfoId the integration info ID of this integration info
	*/
	@Override
	public void setIntegrationInfoId(long integrationInfoId) {
		_integrationInfo.setIntegrationInfoId(integrationInfoId);
	}

	/**
	* Sets the modified date of this integration info.
	*
	* @param modifiedDate the modified date of this integration info
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_integrationInfo.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_integrationInfo.setNew(n);
	}

	/**
	* Sets the primary key of this integration info.
	*
	* @param primaryKey the primary key of this integration info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_integrationInfo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_integrationInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the resource block ID of this integration info.
	*
	* @param resourceBlockId the resource block ID of this integration info
	*/
	@Override
	public void setResourceBlockId(long resourceBlockId) {
		_integrationInfo.setResourceBlockId(resourceBlockId);
	}

	/**
	* Sets the user ID of this integration info.
	*
	* @param userId the user ID of this integration info
	*/
	@Override
	public void setUserId(long userId) {
		_integrationInfo.setUserId(userId);
	}

	/**
	* Sets the user name of this integration info.
	*
	* @param userName the user name of this integration info
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_integrationInfo.setUserName(userName);
	}

	/**
	* Sets the user uuid of this integration info.
	*
	* @param userUuid the user uuid of this integration info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_integrationInfo.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IntegrationInfoWrapper)) {
			return false;
		}

		IntegrationInfoWrapper integrationInfoWrapper = (IntegrationInfoWrapper)obj;

		if (Objects.equals(_integrationInfo,
					integrationInfoWrapper._integrationInfo)) {
			return true;
		}

		return false;
	}

	@Override
	public IntegrationInfo getWrappedModel() {
		return _integrationInfo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _integrationInfo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _integrationInfo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_integrationInfo.resetOriginalValues();
	}

	private final IntegrationInfo _integrationInfo;
}