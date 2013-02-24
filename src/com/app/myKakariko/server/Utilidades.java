/**
 * 
 */
package com.app.myKakariko.server;

import com.app.myKakariko.shared.FieldVerifier;

/**
 * @author nicolasmoraes
 *
 */
public class Utilidades {

	
	//https://api.mercadolibre.com/sites/MLU/categories
	
	public static String MASCOTAS="MLU1071";
	public static String ANTIGUEDADES="MLU1367";
	public static String CAMARAS_ACCESORIOS="MLU1039";
	public static String BEBES="MLU1384";
	public static String TELEFONIA_ACCESORIOS="MLU1051";
	public static String COLECCIONABLES="MLU1798";
	public static String COMPUTACION="MLU1648";
	public static String VIDEO_JUEGOS="MLU1144";
	public static String DEPORTES="MLU1276";
	public static String ELECTRODOMESTICOS="MLU5726";
	public static String AUDIO_VIDEO="MLU1000";
	public static String HOGAR="MLU1574";
	public static String INDUSTRIA_OFICINA="MLU1499";
	public static String INSTRUMENTOS_MUSICALES="MLU1182";
	public static String JUEGOS_JUGUETES="MLU1132";
	public static String MUSICA_LIBROS_PELICULAS="MLU1168";
	public static String ROPA_JOYAS_RELOJES="MLU1430";
	public static String SALUD_BELLEZA="MLU1246";

	
	
	/** Esperando confirmacion de Abitab */
	public static String ESTADO_1 ="Esperando confirmacion de Abitab";
	/**Pago confirmado, enviando*/
	public static String ESTADO_2 ="Pago confirmado, enviando";
	/**Paquete entregado*/
	public static String ESTADO_3 ="Paquete entregado";


	/**Dado un nombre de categoria dado por el combobox de busqueda
	 * devuelve el numero de categoria correspondiente.
	 * */
	public static String viewCategorie(String comboBoxValue){
		
		String categoria = null;

		if (comboBoxValue.equals(FieldVerifier.ANIMALES)) {

			categoria = Utilidades.MASCOTAS;

		} else if (comboBoxValue.equals(FieldVerifier.ARTE_ANTIGUEDAD)) {

			categoria = Utilidades.ANTIGUEDADES;

		} else if (comboBoxValue.equals(FieldVerifier.CAMARAS_ACCESORIOS)) {

			categoria = Utilidades.CAMARAS_ACCESORIOS;

		} else if (comboBoxValue.equals(FieldVerifier.TELEFONIA)) {

			categoria = Utilidades.TELEFONIA_ACCESORIOS;

		} else if (comboBoxValue.equals(FieldVerifier.COLECCIONES)) {

			categoria = Utilidades.COLECCIONABLES;
		}

		else if (comboBoxValue.equals(FieldVerifier.INFORMATICA)) {

			categoria = Utilidades.COMPUTACION;
		}

		else if (comboBoxValue.equals(FieldVerifier.CONSOLAS)) {

			categoria = Utilidades.VIDEO_JUEGOS;
		}

		else if (comboBoxValue.equals(FieldVerifier.DEPORTES)) {

			categoria = Utilidades.DEPORTES;
		}

		else if (comboBoxValue.equals(FieldVerifier.ELECTRODOMESTICOS)) {

			categoria = Utilidades.ELECTRODOMESTICOS;
		}

		else if (comboBoxValue.equals(FieldVerifier.ELECTRONICA_AUDIO_VIDEO)) {

			categoria = Utilidades.AUDIO_VIDEO;
		}

		else if (comboBoxValue.equals(FieldVerifier.HOGAR)) {

			categoria = Utilidades.HOGAR;
		}

		else if (comboBoxValue.equals(FieldVerifier.INDUSTRIA_Y_OFICINA)) {

			categoria = Utilidades.INDUSTRIA_OFICINA;
		}

		else if (comboBoxValue.equals(FieldVerifier.INSTRUMENTOS_MUSICALES)) {

			categoria = Utilidades.INSTRUMENTOS_MUSICALES;
		}

		else if (comboBoxValue.equals(FieldVerifier.JUEGOS_Y_JUGUETES)) {

			categoria = Utilidades.JUEGOS_JUGUETES;
		}

		else if (comboBoxValue.equals(FieldVerifier.MUSICA_LIBROS_PELICULAS)) {

			categoria = Utilidades.MUSICA_LIBROS_PELICULAS;
		}

		else if (comboBoxValue.equals(FieldVerifier.ROPA_JOYAS_RELOJES)) {

			categoria = Utilidades.ROPA_JOYAS_RELOJES;
		}
		
		return categoria;
	}
	
	

	
}
