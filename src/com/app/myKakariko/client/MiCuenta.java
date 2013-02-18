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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class MiCuenta extends Composite {

		// text box para ingreso
		private TextBox textBox_2;
		private TextBox textBox_3;
		private TextBox textBox_4;
		private TextBox textBox_5;
		private TextBox textBox_6;
		private TextBox textBox_8;
		private TextBox textBox_9; 
		private TextBox textBox_1;
		private TextBox textBox_7;

		// boton para modificacion
		private Button btnBuscar;


		//private DecoratedTabPanel decoratedTabPanel;
		
		private Label lblNewLabel_7;
		
		/**
		 * Crea un servicio remoto proxy para comunicarse con la capa servidora de
		 * Menu.
		 */
	private final MiCuentaServiceAsync panelDeControl = GWT.create(MiCuentaService.class);

	//private HTML sendBoxLogo= new HTML(Destacados.SEND_BOX_LOGO, true);

	
	
		public MiCuenta() {
			
			//decoratedTabPanel = new DecoratedTabPanel();
			//initWidget(decoratedTabPanel);
			//decoratedTabPanel.setSize("856", "451");
			//decoratedTabPanel.setAnimationEnabled(true);
			AbsolutePanel absolutePanel = new AbsolutePanel();
			absolutePanel.setStylePrimaryName("menuPrincipal");
			absolutePanel.setStyleName("menuPrincipal");
			absolutePanel.setSize("880px", "380px");
			initWidget(absolutePanel);
			//decoratedTabPanel.add(absolutePanel, "mis datos",
				//	false);
	 
			Label lblNewLabel_1 = new Label("password");
			absolutePanel.add(lblNewLabel_1, 340, 116);

			Label lblNewLabel_2 = new Label("direccion");
			absolutePanel.add(lblNewLabel_2, 10, 162);

			Label lblNewLabel_3 = new Label("telefono");
			absolutePanel.add(lblNewLabel_3, 340, 162);

			Label lblNewLabel_5 = new Label("cedula");
			absolutePanel.add(lblNewLabel_5, 10, 204);

			textBox_2 = new TextBox();
			textBox_2.setTitle("mi password");
			absolutePanel.add(textBox_2, 408, 116);

			textBox_3 = new TextBox();
			textBox_3.setTitle("Puedes cambiar tu direccion en cualquier momento, puedes poner cualquiera, la de tu trabajo, tu novia, tus padres, y la puedes cambiar cuantas veces quieras.");
			absolutePanel.add(textBox_3, 96, 162);

			textBox_4 = new TextBox();
			textBox_4.setTitle("Puedes cambiar tu telefono las veces que quieras, puede estar asociado con la direccion actual, o sea seria un numero particualar, o sino un celular.");
			absolutePanel.add(textBox_4, 408, 162);

			textBox_5 = new TextBox();
			textBox_5.setEnabled(false);
			textBox_5.setTitle("Actualmente la cedula, no es modificable.");
			absolutePanel.add(textBox_5, 96, 204);

			Label lblNewLabel_6 = new Label("ciudad");
			absolutePanel.add(lblNewLabel_6, 340, 204);

			textBox_6 = new TextBox();
			textBox_6.setTitle("Tanto la ciudad como el departamento, debe estar relacionado con tu direccion actual, si nos facilita los datos, sera mejor para Ud, al momento de recibir un paquete.");
			absolutePanel.add(textBox_6, 408, 204);

			btnBuscar = new Button("modificar");
			btnBuscar.setStyleName("btn");
			absolutePanel.add(btnBuscar, 424, 270);
			
			textBox_8 = new TextBox();
			textBox_8.setTitle("El username, nunca sera modificable, es una manera de prevenir al sistema de falsos compradores, repelerlos y por otro lado asegurar el buen funcionamiento del sistema para nuestros \"buenos\" usuarios. ");
			textBox_8.setEnabled(false);
			absolutePanel.add(textBox_8, 96, 116);
			
			Label lblUsername = new Label("username");
			
			absolutePanel.add(lblUsername, 12, 116);
			
			textBox_9 = new TextBox();
			textBox_9.setTitle("Tanto la ciudad como el departamento, debe estar relacionado con tu direccion actual, si nos facilita los datos, sera mejor para Ud, al momento de recibir un paquete.");
			absolutePanel.add(textBox_9, 96, 250);
			
			Label lblDepartamento = new Label("departamento");
			absolutePanel.add(lblDepartamento, 0, 250);
			
			lblNewLabel_7 = new Label("");
			absolutePanel.add(lblNewLabel_7, 486, 116);
			
		    textBox_1 = new TextBox();
			absolutePanel.add(textBox_1, 408, 72);
			
			Label lblNewLabel = new Label("apelido");
			absolutePanel.add(lblNewLabel, 340, 72);
			
			textBox_7 = new TextBox();
			absolutePanel.add(textBox_7, 96, 72);
			
			Label lblNombre = new Label("nombre");
			absolutePanel.add(lblNombre, 12, 72);
			
			HTML htmlNewHtml = new HTML("<h3>Mi cuenta</h3>", true);
			htmlNewHtml.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			absolutePanel.add(htmlNewHtml, 260, 8);
			htmlNewHtml.setSize("255px", "28px");
			
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

					Window.Location.reload();				
				}
				
			}

			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (Cookies.getCookie("13051983ntmp")!=null){
					btnBuscar.setEnabled(false);
					modificar();
					}else{
				    	Window.Location.reload();
		
			}
			}
			private void modificar() {
				
				textBox_2.setEnabled(false);
				textBox_3.setEnabled(false);
				textBox_4.setEnabled(false);
				textBox_6.setEnabled(false);
				textBox_9.setEnabled(false);
				textBox_7.setEnabled(false);
				textBox_1.setEnabled(false);
				
				String username =Cookies.getCookie("13051983ntmp");
				String passw= textBox_2.getText();
				String direccion=textBox_3.getText();
				String telefono=textBox_4.getText();
				String ciudad=textBox_6.getText();
				String depto=textBox_9.getText();
				
				
				//cambiar la llamada al evento de RPC
				String nombre=textBox_7.getText();
				String apellido=textBox_1.getText();			
				
				
				if (!FieldVerifier.isValidPass(passw)) {
					lblNewLabel_7.setText("El password no puede ser vacio, y debe tener al menos 5 caracteres");
					btnBuscar.setEnabled(true);
					return;
				}
				
				panelDeControl.updateClient(username,passw, direccion,telefono,ciudad,depto,nombre,apellido,new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage()); 
						textBox_2.setEnabled(true);
						textBox_3.setEnabled(true);
						textBox_4.setEnabled(true);
						textBox_6.setEnabled(true);
						textBox_9.setEnabled(true);
						textBox_7.setEnabled(true);
						textBox_1.setEnabled(true);
						btnBuscar.setEnabled(true);	
						
					}

					@Override
					public void onSuccess(String result) {
						Window.alert(result+ " datos modificados, tendras que iniciar nuevamente.");
						Cookies.removeCookie("13051983ntmp");
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
					// btnEnviar.setEnabled(true);
					Window.alert(caught.getMessage());
					
				}

				@Override
				public void onSuccess(String[] result) {
					// btnEnviar.setEnabled(true);
					 
					 textBox_8.setText(result[0]);
					 textBox_2.setText(result[1]);
					 textBox_3.setText(result[2]);
					 textBox_4.setText(result[3]);
					 textBox_5.setText(result[4]);
					 textBox_6.setText(result[5]);
					 textBox_9.setText(result[6]);
					 textBox_7.setText(result[7]);
					 textBox_1.setText(result[8]);
		 
					 //S7 NOM
 					 //S8 APELL		 
					 
				}

			});

		}
		
	
	}
