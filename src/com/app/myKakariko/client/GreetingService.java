package com.app.myKakariko.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;

	String[] query(String name) throws IllegalArgumentException;

	String inicio(String name) throws IllegalArgumentException;

	String nuevoUsuario(String username, String password,
			String nombre, String apellido, String cedula, String departamento,
			String ciudad, String direccion, String telefono);

	boolean login(String user, String pass);
	
	String[] precio(String input, String shipping)throws IllegalArgumentException;;
	
	

}
