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

}
