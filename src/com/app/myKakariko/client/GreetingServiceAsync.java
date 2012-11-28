package com.app.myKakariko.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void query(String name, AsyncCallback<String[]> callback);

	void inicio(String name, AsyncCallback<String> callback);

	void nuevoUsuario(String username, String password,String email, String nombre,
			String apellido, String cedula, String departamento, String ciudad, String direccion, String barrio, String telefono, AsyncCallback<String> callback);



}
