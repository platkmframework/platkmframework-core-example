package org.platkmframework.core.example.rmi.server;

import org.platkmframework.annotation.rmi.RMIServer;

@RMIServer(name = "Saludar", port = "8087")
public class SaludoImpl implements Saludo{

	
	public String responder(String nombre) {
		return "Hola " + nombre;
	}
}
