package com.app.myKakariko.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;

import javax.jdo.PersistenceManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.app.myKakariko.client.GreetingService;
import com.app.myKakariko.server.database.Client;
import com.app.myKakariko.server.database.PMF;
import com.app.myKakariko.shared.FieldVerifier;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String pictures = null;
		String price = null;
		String sold_quantity = null;
		String title = null;
		String s = null;
		String currency = null;

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

			System.out.println("result: " + result);

			JSONObject json = (JSONObject) JSONSerializer.toJSON(result);

			// String id = json.getString( "id" );
			price = json.getString("price");
			sold_quantity = json.getString("sold_quantity");
			title = json.getString("title");
			currency = json.getString("currency_id");

			// https://api.mercadolibre.com/items/MLA421101451/pictures?access_token=$ACCESS_TOKEN
			// T O

			pictures = json.getString("thumbnail");
			System.out.println("id pic: " + pictures);

			s = pictures.replace("_v_I_f", "_v_T_f");

			reader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Item, " + input + "!<br>" + title + "<br>Precio: " + price
				+ " " + currency/* serverInfo */
				+ ".<br><br>Cantidad: " + sold_quantity + "<br>" + "<img src="
				+ s + ">";
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
				//System.out.println(line);
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
				price=calculadoraDePrecio(price);
				thumbnail = array.getString("thumbnail");
				currency = array.getString("currency_id");
				pic = thumbnail.replace("_v_I_f", "_v_T_f");
				stop_time = array.getString("stop_time");
				condition = array.getString("condition");
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
						+ ". Estado "
						+ condition
						+ "<br><b>Oferta Valida: </b>"
						+ stop_time
						+ "</p><br></div>" +
						"<div id=\"gwtContainer\"><p align=\"right\"><button class=\"btn btn-warning\" input type=\"button\" >detalles</button></p></div>"
						+"</div><hr> </div>";
						
					System.out.println(html);	
						
						//"<hr> </div>";
				s[i]=html;
				
			}
			

			reader.close();

			System.out.println("QUERY :" + site + " " + query);

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
				price=calculadoraDePrecio(price);			
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


public String nuevoUsuario(String username, String password,String email, String nombre,
		String apellido, String cedula, String departamento, String ciudad, String direccion, String barrio, String telefono)
		throws IllegalArgumentException {

	PersistenceManager pm = null;
	pm = PMF.get().getPersistenceManager();

	Client users = new Client(username, password, email, nombre,
			apellido, cedula, departamento, ciudad, direccion, barrio, telefono);
	
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
	//String serverInfo = getServletContext().getServerInfo();
	//String userAgent = getThreadLocalRequest().getHeader("User-Agent");

	// Escape data from the client to avoid cross-site script
	// vulnerabilities.
	nombre = escapeHtml(nombre);
	apellido = escapeHtml(apellido);
	//userAgent = escapeHtml(userAgent);

//	return "Hello, " + nombre + " " + apellido + "!<br><br>I am running "
//			+ serverInfo + ".<br><br>It looks like you are using:<br>"
//			+ userAgent;

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



public String calculadoraDePrecio(String precioInicial){
	
	System.out.println("<MODULO CALCULADORA>");
	
	System.out.println("ANTES DE MODIFICAR: "+ precioInicial);
	
	Float porcentaje=(float) 3;
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
