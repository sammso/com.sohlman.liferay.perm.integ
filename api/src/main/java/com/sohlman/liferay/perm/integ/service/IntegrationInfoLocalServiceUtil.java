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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for IntegrationInfo. This utility wraps
 * {@link com.sohlman.liferay.perm.integ.service.impl.IntegrationInfoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see IntegrationInfoLocalService
 * @see com.sohlman.liferay.perm.integ.service.base.IntegrationInfoLocalServiceBaseImpl
 * @see com.sohlman.liferay.perm.integ.service.impl.IntegrationInfoLocalServiceImpl
 * @generated
 */
@ProviderType
public class IntegrationInfoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sohlman.liferay.perm.integ.service.impl.IntegrationInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the integration info to the database. Also notifies the appropriate model listeners.
	*
	* @param integrationInfo the integration info
	* @return the integration info that was added
	*/
	public static com.sohlman.liferay.perm.integ.model.IntegrationInfo addIntegrationInfo(
		com.sohlman.liferay.perm.integ.model.IntegrationInfo integrationInfo) {
		return getService().addIntegrationInfo(integrationInfo);
	}

	public static com.sohlman.liferay.perm.integ.model.IntegrationInfo addIntegrationInfo(
		long groupId, java.lang.String className)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addIntegrationInfo(groupId, className);
	}

	/**
	* Creates a new integration info with the primary key. Does not add the integration info to the database.
	*
	* @param integrationInfoId the primary key for the new integration info
	* @return the new integration info
	*/
	public static com.sohlman.liferay.perm.integ.model.IntegrationInfo createIntegrationInfo(
		long integrationInfoId) {
		return getService().createIntegrationInfo(integrationInfoId);
	}

	/**
	* Deletes the integration info from the database. Also notifies the appropriate model listeners.
	*
	* @param integrationInfo the integration info
	* @return the integration info that was removed
	*/
	public static com.sohlman.liferay.perm.integ.model.IntegrationInfo deleteIntegrationInfo(
		com.sohlman.liferay.perm.integ.model.IntegrationInfo integrationInfo) {
		return getService().deleteIntegrationInfo(integrationInfo);
	}

	/**
	* Deletes the integration info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param integrationInfoId the primary key of the integration info
	* @return the integration info that was removed
	* @throws PortalException if a integration info with the primary key could not be found
	*/
	public static com.sohlman.liferay.perm.integ.model.IntegrationInfo deleteIntegrationInfo(
		long integrationInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteIntegrationInfo(integrationInfoId);
	}

	public static com.sohlman.liferay.perm.integ.model.IntegrationInfo fetchIntegrationInfo(
		long integrationInfoId) {
		return getService().fetchIntegrationInfo(integrationInfoId);
	}

	/**
	* Returns the integration info with the primary key.
	*
	* @param integrationInfoId the primary key of the integration info
	* @return the integration info
	* @throws PortalException if a integration info with the primary key could not be found
	*/
	public static com.sohlman.liferay.perm.integ.model.IntegrationInfo getIntegrationInfo(
		long integrationInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getIntegrationInfo(integrationInfoId);
	}

	/**
	* Updates the integration info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param integrationInfo the integration info
	* @return the integration info that was updated
	*/
	public static com.sohlman.liferay.perm.integ.model.IntegrationInfo updateIntegrationInfo(
		com.sohlman.liferay.perm.integ.model.IntegrationInfo integrationInfo) {
		return getService().updateIntegrationInfo(integrationInfo);
	}

	/**
	* Returns the number of integration infos.
	*
	* @return the number of integration infos
	*/
	public static int getIntegrationInfosCount() {
		return getService().getIntegrationInfosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.perm.integ.model.impl.IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.perm.integ.model.impl.IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the integration infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.perm.integ.model.impl.IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @return the range of integration infos
	*/
	public static java.util.List<com.sohlman.liferay.perm.integ.model.IntegrationInfo> getIntegrationInfos(
		int start, int end) {
		return getService().getIntegrationInfos(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void updateIntegrationInfoByClassname(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().updateIntegrationInfoByClassname(className);
	}

	public static void updateIntegrationInfoForGroup(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().updateIntegrationInfoForGroup(groupId);
	}

	public static IntegrationInfoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<IntegrationInfoLocalService, IntegrationInfoLocalService> _serviceTracker =
		ServiceTrackerFactory.open(IntegrationInfoLocalService.class);
}