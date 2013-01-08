package com.app.myKakariko.client;

import com.app.myKakariko.shared.FieldVerifier;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;

public class MiCuenta extends Composite {



		// boton para modificacion
		private Button btnEnviar;

		// text box para ingreso
		private TextBox textBox_2;
		private TextBox textBox_3;
		private TextBox textBox_4;
		private TextBox textBox_5;
		private TextBox textBox_6;
		private TextBox textBox_8;
		private TextBox textBox_9; 

		// boton para modificacion
		private Button btnBuscar;

		private HTML sendBoxReg= new HTML(Destacados.REG_BOX, true);


		private DecoratedTabPanel decoratedTabPanel;
		
		private Label lblNewLabel_7;
		
		/**
		 * Crea un servicio remoto proxy para comunicarse con la capa servidora de
		 * Menu.
		 */
	private final MiCuentaServiceAsync panelDeControl = GWT.create(MiCuentaService.class);

	
	
		public MiCuenta() {
			
			decoratedTabPanel = new DecoratedTabPanel();
			initWidget(decoratedTabPanel);
			decoratedTabPanel.setAnimationEnabled(true);
			AbsolutePanel absolutePanel = new AbsolutePanel();
			absolutePanel.setStylePrimaryName("menuPrincipal");
			absolutePanel.setStyleName("menuPrincipal");
			AbsolutePanel absolutePanel3 = new AbsolutePanel();
			absolutePanel3.setStylePrimaryName("menuPrincipal");
			absolutePanel3.setStyleName("menuPrincipal");
			AbsolutePanel absolutePanel4 = new AbsolutePanel();
			absolutePanel4.setStylePrimaryName("menuPrincipal");
			absolutePanel4.setStyleName("menuPrincipal");
			AbsolutePanel absolutePanel5 = new AbsolutePanel();
			absolutePanel5.setStylePrimaryName("menuPrincipal");
			absolutePanel5.setStyleName("menuPrincipal");
			absolutePanel.setSize("880px", "406px");
			absolutePanel3.setSize("880px", "406px");
			absolutePanel4.setSize("880px", "406px");
			absolutePanel5.setSize("880px", "406px");

			decoratedTabPanel.add(absolutePanel, "mis datos",
					false);
	 
			Label lblNewLabel_1 = new Label("password");
			absolutePanel.add(lblNewLabel_1, 9, 59);

			Label lblNewLabel_2 = new Label("direccion");
			absolutePanel.add(lblNewLabel_2, 9, 105);

			Label lblNewLabel_3 = new Label("telefono");
			absolutePanel.add(lblNewLabel_3, 9, 153);

			Label lblNewLabel_5 = new Label("cedula");
			absolutePanel.add(lblNewLabel_5, 9, 197);
			
			absolutePanel.add(sendBoxReg,650,195);
			sendBoxReg.setSize("220px", "169px");

			textBox_2 = new TextBox();
			textBox_2.setTitle("mi password");
			absolutePanel.add(textBox_2, 96, 59);

			textBox_3 = new TextBox();
			textBox_3.setTitle("Puedes cambiar tu direccion en cualquier momento, puedes poner cualquiera, la de tu trabajo, tu novia, tus padres, y la puedes cambiar cuantas veces quieras.");
			absolutePanel.add(textBox_3, 96, 105);

			textBox_4 = new TextBox();
			textBox_4.setTitle("Puedes cambiar tu telefono las veces que quieras, puede estar asociado con la direccion actual, o sea seria un numero particualar, o sino un celular.");
			absolutePanel.add(textBox_4, 96, 151);

			textBox_5 = new TextBox();
			textBox_5.setEnabled(false);
			textBox_5.setTitle("Actualmente la cedula, no es modificable.");
			absolutePanel.add(textBox_5, 96, 197);

			Label lblNewLabel_6 = new Label("ciudad");
			absolutePanel.add(lblNewLabel_6, 9, 245);

			textBox_6 = new TextBox();
			textBox_6.setTitle("Tanto la ciudad como el departamento, debe estar relacionado con tu direccion actual, si nos facilita los datos, sera mejor para Ud, al momento de recibir un paquete.");
			absolutePanel.add(textBox_6, 96, 243);

			btnEnviar = new Button("cancelar");
			btnEnviar.setStyleName("btn btn-large");
			absolutePanel.add(btnEnviar, 206, 356);

			btnBuscar = new Button("modificar");
			btnBuscar.setStyleName("btn btn-large btn-primary");
			absolutePanel.add(btnBuscar, 91, 356);
			
			textBox_8 = new TextBox();
			textBox_8.setTitle("El username, nunca sera modificable, es una manera de prevenir al sistema de falsos compradores, repelerlos y por otro lado asegurar el buen funcionamiento del sistema para nuestros \"buenos\" usuarios. ");
			textBox_8.setEnabled(false);
			absolutePanel.add(textBox_8, 96, 13);
			
			Label lblUsername = new Label("username");
			
			absolutePanel.add(lblUsername, 9, 13);
			
			textBox_9 = new TextBox();
			textBox_9.setTitle("Tanto la ciudad como el departamento, debe estar relacionado con tu direccion actual, si nos facilita los datos, sera mejor para Ud, al momento de recibir un paquete.");
			absolutePanel.add(textBox_9, 96, 282);
			
			Label lblDepartamento = new Label("departamento");
			absolutePanel.add(lblDepartamento, 9, 282);
			
			lblNewLabel_7 = new Label("");
			absolutePanel.add(lblNewLabel_7, 486, 116);
			decoratedTabPanel.add(absolutePanel3, "mis compras activas", false);

			Label lblNewLabel = new Label("id movil");
			absolutePanel3.add(lblNewLabel, 20, 21);



			Button btnNewButton_1 = new Button("New button");
			absolutePanel3.add(btnNewButton_1, 121, 44);

			TextBox textBox_1 = new TextBox();
			absolutePanel3.add(textBox_1, 84, 10);

			RadioButton rdbtnTodos = new RadioButton("new name", "todos");
			absolutePanel3.add(rdbtnTodos, 245, 19);
			
			HTML htmlNewHtml_1 = new HTML("<table class=\"table table-condensed\"><caption>hello table</caption><tbody> <thead><tr><th>campo____1</th><th>campo____2</th><th>campo____3</th><th>campo____4</th></tr></thead><tr class=\"success\"><td>1</td> <td>TB - Monthly</td><td>01/04/2012</td><td>Approved</td></tr></tbody></table>", true);
			
			
			
			absolutePanel3.add(htmlNewHtml_1, 43, 112);
			htmlNewHtml_1.setSize("417px", "131px");
			decoratedTabPanel.add(absolutePanel4, "mis compras finalizadas", false);

			Label lblNewLabel_4 = new Label("id cliente");
			absolutePanel4.add(lblNewLabel_4, 20, 152);

			Button btnNewButton = new Button("New button");
			btnNewButton.setText("facturar");
			absolutePanel4.add(btnNewButton, 91, 196);

			TextBox textBox = new TextBox();
			absolutePanel4.add(textBox, 78, 142);

			Label lblBuscarCliente = new Label("buscar cliente");
			absolutePanel4.add(lblBuscarCliente, 20, 28);
			decoratedTabPanel.add(absolutePanel5, "acerca de send-box.com", false);

			HTML htmlNewHtml = new HTML("<table class=\"table table-condensed\"><caption>hello table</caption><tbody> <thead><tr><th>campo____1</th><th>campo____2</th><th>campo____3</th><th>campo____4</th></tr></thead><tr class=\"success\"><td>1</td> <td>TB - Monthly</td><td>01/04/2012</td><td>Approved</td></tr></tbody></table>", true);
			absolutePanel5.add(htmlNewHtml, 95, 81);
			htmlNewHtml.setSize("484px", "89px");
			
			if (Cookies.getCookie("13051983ntmp")!=null){
			findClient();
			}
			
			//Handler para la busqueda de datos personales.
			MyHandler handler = new MyHandler();
			btnBuscar.addClickHandler(handler);

		}
		

		

