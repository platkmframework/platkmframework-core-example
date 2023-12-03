package org.platkmframework.core.example.rmi;

import java.rmi.RemoteException;
import java.util.List;

import org.platkmframework.content.ioc.ObjectContainer;
import org.platkmframework.content.ioc.exception.IoDCException;
import org.platkmframework.content.project.ProjectContent;
import org.platkmframework.core.example.rmi.service.PedirSaludoService;
import org.platkmframework.core.rmi.RMIException;
import org.platkmframework.core.rmi.RMIServerManager;
import org.platkmframework.jpa.persistence.CustomIoDprocess; 

public class MainRMIExample {

	public static void main(String[] args) throws IoDCException, RMIException, RemoteException {
		
		initConfig();
		
		List<?> list = ObjectContainer.instance().getListObjectByInstance(PedirSaludoService.class);
		PedirSaludoService pedirSaludoService = (PedirSaludoService) list.get(0);
		
		System.out.println(pedirSaludoService.pedirSaludo("Pedro"));
		System.out.println(pedirSaludoService.pedirSaludo("Ana"));
		System.out.println(pedirSaludoService.pedirSaludo("Antonio"));
		
		RMIServerManager.instance().stopService("Saludar");
	}
	
	
	private static void initConfig() throws IoDCException, RMIException {
		
		ProjectContent.instance().addProperty("rmi.saludo.lookupname", "Saludar").
		addProperty("rmi.saludo.server", "localhost").
		addProperty("rmi.saludo.port", "8087");

		ObjectContainer.instance().process( System.getProperty("java.class.path"), new String[] {"org.platkmframework","org.platkmframework.core.example"}, 
				ProjectContent.instance().getAppProperties(),
				new CustomIoDprocess());
		
		RMIServerManager.instance().runAllOnStart(); 
		
	}

}
