package com.app.myKakariko.server;

import javax.jdo.PersistenceManager;

import com.app.myKakariko.client.MiCuentaService;
import com.app.myKakariko.server.database.Client;
import com.app.myKakariko.server.database.PMF;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class MiCuentaServicesImpl extends RemoteServiceServlet implements MiCuentaService {

	

	@Override
	public String[] miCuenta(String username) throws IllegalArgumentException {
			
		System.out.println("usuario a buscar ..."+username);
		
		String [] s = new String[7];
		PersistenceManager pm = null;
		pm = PMF.get().getPersistenceManager();

		Client e = null;

		try {

			Key k = KeyFactory.createKey(Client.class.getSimpleName(),username);
			e = pm.getObjectById(Client.class, k);
		
			String user = e.getUsername();
			String password =e.getPassword();
			String direccion =e.getDireccion();
			String tel = e.getTelefono();
			String ci =e.getCedula();
			String dpto = e.getDepartamento();
			String ciudad = e.getCiudad();
		
		
			s[0]=user;
			s[1]=password;
			s[2]=direccion;
			s[3]=tel;
			s[4]=ci;
			s[5]=dpto;
			s[6]=ciudad;
			
			
			
		} catch (Exception ex) {
			
		System.out.println("error al traer la data");
		


		}

		return s;
	
	
	}	
}
