package com.app.myKakariko.client;




import com.app.myKakariko.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Kakariko implements EntryPoint, ValueChangeHandler {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private final MiCuentaServiceAsync comprarService = GWT.create(MiCuentaService.class);

	private final long DURATION_QUERY = 180000000;
	private static String userlog=null;
	private static String userpas=null;

	private TextBox txtbxIpod;
	private Button btnNewButton;
	private HTML htmlNewHtml= new HTML("", true);
	private HTML htmlNewHtml2= new HTML("", true);
	private HTML htmlNewHtml3= new HTML("", true);
	private HTML htmlNewHtml4= new HTML("", true);
	private HTML htmlNewHtml5= new HTML("", true);
	private HTML htmlNewHtml6= new HTML("", true);
	private HTML htmlNewHtml7= new HTML("", true);
	private HTML htmlDestacado= new HTML("", true);
	
	//para comprar
	private HTML datos1= new HTML("", true);
	private HTML datos2= new HTML("", true);




	private HTML htmlRegistration= new HTML("", true);

	private HTML destacado1= new HTML(Destacados.DESTACADO_UNO, true);
	private HTML destacado2= new HTML(Destacados.DESTACADO_DOS, true);
	private HTML destacado3= new HTML(Destacados.DESTACADO_TRES, true);
	private HTML destacado4= new HTML(Destacados.DESTACADO_CUATRO, true);
	private HTML destacado5= new HTML(Destacados.DESTACADO_CINCO, true);
	private HTML destacado6= new HTML(Destacados.DESTACADO_SEIS, true);
	private HTML destacado7= new HTML(Destacados.DESTACADO_SIETE, true);
	private HTML destacado8= new HTML(Destacados.DESTACADO_OCHO, true);
	private HTML destacado9= new HTML(Destacados.DESTACADO_NUEVE, true);

	private HTML sendBoxImg= new HTML(Destacados.SEND_BOX_PAY, true);


	private String producto1;
	private String producto2;	
	private String producto3;
	private String producto4;
	private String producto5;
	private String producto6;
	private String producto7;

	private Button p1=new Button("comprar");




	private Button btnNewButton_1;
	//private HTML htmlInicio;
	private ListBox comboBox;

	private Button btnNewButton_2; //iniciarSesion
	//private HTML htmliniciarSesion= new HTML(IniciarSesionHTML.INICIAR_SESION, true);
	private TextBox userName;
	private PasswordTextBox pass;
	private Button btnNewButton_5;

	private Hyperlink btnNewButton_3 ;

	//Botones de registracion.
	private Button confirmar=new Button("enviar");
	private Hyperlink cancelar;

	//inicio
	private Hyperlink home;

	//panel de usuario.
	private Hyperlink miCuenta;
	private MiCuenta panelDeControl=new MiCuenta();

	final Label errorLabel = new Label();
	 private HTML label=new HTML("",true);

	 
	private ListBox comboBox_1;
	private String nom = null;
	private String dir = null;
	private String ciuyDepto = null;
	
	private Button btnComprar;
 
	private  Comprar comprando= new Comprar("","","","","");

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		
		p1.setVisible(false);
	

		
		RootPanel.get("htmlDestacado").add(htmlDestacado);

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		//RootPanel.get("sendButtonContainer").add(sendButton, 238, 200);
		RootPanel.get("errorLabelContainer").add(errorLabel);
		
		
		comboBox_1 = new ListBox();
		comboBox_1.setVisible(false);
		rootPanel.add(comboBox_1, 30, 80);
		
		comboBox_1.addItem("precio sin impuesto de entrega");
		comboBox_1.addItem("Entrega hasta 24 Hrs");
		comboBox_1.addItem("Entrega hasta 48 Hrs");
		comboBox_1.addItem("Entrega hasta 72 Hrs");
		comboBox_1.addItem("Entrega despues de 72 Hrs");
		RootPanel.get("comboentrega").add(comboBox_1);
		
		//comprar
		datos1.setVisible(false);
		datos2.setVisible(false);
		RootPanel.get("dato1").add(datos1);
		RootPanel.get("dato2").add(datos2);
		
		btnComprar = new Button("comprar");
		btnComprar.setVisible(false);
		btnComprar.setStyleName("btn btn-success");
		RootPanel.get("btnComprar").add(btnComprar);
		label.setVisible(false);
		RootPanel.get("labelPrice").add(label);

		
		
		//miCuenta
		miCuenta= new Hyperlink("mi cuenta","miCuenta");
		miCuenta.setStyleName("btn btn-link");
		RootPanel.get("miCuenta").add(miCuenta);
		miCuenta.setVisible(false);

		//home
		home= new Hyperlink("inicio","home");
		home.setStyleName("btn btn-link");
		RootPanel.get("inicio").add(home);
		home.setVisible(true);

		//login in send-box.com
		userName = new TextBox();
		pass = new PasswordTextBox();
		btnNewButton_5 = new Button("entrar");
		RootPanel.get("login").add(btnNewButton_5);
		btnNewButton_5.setSize("64px", "30px");
		btnNewButton_5.setStyleName("btn");

		//register in send-box.com
		btnNewButton_3 = new Hyperlink("registrarse","registro");
		RootPanel.get("registro").add(btnNewButton_3);
		btnNewButton_3.setStyleName("btn btn-link");
        confirmar.setVisible(false);
        confirmar.setStyleName("btn btn-primary");
		RootPanel.get("confirmar").add(confirmar);	
        cancelar = new Hyperlink("cancelar","home");
        cancelar.setVisible(false);
        cancelar.setStyleName("btn");
		RootPanel.get("cancelar").add(cancelar);

		//logout send-box.com
		btnNewButton_2 = new Button("salir");
		RootPanel.get("salir").add(btnNewButton_2);
		btnNewButton_2.setStyleName("btn btn-link");
		btnNewButton_2.setVisible(false);


		// /////////galletitas///////////////
				if (Cookies.getCookie("13051983ntmp") != null) {
					home.setVisible(false);
					System.out.println("hay cookie");
					btnNewButton_5.setVisible(false);
					userName=TextBox.wrap(DOM.getElementById("nico"));
					userName.setVisible(false);
					pass=PasswordTextBox.wrap(DOM.getElementById("nicolas"));
				    pass.setVisible(false);
					miCuenta.setVisible(true);
					btnNewButton_3.setVisible(false);
					btnNewButton_2.setVisible(true);
					confirmar.setVisible(false);
					cancelar.setVisible(false);




				} else {
					History.newItem("home");

				}

		RootPanel.get("userReg").setVisible(false);
		RootPanel.get("passReg").setVisible(false);
		RootPanel.get("nombreReg").setVisible(false);
		RootPanel.get("apellidoReg").setVisible(false);
		RootPanel.get("cedulaReg").setVisible(false);
		RootPanel.get("departamentoReg").setVisible(false);
		RootPanel.get("ciudadReg").setVisible(false);
		RootPanel.get("direccionReg").setVisible(false);
		RootPanel.get("telefonoReg").setVisible(false);

		btnNewButton = new Button("New button");
		btnNewButton.setText("buscar");
		// We can add style names to widgets
		//sendButton.addStyleName("sendButton");
		btnNewButton.setStyleName("btn btn-primary");
		btnNewButton.setSize("64px", "30px");
		RootPanel.get("btnNewButton").add(btnNewButton);


		txtbxIpod = new TextBox();
		txtbxIpod.setSize("436px", "20px");

		RootPanel.get("txtbxIpod").add(txtbxIpod);
		RootPanel.get("htmlNewHtml").add(htmlNewHtml);
		RootPanel.get("htmlNewHtml").add(htmlNewHtml2);
		RootPanel.get("htmlNewHtml").add(htmlNewHtml3);
		RootPanel.get("htmlNewHtml").add(htmlNewHtml4);
		RootPanel.get("htmlNewHtml").add(htmlNewHtml5);
		RootPanel.get("htmlNewHtml").add(htmlNewHtml6);
		RootPanel.get("htmlNewHtml").add(htmlNewHtml7);

		btnNewButton_1 = new Button("Cerrar");
		btnNewButton_1.setStyleName("btn btn-link");

		rootPanel.add(btnNewButton_1, 345, 66);
		RootPanel.get("cerrar").add(btnNewButton_1);
		btnNewButton_1.setVisible(false);


		comboBox = new ListBox();
		rootPanel.add(comboBox, 20, 70);
		rootPanel.setTitle("cateogorias");
		comboBox.setSize("173px", "30px");
		comboBox.addItem("Todas las categorias");
		comboBox.addItem("Animales y Mascotas");
		comboBox.addItem("Arte y Antiguedades");
		comboBox.addItem("Camaras y Accesorios");
		comboBox.addItem("Celulares y Telefon’a");
		comboBox.addItem("Coleccionables");
		comboBox.addItem("Computacion");
		comboBox.addItem("Consolas y Videojuegos");
		comboBox.addItem("Deportes y Fitness");
		comboBox.addItem("Electrodomesticos y Aires Ac.");
		comboBox.addItem("Electronica, Audio y Video");
		comboBox.addItem("Hogar, Muebles y Jardin");
		comboBox.addItem("Industrias y Oficinas");	
		comboBox.addItem("Instrumentos Musicales");
		comboBox.addItem("Juegos y Juguetes");	
		comboBox.addItem("Musica, Libros y Peliculas");
		comboBox.addItem("Ropa, Joyas y Relojes");
		comboBox.addItem("Industrias y Oficinas");



		RootPanel.get("combo").add(comboBox);



		//Destacados
		RootPanel.get("des1").add(destacado1);
		RootPanel.get("des2").add(destacado2);
		RootPanel.get("des3").add(destacado3);
		RootPanel.get("des4").add(destacado4);
		RootPanel.get("des5").add(destacado5);
		RootPanel.get("des6").add(destacado6);
		RootPanel.get("des7").add(destacado7);
		RootPanel.get("des8").add(destacado8);
		RootPanel.get("des9").add(destacado9);



		RootPanel.get("pay").add(sendBoxImg);


        History.addValueChangeHandler(this);
        //when there is no token, the "home" token is set else changePage() is called.
        //this is useful if a user has bookmarked a site other than the homepage.
        if(History.getToken().isEmpty()){
            History.newItem("home");
        } else {
            changePage(History.getToken());
        }


		btnNewButton_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				label.setVisible(false);
				label.setText("");
				btnComprar.setVisible(false);
				htmlDestacado.setVisible(false);
				comboBox_1.setVisible(false);
				datos1.setVisible(false);
				datos2.setVisible(false);
				htmlNewHtml.setHTML("");
				htmlNewHtml2.setHTML("");
				htmlNewHtml3.setHTML("");
				htmlNewHtml4.setHTML("");
				htmlNewHtml5.setHTML("");
				htmlNewHtml6.setHTML("");
				htmlNewHtml7.setHTML("");
				btnNewButton_1.setVisible(false);
				sendBoxImg.setVisible(true);
				p1.setVisible(false);
	
				History.newItem("home");

			}
		});


		// Handler para eliminacion de cookies.
				class MyHandlerCookie implements ClickHandler, KeyUpHandler {

					@Override
					public void onClick(ClickEvent event) {
						Cookies.removeCookie("13051983ntmp");
						Cookies.removeCookie("13051983comprarnombre");
						Cookies.removeCookie("13051983comprardir");
						Cookies.removeCookie("13051983ciudaddepto");
						Window.Location.reload();

					}

					@Override
					public void onKeyUp(KeyUpEvent event) {
						Cookies.removeCookie("13051983ntmp");
						Cookies.removeCookie("13051983comprarnombre");
						Cookies.removeCookie("13051983comprardir");
						Cookies.removeCookie("13051983ciudaddepto");
						Window.Location.reload();


					}

				}


		class MyHandlerProducto1 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				viewItem();				

			}

			@Override
			public void onClick(ClickEvent event) {
				viewItem();

			}

			private void viewItem() {
				htmlNewHtml.setVisible(false);
				htmlNewHtml2.setVisible(false);
				htmlNewHtml3.setVisible(false);
				htmlNewHtml4.setVisible(false);
				htmlNewHtml5.setVisible(false);
				htmlNewHtml6.setVisible(false);
				htmlNewHtml7.setVisible(false);
				p1.setVisible(false);
	

				mostrarItem(Cookies.getCookie("prod1"));

				
			}


		}

		class MyHandlerProducto2 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				viewItem();				

			}

			@Override
			public void onClick(ClickEvent event) {
				viewItem();

			}

			private void viewItem() {
				htmlNewHtml.setVisible(false);
				htmlNewHtml2.setVisible(false);
				htmlNewHtml3.setVisible(false);
				htmlNewHtml4.setVisible(false);
				htmlNewHtml5.setVisible(false);
				htmlNewHtml6.setVisible(false);
				htmlNewHtml7.setVisible(false);
				p1.setVisible(false);
		

				mostrarItem(Cookies.getCookie("prod2"));

				
			}


		}

		class MyHandlerProducto3 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				viewItem();				

			}

			@Override
			public void onClick(ClickEvent event) {
				viewItem();

			}

			private void viewItem() {
				htmlNewHtml.setVisible(false);
				htmlNewHtml2.setVisible(false);
				htmlNewHtml3.setVisible(false);
				htmlNewHtml4.setVisible(false);
				htmlNewHtml5.setVisible(false);
				htmlNewHtml6.setVisible(false);
				htmlNewHtml7.setVisible(false);
				p1.setVisible(false);
			

				mostrarItem(Cookies.getCookie("prod3"));
			
			}

		}

		class MyHandlerProducto4 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				viewItem();				

			}

			@Override
			public void onClick(ClickEvent event) {
				viewItem();

			}

			private void viewItem() {
				htmlNewHtml.setVisible(false);
				htmlNewHtml2.setVisible(false);
				htmlNewHtml3.setVisible(false);
				htmlNewHtml4.setVisible(false);
				htmlNewHtml5.setVisible(false);
				htmlNewHtml6.setVisible(false);
				htmlNewHtml7.setVisible(false);
				p1.setVisible(false);
			

				mostrarItem(Cookies.getCookie("prod4"));

				
			}


		}

		class MyHandlerProducto5 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				viewItem();				

			}

			@Override
			public void onClick(ClickEvent event) {
				viewItem();

			}

			private void viewItem() {
				htmlNewHtml.setVisible(false);
				htmlNewHtml2.setVisible(false);
				htmlNewHtml3.setVisible(false);
				htmlNewHtml4.setVisible(false);
				htmlNewHtml5.setVisible(false);
				htmlNewHtml6.setVisible(false);
				htmlNewHtml7.setVisible(false);
				p1.setVisible(false);
			

				mostrarItem(Cookies.getCookie("prod5"));

				
			}


		}


		class MyHandlerProducto6 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				viewItem();				

			}

			@Override
			public void onClick(ClickEvent event) {
				viewItem();

			}

			private void viewItem() {
				htmlNewHtml.setVisible(false);
				htmlNewHtml2.setVisible(false);
				htmlNewHtml3.setVisible(false);
				htmlNewHtml4.setVisible(false);
				htmlNewHtml5.setVisible(false);
				htmlNewHtml6.setVisible(false);
				htmlNewHtml7.setVisible(false);
				p1.setVisible(false);
				

				mostrarItem(Cookies.getCookie("prod6"));

				
			}


		}

		class MyHandlerProducto7 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				viewItem();				

			}

			@Override
			public void onClick(ClickEvent event) {
				viewItem();

			}

			private void viewItem() {
				htmlNewHtml.setVisible(false);
				htmlNewHtml2.setVisible(false);
				htmlNewHtml3.setVisible(false);
				htmlNewHtml4.setVisible(false);
				htmlNewHtml5.setVisible(false);
				htmlNewHtml6.setVisible(false);
				htmlNewHtml7.setVisible(false);
				p1.setVisible(false);
			

				mostrarItem(Cookies.getCookie("prod7"));

				
			}


		}





		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				confirmar.setEnabled(false);
				sendNameToServer();

			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				//if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				confirmar.setEnabled(false);
				//cancelar.setEnabled(false);
				sendNameToServer();
				//System.out.println("hola");

				//}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				//String textToServer = textBox.getText();

				TextBox usernameText=TextBox.wrap(DOM.getElementById("userReg"));
				PasswordTextBox passwordText=PasswordTextBox.wrap(DOM.getElementById("passReg"));
				TextBox nombreText=TextBox.wrap(DOM.getElementById("nombreReg"));
				TextBox apellidoText=TextBox.wrap(DOM.getElementById("apellidoReg"));
				TextBox cedulaText=TextBox.wrap(DOM.getElementById("cedulaReg"));
				TextBox departamentoText=TextBox.wrap(DOM.getElementById("departamentoReg"));
				TextBox ciudadText=TextBox.wrap(DOM.getElementById("ciudadReg"));
				TextBox direccionText=TextBox.wrap(DOM.getElementById("direccionReg"));
				TextBox telefonoText=TextBox.wrap(DOM.getElementById("telefonoReg"));

				String username =usernameText.getText();
				String password=passwordText.getText();
				String nombre=nombreText.getText();
				String apellido=apellidoText.getText(); 	
				String cedula=cedulaText.getText();
				String departamento=departamentoText.getText();
				String ciudad=ciudadText.getText();
				String direccion=direccionText.getText(); 
				String telefono=telefonoText.getText();

				if (!FieldVerifier.isEmail(username)) {
					errorLabel.setText("Debes ingresar un email valido.");
					DOM.getElementById("userReg").setPropertyString("value", "");
					confirmar.setEnabled(true);
					return;
				}

				if (!FieldVerifier.isValidPass(password)) {
					errorLabel.setText("El password no puede ser vacio, y debe tener al menos 5 caracteres");
					DOM.getElementById("passReg").setPropertyString("value", "");
					confirmar.setEnabled(true);
					return;
				}
				if (!FieldVerifier.isValidName(nombre)) {
					errorLabel.setText("El nombre no puede ser vacio.");
					confirmar.setEnabled(true);
					return;
				}

				if (!FieldVerifier.isValidName(apellido)) {
					errorLabel.setText("El apellido no puede ser vacio.");
					confirmar.setEnabled(true);
					return;
				}

				if (!FieldVerifier.isValidCi(cedula)) {
					errorLabel.setText("La cedula no puede ser vacia, ingresala SIN puntos y sin el guion ni el ultimo numero");
					DOM.getElementById("cedulaReg").setPropertyString("value", "");
					confirmar.setEnabled(true);
					return;
				}

				if (!FieldVerifier.isValidName(departamento)) {
					errorLabel.setText("El depto no puede ser vacio.");
					confirmar.setEnabled(true);
					return;
				}

				if (!FieldVerifier.isValidName(ciudad)) {
					errorLabel.setText("La ciudad no puede ser vacia.");
					confirmar.setEnabled(true);
					return;
				}
				if (!FieldVerifier.isValidTel(telefono)) {
					errorLabel.setText("El telefono no puede ser vacio y debe ser valido.");
					DOM.getElementById("telefonoReg").setPropertyString("value", "");
					confirmar.setEnabled(true);
					return;
				}
				if (!FieldVerifier.isValidName(direccion)) {
					errorLabel.setText("La direccion no puede ser vacia.");
					confirmar.setEnabled(true);
					return;
				}


				greetingService.nuevoUsuario(username, password, nombre,
						apellido, cedula, departamento, ciudad, direccion, telefono,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {

								Window.alert("Error al registrarte");

								confirmar.setEnabled(true);
								//cancelar.setEnabled(true);
							}

							public void onSuccess(String result) {

								Window.alert("Gracias por registrarte en send-box.com");

								DOM.getElementById("userReg").setPropertyString("value", "");
								DOM.getElementById("passReg").setPropertyString("value", "");
								DOM.getElementById("nombreReg").setPropertyString("value", "");
								DOM.getElementById("apellidoReg").setPropertyString("value", "");
								DOM.getElementById("cedulaReg").setPropertyString("value", "");
								DOM.getElementById("departamentoReg").setPropertyString("value", "");
								DOM.getElementById("ciudadReg").setPropertyString("value", "");
								DOM.getElementById("direccionReg").setPropertyString("value", "");
								DOM.getElementById("telefonoReg").setPropertyString("value", "");

								confirmar.setEnabled(true);
								//cancelar.setEnabled(true);
							}
						});
			}
		}
		
		/** Handler q recalcula el precio de un item con el combo de shipping */
		class MyHandlerCombo implements ChangeHandler {

			@Override
			public void onChange(ChangeEvent event) {
				int indexCat = comboBox_1.getSelectedIndex();
				final String comboBoxValue = comboBox_1.getValue(indexCat);
				java.util.Date expires = new java.util.Date(System.currentTimeMillis() + DURATION_QUERY);

				

				if (!comboBoxValue.equals("precio sin impuesto de entrega")) {
					
					Cookies.setCookie("shipping", comboBoxValue, expires);
					recalculo(comboBoxValue,
							Cookies.getCookie("13051983valor"),
							Cookies.getCookie("13051983moneda"));
					btnComprar.setVisible(true);
					label.setVisible(true);

				} else {

					btnComprar.setVisible(false);
					label.setVisible(false);
					label.setText("");

				}
			}

			private void recalculo(String shipping, String precioInicial,
					String moneda) {

				comprarService.calcularPrecioFinal(precioInicial, shipping,
						moneda, new AsyncCallback<String>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO
								System.out.println("ERROR DE COMBOBOX");
							}

							@Override
							public void onSuccess(String result) {

								final long DURATION = 180000;

								java.util.Date expires = new java.util.Date(
										System.currentTimeMillis() + DURATION);
								System.out.println("PRECIO CALCULADO: "
										+ Cookies.getCookie("13051983moneda")
										+ " " + result);
							
								
							//String gaga=	"<p class=\"text-error\"><strong>Total a pagar : "+Cookies.getCookie("13051983moneda")+ " "+ result + "</strong></p>";
								
								label.setHTML("<p class=\"text-error\"><strong>Total a pagar : "+Cookies.getCookie("13051983moneda")+ " "+ result + "</strong></p>");

							}

						});

			}
		}



		class MyHandler1 implements ClickHandler, KeyUpHandler {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

			}


		}

		// Create a handler for the sendButton and nameField
				class MyHandler2 implements ClickHandler, KeyUpHandler {

					@Override
					public void onKeyUp(KeyUpEvent event) {
						makeQuery();
					}

					@Override
					public void onClick(ClickEvent event) {
						makeQuery();

					}

					private void makeQuery(){
						panelDeControl.setVisible(false);
						String consulta= txtbxIpod.getText();
						greetingService.query(consulta, new AsyncCallback<String[]>(){


							public void onFailure(Throwable caught) {
								//TODO

							}


							public void onSuccess(String[] result) {
								java.util.Date expires = new java.util.Date(System.currentTimeMillis() + DURATION_QUERY);

								p1.setVisible(false);
								htmlDestacado.setVisible(false);
								comprando.setVisible(false);
								htmlNewHtml.setHTML(result[0]);
								
								producto1= result[0].substring(4, 18);
								producto1=producto1.trim();

								Cookies.setCookie("prod1", producto1, expires);

								producto2= result[1].substring(4, 18);
								producto2=producto2.trim();
								Cookies.setCookie("prod2", producto2, expires);

								producto3= result[2].substring(4, 18);
								producto3=producto3.trim();
								Cookies.setCookie("prod3", producto3, expires);

								producto4= result[3].substring(4, 18);
								producto4=producto4.trim();
								Cookies.setCookie("prod4", producto4, expires);

								producto5= result[4].substring(4, 18);
								producto5=producto5.trim();
								Cookies.setCookie("prod5", producto5, expires);

								producto6= result[5].substring(4, 18);
								producto6=producto6.trim();
								Cookies.setCookie("prod6", producto6, expires);

								producto7= result[6].substring(4, 18);
								producto7=producto7.trim();
								Cookies.setCookie("prod7", producto7, expires);
								
								sendBoxImg.setVisible(false);

								htmlNewHtml.setVisible(true);
								htmlNewHtml2.setVisible(true);
								htmlNewHtml3.setVisible(true);
								htmlNewHtml4.setVisible(true);
								htmlNewHtml5.setVisible(true);
								htmlNewHtml6.setVisible(true);
								htmlNewHtml7.setVisible(true);
								htmlNewHtml2.setHTML(result[1]);
								htmlNewHtml3.setHTML(result[2]);
								htmlNewHtml4.setHTML(result[3]);
								htmlNewHtml5.setHTML(result[4]);
								htmlNewHtml6.setHTML(result[5]);
								htmlNewHtml7.setHTML(result[6]);	
								btnNewButton_1.setVisible(true);


							}


						});

					}


				}		

				 class MyHandler3 implements ClickHandler, KeyUpHandler {

					@Override
					public void onKeyUp(KeyUpEvent event) {
						login();
					}

					@Override
					public void onClick(ClickEvent event) {
						login();
					}

					private void login(){

						userName=TextBox.wrap(DOM.getElementById("nico"));

						pass=PasswordTextBox.wrap(DOM.getElementById("nicolas"));



						String username= userName.getText();
						userlog=username;
						String passs= pass.getText();
						userpas=passs;

						greetingService.login(username,passs, new AsyncCallback<Boolean>(){


							public void onFailure(Throwable caught) {

								Window.alert("Error al loguearse");


							}


							public void onSuccess(Boolean result) {				

								// ////////////////COOKIES////////////////////////
								final long DURATION = 1800000; // duration
								// remembering login.3 minutos

								java.util.Date expires = new java.util.Date(
										System.currentTimeMillis() + DURATION);
								Cookies.setCookie("13051983ntmp", userlog, expires);
								Cookies.setCookie("13051983ntmppasw", userpas, expires);
								
								
								
								// cokies

								userName.setVisible(false);
								btnNewButton_3.setVisible(false);
								pass.setVisible(false);
								miCuenta.setVisible(true);
								btnNewButton_5.setVisible(false);
								btnNewButton_2.setVisible(true);

								Window.alert("Welcome back " + userlog);


								if (History.getToken().equals("registro"))
								   History.newItem("home");

							}


						});

					}


				}
				 
				 
				 
				 
				 

				 class MyHandlerDestacados implements ClickHandler, KeyUpHandler{

						@Override
						public void onKeyUp(KeyUpEvent event) {
							viewItem();		
							

						}

						@Override
						public void onClick(ClickEvent event) {
							viewItem();

						}

						private void viewItem() {
							
							//sendBoxImg.setVisible(false);
							comprando.setVisible(false);
							btnNewButton_1.setVisible(true);
							htmlNewHtml.setVisible(false);
							htmlNewHtml2.setVisible(false);
							htmlNewHtml3.setVisible(false);
							htmlNewHtml4.setVisible(false);
							htmlNewHtml5.setVisible(false);
							htmlNewHtml6.setVisible(false);
							htmlNewHtml7.setVisible(false);
							p1.setVisible(false);						

							mostrarItem(Destacados.DESTACADO_PRODUCTO1);
							
							 
						}


					}		 

				 class MyHandlerDestacados2 implements ClickHandler, KeyUpHandler{

						@Override
						public void onKeyUp(KeyUpEvent event) {
							viewItem();				

						}

						@Override
						public void onClick(ClickEvent event) {
							viewItem();

						}

						private void viewItem() {
							
							comprando.setVisible(false);
							btnNewButton_1.setVisible(true);
							htmlNewHtml.setVisible(false);
							htmlNewHtml2.setVisible(false);
							htmlNewHtml3.setVisible(false);
							htmlNewHtml4.setVisible(false);
							htmlNewHtml5.setVisible(false);
							htmlNewHtml6.setVisible(false);
							htmlNewHtml7.setVisible(false);
							p1.setVisible(false);
						

							mostrarItem(Destacados.DESTACADO_PRODUCTO2);
							
							 
						}


					}		 

				 class MyHandlerDestacados3 implements ClickHandler, KeyUpHandler{

						@Override
						public void onKeyUp(KeyUpEvent event) {
							viewItem();				

						}

						@Override
						public void onClick(ClickEvent event) {
							viewItem();

						}

						private void viewItem() {
							
							//sendBoxImg.setVisible(false);
							comprando.setVisible(false);
							btnNewButton_1.setVisible(true);
							htmlNewHtml.setVisible(false);
							htmlNewHtml2.setVisible(false);
							htmlNewHtml3.setVisible(false);
							htmlNewHtml4.setVisible(false);
							htmlNewHtml5.setVisible(false);
							htmlNewHtml6.setVisible(false);
							htmlNewHtml7.setVisible(false);
							p1.setVisible(false);
						

							mostrarItem(Destacados.DESTACADO_PRODUCTO3);
							
							 
						}


					}

				 class MyHandlerDestacados4 implements ClickHandler, KeyUpHandler{

						@Override
						public void onKeyUp(KeyUpEvent event) {
							viewItem();				

						}

						@Override
						public void onClick(ClickEvent event) {
							viewItem();

						}

						private void viewItem() {
							
							//sendBoxImg.setVisible(false);
							comprando.setVisible(false);
							btnNewButton_1.setVisible(true);
							htmlNewHtml.setVisible(false);
							htmlNewHtml2.setVisible(false);
							htmlNewHtml3.setVisible(false);
							htmlNewHtml4.setVisible(false);
							htmlNewHtml5.setVisible(false);
							htmlNewHtml6.setVisible(false);
							htmlNewHtml7.setVisible(false);
							p1.setVisible(false);
				

							mostrarItem(Destacados.DESTACADO_PRODUCTO4);
							
							 
						}


					}

				 class MyHandlerDestacados5 implements ClickHandler, KeyUpHandler{

						@Override
						public void onKeyUp(KeyUpEvent event) {
							viewItem();				

						}

						@Override
						public void onClick(ClickEvent event) {
							viewItem();

						}

						private void viewItem() {
							
							//sendBoxImg.setVisible(false);
							comprando.setVisible(false);
							btnNewButton_1.setVisible(true);
							htmlNewHtml.setVisible(false);
							htmlNewHtml2.setVisible(false);
							htmlNewHtml3.setVisible(false);
							htmlNewHtml4.setVisible(false);
							htmlNewHtml5.setVisible(false);
							htmlNewHtml6.setVisible(false);
							htmlNewHtml7.setVisible(false);
							p1.setVisible(false);
						

							mostrarItem(Destacados.DESTACADO_PRODUCTO5);
							
							 
						}


					}	

				 class MyHandlerDestacados6 implements ClickHandler, KeyUpHandler{

						@Override
						public void onKeyUp(KeyUpEvent event) {
							viewItem();				

						}

						@Override
						public void onClick(ClickEvent event) {
							viewItem();

						}

						private void viewItem() {
							
							//sendBoxImg.setVisible(false);
							comprando.setVisible(false);
							btnNewButton_1.setVisible(true);
							htmlNewHtml.setVisible(false);
							htmlNewHtml2.setVisible(false);
							htmlNewHtml3.setVisible(false);
							htmlNewHtml4.setVisible(false);
							htmlNewHtml5.setVisible(false);
							htmlNewHtml6.setVisible(false);
							htmlNewHtml7.setVisible(false);
							p1.setVisible(false);


							mostrarItem(Destacados.DESTACADO_PRODUCTO6);
							
							 
						}


					}

				 class MyHandlerDestacados7 implements ClickHandler, KeyUpHandler{

						@Override
						public void onKeyUp(KeyUpEvent event) {
							viewItem();				

						}

						@Override
						public void onClick(ClickEvent event) {
							viewItem();

						}

						private void viewItem() {
							
							//sendBoxImg.setVisible(false);
							comprando.setVisible(false);
							btnNewButton_1.setVisible(true);
							htmlNewHtml.setVisible(false);
							htmlNewHtml2.setVisible(false);
							htmlNewHtml3.setVisible(false);
							htmlNewHtml4.setVisible(false);
							htmlNewHtml5.setVisible(false);
							htmlNewHtml6.setVisible(false);
							htmlNewHtml7.setVisible(false);
							p1.setVisible(false);
				
							mostrarItem(Destacados.DESTACADO_PRODUCTO7);
							
							 
						}


					}
				 class MyHandlerDestacados8 implements ClickHandler, KeyUpHandler{

						@Override
						public void onKeyUp(KeyUpEvent event) {
							viewItem();				

						}

						@Override
						public void onClick(ClickEvent event) {
							viewItem();

						}

						private void viewItem() {
							
							//sendBoxImg.setVisible(false);
							comprando.setVisible(false);
							btnNewButton_1.setVisible(true);
							htmlNewHtml.setVisible(false);
							htmlNewHtml2.setVisible(false);
							htmlNewHtml3.setVisible(false);
							htmlNewHtml4.setVisible(false);
							htmlNewHtml5.setVisible(false);
							htmlNewHtml6.setVisible(false);
							htmlNewHtml7.setVisible(false);
							p1.setVisible(false);
			

							mostrarItem(Destacados.DESTACADO_PRODUCTO8);
							
							 
						}


					}	
				 class MyHandlerDestacados9 implements ClickHandler, KeyUpHandler{

						@Override
						public void onKeyUp(KeyUpEvent event) {
							viewItem();				

						}

						@Override
						public void onClick(ClickEvent event) {
							viewItem();

						}

						private void viewItem() {
							
							//sendBoxImg.setVisible(false);
							comprando.setVisible(false);
							btnNewButton_1.setVisible(true);
							htmlNewHtml.setVisible(false);
							htmlNewHtml2.setVisible(false);
							htmlNewHtml3.setVisible(false);
							htmlNewHtml4.setVisible(false);
							htmlNewHtml5.setVisible(false);
							htmlNewHtml6.setVisible(false);
							htmlNewHtml7.setVisible(false);
							p1.setVisible(false);

							mostrarItem(Destacados.DESTACADO_PRODUCTO9);
							
							 
						}


					}


		MyHandlerComprar handlerComprar = new MyHandlerComprar();	
		btnComprar.addClickHandler(handlerComprar);
				 
		MyHandlerCombo	handlerCombo = new MyHandlerCombo();
		comboBox_1.addChangeHandler(handlerCombo);
				 
		MyHandlerDestacados destacado1Handler= new MyHandlerDestacados();	 
		destacado1.addClickHandler(destacado1Handler);	

		MyHandlerDestacados2 destacado2Handler= new MyHandlerDestacados2();
		destacado2.addClickHandler(destacado2Handler);

		MyHandlerDestacados3 destacado3Handler= new MyHandlerDestacados3();
		destacado3.addClickHandler(destacado3Handler);

		MyHandlerDestacados4 destacado4Handler= new MyHandlerDestacados4();
		destacado4.addClickHandler(destacado4Handler);

		MyHandlerDestacados5 destacado5Handler= new MyHandlerDestacados5();
		destacado5.addClickHandler(destacado5Handler);

		MyHandlerDestacados6 destacado6Handler= new MyHandlerDestacados6();
		destacado6.addClickHandler(destacado6Handler);

		MyHandlerDestacados7 destacado7Handler= new MyHandlerDestacados7();
		destacado7.addClickHandler(destacado7Handler);

		MyHandlerDestacados8 destacado8Handler= new MyHandlerDestacados8();
		destacado8.addClickHandler(destacado8Handler);

		MyHandlerDestacados9 destacado9Handler= new MyHandlerDestacados9();
		destacado9.addClickHandler(destacado9Handler);

		//Login en SendBox.		 
		MyHandler3 handlerLogin =new MyHandler3();
		btnNewButton_5.addClickHandler(handlerLogin);

		//Lanza evento para registrar nuevo usuario en el sistema.
		MyHandler handlerPegar = new MyHandler();
		confirmar.addClickHandler(handlerPegar);

		//Limpia registros de ingreso
		MyHandler1 handlerLimpiarRegistro = new MyHandler1();
		cancelar.addClickHandler(handlerLimpiarRegistro);

		MyHandler2 handler2 = new MyHandler2();
		btnNewButton.addClickHandler(handler2);
		btnNewButton.addKeyUpHandler(handler2);
		txtbxIpod.addKeyUpHandler(handler2);
		
		//Mata Cookies
		MyHandlerCookie killingCookies = new MyHandlerCookie();
		btnNewButton_2.addClickHandler(killingCookies);

		//Define handler to manage the click event on the product list
		MyHandlerProducto1 p1 = new MyHandlerProducto1();
		htmlNewHtml.addClickHandler(p1);

		MyHandlerProducto2 p2 = new MyHandlerProducto2();
		htmlNewHtml2.addClickHandler(p2);

		MyHandlerProducto3 p3 = new MyHandlerProducto3();
		htmlNewHtml3.addClickHandler(p3);

		MyHandlerProducto4 p4 = new MyHandlerProducto4();
		htmlNewHtml4.addClickHandler(p4);

		MyHandlerProducto5 p5 = new MyHandlerProducto5();
		htmlNewHtml5.addClickHandler(p5);

		MyHandlerProducto6 p6 = new MyHandlerProducto6();
		htmlNewHtml6.addClickHandler(p6);

		MyHandlerProducto7 p7 = new MyHandlerProducto7();
		htmlNewHtml7.addClickHandler(p7);


	}

	
