package com.sohlman.liferay.perm.integ.portlet.admin.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.sohlman.liferay.perm.integ.PermissionedIntegrations;
import com.sohlman.liferay.perm.integ.service.IntegrationInfoService;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.integration",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=com.sohlman.liferay.perm.integ.admnportlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminPortletPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute("integrationInfoService", _integrationInfoService);
		super.doView(renderRequest, renderResponse);
	}
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	private IntegrationInfoService _integrationInfoService;
}