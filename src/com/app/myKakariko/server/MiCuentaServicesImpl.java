package com.app.myKakariko.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.List;

import javax.jdo.PersistenceManager;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.app.myKakariko.client.MiCuentaService;
import com.app.myKakariko.server.database.Client;
import com.app.myKakariko.server.database.PMF;
import com.app.myKakariko.server.database.Ventas;
import com.app.myKakariko.shared.FieldVerifier;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import javax.jdo.Query;

@SuppressWarnings("serial")
public class MiCuentaServicesImpl extends RemoteServiceServlet implements MiCuentaService {

	private final String SHIPPING_1 ="Entrega hasta 24 Hrs";
	private final String SHIPPING_2 ="Entrega hasta 48 Hrs";
	private final String SHIPPING_3 ="Entrega hasta 72 Hrs";
	private final String SHIPPING_4 ="Entrega despues de 72 Hrs";
	
	private final String PESOS = "$";
	private final String DOLARES = "U$S";

	
	
	@Override
	public String ventasCliente(String idClient){
		
		/*
		 .success 	VERDA
		 .error 	ROJO
         .warning 	AMARILLO
		  .info		AZUL
		*/
	
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		  Query query = pm.newQuery(Ventas.class,"username == '" + idClient + "'" );
		  String consulta="";
		    try {
		        List<Ventas> results = (List<Ventas>) query.execute();
		        if (!results.isEmpty()) {

		            for (Ventas e : results) {
		            	
		            	if(e.getEstado().equals(Utilidades.ESTADO_1) ){
		            		consulta= consulta + "<tr class=\"error\"><td>"+ e.getDescripcion() +"</td> <td>"+ e.getPrecioFinal() + e.getMoneda()+" </td><td>" + e.getDateCompra()+ "</td><td>"+e.getEstado()+ "</td></tr>";
		            	}
		                
		            	if(e.getEstado().equals(Utilidades.ESTADO_2)){
		            		consulta= consulta + "<tr class=\"info\"><td>"+ e.getDescripcion() +"</td> <td>"+ e.getPrecioFinal() + e.getMoneda()+" </td><td>" + e.getDateCompra()+ "</td><td>"+e.getEstado()+ "</td></tr>";
		            	}
		                
		            	if(e.getEstado().equals(Utilidades.ESTADO_3)){
		            		consulta= consulta + "<tr class=\"success\"><td>"+ e.getDescripcion() +"</td> <td>"+ e.getPrecioFinal() + e.getMoneda()+" </td><td>" + e.getDateCompra()+ "</td><td>"+e.getEstado()+ "</td></tr>";
		            	}
  	
		            }
		        } else {
	                System.out.println("<h1>OCURRIO UN ERROR GRAVE<h1>");
		        }
		    } finally {
		        query.closeAll();
		    }
		
		    
		    String tabla= "<table class=\"table table-condensed\"><caption>MIS COMPRAS ACTIVAS</caption><tbody><thead><tr><th>Descripcion</th><th>Precio</th><th>Fecha de compra</th><th>Estado</th></tr></thead>";
		    
		    String finTabla="</tbody></table>";
		    		
		    		
		String salida = tabla.concat(consulta);
		String tablaFinal = salida.concat(finTabla);
		
		
		System.out.println(tablaFinal);
		
		
		return tablaFinal;
	}
	
	
	
	
	
