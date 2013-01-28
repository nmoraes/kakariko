package com.app.myKakariko.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class DialogSendBox extends DialogBox {

	private HTML html;

	
	public DialogSendBox(String msg, String msg2) {
	      // Set the dialog box's caption.
	      setText(msg);
	      // Enable animation.
	      setAnimationEnabled(false);
	      
	   // Enable glass background.
	      setGlassEnabled(true);
	      
	      //Label label = new Label("This is a simple dialog box.");

	         VerticalPanel panel = new VerticalPanel();
	         panel.setSize("578px", "138px");
	         panel.setSpacing(10);
	         panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

	         setWidget(panel);
	         
	         AbsolutePanel absolutePanel = new AbsolutePanel();
	         panel.add(absolutePanel);
	         absolutePanel.setHeight("79px");
	         
	          
	         html= new HTML(msg2, true);
	         absolutePanel.add(html, 0, 0);
	         html.setSize("578px", "69px");
	          
	          AbsolutePanel absolutePanel_1 = new AbsolutePanel();
	          panel.add(absolutePanel_1);
	          panel.setCellHorizontalAlignment(absolutePanel_1, HasHorizontalAlignment.ALIGN_CENTER);
	          panel.setCellVerticalAlignment(absolutePanel_1, HasVerticalAlignment.ALIGN_BOTTOM);
	          absolutePanel_1.setHeight("53px");
	          
	           
	           
	           // DialogBox is a SimplePanel, so you have to set its widget property to
	           // whatever you want its contents to be.
	           Button ok = new Button("aceptar");
	           absolutePanel_1.add(ok, 253, 10);
	           ok.setStyleName("btn btn-primary");
	           ok.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				DialogSendBox.this.hide();
				Window.Location.reload();
				
			}
	             });
	      
	     // setWidget(ok);
	    
	    }
	  }
	
	
	

