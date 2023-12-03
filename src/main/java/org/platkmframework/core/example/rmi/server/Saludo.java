package org.platkmframework.core.example.rmi.server;

import java.rmi.RemoteException;

public interface Saludo extends java.rmi.Remote{
	
	
	public String responder(String nombre) throws RemoteException;

}
