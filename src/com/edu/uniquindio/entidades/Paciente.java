package com.edu.uniquindio.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PACIENTE database table.
 * 
 */
@Entity
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String pacienteid;

	private String apellido;

	private String cedula;

	private String eps;

	private String estatura;

	private String fechanacimiento;

	private String genero;

	private String nombre;

	private String peso;

	private String rh;

	//bi-directional many-to-one association to Sistema
	@ManyToOne
	@JoinColumn(name="SISTEMAID")
	private Sistema sistema;

	public Paciente() {
	}

	public String getPacienteid() {
		return this.pacienteid;
	}

	public void setPacienteid(String pacienteid) {
		this.pacienteid = pacienteid;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getEps() {
		return this.eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getEstatura() {
		return this.estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public String getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPeso() {
		return this.peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getRh() {
		return this.rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public Sistema getSistema() {
		return this.sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

}