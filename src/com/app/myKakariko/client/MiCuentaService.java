package com.app.myKakariko.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MiCuentaService")
public interface MiCuentaService  extends RemoteService  {

	
	String[] miCuenta(String user);
	
	String calcularPrecioFinal(String precio, String shipping, String moneda);

	String comprarProducto(String username, String userpass, String prod,
			String shipping)
			throws IllegalArgumentException;

	String updateClient(String user, String password, String direccion,
			String telefono, String ciudad, String depto, String nombre,
			String apellido);

	
	
	
	
}
