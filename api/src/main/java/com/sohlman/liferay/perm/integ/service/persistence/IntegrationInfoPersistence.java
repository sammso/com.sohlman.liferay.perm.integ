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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sohlman.liferay.perm.integ.exception.NoSuchInfoException;
import com.sohlman.liferay.perm.integ.model.IntegrationInfo;

/**
 * The persistence interface for the integration info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sohlman.liferay.perm.integ.service.persistence.impl.IntegrationInfoPersistenceImpl
 * @see IntegrationInfoUtil
 * @generated
 */
@ProviderType
public interface IntegrationInfoPersistence extends BasePersistence<IntegrationInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IntegrationInfoUtil} to access the integration info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the integration infos where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @return the matching integration infos
	*/
	public java.util.List<IntegrationInfo> findByResourceBlockId(
		long resourceBlockId);

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
	public java.util.List<IntegrationInfo> findByResourceBlockId(
		long resourceBlockId, int start, int end);

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
	public java.util.List<IntegrationInfo> findByResourceBlockId(
		long resourceBlockId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

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
	public java.util.List<IntegrationInfo> findByResourceBlockId(
		long resourceBlockId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first integration info in the ordered set where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public IntegrationInfo findByResourceBlockId_First(long resourceBlockId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException;

	/**
	* Returns the first integration info in the ordered set where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public IntegrationInfo fetchByResourceBlockId_First(long resourceBlockId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

	/**
	* Returns the last integration info in the ordered set where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public IntegrationInfo findByResourceBlockId_Last(long resourceBlockId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException;

	/**
	* Returns the last integration info in the ordered set where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public IntegrationInfo fetchByResourceBlockId_Last(long resourceBlockId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

	/**
	* Returns the integration infos before and after the current integration info in the ordered set where resourceBlockId = &#63;.
	*
	* @param integrationInfoId the primary key of the current integration info
	* @param resourceBlockId the resource block ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next integration info
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public IntegrationInfo[] findByResourceBlockId_PrevAndNext(
		long integrationInfoId, long resourceBlockId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException;

	/**
	* Removes all the integration infos where resourceBlockId = &#63; from the database.
	*
	* @param resourceBlockId the resource block ID
	*/
	public void removeByResourceBlockId(long resourceBlockId);

	/**
	* Returns the number of integration infos where resourceBlockId = &#63;.
	*
	* @param resourceBlockId the resource block ID
	* @return the number of matching integration infos
	*/
	public int countByResourceBlockId(long resourceBlockId);

	/**
	* Returns all the integration infos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching integration infos
	*/
	public java.util.List<IntegrationInfo> findByGroupId(long groupId);

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
	public java.util.List<IntegrationInfo> findByGroupId(long groupId,
		int start, int end);

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
	public java.util.List<IntegrationInfo> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

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
	public java.util.List<IntegrationInfo> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first integration info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public IntegrationInfo findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException;

	/**
	* Returns the first integration info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public IntegrationInfo fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

	/**
	* Returns the last integration info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public IntegrationInfo findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException;

	/**
	* Returns the last integration info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public IntegrationInfo fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

	/**
	* Returns the integration infos before and after the current integration info in the ordered set where groupId = &#63;.
	*
	* @param integrationInfoId the primary key of the current integration info
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next integration info
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public IntegrationInfo[] findByGroupId_PrevAndNext(long integrationInfoId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException;

	/**
	* Returns all the integration infos that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching integration infos that the user has permission to view
	*/
	public java.util.List<IntegrationInfo> filterFindByGroupId(long groupId);

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
	public java.util.List<IntegrationInfo> filterFindByGroupId(long groupId,
		int start, int end);

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
	public java.util.List<IntegrationInfo> filterFindByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

	/**
	* Returns the integration infos before and after the current integration info in the ordered set of integration infos that the user has permission to view where groupId = &#63;.
	*
	* @param integrationInfoId the primary key of the current integration info
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next integration info
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public IntegrationInfo[] filterFindByGroupId_PrevAndNext(
		long integrationInfoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException;

	/**
	* Removes all the integration infos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of integration infos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching integration infos
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the number of integration infos that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching integration infos that the user has permission to view
	*/
	public int filterCountByGroupId(long groupId);

	/**
	* Returns the integration info where groupId = &#63; and className = &#63; or throws a {@link NoSuchInfoException} if it could not be found.
	*
	* @param groupId the group ID
	* @param className the class name
	* @return the matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public IntegrationInfo findByG_CN(long groupId, java.lang.String className)
		throws NoSuchInfoException;

	/**
	* Returns the integration info where groupId = &#63; and className = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param className the class name
	* @return the matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public IntegrationInfo fetchByG_CN(long groupId, java.lang.String className);

	/**
	* Returns the integration info where groupId = &#63; and className = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param className the class name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public IntegrationInfo fetchByG_CN(long groupId,
		java.lang.String className, boolean retrieveFromCache);

	/**
	* Removes the integration info where groupId = &#63; and className = &#63; from the database.
	*
	* @param groupId the group ID
	* @param className the class name
	* @return the integration info that was removed
	*/
	public IntegrationInfo removeByG_CN(long groupId, java.lang.String className)
		throws NoSuchInfoException;

	/**
	* Returns the number of integration infos where groupId = &#63; and className = &#63;.
	*
	* @param groupId the group ID
	* @param className the class name
	* @return the number of matching integration infos
	*/
	public int countByG_CN(long groupId, java.lang.String className);

	/**
	* Returns all the integration infos where className = &#63;.
	*
	* @param className the class name
	* @return the matching integration infos
	*/
	public java.util.List<IntegrationInfo> findByClassname(
		java.lang.String className);

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
	public java.util.List<IntegrationInfo> findByClassname(
		java.lang.String className, int start, int end);

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
	public java.util.List<IntegrationInfo> findByClassname(
		java.lang.String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

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
	public java.util.List<IntegrationInfo> findByClassname(
		java.lang.String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first integration info in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public IntegrationInfo findByClassname_First(java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException;

	/**
	* Returns the first integration info in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public IntegrationInfo fetchByClassname_First(java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

	/**
	* Returns the last integration info in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info
	* @throws NoSuchInfoException if a matching integration info could not be found
	*/
	public IntegrationInfo findByClassname_Last(java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException;

	/**
	* Returns the last integration info in the ordered set where className = &#63;.
	*
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching integration info, or <code>null</code> if a matching integration info could not be found
	*/
	public IntegrationInfo fetchByClassname_Last(java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

	/**
	* Returns the integration infos before and after the current integration info in the ordered set where className = &#63;.
	*
	* @param integrationInfoId the primary key of the current integration info
	* @param className the class name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next integration info
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public IntegrationInfo[] findByClassname_PrevAndNext(
		long integrationInfoId, java.lang.String className,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException;

	/**
	* Removes all the integration infos where className = &#63; from the database.
	*
	* @param className the class name
	*/
	public void removeByClassname(java.lang.String className);

	/**
	* Returns the number of integration infos where className = &#63;.
	*
	* @param className the class name
	* @return the number of matching integration infos
	*/
	public int countByClassname(java.lang.String className);

	/**
	* Caches the integration info in the entity cache if it is enabled.
	*
	* @param integrationInfo the integration info
	*/
	public void cacheResult(IntegrationInfo integrationInfo);

	/**
	* Caches the integration infos in the entity cache if it is enabled.
	*
	* @param integrationInfos the integration infos
	*/
	public void cacheResult(java.util.List<IntegrationInfo> integrationInfos);

	/**
	* Creates a new integration info with the primary key. Does not add the integration info to the database.
	*
	* @param integrationInfoId the primary key for the new integration info
	* @return the new integration info
	*/
	public IntegrationInfo create(long integrationInfoId);

	/**
	* Removes the integration info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param integrationInfoId the primary key of the integration info
	* @return the integration info that was removed
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public IntegrationInfo remove(long integrationInfoId)
		throws NoSuchInfoException;

	public IntegrationInfo updateImpl(IntegrationInfo integrationInfo);

	/**
	* Returns the integration info with the primary key or throws a {@link NoSuchInfoException} if it could not be found.
	*
	* @param integrationInfoId the primary key of the integration info
	* @return the integration info
	* @throws NoSuchInfoException if a integration info with the primary key could not be found
	*/
	public IntegrationInfo findByPrimaryKey(long integrationInfoId)
		throws NoSuchInfoException;

	/**
	* Returns the integration info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param integrationInfoId the primary key of the integration info
	* @return the integration info, or <code>null</code> if a integration info with the primary key could not be found
	*/
	public IntegrationInfo fetchByPrimaryKey(long integrationInfoId);

	@Override
	public java.util.Map<java.io.Serializable, IntegrationInfo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the integration infos.
	*
	* @return the integration infos
	*/
	public java.util.List<IntegrationInfo> findAll();

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
	public java.util.List<IntegrationInfo> findAll(int start, int end);

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
	public java.util.List<IntegrationInfo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator);

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
	public java.util.List<IntegrationInfo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the integration infos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of integration infos.
	*
	* @return the number of integration infos
	*/
	public int countAll();
}