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

package com.sohlman.liferay.perm.integ.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sohlman.liferay.perm.integ.model.IntegrationInfo;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the integration info service. This utility wraps {@link com.sohlman.liferay.perm.integ.service.persistence.impl.IntegrationInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IntegrationInfoPersistence
 * @see com.sohlman.liferay.perm.integ.service.persistence.impl.IntegrationInfoPersistenceImpl
 * @generated
 */
@ProviderType
public class IntegrationInfoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(IntegrationInfo integrationInfo) {
		getPersistence().clearCache(integrationInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<IntegrationInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IntegrationInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IntegrationInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static IntegrationInfo update(IntegrationInfo integrationInfo) {
		return getPersistence().update(integrationInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static IntegrationInfo update(IntegrationInfo integrationInfo,
		ServiceContext serviceContext) {
		return getPersistence().update(integrationInfo, serviceContext);
	}

	/**
	* Returns all the integration infos where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @return the matching integration infos
	*/
	public static List<IntegrationInfo> findByResourceBlockId(
		long resourceBlockId) {
		return getPersistence().findByResourceBlockId(resourceBlockId);
	}

	/**
	* Returns a range of all the integration infos where resourceBlockId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param resourceBlockId the resource block ID
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @return the range of matching integration infos
	*/
	public static List<IntegrationInfo> findByResourceBlockId(
		long resourceBlockId, int start, int end) {
		return getPersistence()
				   .findByResourceBlockId(resourceBlockId, start, end);
	}

	/**
	* Returns an ordered range of all the integration infos where resourceBlockId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param resourceBlockId the resource block ID
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching integration infos
	*/
	public static List<IntegrationInfo> findByResourceBlockId(
		long resourceBlockId, int start, int end,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence()
				   .findByResourceBlockId(resourceBlockId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the integration infos where resourceBlockId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param resourceBlockId the resource block ID
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching integration infos
	*/
	public static List<IntegrationInfo> findByResourceBlockId(
		long resourceBlockId, int start, int end,
		OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByResourceBlockId(resourceBlockId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first integration info in the ordered set where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public static IntegrationInfo findByResourceBlockId_First(
		long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence()
				   .findByResourceBlockId_First(resourceBlockId,
			orderByComparator);
	}

	/**
	* Returns the first integration info in the ordered set where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public static IntegrationInfo fetchByResourceBlockId_First(
		long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence()
				   .fetchByResourceBlockId_First(resourceBlockId,
			orderByComparator);
	}

	/**
	* Returns the last integration info in the ordered set where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public static IntegrationInfo findByResourceBlockId_Last(
		long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence()
				   .findByResourceBlockId_Last(resourceBlockId,
			orderByComparator);
	}

	/**
	* Returns the last integration info in the ordered set where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public static IntegrationInfo fetchByResourceBlockId_Last(
		long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence()
				   .fetchByResourceBlockId_Last(resourceBlockId,
			orderByComparator);
	}

	/**
	* Returns the integration infos before and after the current integration info in the ordered set where resourceBlockId = &#63;.
	*
	* @param integrationInfoId the primary key of the current integration info
	* @param resourceBlockId the resource block ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next integration info
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public static IntegrationInfo[] findByResourceBlockId_PrevAndNext(
		long integrationInfoId, long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence()
				   .findByResourceBlockId_PrevAndNext(integrationInfoId,
			resourceBlockId, orderByComparator);
	}

	/**
	* Removes all the integration infos where resourceBlockId = &#63; from the database.
	*
	* @param resourceBlockId the resource block ID
	*/
	public static void removeByResourceBlockId(long resourceBlockId) {
		getPersistence().removeByResourceBlockId(resourceBlockId);
	}

	/**
	* Returns the number of integration infos where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @return the number of matching integration infos
	*/
	public static int countByResourceBlockId(long resourceBlockId) {
		return getPersistence().countByResourceBlockId(resourceBlockId);
	}

	/**
	* Returns all the integration infos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching integration infos
	*/
	public static List<IntegrationInfo> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the integration infos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @return the range of matching integration infos
	*/
	public static List<IntegrationInfo> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the integration infos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching integration infos
	*/
	public static List<IntegrationInfo> findByGroupId(long groupId, int start,
		int end, OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the integration infos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching integration infos
	*/
	public static List<IntegrationInfo> findByGroupId(long groupId, int start,
		int end, OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first integration info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public static IntegrationInfo findByGroupId_First(long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first integration info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public static IntegrationInfo fetchByGroupId_First(long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last integration info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public static IntegrationInfo findByGroupId_Last(long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last integration info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public static IntegrationInfo fetchByGroupId_Last(long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the integration infos before and after the current integration info in the ordered set where groupId = &#63;.
	*
	* @param integrationInfoId the primary key of the current integration info
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next integration info
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public static IntegrationInfo[] findByGroupId_PrevAndNext(
		long integrationInfoId, long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(integrationInfoId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the integration infos that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching integration infos that the user has permission to view
	*/
	public static List<IntegrationInfo> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the integration infos that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @return the range of matching integration infos that the user has permission to view
	*/
	public static List<IntegrationInfo> filterFindByGroupId(long groupId,
		int start, int end) {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the integration infos that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching integration infos that the user has permission to view
	*/
	public static List<IntegrationInfo> filterFindByGroupId(long groupId,
		int start, int end, OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the integration infos before and after the current integration info in the ordered set of integration infos that the user has permission to view where groupId = &#63;.
	*
	* @param integrationInfoId the primary key of the current integration info
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next integration info
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public static IntegrationInfo[] filterFindByGroupId_PrevAndNext(
		long integrationInfoId, long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(integrationInfoId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the integration infos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of integration infos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching integration infos
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of integration infos that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching integration infos that the user has permission to view
	*/
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the integration info where groupId = &#63; and className = &#63; or throws a {@link NoSuchInfoException} if it could not be found.
	*
	* @param groupId the group ID
	* @param className the class name
	* @return the matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public static IntegrationInfo findByG_CN(long groupId,
		java.lang.String className)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence().findByG_CN(groupId, className);
	}

	/**
	* Returns the integration info where groupId = &#63; and className = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param className the class name
	* @return the matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public static IntegrationInfo fetchByG_CN(long groupId,
		java.lang.String className) {
		return getPersistence().fetchByG_CN(groupId, className);
	}

	/**
	* Returns the integration info where groupId = &#63; and className = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param className the class name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public static IntegrationInfo fetchByG_CN(long groupId,
		java.lang.String className, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByG_CN(groupId, className, retrieveFromCache);
	}

	/**
	* Removes the integration info where groupId = &#63; and className = &#63; from the database.
	*
	* @param groupId the group ID
	* @param className the class name
	* @return the integration info that was removed
	*/
	public static IntegrationInfo removeByG_CN(long groupId,
		java.lang.String className)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence().removeByG_CN(groupId, className);
	}

	/**
	* Returns the number of integration infos where groupId = &#63; and className = &#63;.
	*
	* @param groupId the group ID
	* @param className the class name
	* @return the number of matching integration infos
	*/
	public static int countByG_CN(long groupId, java.lang.String className) {
		return getPersistence().countByG_CN(groupId, className);
	}

	/**
	* Returns all the integration infos where className = &#63;.
	*
	* @param className the class name
	* @return the matching integration infos
	*/
	public static List<IntegrationInfo> findByClassname(
		java.lang.String className) {
		return getPersistence().findByClassname(className);
	}

	/**
	* Returns a range of all the integration infos where className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @return the range of matching integration infos
	*/
	public static List<IntegrationInfo> findByClassname(
		java.lang.String className, int start, int end) {
		return getPersistence().findByClassname(className, start, end);
	}

	/**
	* Returns an ordered range of all the integration infos where className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching integration infos
	*/
	public static List<IntegrationInfo> findByClassname(
		java.lang.String className, int start, int end,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence()
				   .findByClassname(className, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the integration infos where className = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching integration infos
	*/
	public static List<IntegrationInfo> findByClassname(
		java.lang.String className, int start, int end,
		OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByClassname(className, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first integration info in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public static IntegrationInfo findByClassname_First(
		java.lang.String className,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence()
				   .findByClassname_First(className, orderByComparator);
	}

	/**
	* Returns the first integration info in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public static IntegrationInfo fetchByClassname_First(
		java.lang.String className,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence()
				   .fetchByClassname_First(className, orderByComparator);
	}

	/**
	* Returns the last integration info in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public static IntegrationInfo findByClassname_Last(
		java.lang.String className,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence()
				   .findByClassname_Last(className, orderByComparator);
	}

	/**
	* Returns the last integration info in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public static IntegrationInfo fetchByClassname_Last(
		java.lang.String className,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence()
				   .fetchByClassname_Last(className, orderByComparator);
	}

	/**
	* Returns the integration infos before and after the current integration info in the ordered set where className = &#63;.
	*
	* @param integrationInfoId the primary key of the current integration info
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next integration info
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public static IntegrationInfo[] findByClassname_PrevAndNext(
		long integrationInfoId, java.lang.String className,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence()
				   .findByClassname_PrevAndNext(integrationInfoId, className,
			orderByComparator);
	}

	/**
	* Removes all the integration infos where className = &#63; from the database.
	*
	* @param className the class name
	*/
	public static void removeByClassname(java.lang.String className) {
		getPersistence().removeByClassname(className);
	}

	/**
	* Returns the number of integration infos where className = &#63;.
	*
	* @param className the class name
	* @return the number of matching integration infos
	*/
	public static int countByClassname(java.lang.String className) {
		return getPersistence().countByClassname(className);
	}

	/**
	* Caches the integration info in the entity cache if it is enabled.
	*
	* @param integrationInfo the integration info
	*/
	public static void cacheResult(IntegrationInfo integrationInfo) {
		getPersistence().cacheResult(integrationInfo);
	}

	/**
	* Caches the integration infos in the entity cache if it is enabled.
	*
	* @param integrationInfos the integration infos
	*/
	public static void cacheResult(List<IntegrationInfo> integrationInfos) {
		getPersistence().cacheResult(integrationInfos);
	}

	/**
	* Creates a new integration info with the primary key. Does not add the integration info to the database.
	*
	* @param integrationInfoId the primary key for the new integration info
	* @return the new integration info
	*/
	public static IntegrationInfo create(long integrationInfoId) {
		return getPersistence().create(integrationInfoId);
	}

	/**
	* Removes the integration info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param integrationInfoId the primary key of the integration info
	* @return the integration info that was removed
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public static IntegrationInfo remove(long integrationInfoId)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence().remove(integrationInfoId);
	}

	public static IntegrationInfo updateImpl(IntegrationInfo integrationInfo) {
		return getPersistence().updateImpl(integrationInfo);
	}

	/**
	* Returns the integration info with the primary key or throws a {@link NoSuchInfoException} if it could not be found.
	*
	* @param integrationInfoId the primary key of the integration info
	* @return the integration info
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public static IntegrationInfo findByPrimaryKey(long integrationInfoId)
		throws com.sohlman.liferay.perm.integ.exception.NoSuchInfoException {
		return getPersistence().findByPrimaryKey(integrationInfoId);
	}

	/**
	* Returns the integration info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param integrationInfoId the primary key of the integration info
	* @return the integration info, or <code>null</code> if a integration info with the primary key could not be found
	*/
	public static IntegrationInfo fetchByPrimaryKey(long integrationInfoId) {
		return getPersistence().fetchByPrimaryKey(integrationInfoId);
	}

	public static java.util.Map<java.io.Serializable, IntegrationInfo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the integration infos.
	*
	* @return the integration infos
	*/
	public static List<IntegrationInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the integration infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @return the range of integration infos
	*/
	public static List<IntegrationInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the integration infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of integration infos
	*/
	public static List<IntegrationInfo> findAll(int start, int end,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the integration infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IntegrationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of integration infos
	* @param end the upper bound of the range of integration infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of integration infos
	*/
	public static List<IntegrationInfo> findAll(int start, int end,
		OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the integration infos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of integration infos.
	*
	* @return the number of integration infos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IntegrationInfoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<IntegrationInfoPersistence, IntegrationInfoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(IntegrationInfoPersistence.class);
}