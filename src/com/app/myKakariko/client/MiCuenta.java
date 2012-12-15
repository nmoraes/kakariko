package com.app.myKakariko.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
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

		// text box para modificacion
		private TextBox textBox_9;
		private TextBox textBox_10;
		private TextBox textBox_12;
		private TextBox textBox_13;

		// etiquetas de modificacion
		private Label lblNombre;
		private Label lblApellido;
		private Label lblTelefono;
		private Label lblDireccion;

		// text box para inpout de busqueda
		private TextBox textBox_8;

		//HISTORIES
		private TextArea textArea;

		//combo box paises
		private ListBox comboBox;

		//combobox paises
		private ListBox comboBox_1;

		//check
		private CheckBox chckbxEsPersonaPublica; 

		private DecoratedTabPanel decoratedTabPanel;
		/**
		 * Crea un servicio remoto proxy para comunicarse con la capa servidora de
		 * Menu.
		 */
		//private final MenuServicesAsync menuServicesAsync = GWT
			//	.create(MenuServices.class);

		public MiCuenta() {

			decoratedTabPanel = new DecoratedTabPanel();
			initWidget(decoratedTabPanel);
			//decoratedTabPanel.setSize("782px", "459px");
			decoratedTabPanel.setAnimationEnabled(true);
			AbsolutePanel absolutePanel = new AbsolutePanel();
			absolutePanel.setStylePrimaryName("menuPrincipal");
			absolutePanel.setStyleName("menuPrincipal");
			AbsolutePanel absolutePanel2 = new AbsolutePanel();
			absolutePanel2.setStylePrimaryName("menuPrincipal");
			absolutePanel2.setStyleName("menuPrincipal");
			AbsolutePanel absolutePanel3 = new AbsolutePanel();
			absolutePanel3.setStylePrimaryName("menuPrincipal");
			absolutePanel3.setStyleName("menuPrincipal");
			AbsolutePanel absolutePanel4 = new AbsolutePanel();
			absolutePanel4.setStylePrimaryName("menuPrincipal");
			absolutePanel4.setStyleName("menuPrincipal");
			AbsolutePanel absolutePanel5 = new AbsolutePanel();
			absolutePanel5.setStylePrimaryName("menuPrincipal");
			absolutePanel5.setStyleName("menuPrincipal");
			absolutePanel.setSize("700px", "406px");
			absolutePanel2.setSize("700px", "406px");
			absolutePanel3.setSize("700px", "406px");
			absolutePanel4.setSize("700px", "406px");
			absolutePanel5.setSize("700px", "406px");

			decoratedTabPanel.add(absolutePanel, "nueva history",
					false);
	 
			Label lblNewLabel_1 = new Label("Denunciado");
			absolutePanel.add(lblNewLabel_1, 0, 251);

			Label lblNewLabel_2 = new Label("Ciudad");
			absolutePanel.add(lblNewLabel_2, 10, 208);

			Label lblNewLabel_3 = new Label("Barrio");
			absolutePanel.add(lblNewLabel_3, 10, 298);

			Label lblNewLabel_5 = new Label("telefono");
			absolutePanel.add(lblNewLabel_5, 10, 322);

			textBox_2 = new TextBox();
			textBox_2.setTitle("ingrese nombre del nuevo cliente");
			absolutePanel.add(textBox_2, 82, 208);

			textBox_3 = new TextBox();
			textBox_3.setTitle("ingrese apellido del nuevo cliente");
			absolutePanel.add(textBox_3, 82, 247);

			textBox_4 = new TextBox();
			textBox_4.setTitle("ingrese cedula del nuevo cliente");
			absolutePanel.add(textBox_4, 82, 286);

			textBox_5 = new TextBox();
			textBox_5.setTitle("ingrese telefono del nuevo cliente");
			absolutePanel.add(textBox_5, 82, 324);

			Label lblNewLabel_6 = new Label("empresa");
			absolutePanel.add(lblNewLabel_6, 10, 364);

			textBox_6 = new TextBox();
			textBox_6.setTitle("ingrese direccion del nuevo cliente");
			absolutePanel.add(textBox_6, 82, 363);

			Label lblIngresoDeNuevo = new Label("ingreso de nuevo usuario");
			absolutePanel.add(lblIngresoDeNuevo, 75, 10);

			btnEnviar = new Button("enviar");
			absolutePanel.add(btnEnviar, 357, 200);

			Label lblModificacionDeUsuario = new Label("modificacion de usuario");
			absolutePanel.add(lblModificacionDeUsuario, 512, 10);

			btnBuscar = new Button("buscar");
			absolutePanel.add(btnBuscar, 694, 10);

			AbsolutePanel absolutePanel_1 = new AbsolutePanel();
			absolutePanel_1.setStylePrimaryName("nicolas");
			absolutePanel_1.setStyleName("body");
			absolutePanel.add(absolutePanel_1, 503, 164);
			absolutePanel_1.setSize("242px", "232px");

			Label lblCedula = new Label("cedula");
			absolutePanel_1.add(lblCedula, 10, 20);

			textBox_8 = new TextBox();
			absolutePanel_1.add(textBox_8, 73, 20);

			lblNombre = new Label("nombre");
			absolutePanel_1.add(lblNombre, 10, 60);

			textBox_9 = new TextBox();
			absolutePanel_1.add(textBox_9, 73, 60);

			lblApellido = new Label("apellido");
			absolutePanel_1.add(lblApellido, 10, 100);

			textBox_10 = new TextBox();
			absolutePanel_1.add(textBox_10, 73, 100);

			lblTelefono = new Label("telefono");
			absolutePanel_1.add(lblTelefono, 10, 140);

			textBox_12 = new TextBox();
			absolutePanel_1.add(textBox_12, 73, 140);

			lblDireccion = new Label("direccion");
			lblDireccion.setStyleName("nicolas");
			absolutePanel_1.add(lblDireccion, 10, 180);

			textBox_13 = new TextBox();
			absolutePanel_1.add(textBox_13, 73, 180);

			textArea = new TextArea();
			textArea.setCharacterWidth(20);
			absolutePanel.add(textArea, 82, 37);
			textArea.setSize("379px", "54px");

			Label lblHistory = new Label("History");
			absolutePanel.add(lblHistory, 10, 69);

			comboBox = new ListBox();
			comboBox.addItem("--");
			comboBox.addItem("Denuncia vecinal");
			comboBox.addItem("Denuncia Policial");
			comboBox.addItem("Empresas Publicas");
			comboBox.addItem("Empresas Privadas");
			comboBox.addItem("Liceos Publicos");
			comboBox.addItem("Liceos Privados");
			comboBox.addItem("Solo por Diversion");

			absolutePanel.add(comboBox, 82, 112);

			Label lblCategoria = new Label("Categoria");
			absolutePanel.add(lblCategoria, 10, 125);

			comboBox_1 = new ListBox();
			comboBox_1.addItem("--");
			comboBox_1.addItem("Argentina");
			comboBox_1.addItem("Bolivia");
			comboBox_1.addItem("Brasil");
			comboBox_1.addItem("Chile");
			comboBox_1.addItem("Colombia");
			comboBox_1.addItem("Ecuador");
			comboBox_1.addItem("Paraguay");
			comboBox_1.addItem("Peru");
			comboBox_1.addItem("Uruguay");
			comboBox_1.addItem("Venezuela");



			absolutePanel.add(comboBox_1, 82, 161);

			Label lblPais = new Label("Pais");
			absolutePanel.add(lblPais, 9, 168);

			chckbxEsPersonaPublica = new CheckBox("Es persona Publica");
			absolutePanel.add(chckbxEsPersonaPublica, 346, 112);
			textBox_13.setVisible(false);
			lblDireccion.setVisible(false);
			textBox_12.setVisible(false);
			lblTelefono.setVisible(false);
			textBox_10.setVisible(false);
			lblApellido.setVisible(false);
			textBox_9.setVisible(false);
			lblNombre.setVisible(false);
			decoratedTabPanel.add(absolutePanel2, "baja de usuarios", false);

			Label lblNewLabel_7 = new Label("borrar usuario");
			absolutePanel2.add(lblNewLabel_7, 26, 10);

			Label lblNewLabel_8 = new Label("cedula");
			absolutePanel2.add(lblNewLabel_8, 26, 52);

			TextBox textBox_7 = new TextBox();
			absolutePanel2.add(textBox_7, 105, 42);

			Button btnEliminar = new Button("eliminar");
			absolutePanel2.add(btnEliminar, 142, 94);

			Label lblNewLabel_9 = new Label("New label");
			absolutePanel2.add(lblNewLabel_9, 26, 178);

			Label lblNewLabel_10 = new Label("New label");
			absolutePanel2.add(lblNewLabel_10, 26, 202);

			Label lblNewLabel_11 = new Label("New label");
			absolutePanel2.add(lblNewLabel_11, 26, 226);

			Label lblNewLabel_12 = new Label("New label");
			absolutePanel2.add(lblNewLabel_12, 26, 250);

			Label lblNewLabel_13 = new Label("New label");
			absolutePanel2.add(lblNewLabel_13, 26, 274);

			Button btnConfirmar = new Button("confirmar");
			absolutePanel2.add(btnConfirmar, 142, 302);

			Button btnCancelar = new Button("cancelar");
			absolutePanel2.add(btnCancelar, 222, 302);
			decoratedTabPanel.add(absolutePanel3, "busqueda", false);

			Label lblNewLabel = new Label("id movil");
			absolutePanel3.add(lblNewLabel, 20, 21);



			Button btnNewButton_1 = new Button("New button");
			absolutePanel3.add(btnNewButton_1, 121, 44);

			TextBox textBox_1 = new TextBox();
			absolutePanel3.add(textBox_1, 84, 10);

			RadioButton rdbtnTodos = new RadioButton("new name", "todos");
			absolutePanel3.add(rdbtnTodos, 245, 19);
			decoratedTabPanel.add(absolutePanel4, "factuaracion", false);

			Label lblNewLabel_4 = new Label("id cliente");
			absolutePanel4.add(lblNewLabel_4, 20, 152);

			Button btnNewButton = new Button("New button");
			btnNewButton.setText("facturar");
			absolutePanel4.add(btnNewButton, 91, 196);

			TextBox textBox = new TextBox();
			absolutePanel4.add(textBox, 78, 142);

			Label lblBuscarCliente = new Label("buscar cliente");
			absolutePanel4.add(lblBuscarCliente, 20, 28);
			decoratedTabPanel.add(absolutePanel5, "acerca de", false);

			HTML htmlNewHtml = new HTML("New HTML", true);
			absolutePanel5.add(htmlNewHtml, 95, 81);
			htmlNewHtml.setSize("193px", "89px");

			// Handler para el ingreso de usuario.
			MyHandler handler = new MyHandler();
			btnEnviar.addClickHandler(handler);

			// Handler para la busqueda de usuario.
			MyHandler2 handler2 = new MyHandler2();
			btnBuscar.addClickHandler(handler2);

			MyHandler3 handler3= new MyHandler3();
			btnNewButton.addClickHandler(handler3);

		}

		
		// controlador de eventos para el boton de enviar nuevo usuario.
		class MyHandler3 implements ClickHandler, KeyUpHandler {

			@Override
			public void onClick(ClickEvent event) {
				facturar();

			}

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub

			}


			private void facturar() {
				String x= "";
			/*	menuServicesAsync.facturacion(x, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						System.out.println("errror");
					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						System.out.println("exito !!!!");
					}});*/
			}

		}

		// controlador de eventos para el boton de enviar nuevo usuario.
		class MyHandler implements ClickHandler, KeyUpHandler {

			@Override
			public void onClick(ClickEvent event) {
				btnEnviar.setEnabled(false);
				textBox_2.setEnabled(false);
				textBox_3.setEnabled(false);
				textBox_4.setEnabled(false);
				textBox_5.setEnabled(false);
				textBox_6.setEnabled(false);
				insertHistory();
			}

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub

			}

			private void insertHistory() {

			//	String login=Login.login;
				String history = textArea.getText();

				int indexCat= comboBox.getSelectedIndex();
				String comboBoxC =comboBox.getValue(indexCat);

				int indexPais= comboBox_1.getSelectedIndex();
				String comboBoxP =comboBox_1.getValue(indexPais);

				String ciudad = textBox_2.getText().toLowerCase();
				String denunciado = textBox_3.getText().toLowerCase();
				String barrio = textBox_4.getText().toLowerCase().trim();
				String telefono=textBox_5.getText().toLowerCase();
				String empresa=textBox_6.getText().toLowerCase();

				boolean personaPublica = chckbxEsPersonaPublica.getValue();

			/*	menuServicesAsync.insertHistory(history, comboBoxC, comboBoxP, ciudad,
						denunciado,barrio,telefono, empresa,personaPublica,login, new AsyncCallback<String>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Error al crear nuevo usuario, "
										+ caught.getMessage());

								textBox_2.setEnabled(true);
								textBox_3.setEnabled(true);
								textBox_4.setEnabled(true);
								textBox_5.setEnabled(true);
								textBox_6.setEnabled(true);
								btnEnviar.setEnabled(true);

							}

							@Override
							public void onSuccess(String result) {

								Window.alert("Se creo el nuevo cliente, " + result);

								textBox_2.setText(null);
								textBox_3.setText(null);
								textBox_4.setText(null);
								textBox_5.setText(null);
								textBox_6.setText(null);

								textBox_2.setEnabled(true);
								textBox_3.setEnabled(true);
								textBox_4.setEnabled(true);
								textBox_5.setEnabled(true);
								textBox_6.setEnabled(true);
								btnEnviar.setEnabled(true);
							}

						});*/

			}

		}

		// controlador de eventos para el boton de buscar nuevo usuario.
		class MyHandler2 implements ClickHandler, KeyUpHandler {

			@Override
			public void onClick(ClickEvent event) {
				// btnEnviar.setEnabled(false);
				// textBox_2.setEnabled(false);
				// textBox_3.setEnabled(false);
				// textBox_4.setEnabled(false);
				// textBox_5.setEnabled(false);
				// textBox_6.setEnabled(false);
				findClient();



			}

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub

			}

			private void findClient() {

				String cedula = textBox_8.getText().toLowerCase().trim();

			/*	menuServicesAsync.findClient(cedula, new AsyncCallback<String[]>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
						textBox_8.setText(null);
						lblNombre.setVisible(false);
						lblApellido.setVisible(false);
						lblTelefono.setVisible(false);
						lblDireccion.setVisible(false);
						textBox_9.setVisible(false);
						textBox_10.setVisible(false);
						textBox_12.setVisible(false);
						textBox_13.setVisible(false);

					}

					@Override
					public void onSuccess(String[] result) {

						Window.alert("Busqueda exitosa, se encontro a : "
								+ result[0].trim() + " " + result[1].trim());
						textBox_8.setText(null);
						lblNombre.setVisible(true);
						lblApellido.setVisible(true);
						lblTelefono.setVisible(true);
						lblDireccion.setVisible(true);
						textBox_9.setVisible(true);
						textBox_10.setVisible(true);
						textBox_12.setVisible(true);
						textBox_13.setVisible(true);
						textBox_9.setText(result[0]);
						textBox_10.setText(result[1]);
						textBox_12.setText(result[2]);
						textBox_13.setText(result[3]);

					}

				});*/

			}

		}
	}
