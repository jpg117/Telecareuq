package com.edu.uniquindio.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SISTEMA database table.
 * 
 */
@Entity
@NamedQuery(name="Sistema.findAll", query="SELECT s FROM Sistema s")
public class Sistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String sistemaid;

	private String direccion;

	private String nombre;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="sistema")
	private List<Paciente> pacientes;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="CIUDADID")
	private Ciudad ciudad;

	public Sistema() {
	}

	public String getSistemaid() {
		return this.sistemaid;
	}

	public void setSistemaid(String sistemaid) {
		this.sistemaid = sistemaid;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setSistema(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setSistema(null);

		return paciente;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}