	@Override
	public String updateClient(String user, String password, String direccion, String telefono,String ciudad,String depto,String nombre,String apellido) {
	    PersistenceManager pm = PMF.get().getPersistenceManager();
  	  
	    
	    try {
	        Client e = pm.getObjectById(Client.class, user);
	        e.setPassword(password);
	        e.setDireccion(direccion);
	        e.setTelefono(telefono);
	        e.setCiudad(ciudad);
	        e.setDepartamento(depto);
	        e.setNombre(nombre);
	        e.setApellido(apellido);
	        }
	      catch(Exception e){
	    	  System.out.println("ERROR AL ACTUALIZAR");
	      }	
	     finally {
	        pm.close();
	    }
	    
	    return "OK, ";
	}
	
	
	
	
	@Override
	public String comprarProducto(String username, String userpass, String prod, String shipping) throws IllegalArgumentException {
		
		//comprarProducto(String username, String nombre, String direccion, String descripcion, String Id, String precioReal, String precioSendBox, String moneda, String shipping) 
		String exit="3RROR";
		/** 
		 * Hay que restar el valor Send-box - el valor original, para insertar en la BD.
		 * 
		 * */
		// llamar los datos del cliente
		boolean validar= validateCredential(username,userpass);
		
		if(validar==true){
			
			String []s=  miCuenta(username);	
			String user=s[0];
			String direccion=s[2];	
			
			String [] s2= precio(prod,shipping);
			String price=s2[0];
			String currency= s2[1];
			String desc=s2[2];
			
			String priceSendBox =calcularPrecioFinal(price,shipping,currency);
			
			
			PersistenceManager pm = null;
			pm = PMF.get().getPersistenceManager();
			Ventas venta = new Ventas(username, prod, priceSendBox, price, shipping, desc, currency,direccion);	
			pm.makePersistent(venta);

			pm.close();
			
			exit="Acabas de comprar: "+desc+ "<br>, abre tu email, y tendras las instrucciones y el numero de cuenta Abitab para el deposito.<br> Recuerda que en \"mi cuenta \" puedes hacer seguimiento de las compras hechas y su estado. <br>Gracias por comprar en send-box.com";

		
		}

		return exit;
		
	}

	

private boolean validateCredential(String user, String pass){

	boolean entrar=false;

	PersistenceManager pm = null;
	try {
		pm = PMF.get().getPersistenceManager();

	} catch (Exception e) {
		e.printStackTrace();
	}

	Client e = null;

	e = pm.getObjectById(Client.class, user);

	if (e.getPassword().equals(pass) == true) {
		entrar=true;
		pm.close();
	}
	
	return entrar;
}

private String[] precio(String input, String shipping) {
	System.out.println(shipping);
	String [] s = new String[4];
	String price = null;
	String currency =null;
	String title=null;

	URL url;
	try {
		url = new URL("https://api.mercadolibre.com/items/" + input);
		InputStream response = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				response));
		String result = "";

		for (String line; (line = reader.readLine()) != null;) {
			System.out.println(line);
			result = result + line;
		}

		JSONObject json = (JSONObject) JSONSerializer.toJSON(result);

		price = json.getString("price");
		currency = json.getString("currency_id");
		currency = currencies(currency);
		title = json.getString("title");
		reader.close();


		s[0]=price;
		s[1]=currency;
		s[2]=title;

		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return s;

}
	
/**
 * @description get the symbol money in the api currencies.
 * */
