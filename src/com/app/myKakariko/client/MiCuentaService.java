package com.app.myKakariko.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MiCuentaService")
public interface MiCuentaService  extends RemoteService  {

	
	String[] miCuenta(String user);

	
	
	
	
}
