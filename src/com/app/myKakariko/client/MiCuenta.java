package com.app.myKakariko.client;

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

public class MiCuenta extends Composite {



		// boton para ingreso
		private Button btnEnviar;

		// text box para ingreso
		private TextBox textBox_2;
		private TextBox textBox_3;
		private TextBox textBox_4;
		private TextBox textBox_5;
		private TextBox textBox_6;

		// boton para modificacion
		private Button btnBuscar;


		private DecoratedTabPanel decoratedTabPanel;
		
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
	 
			Label lblNewLabel_1 = new Label("nombre");
			absolutePanel.add(lblNewLabel_1, 18, 101);

			Label lblNewLabel_2 = new Label("apellido");
			absolutePanel.add(lblNewLabel_2, 18, 150);

			Label lblNewLabel_3 = new Label("cedula");
			absolutePanel.add(lblNewLabel_3, 23, 203);

			Label lblNewLabel_5 = new Label("direccion");
			absolutePanel.add(lblNewLabel_5, 9, 239);

			textBox_2 = new TextBox();
			textBox_2.setTitle("ingrese nombre del nuevo cliente");
			absolutePanel.add(textBox_2, 82, 101);

			textBox_3 = new TextBox();
			textBox_3.setTitle("ingrese apellido del nuevo cliente");
			absolutePanel.add(textBox_3, 82, 147);

			textBox_4 = new TextBox();
			textBox_4.setTitle("ingrese cedula del nuevo cliente");
			absolutePanel.add(textBox_4, 82, 193);

			textBox_5 = new TextBox();
			textBox_5.setTitle("ingrese telefono del nuevo cliente");
			absolutePanel.add(textBox_5, 82, 239);

			Label lblNewLabel_6 = new Label("telefono");
			absolutePanel.add(lblNewLabel_6, 11, 285);

			textBox_6 = new TextBox();
			textBox_6.setTitle("ingrese direccion del nuevo cliente");
			absolutePanel.add(textBox_6, 82, 285);

			Label lblIngresoDeNuevo = new Label("datos personales");
			absolutePanel.add(lblIngresoDeNuevo, 75, 10);

			btnEnviar = new Button("enviar");
			absolutePanel.add(btnEnviar, 357, 200);

			btnBuscar = new Button("buscar");
			absolutePanel.add(btnBuscar, 440, 82);
			
			TextBox textBox_8 = new TextBox();
			absolutePanel.add(textBox_8, 82, 55);
			
			Label lblUsername = new Label("username");
			lblUsername.setStyleName("label label-warning");
			absolutePanel.add(lblUsername, 13, 63);
			
			TextBox textBox_9 = new TextBox();
			absolutePanel.add(textBox_9, 82, 324);
			
			Label lblDepartamento = new Label("departamento");
			absolutePanel.add(lblDepartamento, 9, 324);
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


			// Handler para la busqueda de datos personales.
			MyHandler2 handler2 = new MyHandler2();
			btnBuscar.addClickHandler(handler2);

		}
		

		

		// controlador de eventos para buscar datos personales.
		class MyHandler2 implements ClickHandler, KeyUpHandler {

			@Override
			public void onClick(ClickEvent event) {
			    btnEnviar.setEnabled(false);
				findClient();
			}

			@Override
			public void onKeyUp(KeyUpEvent event) {
			    btnEnviar.setEnabled(false);
				findClient();
			}

			private void findClient() {
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
						 
						 System.out.println("hola Mi cuento: "+ result[0] + " " +result[1]);


					}

				});

			}

		}
	}
