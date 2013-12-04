package com.edu.uniquindio.servicio;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.edu.uniquindio.entidades.Paciente;
import com.edu.uniquindio.entidades.Sistema;

public class PacienteService {

	private  static final Logger LOGGER = Logger.getLogger(PacienteService.class.getName());

	@PersistenceContext(unitName = "persistencia")
	EntityManager mgr;

	private String errorMsg;

	public PacienteService(){
		LOGGER.info("Paciente instanciado");
	}

	/**
	 * Crear un paciente - con persistencia
	 * @param a
	 */
	public void crearPaciente(Paciente paciente){
		LOGGER.info("Entrando al metodo crear paciente: ["
				+ paciente.getNombre() + ","+ paciente.getApellido() +","+ paciente.getCedula() 
				+","+ paciente.getEstatura() +","+ paciente.getFechanacimiento() + ","+ paciente.getPeso() +
				","+ paciente.getRh() +","+ paciente.getEps() +","+ paciente.getGenero() +"]");

		EntityManager mgr = EMF.get().createEntityManager();
		try {
			mgr.getTransaction().begin();
			mgr.persist(paciente);
			mgr.getTransaction().commit();

			LOGGER.info("Paciente persistido");
		} catch (Exception e) {
			LOGGER.info("msg="+e.getMessage()+"\n toString="+e.toString());

		} finally {
			mgr.close();
		}
		LOGGER.info("Saliendo del metodo crear paciente");
	}
	
	

}