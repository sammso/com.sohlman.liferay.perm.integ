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

package com.sohlman.liferay.perm.integ.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sohlman.liferay.perm.integ.exception.NoSuchInfoException;
import com.sohlman.liferay.perm.integ.model.IntegrationInfo;
import com.sohlman.liferay.perm.integ.model.impl.IntegrationInfoImpl;
import com.sohlman.liferay.perm.integ.model.impl.IntegrationInfoModelImpl;
import com.sohlman.liferay.perm.integ.service.persistence.IntegrationInfoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the integration info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IntegrationInfoPersistence
 * @see com.sohlman.liferay.perm.integ.service.persistence.IntegrationInfoUtil
 * @generated
 */
@ProviderType
public class IntegrationInfoPersistenceImpl extends BasePersistenceImpl<IntegrationInfo>
	implements IntegrationInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IntegrationInfoUtil} to access the integration info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IntegrationInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED,
			IntegrationInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED,
			IntegrationInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESOURCEBLOCKID =
		new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED,
			IntegrationInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByResourceBlockId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEBLOCKID =
		new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED,
			IntegrationInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByResourceBlockId",
			new String[] { Long.class.getName() },
			IntegrationInfoModelImpl.RESOURCEBLOCKID_COLUMN_BITMASK |
			IntegrationInfoModelImpl.GROUPID_COLUMN_BITMASK |
			IntegrationInfoModelImpl.CLASSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESOURCEBLOCKID = new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResourceBlockId", new String[] { Long.class.getName() });

	/**
	 * Returns all the integration infos where resourceBlockId = &#63;.
	 *
	 * @param resourceBlockId the resource block ID
	 * @return the matching integration infos
	 */
	@Override
	public List<IntegrationInfo> findByResourceBlockId(long resourceBlockId) {
		return findByResourceBlockId(resourceBlockId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<IntegrationInfo> findByResourceBlockId(long resourceBlockId,
		int start, int end) {
		return findByResourceBlockId(resourceBlockId, start, end, null);
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
	@Override
	public List<IntegrationInfo> findByResourceBlockId(long resourceBlockId,
		int start, int end, OrderByComparator<IntegrationInfo> orderByComparator) {
		return findByResourceBlockId(resourceBlockId, start, end,
			orderByComparator, true);
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
	@Override
	public List<IntegrationInfo> findByResourceBlockId(long resourceBlockId,
		int start, int end,
		OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEBLOCKID;
			finderArgs = new Object[] { resourceBlockId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESOURCEBLOCKID;
			finderArgs = new Object[] {
					resourceBlockId,
					
					start, end, orderByComparator
				};
		}

		List<IntegrationInfo> list = null;

		if (retrieveFromCache) {
			list = (List<IntegrationInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IntegrationInfo integrationInfo : list) {
					if ((resourceBlockId != integrationInfo.getResourceBlockId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_INTEGRATIONINFO_WHERE);

			query.append(_FINDER_COLUMN_RESOURCEBLOCKID_RESOURCEBLOCKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IntegrationInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resourceBlockId);

				if (!pagination) {
					list = (List<IntegrationInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IntegrationInfo>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first integration info in the ordered set where resourceBlockId = &#63;.
	 *
	 * @param resourceBlockId the resource block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching integration info
	 * @throws NoSuchInfoException if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo findByResourceBlockId_First(long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = fetchByResourceBlockId_First(resourceBlockId,
				orderByComparator);

		if (integrationInfo != null) {
			return integrationInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("resourceBlockId=");
		msg.append(resourceBlockId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInfoException(msg.toString());
	}

	/**
	 * Returns the first integration info in the ordered set where resourceBlockId = &#63;.
	 *
	 * @param resourceBlockId the resource block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching integration info, or <code>null</code> if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo fetchByResourceBlockId_First(long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		List<IntegrationInfo> list = findByResourceBlockId(resourceBlockId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last integration info in the ordered set where resourceBlockId = &#63;.
	 *
	 * @param resourceBlockId the resource block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching integration info
	 * @throws NoSuchInfoException if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo findByResourceBlockId_Last(long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = fetchByResourceBlockId_Last(resourceBlockId,
				orderByComparator);

		if (integrationInfo != null) {
			return integrationInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("resourceBlockId=");
		msg.append(resourceBlockId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInfoException(msg.toString());
	}

	/**
	 * Returns the last integration info in the ordered set where resourceBlockId = &#63;.
	 *
	 * @param resourceBlockId the resource block ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching integration info, or <code>null</code> if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo fetchByResourceBlockId_Last(long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		int count = countByResourceBlockId(resourceBlockId);

		if (count == 0) {
			return null;
		}

		List<IntegrationInfo> list = findByResourceBlockId(resourceBlockId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IntegrationInfo[] findByResourceBlockId_PrevAndNext(
		long integrationInfoId, long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = findByPrimaryKey(integrationInfoId);

		Session session = null;

		try {
			session = openSession();

			IntegrationInfo[] array = new IntegrationInfoImpl[3];

			array[0] = getByResourceBlockId_PrevAndNext(session,
					integrationInfo, resourceBlockId, orderByComparator, true);

			array[1] = integrationInfo;

			array[2] = getByResourceBlockId_PrevAndNext(session,
					integrationInfo, resourceBlockId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IntegrationInfo getByResourceBlockId_PrevAndNext(
		Session session, IntegrationInfo integrationInfo, long resourceBlockId,
		OrderByComparator<IntegrationInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTEGRATIONINFO_WHERE);

		query.append(_FINDER_COLUMN_RESOURCEBLOCKID_RESOURCEBLOCKID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(IntegrationInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(resourceBlockId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(integrationInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IntegrationInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the integration infos where resourceBlockId = &#63; from the database.
	 *
	 * @param resourceBlockId the resource block ID
	 */
	@Override
	public void removeByResourceBlockId(long resourceBlockId) {
		for (IntegrationInfo integrationInfo : findByResourceBlockId(
				resourceBlockId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(integrationInfo);
		}
	}

	/**
	 * Returns the number of integration infos where resourceBlockId = &#63;.
	 *
	 * @param resourceBlockId the resource block ID
	 * @return the number of matching integration infos
	 */
	@Override
	public int countByResourceBlockId(long resourceBlockId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESOURCEBLOCKID;

		Object[] finderArgs = new Object[] { resourceBlockId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INTEGRATIONINFO_WHERE);

			query.append(_FINDER_COLUMN_RESOURCEBLOCKID_RESOURCEBLOCKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resourceBlockId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_RESOURCEBLOCKID_RESOURCEBLOCKID_2 =
		"integrationInfo.resourceBlockId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED,
			IntegrationInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED,
			IntegrationInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			IntegrationInfoModelImpl.GROUPID_COLUMN_BITMASK |
			IntegrationInfoModelImpl.CLASSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the integration infos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching integration infos
	 */
	@Override
	public List<IntegrationInfo> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<IntegrationInfo> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<IntegrationInfo> findByGroupId(long groupId, int start,
		int end, OrderByComparator<IntegrationInfo> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<IntegrationInfo> findByGroupId(long groupId, int start,
		int end, OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<IntegrationInfo> list = null;

		if (retrieveFromCache) {
			list = (List<IntegrationInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IntegrationInfo integrationInfo : list) {
					if ((groupId != integrationInfo.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_INTEGRATIONINFO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IntegrationInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<IntegrationInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IntegrationInfo>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first integration info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching integration info
	 * @throws NoSuchInfoException if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo findByGroupId_First(long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = fetchByGroupId_First(groupId,
				orderByComparator);

		if (integrationInfo != null) {
			return integrationInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInfoException(msg.toString());
	}

	/**
	 * Returns the first integration info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching integration info, or <code>null</code> if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo fetchByGroupId_First(long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		List<IntegrationInfo> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last integration info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching integration info
	 * @throws NoSuchInfoException if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo findByGroupId_Last(long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (integrationInfo != null) {
			return integrationInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInfoException(msg.toString());
	}

	/**
	 * Returns the last integration info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching integration info, or <code>null</code> if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo fetchByGroupId_Last(long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<IntegrationInfo> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IntegrationInfo[] findByGroupId_PrevAndNext(long integrationInfoId,
		long groupId, OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = findByPrimaryKey(integrationInfoId);

		Session session = null;

		try {
			session = openSession();

			IntegrationInfo[] array = new IntegrationInfoImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, integrationInfo,
					groupId, orderByComparator, true);

			array[1] = integrationInfo;

			array[2] = getByGroupId_PrevAndNext(session, integrationInfo,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IntegrationInfo getByGroupId_PrevAndNext(Session session,
		IntegrationInfo integrationInfo, long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTEGRATIONINFO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(IntegrationInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(integrationInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IntegrationInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the integration infos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching integration infos that the user has permission to view
	 */
	@Override
	public List<IntegrationInfo> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<IntegrationInfo> filterFindByGroupId(long groupId, int start,
		int end) {
		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<IntegrationInfo> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator<IntegrationInfo> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTEGRATIONINFO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
				orderByComparator);
		}
		else {
			query.append(IntegrationInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				IntegrationInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				_FILTER_ENTITY_TABLE_FILTER_USERID_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<IntegrationInfo>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public IntegrationInfo[] filterFindByGroupId_PrevAndNext(
		long integrationInfoId, long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(integrationInfoId, groupId,
				orderByComparator);
		}

		IntegrationInfo integrationInfo = findByPrimaryKey(integrationInfoId);

		Session session = null;

		try {
			session = openSession();

			IntegrationInfo[] array = new IntegrationInfoImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, integrationInfo,
					groupId, orderByComparator, true);

			array[1] = integrationInfo;

			array[2] = filterGetByGroupId_PrevAndNext(session, integrationInfo,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IntegrationInfo filterGetByGroupId_PrevAndNext(Session session,
		IntegrationInfo integrationInfo, long groupId,
		OrderByComparator<IntegrationInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTEGRATIONINFO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(IntegrationInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				IntegrationInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				_FILTER_ENTITY_TABLE_FILTER_USERID_COLUMN, groupId);

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(integrationInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IntegrationInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the integration infos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (IntegrationInfo integrationInfo : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(integrationInfo);
		}
	}

	/**
	 * Returns the number of integration infos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching integration infos
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INTEGRATIONINFO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of integration infos that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching integration infos that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_SQL_COUNT_INTEGRATIONINFO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				IntegrationInfo.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				_FILTER_ENTITY_TABLE_FILTER_USERID_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "integrationInfo.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_CN = new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED,
			IntegrationInfoImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByG_CN",
			new String[] { Long.class.getName(), String.class.getName() },
			IntegrationInfoModelImpl.GROUPID_COLUMN_BITMASK |
			IntegrationInfoModelImpl.CLASSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_CN = new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_CN",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the integration info where groupId = &#63; and className = &#63; or throws a {@link NoSuchInfoException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @return the matching integration info
	 * @throws NoSuchInfoException if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo findByG_CN(long groupId, String className)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = fetchByG_CN(groupId, className);

		if (integrationInfo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", className=");
			msg.append(className);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchInfoException(msg.toString());
		}

		return integrationInfo;
	}

	/**
	 * Returns the integration info where groupId = &#63; and className = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @return the matching integration info, or <code>null</code> if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo fetchByG_CN(long groupId, String className) {
		return fetchByG_CN(groupId, className, true);
	}

	/**
	 * Returns the integration info where groupId = &#63; and className = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching integration info, or <code>null</code> if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo fetchByG_CN(long groupId, String className,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { groupId, className };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_G_CN,
					finderArgs, this);
		}

		if (result instanceof IntegrationInfo) {
			IntegrationInfo integrationInfo = (IntegrationInfo)result;

			if ((groupId != integrationInfo.getGroupId()) ||
					!Objects.equals(className, integrationInfo.getClassName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_INTEGRATIONINFO_WHERE);

			query.append(_FINDER_COLUMN_G_CN_GROUPID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_G_CN_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_CN_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_G_CN_CLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindClassName) {
					qPos.add(className);
				}

				List<IntegrationInfo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_G_CN,
						finderArgs, list);
				}
				else {
					IntegrationInfo integrationInfo = list.get(0);

					result = integrationInfo;

					cacheResult(integrationInfo);

					if ((integrationInfo.getGroupId() != groupId) ||
							(integrationInfo.getClassName() == null) ||
							!integrationInfo.getClassName().equals(className)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_G_CN,
							finderArgs, integrationInfo);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_G_CN, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (IntegrationInfo)result;
		}
	}

	/**
	 * Removes the integration info where groupId = &#63; and className = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @return the integration info that was removed
	 */
	@Override
	public IntegrationInfo removeByG_CN(long groupId, String className)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = findByG_CN(groupId, className);

		return remove(integrationInfo);
	}

	/**
	 * Returns the number of integration infos where groupId = &#63; and className = &#63;.
	 *
	 * @param groupId the group ID
	 * @param className the class name
	 * @return the number of matching integration infos
	 */
	@Override
	public int countByG_CN(long groupId, String className) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_CN;

		Object[] finderArgs = new Object[] { groupId, className };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INTEGRATIONINFO_WHERE);

			query.append(_FINDER_COLUMN_G_CN_GROUPID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_G_CN_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_CN_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_G_CN_CLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindClassName) {
					qPos.add(className);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_CN_GROUPID_2 = "integrationInfo.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_CN_CLASSNAME_1 = "integrationInfo.className IS NULL";
	private static final String _FINDER_COLUMN_G_CN_CLASSNAME_2 = "integrationInfo.className = ?";
	private static final String _FINDER_COLUMN_G_CN_CLASSNAME_3 = "(integrationInfo.className IS NULL OR integrationInfo.className = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME =
		new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED,
			IntegrationInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByClassname",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME =
		new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED,
			IntegrationInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClassname",
			new String[] { String.class.getName() },
			IntegrationInfoModelImpl.CLASSNAME_COLUMN_BITMASK |
			IntegrationInfoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAME = new FinderPath(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClassname",
			new String[] { String.class.getName() });

	/**
	 * Returns all the integration infos where className = &#63;.
	 *
	 * @param className the class name
	 * @return the matching integration infos
	 */
	@Override
	public List<IntegrationInfo> findByClassname(String className) {
		return findByClassname(className, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<IntegrationInfo> findByClassname(String className, int start,
		int end) {
		return findByClassname(className, start, end, null);
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
	@Override
	public List<IntegrationInfo> findByClassname(String className, int start,
		int end, OrderByComparator<IntegrationInfo> orderByComparator) {
		return findByClassname(className, start, end, orderByComparator, true);
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
	@Override
	public List<IntegrationInfo> findByClassname(String className, int start,
		int end, OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME;
			finderArgs = new Object[] { className };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME;
			finderArgs = new Object[] { className, start, end, orderByComparator };
		}

		List<IntegrationInfo> list = null;

		if (retrieveFromCache) {
			list = (List<IntegrationInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IntegrationInfo integrationInfo : list) {
					if (!Objects.equals(className,
								integrationInfo.getClassName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_INTEGRATIONINFO_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IntegrationInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				if (!pagination) {
					list = (List<IntegrationInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IntegrationInfo>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first integration info in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching integration info
	 * @throws NoSuchInfoException if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo findByClassname_First(String className,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = fetchByClassname_First(className,
				orderByComparator);

		if (integrationInfo != null) {
			return integrationInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInfoException(msg.toString());
	}

	/**
	 * Returns the first integration info in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching integration info, or <code>null</code> if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo fetchByClassname_First(String className,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		List<IntegrationInfo> list = findByClassname(className, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last integration info in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching integration info
	 * @throws NoSuchInfoException if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo findByClassname_Last(String className,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = fetchByClassname_Last(className,
				orderByComparator);

		if (integrationInfo != null) {
			return integrationInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInfoException(msg.toString());
	}

	/**
	 * Returns the last integration info in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching integration info, or <code>null</code> if a matching integration info could not be found
	 */
	@Override
	public IntegrationInfo fetchByClassname_Last(String className,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		int count = countByClassname(className);

		if (count == 0) {
			return null;
		}

		List<IntegrationInfo> list = findByClassname(className, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IntegrationInfo[] findByClassname_PrevAndNext(
		long integrationInfoId, String className,
		OrderByComparator<IntegrationInfo> orderByComparator)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = findByPrimaryKey(integrationInfoId);

		Session session = null;

		try {
			session = openSession();

			IntegrationInfo[] array = new IntegrationInfoImpl[3];

			array[0] = getByClassname_PrevAndNext(session, integrationInfo,
					className, orderByComparator, true);

			array[1] = integrationInfo;

			array[2] = getByClassname_PrevAndNext(session, integrationInfo,
					className, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IntegrationInfo getByClassname_PrevAndNext(Session session,
		IntegrationInfo integrationInfo, String className,
		OrderByComparator<IntegrationInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTEGRATIONINFO_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(IntegrationInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(integrationInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IntegrationInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the integration infos where className = &#63; from the database.
	 *
	 * @param className the class name
	 */
	@Override
	public void removeByClassname(String className) {
		for (IntegrationInfo integrationInfo : findByClassname(className,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(integrationInfo);
		}
	}

	/**
	 * Returns the number of integration infos where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching integration infos
	 */
	@Override
	public int countByClassname(String className) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAME;

		Object[] finderArgs = new Object[] { className };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INTEGRATIONINFO_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_1 = "integrationInfo.className IS NULL";
	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_2 = "integrationInfo.className = ?";
	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_3 = "(integrationInfo.className IS NULL OR integrationInfo.className = '')";

	public IntegrationInfoPersistenceImpl() {
		setModelClass(IntegrationInfo.class);
	}

	/**
	 * Caches the integration info in the entity cache if it is enabled.
	 *
	 * @param integrationInfo the integration info
	 */
	@Override
	public void cacheResult(IntegrationInfo integrationInfo) {
		entityCache.putResult(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoImpl.class, integrationInfo.getPrimaryKey(),
			integrationInfo);

		finderCache.putResult(FINDER_PATH_FETCH_BY_G_CN,
			new Object[] {
				integrationInfo.getGroupId(), integrationInfo.getClassName()
			}, integrationInfo);

		integrationInfo.resetOriginalValues();
	}

	/**
	 * Caches the integration infos in the entity cache if it is enabled.
	 *
	 * @param integrationInfos the integration infos
	 */
	@Override
	public void cacheResult(List<IntegrationInfo> integrationInfos) {
		for (IntegrationInfo integrationInfo : integrationInfos) {
			if (entityCache.getResult(
						IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
						IntegrationInfoImpl.class,
						integrationInfo.getPrimaryKey()) == null) {
				cacheResult(integrationInfo);
			}
			else {
				integrationInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all integration infos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IntegrationInfoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the integration info.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IntegrationInfo integrationInfo) {
		entityCache.removeResult(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoImpl.class, integrationInfo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((IntegrationInfoModelImpl)integrationInfo);
	}

	@Override
	public void clearCache(List<IntegrationInfo> integrationInfos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (IntegrationInfo integrationInfo : integrationInfos) {
			entityCache.removeResult(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
				IntegrationInfoImpl.class, integrationInfo.getPrimaryKey());

			clearUniqueFindersCache((IntegrationInfoModelImpl)integrationInfo);
		}
	}

	protected void cacheUniqueFindersCache(
		IntegrationInfoModelImpl integrationInfoModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					integrationInfoModelImpl.getGroupId(),
					integrationInfoModelImpl.getClassName()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_G_CN, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_G_CN, args,
				integrationInfoModelImpl);
		}
		else {
			if ((integrationInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_CN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						integrationInfoModelImpl.getGroupId(),
						integrationInfoModelImpl.getClassName()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_G_CN, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_G_CN, args,
					integrationInfoModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		IntegrationInfoModelImpl integrationInfoModelImpl) {
		Object[] args = new Object[] {
				integrationInfoModelImpl.getGroupId(),
				integrationInfoModelImpl.getClassName()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_G_CN, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_G_CN, args);

		if ((integrationInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_CN.getColumnBitmask()) != 0) {
			args = new Object[] {
					integrationInfoModelImpl.getOriginalGroupId(),
					integrationInfoModelImpl.getOriginalClassName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_CN, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_G_CN, args);
		}
	}

	/**
	 * Creates a new integration info with the primary key. Does not add the integration info to the database.
	 *
	 * @param integrationInfoId the primary key for the new integration info
	 * @return the new integration info
	 */
	@Override
	public IntegrationInfo create(long integrationInfoId) {
		IntegrationInfo integrationInfo = new IntegrationInfoImpl();

		integrationInfo.setNew(true);
		integrationInfo.setPrimaryKey(integrationInfoId);

		integrationInfo.setCompanyId(companyProvider.getCompanyId());

		return integrationInfo;
	}

	/**
	 * Removes the integration info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param integrationInfoId the primary key of the integration info
	 * @return the integration info that was removed
	 * @throws NoSuchInfoException if a integration info with the primary key could not be found
	 */
	@Override
	public IntegrationInfo remove(long integrationInfoId)
		throws NoSuchInfoException {
		return remove((Serializable)integrationInfoId);
	}

	/**
	 * Removes the integration info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the integration info
	 * @return the integration info that was removed
	 * @throws NoSuchInfoException if a integration info with the primary key could not be found
	 */
	@Override
	public IntegrationInfo remove(Serializable primaryKey)
		throws NoSuchInfoException {
		Session session = null;

		try {
			session = openSession();

			IntegrationInfo integrationInfo = (IntegrationInfo)session.get(IntegrationInfoImpl.class,
					primaryKey);

			if (integrationInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(integrationInfo);
		}
		catch (NoSuchInfoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected IntegrationInfo removeImpl(IntegrationInfo integrationInfo) {
		integrationInfo = toUnwrappedModel(integrationInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(integrationInfo)) {
				integrationInfo = (IntegrationInfo)session.get(IntegrationInfoImpl.class,
						integrationInfo.getPrimaryKeyObj());
			}

			if (integrationInfo != null) {
				session.delete(integrationInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (integrationInfo != null) {
			clearCache(integrationInfo);
		}

		return integrationInfo;
	}

	@Override
	public IntegrationInfo updateImpl(IntegrationInfo integrationInfo) {
		integrationInfo = toUnwrappedModel(integrationInfo);

		boolean isNew = integrationInfo.isNew();

		IntegrationInfoModelImpl integrationInfoModelImpl = (IntegrationInfoModelImpl)integrationInfo;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (integrationInfo.getCreateDate() == null)) {
			if (serviceContext == null) {
				integrationInfo.setCreateDate(now);
			}
			else {
				integrationInfo.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!integrationInfoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				integrationInfo.setModifiedDate(now);
			}
			else {
				integrationInfo.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (integrationInfo.isNew()) {
				session.save(integrationInfo);

				integrationInfo.setNew(false);
			}
			else {
				integrationInfo = (IntegrationInfo)session.merge(integrationInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !IntegrationInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((integrationInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEBLOCKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						integrationInfoModelImpl.getOriginalResourceBlockId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RESOURCEBLOCKID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEBLOCKID,
					args);

				args = new Object[] {
						integrationInfoModelImpl.getResourceBlockId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RESOURCEBLOCKID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEBLOCKID,
					args);
			}

			if ((integrationInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						integrationInfoModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { integrationInfoModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((integrationInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						integrationInfoModelImpl.getOriginalClassName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
					args);

				args = new Object[] { integrationInfoModelImpl.getClassName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
					args);
			}
		}

		entityCache.putResult(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
			IntegrationInfoImpl.class, integrationInfo.getPrimaryKey(),
			integrationInfo, false);

		clearUniqueFindersCache(integrationInfoModelImpl);
		cacheUniqueFindersCache(integrationInfoModelImpl, isNew);

		integrationInfo.resetOriginalValues();

		return integrationInfo;
	}

	protected IntegrationInfo toUnwrappedModel(IntegrationInfo integrationInfo) {
		if (integrationInfo instanceof IntegrationInfoImpl) {
			return integrationInfo;
		}

		IntegrationInfoImpl integrationInfoImpl = new IntegrationInfoImpl();

		integrationInfoImpl.setNew(integrationInfo.isNew());
		integrationInfoImpl.setPrimaryKey(integrationInfo.getPrimaryKey());

		integrationInfoImpl.setIntegrationInfoId(integrationInfo.getIntegrationInfoId());
		integrationInfoImpl.setGroupId(integrationInfo.getGroupId());
		integrationInfoImpl.setCompanyId(integrationInfo.getCompanyId());
		integrationInfoImpl.setUserId(integrationInfo.getUserId());
		integrationInfoImpl.setUserName(integrationInfo.getUserName());
		integrationInfoImpl.setCreateDate(integrationInfo.getCreateDate());
		integrationInfoImpl.setModifiedDate(integrationInfo.getModifiedDate());
		integrationInfoImpl.setResourceBlockId(integrationInfo.getResourceBlockId());
		integrationInfoImpl.setClassName(integrationInfo.getClassName());

		return integrationInfoImpl;
	}

	/**
	 * Returns the integration info with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the integration info
	 * @return the integration info
	 * @throws NoSuchInfoException if a integration info with the primary key could not be found
	 */
	@Override
	public IntegrationInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInfoException {
		IntegrationInfo integrationInfo = fetchByPrimaryKey(primaryKey);

		if (integrationInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return integrationInfo;
	}

	/**
	 * Returns the integration info with the primary key or throws a {@link NoSuchInfoException} if it could not be found.
	 *
	 * @param integrationInfoId the primary key of the integration info
	 * @return the integration info
	 * @throws NoSuchInfoException if a integration info with the primary key could not be found
	 */
	@Override
	public IntegrationInfo findByPrimaryKey(long integrationInfoId)
		throws NoSuchInfoException {
		return findByPrimaryKey((Serializable)integrationInfoId);
	}

	/**
	 * Returns the integration info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the integration info
	 * @return the integration info, or <code>null</code> if a integration info with the primary key could not be found
	 */
	@Override
	public IntegrationInfo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
				IntegrationInfoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		IntegrationInfo integrationInfo = (IntegrationInfo)serializable;

		if (integrationInfo == null) {
			Session session = null;

			try {
				session = openSession();

				integrationInfo = (IntegrationInfo)session.get(IntegrationInfoImpl.class,
						primaryKey);

				if (integrationInfo != null) {
					cacheResult(integrationInfo);
				}
				else {
					entityCache.putResult(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
						IntegrationInfoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
					IntegrationInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return integrationInfo;
	}

	/**
	 * Returns the integration info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param integrationInfoId the primary key of the integration info
	 * @return the integration info, or <code>null</code> if a integration info with the primary key could not be found
	 */
	@Override
	public IntegrationInfo fetchByPrimaryKey(long integrationInfoId) {
		return fetchByPrimaryKey((Serializable)integrationInfoId);
	}

	@Override
	public Map<Serializable, IntegrationInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, IntegrationInfo> map = new HashMap<Serializable, IntegrationInfo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			IntegrationInfo integrationInfo = fetchByPrimaryKey(primaryKey);

			if (integrationInfo != null) {
				map.put(primaryKey, integrationInfo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
					IntegrationInfoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (IntegrationInfo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_INTEGRATIONINFO_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (IntegrationInfo integrationInfo : (List<IntegrationInfo>)q.list()) {
				map.put(integrationInfo.getPrimaryKeyObj(), integrationInfo);

				cacheResult(integrationInfo);

				uncachedPrimaryKeys.remove(integrationInfo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(IntegrationInfoModelImpl.ENTITY_CACHE_ENABLED,
					IntegrationInfoImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the integration infos.
	 *
	 * @return the integration infos
	 */
	@Override
	public List<IntegrationInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<IntegrationInfo> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<IntegrationInfo> findAll(int start, int end,
		OrderByComparator<IntegrationInfo> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<IntegrationInfo> findAll(int start, int end,
		OrderByComparator<IntegrationInfo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<IntegrationInfo> list = null;

		if (retrieveFromCache) {
			list = (List<IntegrationInfo>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_INTEGRATIONINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INTEGRATIONINFO;

				if (pagination) {
					sql = sql.concat(IntegrationInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<IntegrationInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IntegrationInfo>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the integration infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (IntegrationInfo integrationInfo : findAll()) {
			remove(integrationInfo);
		}
	}

	/**
	 * Returns the number of integration infos.
	 *
	 * @return the number of integration infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INTEGRATIONINFO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IntegrationInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the integration info persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(IntegrationInfoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_INTEGRATIONINFO = "SELECT integrationInfo FROM IntegrationInfo integrationInfo";
	private static final String _SQL_SELECT_INTEGRATIONINFO_WHERE_PKS_IN = "SELECT integrationInfo FROM IntegrationInfo integrationInfo WHERE integrationInfoId IN (";
	private static final String _SQL_SELECT_INTEGRATIONINFO_WHERE = "SELECT integrationInfo FROM IntegrationInfo integrationInfo WHERE ";
	private static final String _SQL_COUNT_INTEGRATIONINFO = "SELECT COUNT(integrationInfo) FROM IntegrationInfo integrationInfo";
	private static final String _SQL_COUNT_INTEGRATIONINFO_WHERE = "SELECT COUNT(integrationInfo) FROM IntegrationInfo integrationInfo WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "integrationInfo.integrationInfoId";
	private static final String _FILTER_ENTITY_TABLE_FILTER_USERID_COLUMN = "integrationInfo.userId";
	private static final String _ORDER_BY_ENTITY_ALIAS = "integrationInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IntegrationInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No IntegrationInfo exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(IntegrationInfoPersistenceImpl.class);
}