package com.sohlman.liferay.perm.integ.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.sohlman.liferay.perm.integ.service.persistence.IntegrationInfoFinder;

import java.util.List;

public class IntegrationInfoFinderImpl extends IntegrationInfoFinderBaseImpl implements IntegrationInfoFinder {
	// Here more custom queries which can work more effiecient on DB level
	
	@Override
	public List<String> findIntegrationClassNames() {
		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(
				"SELECT DISTINCT className FROM IntegrationInfo");

			q.addScalar("className", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(q);

			return (List<String>)QueryUtil.list(
				q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}
