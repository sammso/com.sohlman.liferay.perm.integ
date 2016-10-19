package com.sohlman.liferay.perm.integ.example1;

import com.sohlman.liferay.perm.integ.Integration;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate=true,
	service=Integration.class 
)
public class MyIntegration implements Integration {
	public MyIntegration(){
		
	}
	
	
}