package com.app.myKakariko.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MiCuentaService")
public interface MiCuentaService  extends RemoteService  {

	
	String[] miCuenta(String user);
	
	String calcularPrecioFinal(String precio, String shipping, String moneda);

	String comprarProducto(String username, String nombre, String direccion,
			String descripcion, String Id, String precioReal,
			String precioSendBox, String moneda, String shipping)
			throws IllegalArgumentException;

	
	
	
	
}
