package com.app.myKakariko.client;


import java.awt.Dialog;

import com.app.myKakariko.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
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

	
	private static String userlog=null;
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
	
	private Button p1=new Button("comprar");;
	private Button p2=new Button("comprar");;
	private Button p3=new Button("comprar");;
	private Button p4=new Button("comprar");;
	private Button p5=new Button("comprar");;
	private Button p6=new Button("comprar");;
	private Button p7=new Button("comprar");;
	
	
	

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
	 private Label label=new Label();
	 	
	private Comprar comprando; //=new Comprar(null,null,null,null);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
	 	
		
		p1.setVisible(false);
		p2.setVisible(false);
		p3.setVisible(false);
		p4.setVisible(false);
		p5.setVisible(false);
		p6.setVisible(false);
		p7.setVisible(false);


		RootPanel.get("htmlDestacado").add(htmlDestacado);
		
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		//RootPanel.get("sendButtonContainer").add(sendButton, 238, 200);
		RootPanel.get("errorLabelContainer").add(errorLabel);
		
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
					
					System.out.println("NO hay cookie");

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
		



		Button btnNewButton_4 = new Button("ayuda");
		rootPanel.add(btnNewButton_4, 198, 185);
		RootPanel.get("ayuda").add(btnNewButton_4);
		btnNewButton_4.setStyleName("btn btn-link");

		
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
				RootPanel.get("comprando").clear();
				htmlDestacado.setVisible(false);
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
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			}
		});
		
		
		// Handler para eliminacion de cookies.
				class MyHandlerCookie implements ClickHandler, KeyUpHandler {

					@Override
					public void onClick(ClickEvent event) {
						// rootPanel.setVisible(false);
						Cookies.removeCookie("13051983ntmp");
						Window.Location.reload();
						// Window.Location.assign("http://www.send-box.com/#home");

					}

					@Override
					public void onKeyUp(KeyUpEvent event) {
						Cookies.removeCookie("13051983ntmp");
						//changePage(History.getToken());
						// Window.Location.assign("http://www.send-box.com/#home");
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
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
					
				 greetingService.greetServer(producto1,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								//TODO
							}

							public void onSuccess(String result) {
								htmlNewHtml2.setHTML(result);
								htmlNewHtml2.setVisible(true);
								RootPanel.get("botonComprar").add(p1);
								p1.setStyleName("btn btn-danger");
								p1.setVisible(true);
								
								
								
							p1.addClickHandler(new ClickHandler() {
								public void onClick(ClickEvent event) {
									
									//validar aca que exita cookie
							if(Cookies.getCookie("13051983ntmp") != null){			
								
								greetingService.precio(producto1, "", new AsyncCallback<String[]>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									//RootPanel.get("comprando").remove(comprando);
									p1.setVisible(false);
									

								}

								@Override
								public void onSuccess(String[] result) {
									p1.setVisible(false);
									RootPanel.get("comprando").clear();
									htmlNewHtml.setVisible(false);
									htmlNewHtml2.setVisible(false);
									htmlNewHtml3.setVisible(false);
									htmlNewHtml4.setVisible(false);
									htmlNewHtml5.setVisible(false);
									htmlNewHtml6.setVisible(false);
									htmlNewHtml7.setVisible(false);
										System.out.println(result[0]);	
										System.out.println(result[1]);	
										comprando = new Comprar(result[0],result[1],result[2],result[3]);

											comprando.setVisible(true);
											RootPanel.get("comprando").add(comprando);

										
										
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
			
			
		}
		
		class MyHandlerProducto2 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				viewItem();
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				viewItem();

			}
			
			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void viewItem() {
				
				htmlNewHtml.setVisible(false);
				htmlNewHtml2.setVisible(false);
				htmlNewHtml3.setVisible(false);
				htmlNewHtml4.setVisible(false);
				htmlNewHtml5.setVisible(false);
				htmlNewHtml6.setVisible(false);
				htmlNewHtml7.setVisible(false);
				
				p1.setVisible(false);
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			
				 greetingService.greetServer(producto2,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								//TODO							
							}

							public void onSuccess(String result) {
								htmlNewHtml3.setHTML(result);
								htmlNewHtml3.setVisible(true);
								RootPanel.get("botonComprar").add(p2);
								p2.setStyleName("btn btn-danger");
								p2.setVisible(true);

								
								p2.addClickHandler(new ClickHandler() {
									public void onClick(ClickEvent event) {
										
										//validar aca que exita cookie
								if(Cookies.getCookie("13051983ntmp") != null){			
									
									greetingService.precio(producto2, "", new AsyncCallback<String[]>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										//RootPanel.get("comprando").remove(comprando);
										p2.setVisible(false);
										

									}

									@Override
									public void onSuccess(String[] result) {
										p2.setVisible(false);
										RootPanel.get("comprando").clear();
										htmlNewHtml.setVisible(false);
										htmlNewHtml2.setVisible(false);
										htmlNewHtml3.setVisible(false);
										htmlNewHtml4.setVisible(false);
										htmlNewHtml5.setVisible(false);
										htmlNewHtml6.setVisible(false);
										htmlNewHtml7.setVisible(false);
											System.out.println(result[0]);	
											System.out.println(result[1]);	
											comprando = new Comprar(result[0],result[1],result[2],result[3]);

												comprando.setVisible(true);
												RootPanel.get("comprando").add(comprando);

											
											
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
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			
				 greetingService.greetServer(producto3,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								//TODO							
							}

							public void onSuccess(String result) {
								htmlNewHtml4.setHTML(result);
								htmlNewHtml4.setVisible(true);
								RootPanel.get("botonComprar").add(p3);
								p3.setStyleName("btn btn-danger");
								p3.setVisible(true);

								
								p3.addClickHandler(new ClickHandler() {
									public void onClick(ClickEvent event) {
										
										//validar aca que exita cookie
								if(Cookies.getCookie("13051983ntmp") != null){			
									
									greetingService.precio(producto3, "", new AsyncCallback<String[]>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										//RootPanel.get("comprando").remove(comprando);
										p3.setVisible(false);
										

									}

									@Override
									public void onSuccess(String[] result) {
										p3.setVisible(false);
										RootPanel.get("comprando").clear();
										htmlNewHtml.setVisible(false);
										htmlNewHtml2.setVisible(false);
										htmlNewHtml3.setVisible(false);
										htmlNewHtml4.setVisible(false);
										htmlNewHtml5.setVisible(false);
										htmlNewHtml6.setVisible(false);
										htmlNewHtml7.setVisible(false);
											System.out.println(result[0]);	
											System.out.println(result[1]);	
											comprando = new Comprar(result[0],result[1],result[2],result[3]);

												comprando.setVisible(true);
												RootPanel.get("comprando").add(comprando);

											
											
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
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			
				 greetingService.greetServer(producto4,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								//TODO							
							}

							public void onSuccess(String result) {
								htmlNewHtml5.setHTML(result);
								htmlNewHtml5.setVisible(true);
								RootPanel.get("botonComprar").add(p4);
								p4.setStyleName("btn btn-danger");
								p4.setVisible(true);
								
								
								p4.addClickHandler(new ClickHandler() {
									public void onClick(ClickEvent event) {
										
										//validar aca que exita cookie
								if(Cookies.getCookie("13051983ntmp") != null){			
									
									greetingService.precio(producto4, "", new AsyncCallback<String[]>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										//RootPanel.get("comprando").remove(comprando);
										p4.setVisible(false);
										

									}

									@Override
									public void onSuccess(String[] result) {
										p4.setVisible(false);
										RootPanel.get("comprando").clear();
										htmlNewHtml.setVisible(false);
										htmlNewHtml2.setVisible(false);
										htmlNewHtml3.setVisible(false);
										htmlNewHtml4.setVisible(false);
										htmlNewHtml5.setVisible(false);
										htmlNewHtml6.setVisible(false);
										htmlNewHtml7.setVisible(false);
											System.out.println(result[0]);	
											System.out.println(result[1]);	
											comprando = new Comprar(result[0],result[1],result[2],result[3]);

												comprando.setVisible(true);
												RootPanel.get("comprando").add(comprando);

											
											
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
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			
				 greetingService.greetServer(producto5,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								//TODO							
							}

							public void onSuccess(String result) {
								htmlNewHtml6.setHTML(result);
								htmlNewHtml6.setVisible(true);
								RootPanel.get("botonComprar").add(p5);
								p5.setStyleName("btn btn-danger");
								p5.setVisible(true);
								
								p1.addClickHandler(new ClickHandler() {
									public void onClick(ClickEvent event) {
										
										//validar aca que exita cookie
								if(Cookies.getCookie("13051983ntmp") != null){			
									
									greetingService.precio(producto5, "", new AsyncCallback<String[]>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										//RootPanel.get("comprando").remove(comprando);
										p5.setVisible(false);
										

									}

									@Override
									public void onSuccess(String[] result) {
										p5.setVisible(false);
										RootPanel.get("comprando").clear();
										htmlNewHtml.setVisible(false);
										htmlNewHtml2.setVisible(false);
										htmlNewHtml3.setVisible(false);
										htmlNewHtml4.setVisible(false);
										htmlNewHtml5.setVisible(false);
										htmlNewHtml6.setVisible(false);
										htmlNewHtml7.setVisible(false);
											System.out.println(result[0]);	
											System.out.println(result[1]);	
											comprando = new Comprar(result[0],result[1],result[2],result[3]);

												comprando.setVisible(true);
												RootPanel.get("comprando").add(comprando);

											
											
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
			
			
			
			
		}
		
		
		class MyHandlerProducto6 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				viewItem();
			}

			@Override
			public void onClick(ClickEvent event) {
				viewItem() ;
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
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			
				 greetingService.greetServer(producto6,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								//TODO							
							}

							public void onSuccess(String result) {
								htmlNewHtml7.setHTML(result);
								htmlNewHtml7.setVisible(true);
								RootPanel.get("botonComprar").add(p6);
								p6.setStyleName("btn btn-danger");
								p6.setVisible(true);
							
								
								p6.addClickHandler(new ClickHandler() {
									public void onClick(ClickEvent event) {
										
										//validar aca que exita cookie
								if(Cookies.getCookie("13051983ntmp") != null){			
									
									greetingService.precio(producto6, "", new AsyncCallback<String[]>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										//RootPanel.get("comprando").remove(comprando);
										p6.setVisible(false);
										

									}

									@Override
									public void onSuccess(String[] result) {
										p6.setVisible(false);
										RootPanel.get("comprando").clear();
										htmlNewHtml.setVisible(false);
										htmlNewHtml2.setVisible(false);
										htmlNewHtml3.setVisible(false);
										htmlNewHtml4.setVisible(false);
										htmlNewHtml5.setVisible(false);
										htmlNewHtml6.setVisible(false);
										htmlNewHtml7.setVisible(false);
											System.out.println(result[0]);	
											System.out.println(result[1]);	
											comprando = new Comprar(result[0],result[1],result[2],result[3]);

												comprando.setVisible(true);
												RootPanel.get("comprando").add(comprando);

											
											
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
				p2.setVisible(false);
				p3.setVisible(false);
				p4.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			
				 greetingService.greetServer(producto7,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								//TODO							
							}

							public void onSuccess(String result) {
								htmlNewHtml.setHTML(result);
								htmlNewHtml.setVisible(true);
								RootPanel.get("botonComprar").add(p7);
								p7.setStyleName("btn btn-danger");
								p7.setVisible(true);
								
								
								p7.addClickHandler(new ClickHandler() {
									public void onClick(ClickEvent event) {
										
										//validar aca que exita cookie
								if(Cookies.getCookie("13051983ntmp") != null){			
									
									greetingService.precio(producto7, "", new AsyncCallback<String[]>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										//RootPanel.get("comprando").remove(comprando);
										p7.setVisible(false);
										

									}

									@Override
									public void onSuccess(String[] result) {
										p7.setVisible(false);
										RootPanel.get("comprando").clear();
										htmlNewHtml.setVisible(false);
										htmlNewHtml2.setVisible(false);
										htmlNewHtml3.setVisible(false);
										htmlNewHtml4.setVisible(false);
										htmlNewHtml5.setVisible(false);
										htmlNewHtml6.setVisible(false);
										htmlNewHtml7.setVisible(false);
											System.out.println(result[0]);	
											System.out.println(result[1]);	
											comprando = new Comprar(result[0],result[1],result[2],result[3]);

												comprando.setVisible(true);
												RootPanel.get("comprando").add(comprando);

											
											
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
								p1.setVisible(false);
								htmlDestacado.setVisible(false);
								RootPanel.get("comprando").clear();
								htmlNewHtml.setHTML(result[0]);
								producto1= result[0].substring(4, 18);
								producto1=producto1.trim();
								System.out.println("HOLAAAAA producto 1 : "+producto1);
								producto2= result[1].substring(4, 18);
								producto2=producto2.trim();
								
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
								// cokies
															
								System.out.println("Welcome Back " +userlog);
									
								userName.setVisible(false);
								btnNewButton_3.setVisible(false);
								pass.setVisible(false);
								miCuenta.setVisible(true);
								btnNewButton_5.setVisible(false);
								btnNewButton_2.setVisible(true);
								
								Window.alert("Welcome back");
								
								
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
							btnNewButton_1.setVisible(true);
							htmlNewHtml.setVisible(false);
							htmlNewHtml2.setVisible(false);
							htmlNewHtml3.setVisible(false);
							htmlNewHtml4.setVisible(false);
							htmlNewHtml5.setVisible(false);
							htmlNewHtml6.setVisible(false);
							htmlNewHtml7.setVisible(false);
							p1.setVisible(false);
							p2.setVisible(false);
							p3.setVisible(false);
							p4.setVisible(false);
							p5.setVisible(false);
							p6.setVisible(false);
							p7.setVisible(false);
								
							 greetingService.greetServer(Destacados.DESTACADO_PRODUCTO1,
									new AsyncCallback<String>() {
										public void onFailure(Throwable caught) {
											//TODO
										}

										public void onSuccess(String result) {
											sendBoxImg.setVisible(false);
											htmlDestacado.setHTML(result);
											htmlDestacado.setVisible(true);
											RootPanel.get("botonComprar").add(p1);
											p1.setStyleName("btn btn-danger");
											p1.setVisible(true);
											
											
											
										p1.addClickHandler(new ClickHandler() {
											public void onClick(ClickEvent event) {
												
												//validar aca que exita cookie
										if(Cookies.getCookie("13051983ntmp") != null){			
											
											greetingService.precio(Destacados.DESTACADO_PRODUCTO1, "", new AsyncCallback<String[]>() {

											@Override
											public void onFailure(Throwable caught) {
												// TODO Auto-generated method stub
												//RootPanel.get("comprando").remove(comprando);
												p1.setVisible(false);
												

											}

											@Override
											public void onSuccess(String[] result) {
												htmlDestacado.setVisible(false);
												p1.setVisible(false);
												RootPanel.get("comprando").clear();
												htmlNewHtml.setVisible(false);
												htmlNewHtml2.setVisible(false);
												htmlNewHtml3.setVisible(false);
												htmlNewHtml4.setVisible(false);
												htmlNewHtml5.setVisible(false);
												htmlNewHtml6.setVisible(false);
												htmlNewHtml7.setVisible(false);
													System.out.println(result[0]);	
													System.out.println(result[1]);	
													comprando = new Comprar(result[0],result[1],result[2],result[3]);

														comprando.setVisible(true);
														RootPanel.get("comprando").add(comprando);

													
													
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
						
						
					}		 
				 
				 
				 
		MyHandlerDestacados destacado1Handler= new MyHandlerDestacados();	 
		destacado1.addClickHandler(destacado1Handler);	 
				 						 
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

//Navegacion.

	@Override
	public void onValueChange(ValueChangeEvent event) {
		changePage(History.getToken());
	}
	
	public void changePage(String token) {
		//Mi Cuenta con cookie valida 
		if (History.getToken().equals("miCuenta") &&	(Cookies.getCookie("13051983ntmp") != null)){
	    	RootPanel.get("comprando").clear();
	    	htmlDestacado.setVisible(false);
	    	home.setVisible(true);  
	    	p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
			
	    	//mi cuenta
	    	
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
			panelDeControl.setVisible(false);
	    	System.out.println("estoy en mi cuenta");
	    	sendBoxImg.setVisible(false);
			panelDeControl.setVisible(true);

	
	    
			//mi cuenta con token vencido
	    }else if (History.getToken().equals("miCuenta") &&	(Cookies.getCookie("13051983ntmp") == null)){	
	    	
	    	Window.Location.reload();
	    	
	     //Registro
	    } else if (History.getToken().equals("registro") && (Cookies.getCookie("13051983ntmp") == null)) {
	    	htmlDestacado.setVisible(false);
	    	RootPanel.get("comprando").clear();
	    	p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
	    	
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
	    	    	
//			RootPanel.get("des1").setVisible(false);

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
			
			Window.alert("Hola, Gracias por llegar a Send-box.com, ya estamos en los ultimos detalles, en pocos dias" +
					 " estaremos ya opertativos, gracias, send-box team.");	
			
		} 
	    
	 
	  //Home page default
	    else {
	    	htmlDestacado.setVisible(false);
	    	home.setVisible(false);
	    	RootPanel.get("comprando").clear();
	    	p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
	    					    	
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
