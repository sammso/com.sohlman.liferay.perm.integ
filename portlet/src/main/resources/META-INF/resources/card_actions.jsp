<%@ include file="/init.jsp"%>
<liferay-ui:icon-menu markupView="lexicon">
	<liferay-security:permissionsURL
		modelResource="com.sohlman.liferay.perm.integ.model.IntegrationInfo"
		modelResourceDescription="${SEARCH_CONTAINER_RESULT_ROW.object.className}"
		resourcePrimKey="${SEARCH_CONTAINER_RESULT_ROW.object.integrationInfoId}" var="permissionsURL" />

	<liferay-ui:icon message="Permissions" url="${permissionsURL}" />
</liferay-ui:icon-menu> 