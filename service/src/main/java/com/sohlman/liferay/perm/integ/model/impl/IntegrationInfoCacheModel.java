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

package com.sohlman.liferay.perm.integ.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.sohlman.liferay.perm.integ.model.IntegrationInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing IntegrationInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see IntegrationInfo
 * @generated
 */
@ProviderType
public class IntegrationInfoCacheModel implements CacheModel<IntegrationInfo>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IntegrationInfoCacheModel)) {
			return false;
		}

		IntegrationInfoCacheModel integrationInfoCacheModel = (IntegrationInfoCacheModel)obj;

		if (integrationInfoId == integrationInfoCacheModel.integrationInfoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, integrationInfoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{integrationInfoId=");
		sb.append(integrationInfoId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", resourceBlockId=");
		sb.append(resourceBlockId);
		sb.append(", className=");
		sb.append(className);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IntegrationInfo toEntityModel() {
		IntegrationInfoImpl integrationInfoImpl = new IntegrationInfoImpl();

		integrationInfoImpl.setIntegrationInfoId(integrationInfoId);
		integrationInfoImpl.setGroupId(groupId);
		integrationInfoImpl.setCompanyId(companyId);
		integrationInfoImpl.setUserId(userId);

		if (userName == null) {
			integrationInfoImpl.setUserName(StringPool.BLANK);
		}
		else {
			integrationInfoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			integrationInfoImpl.setCreateDate(null);
		}
		else {
			integrationInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			integrationInfoImpl.setModifiedDate(null);
		}
		else {
			integrationInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		integrationInfoImpl.setResourceBlockId(resourceBlockId);

		if (className == null) {
			integrationInfoImpl.setClassName(StringPool.BLANK);
		}
		else {
			integrationInfoImpl.setClassName(className);
		}

		integrationInfoImpl.resetOriginalValues();

		return integrationInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		integrationInfoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		resourceBlockId = objectInput.readLong();
		className = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(integrationInfoId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(resourceBlockId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}
	}

	public long integrationInfoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long resourceBlockId;
	public String className;
}