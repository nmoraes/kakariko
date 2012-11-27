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
 
	public Ventas(String username, String itemId, int precio) {
		this.username = username;
		this.itemId = itemId;
		this.estado = "Esperando confirmacion de Abitab"; 
		this.dateCompra =  new Date();			// cuadno compra el cliente
		this.dateTransactionCompleted = null;	//cuando pago en abitab
		this.entregaEstimada= null;				//calculada a partir del pago en abitab
		this.precio=precio;						//precio del item + shipping
		this.dateShiped = null;

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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Date getDateShiped() {
		return dateShiped;
	}

	public void setDateShiped(Date dateShiped) {
		this.dateShiped = dateShiped;
	}

	@PrimaryKey
	@Persistent
	private String username;

	@Persistent
	private String itemId;

	
	@Persistent
	private String estado;

	@Persistent
	private Date dateCompra;
	
	@Persistent
	private Date dateTransactionCompleted;
	
	@Persistent
	private Date entregaEstimada;
	
	@Persistent
	private int precio;
	
	@Persistent
	private Date dateShiped;


}
