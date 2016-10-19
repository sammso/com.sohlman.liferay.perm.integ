package com.sohlman.liferay.perm.integ.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sohlman.liferay.perm.integ.Integration;
import com.sohlman.liferay.perm.integ.PermissionedIntegrations;
import com.sohlman.liferay.perm.integ.model.IntegrationInfo;
import com.sohlman.liferay.perm.integ.service.IntegrationInfoLocalService;
import com.sohlman.liferay.perm.integ.service.IntegrationInfoService;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

@Component(
	immediate=true, 
	service=PermissionedIntegrations.class 
)
public class PermissionedIntegrationsImpl implements PermissionedIntegrations {

	@Activate
	public void activate(BundleContext bundleContext) {
	    _bundleContext = bundleContext;   
		_serviceTracker  = new ServiceTracker<Integration, Integration>(
			bundleContext, Integration.class,  new IntegrationServiceTrackerCustomizer());
		
		_serviceTracker.open(); 
	}
	
	@Deactivate
	public void deactivate(BundleContext bundleContext) {
		_bundleContext = null;
	}
	
	@Override
	public Integration getIntegration(long groupId, String className) {
		
		IntegrationInfo integrationInfo = 
			_integrationInfoService.fetchIntegrationInfo(groupId, className);
		
		if (integrationInfo!=null) {
			ServiceReference<Integration> serviceReference = 
				(ServiceReference<Integration>) _bundleContext.getServiceReference(className);
			
			if (serviceReference==null) {
				return null;
			}
			
			return _bundleContext.getService(serviceReference);
		}
		else {
			return null;
		}
	}
	
	private class IntegrationServiceTrackerCustomizer implements ServiceTrackerCustomizer<Integration, Integration> {
		
		@Override
		public Integration addingService(ServiceReference<Integration> serviceReference) {
			Integration integration = _bundleContext.getService(serviceReference);
			
			_log.error(integration.getClass().getName());
			
			return integration;
		}

		@Override
		public void modifiedService(ServiceReference<Integration> reference, Integration service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removedService(ServiceReference<Integration> reference, Integration service) {
	
		}
		private Log _log = LogFactoryUtil.getLog(IntegrationServiceTrackerCustomizer.class);
	}

	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	private IntegrationInfoService _integrationInfoService;
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	private IntegrationInfoLocalService _integrationInfoLocalService;
	
	private BundleContext _bundleContext;
	private ServiceTracker<Integration,Integration> _serviceTracker;
	
	
}
