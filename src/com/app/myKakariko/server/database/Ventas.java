package com.app.myKakariko.server.database;

import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

 
@PersistenceCapable 
public class Ventas {

	/** 
	 * Ventas representa al data object, de las ventas del sistema
	 */
 
	public Ventas(String username, String itemId, String precioFinal, String precioOriginal, String shippingType, String desc, String moneda,String direccion) {
		this.username = username;
		this.itemId = itemId;
		this.estado = "Esperando confirmacion de Abitab"; 
		this.dateCompra =  new Date();			// cuadno compra el cliente
		this.dateTransactionCompleted = null;	//cuando pago en abitab
		this.entregaEstimada= null;				//calculada a partir del pago en abitab
		this.precioFinal=precioFinal;			//precio del item + shipping
		this.precioOriginal=precioOriginal;
		this.dateShiped = null;
		this.regalo= false;
		this.shipping= shippingType;
		this.ganancia=null;  					 //precio - precio original
		this.nombreDelRegalo=null;
		this.direccion=direccion;
		this.descripcion= desc;
		this.moneda=moneda;
		
  
	}

	

	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getMoneda() {
		return moneda;
	}



	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}



	public String getPrecioFinal() {
		return precioFinal;
	}



	public void setPrecioFinal(String precioFinal) {
		this.precioFinal = precioFinal;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public boolean isRegalo() {
		return regalo;
	}

	public void setRegalo(boolean regalo) {
		this.regalo = regalo;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getDateCompra() {
		return dateCompra;
	}

	public void setDateCompra(Date dateCompra) {
		this.dateCompra = dateCompra;
	}

	public Date getDateTransactionCompleted() {
		return dateTransactionCompleted;
	}

	public void setDateTransactionCompleted(Date dateTransactionCompleted) {
		this.dateTransactionCompleted = dateTransactionCompleted;
	}

	public Date getEntregaEstimada() {
		return entregaEstimada;
	}

	public void setEntregaEstimada(Date entregaEstimada) {
		this.entregaEstimada = entregaEstimada;
	}



	public Date getDateShiped() {
		return dateShiped;
	}

	public void setDateShiped(Date dateShiped) {
		this.dateShiped = dateShiped;
	}

	
	@Persistent
	private String username;

	@Persistent
	private String itemId;

	@Persistent
	private String descripcion;
	
	@Persistent
	private String moneda;
	
	@Persistent
	private String precioOriginal;
	
	@Persistent
	private String estado;

	@Persistent
	private Date dateCompra;
	
	@Persistent
	private Date dateTransactionCompleted;
	
	@Persistent
	private Date entregaEstimada;
	
	@Persistent
	private String precioFinal;
	
	@Persistent
	private Date dateShiped;
	
	@Persistent
	private boolean regalo;
	
	@Persistent
	private String shipping;
	
	@Persistent
	private String ganancia;
	
	@Persistent
	private String nombreDelRegalo;
	
	@Persistent
	private String direccion;
	

	public String getGanancia() {
		return ganancia;
	}

	public void setGanancia(String ganancia) {
		this.ganancia = ganancia;
	}

}
