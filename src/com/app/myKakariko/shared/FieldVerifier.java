package com.app.myKakariko.shared;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;


/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> package because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is not translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	/**
	 * Verifies that the specified name is valid for our service.
	 * 
	 * In this example, we only require that the name is at least four
	 * characters. In your application, you can use more complex checks to ensure
	 * that usernames, passwords, email addresses, URLs, and other fields have the
	 * proper syntax.
	 * 
	 * @param name the name to validate				rvm use 1.9.3
	 * @return true if valid, false if invalid jekyll --pygments --safe --auto
	 */
	
	
	public static String TODAS_LAS_CATEGORIAS ="Todas las categorias";
	public static String ANIMALES ="Animales y Mascotas";
	public static String ARTE_ANTIGUEDAD= "Arte y Antiguedades";	
	public static String CAMARAS_ACCESORIOS ="Camaras y Accesorios";	
	public static String TELEFONIA ="Celulares y Telefonia";	
	public static String COLECCIONES="Coleccionables";	
	public static String INFORMATICA ="Computacion";
	public static String CONSOLAS ="Consolas y Videojuegos";
	public static String DEPORTES ="Deportes y Fitness";
	public static String ELECTRODOMESTICOS ="Electrodomesticos y Aires Ac.";
	public static String ELECTRONICA_AUDIO_VIDEO ="Electronica, Audio y Video";
	public static String HOGAR = "Hogar, Muebles y Jardin";
	public static String INDUSTRIA_Y_OFICINA ="Industrias y Oficinas";
	public static String INSTRUMENTOS_MUSICALES ="Instrumentos Musicales";
	public static String  JUEGOS_Y_JUGUETES = "Juegos y Juguetes";
	public static String MUSICA_LIBROS_PELICULAS ="Musica, Libros y Peliculas";
	public static String ROPA_JOYAS_RELOJES ="Ropa, Joyas y Relojes";

	
	public static boolean isValidPass(String name) {
		if (name == null || name.equals("")) {
			return false;
		}
		return name.length() > 4;
	}
	
	public static boolean isValidCi(String cedula) {
		if (cedula == null || cedula.equals("")) {
			return false;
		}
		return cedula.length() == 7;
	}
	
	public static boolean isValidTel(String tel) {
		if (tel == null || tel.equals("")) {
			return false;
		}
		return tel.length() >=8;
	}
	
	/**
	 * Validacion de emails.
	 */
	
	   public static boolean isEmail(String value) {
           if(value == null) return true;
           
           String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$";
           
           boolean valid = false;
           
           if(value.getClass().toString().equals(String.class.toString())) {
                   valid = ((String)value).matches(emailPattern);
           } else {
                   valid = ((Object)value).toString().matches(emailPattern);
           }

           return valid;
   }

	   public static boolean isValidName(String name) {
			if (name == null || name.equals("")) {
				return false;
			}
			return true;
		}
	   
	   
	   public static String currencies(String defaultCurrencyId){
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
	

	   
	
	
}