class MyHandlerComprar implements ClickHandler, KeyUpHandler {
		
		/**
		 * Fired when the user clicks on the sendButton.
		 */
		public void onClick(ClickEvent event) {
			comprar();
			
		}

		/**
		 * Fired when the user types in the nameField.
		 */
		public void onKeyUp(KeyUpEvent event) {
			comprar();
		}

		/**
		 * Send the name from the nameField to the server and wait for a response.
		 */
		private void comprar(){
		
			String username =Cookies.getCookie("13051983ntmp");
			String userpass =Cookies.getCookie("13051983ntmppasw");
			String prod =Cookies.getCookie("13051983prodactual");
			String shipping =Cookies.getCookie("shipping");

			
			System.out.println(username);
			System.out.println(userpass);
			System.out.println(prod);
			System.out.println(shipping);

			

			//username passqord id_producto // shipping
			comprarService.comprarProducto(username, userpass, prod,
					shipping, new AsyncCallback<String>() {

				@Override
				public void onFailure(Throwable caught) {
					//Window.alert("Error al comprar, segurmente se vencio la cookie, oprime F5.");
					//RootPanel.get("comprando").clear();	
					Window.Location.reload();
				}

				@Override
				public void onSuccess(String result) {	 
					//Window.alert(result);
					
					DialogSendBox dialogo = new DialogSendBox("Gracias por comprar en send-box.com",result);
					dialogo.center();
					dialogo.show();
					
					
					
				//	RootPanel.get("comprando").clear();	
					//Window.Location.reload();

	 
					 
				}

			});
			
			
			
		
		}
		
	}
	
	

	public void mostrarItem(String producto){
		sendBoxImg.setVisible(false);
		java.util.Date expires = new java.util.Date(System.currentTimeMillis() + DURATION_QUERY);
		Cookies.setCookie("13051983prodactual", producto, expires);
		
		
		 greetingService.greetServer(producto,
					new AsyncCallback<String>() {
						public void onFailure(Throwable caught) {
							//TODO
						}

						public void onSuccess(String result) {
							sendBoxImg.setVisible(false);
							htmlNewHtml2.setHTML(result);
							htmlNewHtml2.setVisible(true);
							RootPanel.get("botonComprar").add(p1);
							p1.setStyleName("btn btn-danger");
							p1.setVisible(true);

						p1.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {

								String prodActual=Cookies.getCookie("13051983prodactual");
								
								//validar aca que exita cookie
							
							if (Cookies.getCookie("13051983ntmp")!=null){
								if(Cookies.getCookie("13051983comprarnombre")!=null && Cookies.getCookie("13051983comprardir")!=null && Cookies.getCookie("13051983ciudaddepto")!=null){
									nom = Cookies.getCookie("13051983comprarnombre");
									dir = Cookies.getCookie("13051983comprardir");
									ciuyDepto=Cookies.getCookie("13051983ciudaddepto");
								}
								else{
									findClient();
																	
								}

							greetingService.precio(prodActual, "", new AsyncCallback<String[]>() {

							@Override
							public void onFailure(Throwable caught) {
								p1.setVisible(false);
								comboBox_1.setVisible(false);	
							}

							@Override
							public void onSuccess(String[] result) {
								sendBoxImg.setVisible(false);

								p1.setVisible(false);
								comboBox_1.setItemSelected(0, true);
								comboBox_1.setVisible(true);
								final long DURATION = 180000; 

								java.util.Date expires = new java.util.Date(System.currentTimeMillis() + DURATION);
								Cookies.setCookie("13051983valor", result[0], expires);
								Cookies.setCookie("13051983moneda", result[1], expires);

								htmlNewHtml.setVisible(false);
								htmlNewHtml2.setVisible(false);
								htmlNewHtml3.setVisible(false);
								htmlNewHtml4.setVisible(false);
								htmlNewHtml5.setVisible(false);
								htmlNewHtml6.setVisible(false);
								htmlNewHtml7.setVisible(false);
								
								datos1.setHTML("<div><img src="+result[2]+ "align=\"left\" class=\"img-rounded\"></div><div><br><strong>Descripcion del producto: </strong><br>" +result[3] + "<br> " + result[1] +  " "+result[0] + ", envio no incluido.</p> " 
										+ "Cantidad : 1 <br>" +"</div>");	
								datos2.setHTML("<div><br><strong>Datos de envio:</strong><br>" +nom +"<br>"+dir + ", "+ciuyDepto + "</div>");
								
								datos1.setVisible(true);
								datos2.setVisible(true);
								
								label.setVisible(true);									

							}	 


							});

							}else{
								Window.alert("Para comprar, debes estar registrado en send-box.com, gracias");

							}	

							}
						});


							}	

					});
	
	}
	
	
	/**Busca los datos de un usuario y los guarda*/
	public void findClient() {
		String username =Cookies.getCookie("13051983ntmp");

			comprarService.miCuenta(username, new AsyncCallback<String[]>() {

			@Override
			public void onFailure(Throwable caught) {
				//TODO
				
			}

			@Override
			public void onSuccess(String[] result) {
			
				 final long DURATION = 180000; 

					java.util.Date expires = new java.util.Date(System.currentTimeMillis() + DURATION);
					Cookies.setCookie("13051983comprarnombre", result[7] + " " + result[8], expires);
					Cookies.setCookie("13051983comprardir", result[2], expires);
					Cookies.setCookie("13051983ciudaddepto", result[5]+", "+result[6], expires);

					
					nom = Cookies.getCookie("13051983comprarnombre");
					dir = Cookies.getCookie("13051983comprardir");
					ciuyDepto =  Cookies.getCookie("13051983ciudaddepto");
			
			}

		});

	}
	
	
	
	
