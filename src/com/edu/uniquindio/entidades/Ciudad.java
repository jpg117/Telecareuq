package com.edu.uniquindio.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CIUDAD database table.
 * 
 */
@Entity
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ciudadid;

	private String nombre;

	private String nombredepartamento;

	private String nombrepais;

	//bi-directional many-to-one association to Sistema
	@OneToMany(mappedBy="ciudad")
	private List<Sistema> sistemas;

	public Ciudad() {
	}

	public String getCiudadid() {
		return this.ciudadid;
	}

	public void setCiudadid(String ciudadid) {
		this.ciudadid = ciudadid;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombredepartamento() {
		return this.nombredepartamento;
	}

	public void setNombredepartamento(String nombredepartamento) {
		this.nombredepartamento = nombredepartamento;
	}

	public String getNombrepais() {
		return this.nombrepais;
	}

	public void setNombrepais(String nombrepais) {
		this.nombrepais = nombrepais;
	}

	public List<Sistema> getSistemas() {
		return this.sistemas;
	}

	public void setSistemas(List<Sistema> sistemas) {
		this.sistemas = sistemas;
	}

	public Sistema addSistema(Sistema sistema) {
		getSistemas().add(sistema);
		sistema.setCiudad(this);

		return sistema;
	}

	public Sistema removeSistema(Sistema sistema) {
		getSistemas().remove(sistema);
		sistema.setCiudad(null);

		return sistema;
	}

}