		//Handler de modificacion.
		class MyHandler implements ClickHandler, KeyUpHandler {

			@Override
			public void onClick(ClickEvent event) {
			    
				if (Cookies.getCookie("13051983ntmp")!=null){
				btnBuscar.setEnabled(false);
				modificar();
				}else{

					  //Window.Location.assign("http://www.send-box.com");
				
				}
				
			}

			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (Cookies.getCookie("13051983ntmp")!=null){
					btnBuscar.setEnabled(false);
					modificar();
					}else{
					  //  Window.Location.assign("http://www.send-box.com");							}
						
					
					
			}
			}
			private void modificar() {
				
				
				String username =Cookies.getCookie("13051983ntmp");
				String passw= textBox_2.getText();
				String direccion=textBox_3.getText();
				String telefono=textBox_4.getText();
				String ciudad=textBox_6.getText();
				String depto=textBox_9.getText();
							
				if (!FieldVerifier.isValidPass(passw)) {
					lblNewLabel_7.setText("El password no puede ser vacio, y debe tener al menos 5 caracteres");
					btnBuscar.setEnabled(true);
					return;
				}
				
				
				System.out.println("ciudad :" + ciudad);
				System.out.println("depto :" + depto);

				
				panelDeControl.updateClient(username,passw, direccion,telefono,ciudad,depto,new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage()); 
						btnBuscar.setEnabled(true);	
						
					}


					

					@Override
					public void onSuccess(String result) {
						Window.alert(result+ "datos modificados, tendras que iniciar nuevamente.");
						Window.Location.reload();
						
					}

				});

			}

		}
		
		public void findClient() {
			
			
			String username =Cookies.getCookie("13051983ntmp");

			
			System.out.println("username de cookie " + username);
			panelDeControl.miCuenta(username, new AsyncCallback<String[]>() {

				@Override
				public void onFailure(Throwable caught) {
					 btnEnviar.setEnabled(true);
					Window.alert(caught.getMessage());
					
				}

				@Override
				public void onSuccess(String[] result) {
					 btnEnviar.setEnabled(true);
					 
					 textBox_8.setText(result[0]);
					 textBox_2.setText(result[1]);
					 textBox_3.setText(result[2]);
					 textBox_4.setText(result[3]);
					 textBox_5.setText(result[4]);
					 textBox_6.setText(result[5]);
					 textBox_9.setText(result[6]);
	 
					 
				}

			});

		}
	}
