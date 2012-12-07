package com.app.myKakariko.server.database;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 


@PersistenceCapable
public class Client {
    

	/** 
	 * Client representa al data object, de los clientes del sistema.
	 */  
 
      
	public Client(String username, String password, String nombre,
			String apellido, String cedula, String departamento, String ciudad, String direccion, String telefono) {
		this.username = username;
		this.password=password;
		this.nombre =nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.departamento = departamento;
		this.ciudad =ciudad;                 //campo innecesario.
		this.direccion = direccion;
		this.telefono = telefono;
		this.date =  new Date();

	}
	
	@Persistent
	private String telefono;
	
	@Persistent
	private String password;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@PrimaryKey
	@Persistent
	private String username;

	@Persistent
	private String apellido;
	
	@Persistent
	private String nombre;

	@Persistent
	private String cedula;

	@Persistent
	private String ciudad;

	@Persistent
	private String departamento;

	@Persistent
	private String direccion;
	
	@Persistent
	private Date date;

	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
