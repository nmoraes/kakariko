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
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;

public class Comprar extends Composite {
	
	private final MiCuentaServiceAsync panelDeControl = GWT.create(MiCuentaService.class);
	private TextBox textBox;
	private TextBox textBox_1;
	private TextBox textBox_2;
	private TextBox textBox_3;
	private DecoratedTabPanel decoratedTabPanel;
	private TextBox textBox_4;
	 //radioButton
	private ListBox comboBox_1;
	
	private HTML image;
	private static String precio;
	private static String moneda;
	private String desc;
	
	
	

	public Comprar(String precio, String moneda, String imagen, String descripcion) {
		
		image= new HTML("<div><p><img src="+imagen+ " align=\"center\" class=\"img-rounded\"><div></p",true);
	
		this.precio=precio;
		this.moneda=moneda;
		desc=descripcion;
		
		
		comboBox_1 = new ListBox();
		comboBox_1.addItem("precio sin impuesto de entrega");
		comboBox_1.addItem("Entrega hasta 24 Hrs");
		comboBox_1.addItem("Entrega hasta 48 Hrs");
		comboBox_1.addItem("Entrega hasta 72 Hrs");
		comboBox_1.addItem("Entrega despues de 72 Hrs");
		
		
		decoratedTabPanel = new DecoratedTabPanel();
		initWidget(decoratedTabPanel);
		decoratedTabPanel.setAnimationEnabled(true);
		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
	
		
		decoratedTabPanel.add(absolutePanel_1, "mi compra",
				false);
		absolutePanel_1.setSize("880px", "258px");

		absolutePanel_1.add(image, 544, 10)	;
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
		
		Button button = new Button("comprar ahora !");
		absolutePanel_1.add(button, 294, 198);
		button.setSize("152px", "28px");
		
		Button button_1 = new Button("cancelar compra");
		absolutePanel_1.add(button_1, 171, 198);
		
		textBox_3 = new TextBox();
		textBox_3.setText(moneda+" "+precio);
		textBox_3.setEnabled(false);
		absolutePanel_1.add(textBox_3, 236, 94);
		
		textBox_4 = new TextBox();
		absolutePanel_1.add(textBox_4, 8, 142);
		
		if (Cookies.getCookie("13051983ntmp")!=null){
			findClient();
			}
			
		
		class MyHandlerCombo implements ChangeHandler, KeyUpHandler{
			
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				int indexCat= comboBox_1.getSelectedIndex();
				final String comboBoxValue =comboBox_1.getValue(indexCat);
				if(!comboBoxValue.equals("precio sin impuesto de entrega"))
					recalculo(comboBoxValue,Comprar.precio,Comprar.moneda);	
				else
					textBox_3.setText(Comprar.moneda+" "+Comprar.precio);
			}
			

			@Override
			public void onChange(ChangeEvent event) {
				int indexCat= comboBox_1.getSelectedIndex();
				final String comboBoxValue =comboBox_1.getValue(indexCat);
				if(!comboBoxValue.equals("precio sin impuesto de entrega"))
					recalculo(comboBoxValue,Comprar.precio,Comprar.moneda);	
				else
					textBox_3.setText(Comprar.moneda+" "+Comprar.precio);
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
						System.out.println(result);
						textBox_3.setText(Comprar.moneda+" "+result);

		 
						 
					}

				});
				
				
			}


		
		}
		
		//Login en SendBox.		 
		MyHandlerCombo handlerCombo =new MyHandlerCombo();
		comboBox_1.addKeyUpHandler(handlerCombo);
		comboBox_1.addChangeHandler(handlerCombo);

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
