package com.app.myKakariko.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>MiCuentaServices</code>.
 */
public interface MiCuentaServiceAsync {

	/**
	 * Despliega los datos del usuario en el panel de control
	 * */
	void miCuenta(String user, AsyncCallback<String[]> callback);

	void calcularPrecioFinal(String precio, String shipping, String moneda,
			AsyncCallback<String> callback);

	void comprarProducto(String username, String userpass, String prod,
			String shipping, AsyncCallback<String> callback);

	void updateClient(String user, String password, String direccion, String telefono,String ciudad,String depto, String nombre, String apellido, AsyncCallback<String> asyncCallback);

	void ventasCliente(String idClient, AsyncCallback<String> callback);

}
