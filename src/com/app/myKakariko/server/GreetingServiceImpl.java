package com.app.myKakariko.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import javax.jdo.PersistenceManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.app.myKakariko.client.GreetingService;
import com.app.myKakariko.server.database.Client;
import com.app.myKakariko.server.database.PMF;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	
	
public String[] precio(String input, String shipping)throws IllegalArgumentException {
	System.out.println(shipping);
	String [] s = new String[5];
	String price = null;
	String currency =null;
	String pictures=null;
	String title =null;
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
		pictures = json.getString("thumbnail");
		pictures=pictures.replace("_v_I_f", "_v_T_f");
		title = json.getString("title");
		reader.close();

		s[0]=price;
		s[1]=currency;
		s[2]=pictures;
		s[3]=title;


		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return s;

}
	
	
    
	public String greetServer(String input) throws IllegalArgumentException {
		

		String pictures = null;
		String price = null;
		String sold_quantity = null;
		String title = null;
		String subtitle = null;
		String s = null;
		String currency = null;
		String cantidadInicial =null;
		String estado = null;
		String stopTime= null;

		// http://answers.oreilly.com/topic/257-how-to-parse-json-in-java/
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

			// String id = json.getString( "id" );
			price = json.getString("price");
			sold_quantity = json.getString("sold_quantity");
			title = json.getString("title");
			currency = json.getString("currency_id");
			currency = currencies(currency);
			subtitle =json.getString("subtitle");
			cantidadInicial =json.getString("initial_quantity");
			estado=estado(json.getString("condition"));
			pictures = json.getString("thumbnail");
			stopTime= json.getString("stop_time");
			System.out.println("id pic: " + pictures);

			s = pictures.replace("_v_I_f", "_v_O_f");

			reader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		

		return  "<div><p><img src="+s+ "align=\"left\" class=\"img-rounded\"><div><br><strong>" +title + " "+ subtitle+ "</strong><br><p class=\"text-error\">Precio: <strong>" + price +  "</strong> "+currency + " (el precio NO incluye el envio)</p> " 
				+ "Cantidad inicial de articulos: "
				+cantidadInicial  + "<br>Cantidad disponible a la venta: " + sold_quantity + "<br>" +
				" Estado del producto : "+estado+"</p></div>";
				
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	@Override
	public String[] query(String name) throws IllegalArgumentException {

		 //log.log(Level.INFO, "AHORA SEEEE CARAJO consulta :" +name);
		 //log.info("HOLA");
		 
		String site = null;
		String query = null;
		String currency = null;
		String stop_time = null;
		String condition = null;

		String titles = null;
		String subtitle = null;
		String price = null;
		String thumbnail = null;
		String pic = null;
		String parametro = name.replaceAll(" ", "");
		String html = "";
		String id= null;
		System.out.println(parametro);
		String symbolCurrency=null;
		String [] s = new String[15];


		// http://answers.oreilly.com/topic/257-how-to-parse-json-in-java/
		URL url;
		try {
			//https://api.mercadolibre.com/sites/MLU/search?category=MLU1051&q=blackberry
			url = new URL("https://api.mercadolibre.com/sites/MLU/search?q="
					+ parametro);
			InputStream response = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response));
			String result = "";

			for (String line; (line = reader.readLine()) != null;) {
				result = result + line;
			}

			System.out.println("result: " + result);

			JSONObject json = (JSONObject) JSONSerializer.toJSON(result);

			// String id = json.getString( "id" );
			site = json.getString("site_id");
			query = json.getString("query");

			// Obtengo el array de items
			JSONObject p = (JSONObject) json.get("paging");
			String total = p.getString("total");
			System.out.println("Total: " + total);

			JSONArray results = json.getJSONArray("results");

			// results.size();
			// Obtengo los 10 primeros
			for (int i = 0; i < 15; i++) {
				html=null;
				pic=null;
				JSONObject array = (JSONObject) results.get(i);
				titles = array.getString("title");
				subtitle = array.getString("subtitle");
				price = array.getString("price");
				//price=calculadoraDePrecio(price);
				thumbnail = array.getString("thumbnail");
				currency = array.getString("currency_id");
				pic = thumbnail.replace("_v_I_f", "_v_T_f");
				stop_time = array.getString("stop_time");
				condition = estado(array.getString("condition"));
				id = array.getString("id");
				symbolCurrency=currencies(currency);

				
				html = "<!--"+id + "                                         -->"+
						"<div>"
						+ "<p><img src="
						+ pic
						+ " align=\"left\" class=\"img-rounded\"><div><br>"
						+ titles
						+ ".<br>"
						+ subtitle
						+ ".<br>"
						+ price
						+ " "
						+ symbolCurrency
						+ ". Estado: "
						+ condition
						+ "<br><b>Oferta Valida: </b>"
						+ stop_time
						+ "</p><br></div>" +
						"<div id=\"gwtContainer\"><p align=\"right\"><button class=\"btn btn-warning\" input type=\"button\" >detalles</button></p></div>"
						+"</div><hr> </div>";
						
					System.out.println(html);	
						
				s[i]=html;
				
			}
			

			reader.close();

			//System.out.println("QUERY :" + site + " " + query);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return null;
		return s;

	}

	@Override
	public String inicio(String name) {

		String site = null;
		String query = null;
		String currency = null;
		String stop_time = null;
		String condition = null;
		String ofertaValidaHasta=null;

		String titles = null;
		String subtitle = null;
		String price = null;
		String thumbnail = null;
		String pic = null;
		String parametro = name.replaceAll(" ", "");
		String html = "";
		String id=null;
		System.out.println(parametro);
		
		String identificadores=null;


		// http://answers.oreilly.com/topic/257-how-to-parse-json-in-java/
		URL url;
		try {
			url = new URL("https://api.mercadolibre.com/sites/MLU/search?q="
					+ parametro);
			InputStream response = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response));
			String result = "";

			for (String line; (line = reader.readLine()) != null;) {
				//System.out.println(line);
				result = result + line;
			}

			System.out.println("result: " + result);

			JSONObject json = (JSONObject) JSONSerializer.toJSON(result);

			site = json.getString("site_id");
			query = json.getString("query");

			// Obtengo el array de items
			JSONObject p = (JSONObject) json.get("paging");
			String total = p.getString("total");
			System.out.println("Total: " + total);

			JSONArray results = json.getJSONArray("results");

			// results.size();
			// Obtengo los 10 primeros
			for (int i = 0; i < 3; i++) {
				JSONObject array = (JSONObject) results.get(i);
				titles = array.getString("title");
				subtitle = array.getString("subtitle");
				price = array.getString("price");
				//price=calculadoraDePrecio(price);			
				thumbnail = array.getString("thumbnail");
				pic = thumbnail.replace("_v_I_f", "_v_T_f");
				currency = array.getString("currency_id");
				stop_time = array.getString("stop_time");
				condition = array.getString("condition");
				id=array.getString("id");
				
				identificadores=identificadores+ id+ "/";
				
				html = html + "<!-- id="+ id +" -->"
						+ "<div>"
						+ "<p><img src="
						+ pic
						+ " align=\"left\" class=\"img-rounded\"><div><br>"
						+ titles
						+ ".<br>"
						+ subtitle
						+ ".<br>"
						+ price
						+ " "						
						+ currency
						+ ". Estado "
						+ condition
						+ "<br><b>Oferta Valida: </b>"
						+ stop_time
						+ "</p><br>" +"<div id=\"gwtContainer\"><p align=\"right\"><button class=\"btn btn-warning\" input type=\"button\" >detalles</button></p></div>"
						+"</div><hr> </div>";

			}
			System.out.println(html);

			reader.close();

			System.out.println("QUERY :" + site + " " + query);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return html;

	}


