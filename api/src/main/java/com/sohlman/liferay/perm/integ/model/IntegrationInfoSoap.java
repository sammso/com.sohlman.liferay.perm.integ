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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sohlman.liferay.perm.integ.service.http.IntegrationInfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.sohlman.liferay.perm.integ.service.http.IntegrationInfoServiceSoap
 * @generated
 */
@ProviderType
public class IntegrationInfoSoap implements Serializable {
	public static IntegrationInfoSoap toSoapModel(IntegrationInfo model) {
		IntegrationInfoSoap soapModel = new IntegrationInfoSoap();

		soapModel.setIntegrationInfoId(model.getIntegrationInfoId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setResourceBlockId(model.getResourceBlockId());
		soapModel.setClassName(model.getClassName());

		return soapModel;
	}

	public static IntegrationInfoSoap[] toSoapModels(IntegrationInfo[] models) {
		IntegrationInfoSoap[] soapModels = new IntegrationInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IntegrationInfoSoap[][] toSoapModels(
		IntegrationInfo[][] models) {
		IntegrationInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IntegrationInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IntegrationInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IntegrationInfoSoap[] toSoapModels(
		List<IntegrationInfo> models) {
		List<IntegrationInfoSoap> soapModels = new ArrayList<IntegrationInfoSoap>(models.size());

		for (IntegrationInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IntegrationInfoSoap[soapModels.size()]);
	}

	public IntegrationInfoSoap() {
	}

	public long getPrimaryKey() {
		return _integrationInfoId;
	}

	public void setPrimaryKey(long pk) {
		setIntegrationInfoId(pk);
	}

	public long getIntegrationInfoId() {
		return _integrationInfoId;
	}

	public void setIntegrationInfoId(long integrationInfoId) {
		_integrationInfoId = integrationInfoId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getResourceBlockId() {
		return _resourceBlockId;
	}

	public void setResourceBlockId(long resourceBlockId) {
		_resourceBlockId = resourceBlockId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	private long _integrationInfoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _resourceBlockId;
	private String _className;
}