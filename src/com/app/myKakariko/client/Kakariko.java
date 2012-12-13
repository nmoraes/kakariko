package com.app.myKakariko.client;


import com.app.myKakariko.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
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

	private TextBox txtbxIpod;
	private Button btnNewButton;
	private HTML htmlNewHtml= new HTML("", true);
	private HTML htmlNewHtml2= new HTML("", true);
	private HTML htmlNewHtml3= new HTML("", true);
	private HTML htmlNewHtml4= new HTML("", true);
	private HTML htmlNewHtml5= new HTML("", true);
	private HTML htmlNewHtml6= new HTML("", true);
	private HTML htmlNewHtml7= new HTML("", true);
	
	private HTML htmlRegistration= new HTML("", true);
	
	private HTML destacado1= new HTML(Destacados.DESTACADO_UNO, true);
	private HTML destacado2= new HTML(Destacados.DESTACADO_DOS, true);
	private HTML destacado3= new HTML(Destacados.DESTACADO_TRES, true);
	private HTML sendBoxImg= new HTML(Destacados.SEND_BOX_PAY, true);

		
	private String producto1;
	private String producto2;	
	private String producto3;
	private String producto4;
	private String producto5;
	private String producto6;
	private String producto7;

	private Button btnNewButton_1;
	//private HTML htmlInicio;
	private ListBox comboBox;
	
	private Button btnNewButton_2; //iniciarSesion
	//private HTML htmliniciarSesion= new HTML(IniciarSesionHTML.INICIAR_SESION, true);
	private TextBox userName;
	private PasswordTextBox pass;
	private Button btnNewButton_5;
	
	private Hyperlink btnNewButton_3 ;
	
	//Botones de registracion
	private Button confirmar=new Button("enviar");
	private Hyperlink cancelar;
	
	private Hyperlink miCuenta;
	private Button salir= new Button("salir");
	
	final Label errorLabel = new Label();
	 private Label label=new Label();
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
	 	
  
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
        confirmar.setStyleName("btn btn-primary");
		RootPanel.get("confirmar").add(confirmar);
		
		miCuenta= new Hyperlink("mi cuenta","home"); //cambiar el token !!!
		miCuenta.setVisible(false);
		miCuenta.setStyleName("btn btn-link");
		RootPanel.get("miCuenta").add(miCuenta);

		

        cancelar = new Hyperlink("cancelar","home");
        cancelar.setVisible(false);
        cancelar.setStyleName("btn");
		RootPanel.get("cancelar").add(cancelar);
		
		
		

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		//RootPanel.get("sendButtonContainer").add(sendButton, 238, 200);
		RootPanel.get("errorLabelContainer").add(errorLabel);
		
		
		btnNewButton = new Button("New button");
		btnNewButton.setText("buscar");
		// We can add style names to widgets
		//sendButton.addStyleName("sendButton");
		btnNewButton.setStyleName("btn btn-success");
		//rootPanel.add(btnNewButton, 20, 0);
		btnNewButton.setSize("64px", "30px");
		RootPanel.get("btnNewButton").add(btnNewButton);

				
		txtbxIpod = new TextBox();
		//rootPanel.add(txtbxIpod, 20, 32);
		txtbxIpod.setSize("436px", "20px");
		
		RootPanel.get("txtbxIpod").add(txtbxIpod);
		
		//rootPanel.add(htmlNewHtml, 365, 115);
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
		comboBox.addItem("Celulares y Telefonía");
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
		
		btnNewButton_2 = new Button("regiNONONONOstrarse");
		rootPanel.add(btnNewButton_2, 20, 185);
		RootPanel.get("iniciar").add(btnNewButton_2);
		btnNewButton_2.setStyleName("btn btn-link");


		btnNewButton_3 = new Hyperlink("registrarse","registro");
		rootPanel.add(btnNewButton_3, 109, 185);
		RootPanel.get("registro").add(btnNewButton_3);
		btnNewButton_3.setStyleName("btn btn-link");

		Button btnNewButton_4 = new Button("ayuda");
		rootPanel.add(btnNewButton_4, 198, 185);
		RootPanel.get("ayuda").add(btnNewButton_4);
		btnNewButton_4.setStyleName("btn btn-link");

		RootPanel.get("des1").add(destacado1);
		RootPanel.get("des2").add(destacado2);
		RootPanel.get("des3").add(destacado3);
		RootPanel.get("pay").add(sendBoxImg);
			
		
		btnNewButton_5 = new Button("entrar");
		RootPanel.get("login").add(btnNewButton_5);
		btnNewButton_5.setSize("64px", "30px");
		btnNewButton_5.setStyleName("btn btn-primary");
			
        
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
				//htmlInicio.setVisible(false);

				htmlNewHtml.setHTML("");
				htmlNewHtml2.setHTML("");
				htmlNewHtml3.setHTML("");
				htmlNewHtml4.setHTML("");
				htmlNewHtml5.setHTML("");
				htmlNewHtml6.setHTML("");
				htmlNewHtml7.setHTML("");
				btnNewButton_1.setVisible(false);
				sendBoxImg.setVisible(true);

			}
		});
		
		

		class MyHandlerProducto1 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod1");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod1");

			}
			
			
		}
		
		class MyHandlerProducto2 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				//viewItem();
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				//viewItem();

			}
			
			
			
			
			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void viewItem() {
			/*
				 greetingService.viewItem(producto2,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("API say's ...... Error");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
							
	
								
																
								}
								
								

								
								
								
							
							
						});*/
			}
			
			
			
			
			
		}
		
		class MyHandlerProducto3 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 3");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 3");

			}
			
			
		}
		
		class MyHandlerProducto4 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 4");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 4");

			}
			
			
		}
		
		class MyHandlerProducto5 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				
		
				
				
				
				
			}

			@Override
			public void onClick(ClickEvent event) {
	
			}
			
			
		}
		
		
		class MyHandlerProducto6 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 6");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 6");

			}
			
			
		}
		
		class MyHandlerProducto7 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 7");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 7");

			}
			
			
		}
		
		
		
		

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				confirmar.setEnabled(false);
				//cancelar.setEnabled(false);
				sendNameToServer();
				System.out.println("hola");
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
					//cancelar.setEnabled(true);
					return;
				}
				
				if (!FieldVerifier.isValidPass(password)) {
					errorLabel.setText("El password no puede ser vacio, y debe tener al menos 5 caracteres");
					DOM.getElementById("passReg").setPropertyString("value", "");
					confirmar.setEnabled(true);
				//	cancelar.setEnabled(true);
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
						
						String consulta= txtbxIpod.getText();
						greetingService.query(consulta, new AsyncCallback<String[]>(){

							
							public void onFailure(Throwable caught) {

								
							}

							
							public void onSuccess(String[] result) {
							//	htmlInicio.setVisible(false);
								htmlNewHtml.setHTML(result[0]);
								producto1= result[0].substring(4, 18);
								producto1=producto1.trim();
								
								producto2= result[1].substring(4, 18);
								producto2=producto2.trim();
								System.out.println("hola :" +producto2);
								
								producto3= result[2].substring(4, 18);
								producto3=producto3.trim();
								
								producto4= result[3].substring(4, 18);
								producto4=producto4.trim();
								
								producto5= result[4].substring(4, 18);
								producto5=producto5.trim();
								
								producto6= result[5].substring(4, 18);
								producto6=producto6.trim();
								
								producto7= result[6].substring(4, 18);
								producto7=producto7.trim();
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
								
							
								
							//	TextBox userName=TextBox.wrap(DOM.getElementById("nico"));
								//System.out.println("MIERCOLES: "+userName.getText());
								
								
								
								//prueba de criptografia
								/*
								String pass ="nicolasmoraes";
								// Hash a password for the first time
								//String hashed = BCrypt.hashpw(pass, BCrypt.gensalt());

								// gensalt's log_rounds parameter determines the complexity
								// the work factor is 2**log_rounds, and the default is 10
								String hashed = BCrypt.hashpw(pass, BCrypt.gensalt(12));

								System.out.println("hash: "+hashed );
								
								// Check that an unencrypted password matches one that has
								// previously been hashed
								if (BCrypt.checkpw("nicolasmoraes", hashed))
									System.out.println("It matches");
								else
									System.out.println("It does not match");
								
							*/
							
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
						String passs= pass.getText();
						
						greetingService.login(username,passs, new AsyncCallback<Boolean>(){

							
							public void onFailure(Throwable caught) {

								Window.alert("Error al loguearse");
											
								
							}

							
							
							
							public void onSuccess(Boolean result) {				
								
								System.out.println("Welcome Back");
									

								userName.setVisible(false);
								btnNewButton_3.setVisible(false);
								pass.setVisible(false);
								miCuenta.setVisible(true);
								btnNewButton_5.setVisible(false);
								
								Window.alert("Welcome back");
								
								//btnNewButton_2.setVisible(false);
								
								//htmlInicio.setHTML(result);
								//RootPanel.get("htmlInicio").add(htmlInicio);

								
								
								
							}
							
							
						});
						
					}
					
					
				}
				 						 
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

//Navegacion.

	@Override
	public void onValueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub
		changePage(History.getToken());
	}
	
	public void changePage(String token) {
	    if(History.getToken().equals("aboutUs")) {
	    	
	        label.setText("cosas que pasan lalalala");
	    } else if (History.getToken().equals("details")) {
	        label.setText("details kakakakakakka");
	    
	    
	     //Registro
	    } else if (History.getToken().equals("registro")) {
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
	    	
	    	
			RootPanel.get("des1").setVisible(false);
			RootPanel.get("des2").setVisible(false);
			RootPanel.get("des3").setVisible(false);
    		
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
			cancelar.setVisible(true);
			
		
	    	/*
	    	userReg=TextBox.wrap(DOM.getElementById("userReg"));
	    	passReg=PasswordTextBox.wrap(DOM.getElementById("passReg"));	    	 

	    	
	    	*/
			
		} 
	    
	  //Home page
     else if (History.getToken().equals("home")) {
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
			
    	   
    		RootPanel.get("des1").setVisible(true);
			RootPanel.get("des2").setVisible(true);
			RootPanel.get("des3").setVisible(true);
			
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
	  //Home page default
	    else {
	    	txtbxIpod.setVisible(true);
	    	btnNewButton.setVisible(true);
	    	comboBox.setVisible(true);
	    	 htmlRegistration.setVisible(false);


	    	RootPanel.get("userReg").setVisible(false);
			RootPanel.get("passReg").setVisible(false);
			RootPanel.get("nombreReg").setVisible(false);
			RootPanel.get("apellidoReg").setVisible(false);
			RootPanel.get("cedulaReg").setVisible(false);
			RootPanel.get("departamentoReg").setVisible(false);
			RootPanel.get("ciudadReg").setVisible(false);
			RootPanel.get("direccionReg").setVisible(false);
			RootPanel.get("telefonoReg").setVisible(false);
	    	sendBoxImg.setVisible(true);
	    	RootPanel.get("des1").setVisible(true);
			RootPanel.get("des2").setVisible(true);
			RootPanel.get("des3").setVisible(true);
	
	    }
	}
	
	
	
}
