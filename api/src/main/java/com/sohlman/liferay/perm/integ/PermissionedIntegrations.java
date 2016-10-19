package com.sohlman.liferay.perm.integ;

public interface PermissionedIntegrations {
	public Integration getIntegration(long groupId, String className);
}
