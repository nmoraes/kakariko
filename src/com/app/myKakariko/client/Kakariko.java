package com.app.myKakariko.client;


import com.app.myKakariko.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.ListBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Kakariko implements EntryPoint {
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
	private HTML htmlNewHtml= new HTML("", true);
	private HTML htmlNewHtml2= new HTML("", true);
	private HTML htmlNewHtml3= new HTML("", true);
	private HTML htmlNewHtml4= new HTML("", true);
	private HTML htmlNewHtml5= new HTML("", true);
	private HTML htmlNewHtml6= new HTML("", true);
	private HTML htmlNewHtml7= new HTML("", true);
	
	private HTML destacado1= new HTML(Destacados.DESTACADO_UNO, true);
	private HTML destacado2= new HTML(Destacados.DESTACADO_DOS, true);
	private HTML destacado3= new HTML(Destacados.DESTACADO_TRES, true);

	
	
	private String producto1;
	private String producto2;	
	private String producto3;
	private String producto4;
	private String producto5;
	private String producto6;
	private String producto7;

	private Button btnNewButton_1;
	private HTML htmlInicio;
	private ListBox comboBox;
	
	private Button btnNewButton_5;
	
	private Button btnNewButton_2; //iniciarSesion
	//private HTML htmliniciarSesion= new HTML(IniciarSesionHTML.INICIAR_SESION, true);

	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		final Label errorLabel = new Label();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		//RootPanel.get("sendButtonContainer").add(sendButton, 238, 200);
		RootPanel.get("errorLabelContainer").add(errorLabel);
		
		
		Button btnNewButton = new Button("New button");
		btnNewButton.setText("buscar");
		// We can add style names to widgets
		//sendButton.addStyleName("sendButton");
		btnNewButton.setStyleName("btn btn-success");
		rootPanel.add(btnNewButton, 20, 0);
		btnNewButton.setSize("64px", "30px");
		RootPanel.get("btnNewButton").add(btnNewButton);

				
		txtbxIpod = new TextBox();
		rootPanel.add(txtbxIpod, 20, 32);
		txtbxIpod.setSize("436px", "20px");
		
		RootPanel.get("txtbxIpod").add(txtbxIpod);
		
		rootPanel.add(htmlNewHtml, 365, 115);
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
		
		htmlInicio = new HTML("", true);
		rootPanel.add(htmlInicio, 365, 148);
		
		comboBox = new ListBox();
		rootPanel.add(comboBox, 20, 70);
		rootPanel.setTitle("cateogorias");
		comboBox.setSize("173px", "30px");
		comboBox.addItem("Todas las categorias");
		comboBox.addItem("Animales y Mascotas");
		comboBox.addItem("Arte y Antigüedades");
		comboBox.addItem("Cámaras y Accesorios");
		comboBox.addItem("Celulares y Telefonía");
		comboBox.addItem("Coleccionables");
		comboBox.addItem("Computación");
		comboBox.addItem("Consolas y Videojuegos");
		comboBox.addItem("Deportes y Fitness");
		comboBox.addItem("Electrodomésticos y Aires Ac.");
		comboBox.addItem("Electrónica, Audio y Video");
		comboBox.addItem("Hogar, Muebles y Jardín");
		comboBox.addItem("Industrias y Oficinas");
		
		comboBox.addItem("Instrumentos Musicales");
		comboBox.addItem("Juegos y Juguetes");
		
		comboBox.addItem("Música, Libros y Películas");
		comboBox.addItem("Ropa, Joyas y Relojes");
		comboBox.addItem("Industrias y Oficinas");
		
		
		
		RootPanel.get("combo").add(comboBox);
		
		btnNewButton_2 = new Button("iniciar sesion");
		rootPanel.add(btnNewButton_2, 20, 185);
		RootPanel.get("iniciar").add(btnNewButton_2);
		btnNewButton_2.setStyleName("btn btn-link");


		Button btnNewButton_3 = new Button("registrarse");
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
		
		btnNewButton_5 = new Button("pegar!");
		rootPanel.add(btnNewButton_5, 382, 244);
		btnNewButton_5.setVisible(false);

		

		
		
		

		
		
		btnNewButton_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				htmlInicio.setVisible(false);
				htmlNewHtml.setHTML("");
				htmlNewHtml2.setHTML("");
				htmlNewHtml3.setHTML("");
				htmlNewHtml4.setHTML("");
				htmlNewHtml5.setHTML("");
				htmlNewHtml6.setHTML("");
				htmlNewHtml7.setHTML("");
				btnNewButton_1.setVisible(false);
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
				sendNameToServer();
				System.out.println("hola");
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				//if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
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
				String textToServer = "basura";
				//String textToServer = textBox.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				//sendButton.setEnabled(false);
			//	textToServerLabel.setText(textToServer);
				//serverResponseLabel.setText("");
				
				
				String username ="nmoraes";
				String password="1234"; 
				String email="nicp@nico"; 
				String nombre="nicolas";
				String apellido="moraes"; 
				String cedula="122221"; 
				String departamento="montevideo"; 
				String ciudad="montevideo"; 
				String direccion="ramallo 1111"; 
				String barrio="malvin"; 
				String telefono="5061074";
				
				
				
				greetingService.nuevoUsuario(username, password, email, nombre,
						apellido, cedula, departamento, ciudad, direccion, barrio, telefono,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
							
								System.out.println("error al ingresar");
							}

							public void onSuccess(String result) {
						
								System.out.println("exito");

								
						
								
							}
						});
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
/*
								// Show the RPC error message to the user
								dialogBox2
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel2
										.addStyleName("serverResponseLabelError");
								serverResponseLabel2.setHTML(SERVER_ERROR);
								dialogBox2.center();
								closeButton2.setFocus(true); */
								
							}

							
							public void onSuccess(String[] result) {
								htmlInicio.setVisible(false);
								
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
								
								TextBox userName=TextBox.wrap(DOM.getElementById("nico"));
								System.out.println("MIERCOLES: "+userName.getText());
								
								
								
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
						// TODO Auto-generated method stub
						//login();
						htmlNewHtml.setVisible(false);
						htmlNewHtml2.setVisible(false);
						htmlNewHtml3.setVisible(false);
						htmlNewHtml4.setVisible(false);
						htmlNewHtml5.setVisible(false);
						htmlNewHtml6.setVisible(false);
						htmlNewHtml7.setVisible(false);


						btnNewButton_1.setVisible(true);
						htmlInicio.setVisible(true);
						htmlInicio.setHTML(IniciarSesionHTML.INICIAR_SESION);
						RootPanel.get("htmlInicio").add(htmlInicio);
					}

					@Override
					public void onClick(ClickEvent event) {
						htmlNewHtml.setVisible(false);
						htmlNewHtml2.setVisible(false);
						htmlNewHtml3.setVisible(false);
						htmlNewHtml4.setVisible(false);
						htmlNewHtml5.setVisible(false);
						htmlNewHtml6.setVisible(false);
						htmlNewHtml7.setVisible(false);
						btnNewButton_1.setVisible(true);
						htmlInicio.setVisible(true);
						htmlInicio.setHTML(IniciarSesionHTML.INICIAR_SESION);
						RootPanel.get("htmlInicio").add(htmlInicio);
					}
				
					
					
					
					private void login(){
						//gps garmin
						String consulta= "";
						greetingService.inicio(consulta, new AsyncCallback<String>(){

							
							public void onFailure(Throwable caught) {

								// Show the RPC error message to the user
							/*	dialogBox2
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel2
										.addStyleName("serverResponseLabelError");
								serverResponseLabel2.setHTML(SERVER_ERROR);
								dialogBox2.center();
								closeButton2.setFocus(true);*/
								
							}

							
							public void onSuccess(String result) {				
								htmlInicio.setHTML(result);
								RootPanel.get("htmlInicio").add(htmlInicio);

							}
							
							
						});
						
					}
					
					
				}
				
				
				 
		MyHandler3 handlerLogin =new MyHandler3();		 
		btnNewButton_2.addClickHandler(handlerLogin);
		
		MyHandler handlerPegar = new MyHandler();
		btnNewButton_5.addClickHandler(handlerPegar);
		//btnNewButton.addClickHandler(handler3);		
				
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
}
