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

	void nuevoUsuario(String username, String password, String nombre,
			String apellido, String cedula, String departamento, String ciudad, String direccion, String telefono, AsyncCallback<String> callback);

	void login(String user, String pass,AsyncCallback<Boolean> callback);

	void precio(String input, String shipping, AsyncCallback<String[]> callback)throws IllegalArgumentException;;



}
