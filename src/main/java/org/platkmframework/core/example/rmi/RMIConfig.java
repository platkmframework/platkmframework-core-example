package org.platkmframework.core.example.rmi;

import org.platkmframework.annotation.Component;
import org.platkmframework.annotation.JBean;
import org.platkmframework.annotation.PropertyFileInfo;
import org.platkmframework.core.rmi.RMIClientProvider; 

@Component
public class RMIConfig {
	
	@PropertyFileInfo(name = "${rmi.saludo.lookupname}")
	private String lookupName;
	
	@PropertyFileInfo(name = "${rmi.saludo.server}")
	private String hostname;
	
	@PropertyFileInfo(name = "${rmi.saludo.port}")
	private String port;
	
	@JBean(name="RMISaludo")
	public RMIClientProvider getRMISaludo() { 
		return new RMIClientProvider(hostname, port, lookupName);
	}

}
