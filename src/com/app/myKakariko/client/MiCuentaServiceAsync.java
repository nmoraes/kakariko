package com.app.myKakariko.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * The async counterpart of <code>MiCuentaServices</code>.
 */
public interface MiCuentaServiceAsync {

	void miCuenta(String user, AsyncCallback<String[]> callback);

	
	
}