public boolean login(String user, String pass) throws IllegalArgumentException {

	String conexion = "";
	Boolean entrar=false;

	PersistenceManager pm = null;
	try {
		pm = PMF.get().getPersistenceManager();

	} catch (Exception e) {
		e.printStackTrace();
	}

	Client e = null;

	e = pm.getObjectById(Client.class, user);

	if (e.getPassword().equals(pass) == true) {
		conexion = e.getNombre() + " " + e.getApellido();
		entrar=true;
		pm.close();
	}

	else {
		throw new IllegalArgumentException();
	}
	
	return entrar;
}


public String nuevoUsuario(String username, String password, String nombre,
		String apellido, String cedula, String departamento, String ciudad, String direccion, String telefono)
		throws IllegalArgumentException {

	PersistenceManager pm = null;
	pm = PMF.get().getPersistenceManager();

	Client users = new Client(username, password, nombre,
			apellido, cedula, departamento, ciudad, direccion, telefono);
	
	Client e = null;
	try {

		Key k = KeyFactory.createKey(Client.class.getSimpleName(),
				username);
		e = pm.getObjectById(Client.class, k);
	} catch (Exception ex) {
		// Si el usuario no existe, salta una excpecion, por lo tanto se va
		// a insertar el nuevo usuario.
		System.out.println("se va a insertar......" + username);
		pm.makePersistent(users);

	}

	if (e != null) {

		throw new IllegalArgumentException();

	}

	pm.close();

	// Escape data from the client to avoid cross-site script
	// vulnerabilities.
	nombre = escapeHtml(nombre);
	apellido = escapeHtml(apellido);

	return username;
}



/**
 * @description get the symbol money in the api currencies.
 * */
public String currencies(String defaultCurrencyId){
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

/**
 * @description get the condition item
 * */
public String estado(String condition){
	String estado="";	
	if(condition.equals("new"))
		estado="Nuevo";
	else if (condition.equals("used")) {
		estado="Usado";		
	}else if (condition.equals("not_specified")) {
		estado="El vendedor no especifico si el producto es nuevo o usado, ante la duda, comuniquese con nosotros";	
	}
	
	return estado;
}





	
	
	
}