//Navegacion.
	
	@Override
	public void onValueChange(ValueChangeEvent event) {
		changePage(History.getToken());
	}

	public void changePage(String token) {
		//Mi Cuenta con cookie valida 
		if (History.getToken().equals("miCuenta") &&(Cookies.getCookie("13051983ntmp") != null)){
			label.setVisible(false);
			label.setText("");
			btnComprar.setVisible(false);
			comboBox_1.setVisible(false);
			datos1.setVisible(false);
			datos2.setVisible(false);
	    	htmlDestacado.setVisible(false);
	    	home.setVisible(true);  
	    	p1.setVisible(false);


			htmlNewHtml.setVisible(false);
			htmlNewHtml2.setVisible(false);
			htmlNewHtml3.setVisible(false);
			htmlNewHtml4.setVisible(false);
			htmlNewHtml5.setVisible(false);
			htmlNewHtml6.setVisible(false);
			htmlNewHtml7.setVisible(false);
			
	    	RootPanel.get("userReg").setVisible(false);
			RootPanel.get("passReg").setVisible(false);
			RootPanel.get("nombreReg").setVisible(false);
			RootPanel.get("apellidoReg").setVisible(false);
			RootPanel.get("cedulaReg").setVisible(false);
			RootPanel.get("departamentoReg").setVisible(false);
			RootPanel.get("ciudadReg").setVisible(false);
			RootPanel.get("direccionReg").setVisible(false);
			RootPanel.get("telefonoReg").setVisible(false);

			confirmar.setVisible(false);
			cancelar.setVisible(false);

			panelDeControl=new MiCuenta();
			RootPanel.get("panelDeControl").add(panelDeControl);
	    	sendBoxImg.setVisible(false);
			panelDeControl.setVisible(true);

			//mi cuenta con token vencido
	    }else if (History.getToken().equals("miCuenta") &&	(Cookies.getCookie("13051983ntmp") == null)){	

	    	Window.Location.reload();

	     //Registro
	    } else if (History.getToken().equals("registro") && (Cookies.getCookie("13051983ntmp") == null)) {
	    	label.setVisible(false);
			label.setText("");
	    	btnComprar.setVisible(false);
	    	htmlDestacado.setVisible(false);
	    	comboBox_1.setVisible(false);
	    	datos1.setVisible(false);
			datos2.setVisible(false);
	    	p1.setVisible(false);


	    	panelDeControl.setVisible(false);
	    	errorLabel.setText("");
	    	errorLabel.setVisible(true);
	    	htmlRegistration.setVisible(true);
	    	htmlRegistration.setHTML("<strong>Registrate en send-box.com</strong> le brindamos la facilidad de que Ud pueda comprar desde internet, lo que quiera y nosotros <br>llevamos el paquete a la puerta de su casa, un servicio unico en Uruguay.");
	 		RootPanel.get("htmlRegistro").add(htmlRegistration);
	    	txtbxIpod.setVisible(false);
	    	btnNewButton.setVisible(false);
	    	sendBoxImg.setVisible(false);
	    	comboBox.setVisible(false);
	    	btnNewButton_1.setVisible(false);
	    	htmlNewHtml.setVisible(false);
			htmlNewHtml2.setVisible(false);
			htmlNewHtml3.setVisible(false);
			htmlNewHtml4.setVisible(false);
			htmlNewHtml5.setVisible(false);
			htmlNewHtml6.setVisible(false);
			htmlNewHtml7.setVisible(false);

			RootPanel.get("userReg").setVisible(true);
			RootPanel.get("passReg").setVisible(true);
			RootPanel.get("nombreReg").setVisible(true);
			RootPanel.get("apellidoReg").setVisible(true);
			RootPanel.get("cedulaReg").setVisible(true);
			RootPanel.get("departamentoReg").setVisible(true);
			RootPanel.get("ciudadReg").setVisible(true);
			RootPanel.get("direccionReg").setVisible(true);
			RootPanel.get("telefonoReg").setVisible(true);

			confirmar.setVisible(true);
			confirmar.setEnabled(false);
			cancelar.setVisible(true);

			Window.alert("Son solo unos pocos dias y" +
					 " estaremos ya opertativos, gracias, pudedes seguir las ultimas novedades en twitter. send-box team.");	

		} 


	  //Home page default
	    else {
	    	label.setVisible(false);
			label.setText("");
	    	btnComprar.setVisible(false);
			comboBox_1.setVisible(false);
			datos1.setVisible(false);
			datos2.setVisible(false);
	    	htmlDestacado.setVisible(false);
	    	home.setVisible(false);
	    	p1.setVisible(false);

	    	panelDeControl.setVisible(false);

	    	 errorLabel.setVisible(false);
	    	 htmlRegistration.setVisible(false);
	    	    txtbxIpod.setVisible(true);

	    	    sendBoxImg.setVisible(true);	
		    	btnNewButton.setVisible(true);
		    	comboBox.setVisible(true);

	    	    htmlNewHtml.setHTML("");
	    	    htmlNewHtml2.setHTML("");
				htmlNewHtml3.setHTML("");
				htmlNewHtml4.setHTML("");
				htmlNewHtml5.setHTML("");
				htmlNewHtml6.setHTML("");
				htmlNewHtml7.setHTML("");

	    		RootPanel.get("userReg").setVisible(false);
				RootPanel.get("passReg").setVisible(false);
				RootPanel.get("nombreReg").setVisible(false);
				RootPanel.get("apellidoReg").setVisible(false);
				RootPanel.get("cedulaReg").setVisible(false);
				RootPanel.get("departamentoReg").setVisible(false);
				RootPanel.get("ciudadReg").setVisible(false);
				RootPanel.get("direccionReg").setVisible(false);
				RootPanel.get("telefonoReg").setVisible(false);

				confirmar.setVisible(false);
				cancelar.setVisible(false);

	    }
	}
}
