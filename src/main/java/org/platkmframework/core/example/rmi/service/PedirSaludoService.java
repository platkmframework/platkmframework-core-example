package org.platkmframework.core.example.rmi.service;

import java.rmi.RemoteException;

import org.platkmframework.annotation.AutoWired;
import org.platkmframework.annotation.Service;
import org.platkmframework.core.example.rmi.server.Saludo;
import org.platkmframework.core.rmi.RMIClientProvider;
import org.platkmframework.core.rmi.RMIException;

@Service
public class PedirSaludoService {
	
	
	@AutoWired(key = "RMISaludo")
	private RMIClientProvider pedirSaludo;
	
	public String pedirSaludo(String name) throws RMIException, RemoteException {
		Saludo saludo = (Saludo) pedirSaludo.provide(Saludo.class);
		return saludo.responder(name);
	}

}
