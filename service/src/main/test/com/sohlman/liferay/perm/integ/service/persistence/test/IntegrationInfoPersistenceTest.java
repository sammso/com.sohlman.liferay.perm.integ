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

package com.sohlman.liferay.perm.integ.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import com.sohlman.liferay.perm.integ.exception.NoSuchInfoException;
import com.sohlman.liferay.perm.integ.model.IntegrationInfo;
import com.sohlman.liferay.perm.integ.service.IntegrationInfoLocalServiceUtil;
import com.sohlman.liferay.perm.integ.service.persistence.IntegrationInfoPersistence;
import com.sohlman.liferay.perm.integ.service.persistence.IntegrationInfoUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class IntegrationInfoPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = IntegrationInfoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<IntegrationInfo> iterator = _integrationInfos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		IntegrationInfo integrationInfo = _persistence.create(pk);

		Assert.assertNotNull(integrationInfo);

		Assert.assertEquals(integrationInfo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		IntegrationInfo newIntegrationInfo = addIntegrationInfo();

		_persistence.remove(newIntegrationInfo);

		IntegrationInfo existingIntegrationInfo = _persistence.fetchByPrimaryKey(newIntegrationInfo.getPrimaryKey());

		Assert.assertNull(existingIntegrationInfo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addIntegrationInfo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		IntegrationInfo newIntegrationInfo = _persistence.create(pk);

		newIntegrationInfo.setGroupId(RandomTestUtil.nextLong());

		newIntegrationInfo.setCompanyId(RandomTestUtil.nextLong());

		newIntegrationInfo.setUserId(RandomTestUtil.nextLong());

		newIntegrationInfo.setUserName(RandomTestUtil.randomString());

		newIntegrationInfo.setCreateDate(RandomTestUtil.nextDate());

		newIntegrationInfo.setModifiedDate(RandomTestUtil.nextDate());

		newIntegrationInfo.setResourceBlockId(RandomTestUtil.nextLong());

		newIntegrationInfo.setClassName(RandomTestUtil.randomString());

		_integrationInfos.add(_persistence.update(newIntegrationInfo));

		IntegrationInfo existingIntegrationInfo = _persistence.findByPrimaryKey(newIntegrationInfo.getPrimaryKey());

		Assert.assertEquals(existingIntegrationInfo.getIntegrationInfoId(),
			newIntegrationInfo.getIntegrationInfoId());
		Assert.assertEquals(existingIntegrationInfo.getGroupId(),
			newIntegrationInfo.getGroupId());
		Assert.assertEquals(existingIntegrationInfo.getCompanyId(),
			newIntegrationInfo.getCompanyId());
		Assert.assertEquals(existingIntegrationInfo.getUserId(),
			newIntegrationInfo.getUserId());
		Assert.assertEquals(existingIntegrationInfo.getUserName(),
			newIntegrationInfo.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingIntegrationInfo.getCreateDate()),
			Time.getShortTimestamp(newIntegrationInfo.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingIntegrationInfo.getModifiedDate()),
			Time.getShortTimestamp(newIntegrationInfo.getModifiedDate()));
		Assert.assertEquals(existingIntegrationInfo.getResourceBlockId(),
			newIntegrationInfo.getResourceBlockId());
		Assert.assertEquals(existingIntegrationInfo.getClassName(),
			newIntegrationInfo.getClassName());
	}

	@Test
	public void testCountByResourceBlockId() throws Exception {
		_persistence.countByResourceBlockId(RandomTestUtil.nextLong());

		_persistence.countByResourceBlockId(0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByG_CN() throws Exception {
		_persistence.countByG_CN(RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByG_CN(0L, StringPool.NULL);

		_persistence.countByG_CN(0L, (String)null);
	}

	@Test
	public void testCountByClassname() throws Exception {
		_persistence.countByClassname(StringPool.BLANK);

		_persistence.countByClassname(StringPool.NULL);

		_persistence.countByClassname((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		IntegrationInfo newIntegrationInfo = addIntegrationInfo();

		IntegrationInfo existingIntegrationInfo = _persistence.findByPrimaryKey(newIntegrationInfo.getPrimaryKey());

		Assert.assertEquals(existingIntegrationInfo, newIntegrationInfo);
	}

	@Test(expected = NoSuchInfoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	@Test
	public void testFilterFindByGroupId() throws Exception {
		_persistence.filterFindByGroupId(0, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<IntegrationInfo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("IntegrationInfo",
			"integrationInfoId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "resourceBlockId", true, "className", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		IntegrationInfo newIntegrationInfo = addIntegrationInfo();

		IntegrationInfo existingIntegrationInfo = _persistence.fetchByPrimaryKey(newIntegrationInfo.getPrimaryKey());

		Assert.assertEquals(existingIntegrationInfo, newIntegrationInfo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		IntegrationInfo missingIntegrationInfo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingIntegrationInfo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		IntegrationInfo newIntegrationInfo1 = addIntegrationInfo();
		IntegrationInfo newIntegrationInfo2 = addIntegrationInfo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newIntegrationInfo1.getPrimaryKey());
		primaryKeys.add(newIntegrationInfo2.getPrimaryKey());

		Map<Serializable, IntegrationInfo> integrationInfos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, integrationInfos.size());
		Assert.assertEquals(newIntegrationInfo1,
			integrationInfos.get(newIntegrationInfo1.getPrimaryKey()));
		Assert.assertEquals(newIntegrationInfo2,
			integrationInfos.get(newIntegrationInfo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, IntegrationInfo> integrationInfos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(integrationInfos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		IntegrationInfo newIntegrationInfo = addIntegrationInfo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newIntegrationInfo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, IntegrationInfo> integrationInfos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, integrationInfos.size());
		Assert.assertEquals(newIntegrationInfo,
			integrationInfos.get(newIntegrationInfo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, IntegrationInfo> integrationInfos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(integrationInfos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		IntegrationInfo newIntegrationInfo = addIntegrationInfo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newIntegrationInfo.getPrimaryKey());

		Map<Serializable, IntegrationInfo> integrationInfos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, integrationInfos.size());
		Assert.assertEquals(newIntegrationInfo,
			integrationInfos.get(newIntegrationInfo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = IntegrationInfoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<IntegrationInfo>() {
				@Override
				public void performAction(IntegrationInfo integrationInfo) {
					Assert.assertNotNull(integrationInfo);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		IntegrationInfo newIntegrationInfo = addIntegrationInfo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(IntegrationInfo.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("integrationInfoId",
				newIntegrationInfo.getIntegrationInfoId()));

		List<IntegrationInfo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		IntegrationInfo existingIntegrationInfo = result.get(0);

		Assert.assertEquals(existingIntegrationInfo, newIntegrationInfo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(IntegrationInfo.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("integrationInfoId",
				RandomTestUtil.nextLong()));

		List<IntegrationInfo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		IntegrationInfo newIntegrationInfo = addIntegrationInfo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(IntegrationInfo.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"integrationInfoId"));

		Object newIntegrationInfoId = newIntegrationInfo.getIntegrationInfoId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("integrationInfoId",
				new Object[] { newIntegrationInfoId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingIntegrationInfoId = result.get(0);

		Assert.assertEquals(existingIntegrationInfoId, newIntegrationInfoId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(IntegrationInfo.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"integrationInfoId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("integrationInfoId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		IntegrationInfo newIntegrationInfo = addIntegrationInfo();

		_persistence.clearCache();

		IntegrationInfo existingIntegrationInfo = _persistence.findByPrimaryKey(newIntegrationInfo.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(existingIntegrationInfo.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingIntegrationInfo,
				"getOriginalGroupId", new Class<?>[0]));
		Assert.assertTrue(Objects.equals(
				existingIntegrationInfo.getClassName(),
				ReflectionTestUtil.invoke(existingIntegrationInfo,
					"getOriginalClassName", new Class<?>[0])));
	}

	protected IntegrationInfo addIntegrationInfo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		IntegrationInfo integrationInfo = _persistence.create(pk);

		integrationInfo.setGroupId(RandomTestUtil.nextLong());

		integrationInfo.setCompanyId(RandomTestUtil.nextLong());

		integrationInfo.setUserId(RandomTestUtil.nextLong());

		integrationInfo.setUserName(RandomTestUtil.randomString());

		integrationInfo.setCreateDate(RandomTestUtil.nextDate());

		integrationInfo.setModifiedDate(RandomTestUtil.nextDate());

		integrationInfo.setResourceBlockId(RandomTestUtil.nextLong());

		integrationInfo.setClassName(RandomTestUtil.randomString());

		_integrationInfos.add(_persistence.update(integrationInfo));

		return integrationInfo;
	}

	private List<IntegrationInfo> _integrationInfos = new ArrayList<IntegrationInfo>();
	private IntegrationInfoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}