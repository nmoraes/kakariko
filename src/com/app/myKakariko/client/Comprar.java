package com.app.myKakariko.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;

public class Comprar extends Composite {
	
	private final MiCuentaServiceAsync panelDeControl = GWT.create(MiCuentaService.class);
	
	private TextBox textBox;
	private TextBox textBox_1;
	private TextBox textBox_2;
	private TextBox textBox_3;
	private HTMLPanel decoratedTabPanel;
	 //radioButton
	private ListBox comboBox_1;
	
	private HTML image;
	private static String precio;
	private static String moneda;
	private static String id;
	private String desc;
	private static String precioSendBox;
	private Button btnComprar;
	private HTML htmlNewHtml;
	private Button btnCancelar;
	private static  String valorCombobox=null;
	
	
	
	

	public Comprar(String precio, String moneda, String imagen, String descripcion, String id) {
		
		image= new HTML("<div><p><img src="+imagen+ " align=\"center\" class=\"img-rounded\"><div></p",true);
	
		this.precio=precio;
		this.moneda=moneda;
		this.id=id;
		desc=descripcion;
		
		
		comboBox_1 = new ListBox();
		comboBox_1.addItem("precio sin impuesto de entrega");
		comboBox_1.addItem("Entrega hasta 24 Hrs");
		comboBox_1.addItem("Entrega hasta 48 Hrs");
		comboBox_1.addItem("Entrega hasta 72 Hrs");
		comboBox_1.addItem("Entrega despues de 72 Hrs");
		
		
		decoratedTabPanel = new HTMLPanel("");
		initWidget(decoratedTabPanel);
		decoratedTabPanel.setSize("880px", "406px");
		//decoratedTabPanel.setAnimationEnabled(true);
		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
	
		
		decoratedTabPanel.add(absolutePanel_1);
		absolutePanel_1.setSize("880px", "406px");

		absolutePanel_1.add(image, 490, 10)	;
		image.setSize("232px", "183px");
		
		absolutePanel_1.add(comboBox_1, 8, 96);
		
		textBox = new TextBox();
		absolutePanel_1.add(textBox, 8, 10);
		textBox.setEnabled(false);
		
		textBox_1 = new TextBox();
		absolutePanel_1.add(textBox_1, 236, 10);
		textBox_1.setEnabled(false);
		
		textBox_2 = new TextBox();
		absolutePanel_1.add(textBox_2, 7, 50);
		textBox_2.setSize("435px", "20px");
		textBox_2.setEnabled(false);
		
		btnComprar = new Button("comprar");
		btnComprar.setVisible(false);
		btnComprar.setStyleName("btn btn-success");
		absolutePanel_1.add(btnComprar, 703, 259);
		btnComprar.setSize("82", "30");
		
		btnCancelar = new Button("cancelar");
		btnCancelar.setStyleName("btn btn-danger");
		absolutePanel_1.add(btnCancelar, 789, 259);
		
		
		btnCancelar.addClickHandler(new ClickHandler() {
	
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("comprando").clear();	
				Window.Location.reload();
			}
		});
		
		textBox_3 = new TextBox();
		textBox_3.setText(moneda+" "+precio);
		textBox_3.setEnabled(false);
		absolutePanel_1.add(textBox_3, 236, 94);
		
		htmlNewHtml = new HTML("<div class=\"alert alert-block\"><h4>Atencion!</h4>Usted esta por comprar 1(uno) producto, al momento de comprar, Ud genera una compra ficticia que se hace real al momento de abonar en Abitab, en el momento que abone, se calcula el tiempo de envio seleccionado. Ej: Ud compra un Lunes, con envio 24Hrs y abona un martes, el producto le llegar el Miercoles.</div>", true);
		absolutePanel_1.add(htmlNewHtml, 8, 295);
		htmlNewHtml.setSize("863px", "110px");
		
		if (Cookies.getCookie("13051983ntmp")!=null){
			findClient();
			}
			
		
		class MyHandlerCombo implements ChangeHandler, KeyUpHandler{
			
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				int indexCat= comboBox_1.getSelectedIndex();
				final String comboBoxValue =comboBox_1.getValue(indexCat);
				Comprar.valorCombobox=comboBoxValue;
				
				if(!comboBoxValue.equals("precio sin impuesto de entrega")){
					recalculo(comboBoxValue,Comprar.precio,Comprar.moneda);	
					btnComprar.setVisible(true);
			}
				else{
					btnComprar.setVisible(false);
					textBox_3.setText(Comprar.moneda+" "+Comprar.precio);
			}
				}
			

			@Override
			public void onChange(ChangeEvent event) {
				int indexCat= comboBox_1.getSelectedIndex();
				final String comboBoxValue =comboBox_1.getValue(indexCat);
				Comprar.valorCombobox=comboBoxValue;
				if(!comboBoxValue.equals("precio sin impuesto de entrega")){
					recalculo(comboBoxValue,Comprar.precio,Comprar.moneda);	
					btnComprar.setVisible(true);
			}
				else{
					btnComprar.setVisible(false);
					textBox_3.setText(Comprar.moneda+" "+Comprar.precio);
			}
				}


			
			
			private void recalculo(String shipping, String precioInicial, String moneda){
				
				
				panelDeControl.calcularPrecioFinal(precioInicial,shipping,moneda, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						textBox_3.setText("");
						System.out.println("ERROR DE COMBOBOX");
					}

					@Override
					public void onSuccess(String result) {	 
						precioSendBox=result;
						textBox_3.setText(Comprar.moneda+" "+result);

		 
						 
					}

				});
				
				
			}


		
		}
		
		
		
		
		
		
			 
		MyHandlerCombo handlerCombo =new MyHandlerCombo();
		comboBox_1.addKeyUpHandler(handlerCombo);
		comboBox_1.addChangeHandler(handlerCombo);

		MyHandlerComprar comprar =new MyHandlerComprar();
		btnComprar.addKeyUpHandler(comprar);
		btnComprar.addClickHandler(comprar);
		//btnComprar
		
		
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
			String nombre= textBox.getText();
			String direccion = textBox_1.getText();
			String descripcion =textBox_2.getText();

			panelDeControl.comprarProducto(username, nombre, direccion,
					descripcion, Comprar.id, Comprar.precio,
				    precioSendBox, Comprar.moneda, Comprar.valorCombobox , new AsyncCallback<String>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Error al comprar, segurmente se vencio la cookie, oprime F5.");
					RootPanel.get("comprando").clear();	
					Window.Location.reload();
				}

				@Override
				public void onSuccess(String result) {	 
					Window.alert(result);
					RootPanel.get("comprando").clear();	
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
				 //btnEnviar.setEnabled(true);
				//Window.alert(caught.getMessage());
				
			}

			@Override
			public void onSuccess(String[] result) {
				 
				int indexCat= comboBox_1.getSelectedIndex();
				final String comboBoxValue =comboBox_1.getValue(indexCat);
				
				System.out.println(result[7] + " " + result[8]);
				
				 textBox.setText(result[7] + " " + result[8]);
				 textBox_1.setText(result[2]);
				 textBox_2.setText(desc);
			
 
				 
			}

		});

	}
}
