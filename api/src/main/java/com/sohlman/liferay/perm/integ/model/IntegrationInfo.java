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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PermissionedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the IntegrationInfo service. Represents a row in the &quot;IntegrationInfo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see IntegrationInfoModel
 * @see com.sohlman.liferay.perm.integ.model.impl.IntegrationInfoImpl
 * @see com.sohlman.liferay.perm.integ.model.impl.IntegrationInfoModelImpl
 * @generated
 */
@ImplementationClassName("com.sohlman.liferay.perm.integ.model.impl.IntegrationInfoImpl")
@ProviderType
public interface IntegrationInfo extends IntegrationInfoModel, PermissionedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.sohlman.liferay.perm.integ.model.impl.IntegrationInfoImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<IntegrationInfo, Long> INTEGRATION_INFO_ID_ACCESSOR =
		new Accessor<IntegrationInfo, Long>() {
			@Override
			public Long get(IntegrationInfo integrationInfo) {
				return integrationInfo.getIntegrationInfoId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<IntegrationInfo> getTypeClass() {
				return IntegrationInfo.class;
			}
		};
}