private String currencies(String defaultCurrencyId){
	String symbolCurrency=null;
		
	if(defaultCurrencyId.equals("UYU"))
		symbolCurrency="$";
	else if (defaultCurrencyId.equals("USD")) {
		symbolCurrency="U$S";		
	}else if (defaultCurrencyId.equals("EUR")) {
		symbolCurrency="€";	
	}
	
	return symbolCurrency;
}
	
	
	//hay q poner q valide con la password tambien
	@Override
	public String[] miCuenta(String username) throws IllegalArgumentException {
					
		String [] s = new String[10];
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
			String nomb = e.getNombre();
			String apellido = e.getApellido();
		
		
			s[0]=user;
			s[1]=password;
			s[2]=direccion;
			s[3]=tel;
			s[4]=ci;
			s[5]=ciudad;
			s[6]=dpto;
			s[7]=nomb;
			s[8]=apellido;
			
			
			
		} catch (Exception ex) {
			
		System.out.println("error al traer la data");
		


		}

		return s;
	
	
	}
	
	/*
	 precio en pesos....
	 	si es menor a 500.
	 	todos los envios 80 pesos.
	 	todos los envios 70 pesos.
	 	todos los envios 60 pesos.
	 	todos los envios 50 pesos.

		
		 si es mayor a 500 pesos.< 999 $
		todos los envios 95 pesos.
	 	todos los envios 85 pesos.
	 	todos los envios 75 pesos.
	 	todos los envios 65 pesos.

		si es mayor = que 1000
		todos los envios 15 %
	 	todos los envios 14 %
	 	todos los envios 13 %
	 	todos los envios 10 %
	 	
	 	1720 -- 100
	 			15
	 
	 * */
	
	
	
	@Override
	public String calcularPrecioFinal(String precio, String shipping, String moneda){		
		
		System.out.println("este es el shipping :"+shipping);
		System.out.println("este es el precio :"+precio);
		System.out.println("este es el moneda :"+moneda);
		System.out.println("este es el precio redondeado porque viene float :"+precio);

		
		Float total=(float) 0;
		Float valor=(float) 0;	
		valor=valor.parseFloat(redondeo(precio));
		
		String salida=null;
		
		
		if (moneda.equals(PESOS)){
				if (valor<=500){
					System.out.println("PRECIO MENOR IGUAL A 500: valor = " +valor);

					if(shipping.equals(SHIPPING_1)){
						total= valor+80;
						salida = total.toString();
						System.out.println("24 hrs: "+total);
					}
					else if(shipping.equals(SHIPPING_2)){
						total= valor+70;
						salida = total.toString();
						System.out.println("48 hrs: "+total);
					}
					else if(shipping.equals(SHIPPING_3)){
						total= valor+60;
						salida = total.toString();
						System.out.println("72 hrs: "+total);
						
					}else if(shipping.equals(SHIPPING_4)){
						total= valor+50;
						salida = total.toString();
						System.out.println("despues 72 hrs: "+total);
						
					}
					
					
				}else if((valor>500) && (valor <=999)){
					
					System.out.println("PRECIO MAYOR Q 500 Y MENOR QUE 999: valor = " +valor);

					if(shipping.equals(SHIPPING_1)){
						total= valor+95;						
						salida = total.toString();
						System.out.println("24 hrs: "+total);
					}
					else if(shipping.equals(SHIPPING_2)){
						total= valor+85;						
						salida = total.toString();
						System.out.println("48 hrs: "+total);
					}
					else if(shipping.equals(SHIPPING_3)){
						total= valor+75;
						salida = total.toString();
						System.out.println("72 hrs: "+total);
						
					}else if(shipping.equals(SHIPPING_4)){
						total= valor+65;
						salida = total.toString();
						System.out.println("despues 72 hrs: "+total);
						
					}
					
					
				}else if(valor>=1000){
					System.out.println("PRECIO MAYOR IGUAL A 1000: valor = " +valor);

					if(shipping.equals(SHIPPING_1)){
						salida=calculadoraDePrecio(precio,12);						
						System.out.println("24 hrs "+salida);
					}
					else if(shipping.equals(SHIPPING_2)){
						salida=calculadoraDePrecio(precio,11);						
						System.out.println("48 hrs "+salida);
					}
					else if(shipping.equals(SHIPPING_3)){
						salida=calculadoraDePrecio(precio,10);						
						System.out.println("72 hrs "+salida);
						
					}else if(shipping.equals(SHIPPING_4)){
						salida=calculadoraDePrecio(precio,9);						
						System.out.println("despues 72 hrs: "+salida);
						
					}
				}
				
						
		}else if (moneda.equals(DOLARES)){
			System.out.println("PRECIO en DOLARES: valor = " +valor);

			if(shipping.equals(SHIPPING_1)){
				salida=calculadoraDePrecio(precio,10);						
				System.out.println("24 hrs "+salida);				
			}
			else if(shipping.equals(SHIPPING_2)){
				salida=calculadoraDePrecio(precio,9);						
				System.out.println("48 hrs "+salida);
			
			}
			else if(shipping.equals(SHIPPING_3)){
				salida=calculadoraDePrecio(precio,8);						
				System.out.println("72 hrs "+salida);
				
			}else if(shipping.equals(SHIPPING_4)){
				salida=calculadoraDePrecio(precio,7);						
				System.out.println("despues 72 hrs: "+salida);
				
			}
		
		
		}
		
			
		return salida;
	}
	
	
	public String calculadoraDePrecio(String precioInicial, float porcentaje){
		
		System.out.println("<MODULO CALCULADORA>");		
		System.out.println("ANTES DE MODIFICAR: "+ precioInicial);
		
		//Float porcentaje=(float) 3;
		Float precio=(float) 0;
		Float auxiliar;
		Float porcentajeCalculado;
		String salida=null;
		Double precioModificado=(double) 0;
		precio = precio.parseFloat(precioInicial);	
		auxiliar =precio * porcentaje;
		porcentajeCalculado =auxiliar/100;
		
		precioModificado=(double) (precio + porcentajeCalculado);
			
		
		salida=precioModificado.toString();
		String redondeo = redondeo(salida);

		
		System.out.println("DESPUES DE MODIFICAR SIN REDONDEAR: "+ salida);
		System.out.println("DESPUES DE MODIFICAR REDONDEADO: "+ redondeo);
		System.out.println("</MODULO CALCULADORA>");
		
		return redondeo;
	}


	public String redondeo(String numero){
			
		Double v = Double.parseDouble(numero); 
	    String val = v+"";
	    BigDecimal big = new BigDecimal(val);
	    big = big.setScale(0, RoundingMode.HALF_UP);
	    String finalPrice =big.toString();

		return finalPrice;
	}
	

	
	
	
}
