package org.platkmframework.core.example.schedule;

import org.platkmframework.content.ioc.ObjectContainer;
import org.platkmframework.content.ioc.exception.IoDCException;
import org.platkmframework.content.project.ProjectContent;
import org.platkmframework.core.rmi.RMIException;
import org.platkmframework.core.scheduler.SchedulerManager;
import org.platkmframework.jpa.persistence.CustomIoDprocess;

public class MainSchedulerExample {

	public static void main(String[] args) throws IoDCException, RMIException {

		initConfig(); 
		
		System.out.println("Las operaciones se van a finalizar a los 30 segundos");
	}

	private static void initConfig() throws IoDCException, RMIException {

		ObjectContainer.instance().process( System.getProperty("java.class.path"), new String[] {"org.platkmframework","org.platkmframework.core.example"}, 
				ProjectContent.instance().getAppProperties(),
				new CustomIoDprocess());
		
		SchedulerManager.instance().runAllOnStart();
		
	}
	
}
