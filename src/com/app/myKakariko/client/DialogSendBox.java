package com.app.myKakariko.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DialogSendBox extends DialogBox {

	private HTML html= new HTML("<div><h1>hello htmls</h1></div>", true);

	
	public DialogSendBox(String msg) {
	      // Set the dialog box's caption.
	      setText(msg);
	      // Enable animation.
	      setAnimationEnabled(true);
	      
	      
	   // Enable glass background.
	      setGlassEnabled(true);
	     
	      // DialogBox is a SimplePanel, so you have to set its widget property to
	      // whatever you want its contents to be.
	      Button ok = new Button("aceptar");
	      ok.setStyleName("btn btn-primary");
	      ok.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				DialogSendBox.this.hide();
				
			}
	        });
	      
	      //Label label = new Label("This is a simple dialog box.");

	         VerticalPanel panel = new VerticalPanel();
	         panel.setHeight("100");
	         panel.setWidth("300");
	         panel.setSpacing(10);
	         panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	         panel.add(html);
	         panel.add(ok);

	         setWidget(panel);
	      
	     // setWidget(ok);
	    
	    }
	  }
	
	
	

