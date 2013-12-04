package com.edu.uniquindio.servicio;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.edu.uniquindio.entidades.Paciente;

public class CuidadorFormalService {


	private static final Logger LOGGER = Logger.getLogger(CuidadorFormalService.class.getName());

	@PersistenceContext(unitName = "persitencia")
	EntityManager mgr;

	private String errorMsg;

	public CuidadorFormalService(){
		LOGGER.info("Cuidador formal instanciado");
	}

	/**
	 * Crear un cuidadorformal - con persistencia
	 * @param a
	 */
//	public void crearCuidadorFormal(Cuidador cuidador){
//		LOGGER.info("Entrando al metodo crear cuidador formal: ["
//				+ cuidador.getNombre() + ","+ cuidador.getApellido() +","+ cuidador.getCedula() 
//				+","+ cuidador.getCorreo() +","+ cuidador.getCelular() + ","+ cuidador.getDireccion() +
//				","+ cuidador.getContraseña()+","+ cuidador.getProfesion() +","+ cuidador.getTipocuidador() +"]");
//
//		EntityManager mgr = EMF.get().createEntityManager();
//		try {
//			mgr.getTransaction().begin();
//			mgr.persist(cuidador);
//			mgr.getTransaction().commit();
//
//			LOGGER.info("Paciente persistido");
//		} catch (Exception e) {
//			LOGGER.info("msg="+e.getMessage()+"\n toString="+e.toString());
//
//		} finally {
//			mgr.close();
//		}
//		LOGGER.info("Saliendo del metodo crear paciente");
//	}
//
//	/**
//	 * Crear un cuidadorinformal - con persistencia
//	 * @param a
//	 */
//	public void crearCuidadorInformal(Cuidador cuidador){
//		LOGGER.info("Entrando al metodo crear cuidador formal: ["
//				+ cuidador.getNombre() + ","+ cuidador.getApellido() +","+ cuidador.getCedula() 
//				+","+ cuidador.getCorreo() +","+ cuidador.getCelular() + ","+ cuidador.getDireccion() +
//				","+ cuidador.getContraseña()+","+ cuidador.getProfesion() +","+ cuidador.getTipocuidador() +"]");
//
//		EntityManager mgr = EMF.get().createEntityManager();
//		try {
//			mgr.getTransaction().begin();
//			mgr.persist(cuidador);
//			mgr.getTransaction().commit();
//
//			LOGGER.info("Paciente persistido");
//		} catch (Exception e) {
//			LOGGER.info("msg="+e.getMessage()+"\n toString="+e.toString());
//
//		} finally {
//			mgr.close();
//		}
//		LOGGER.info("Saliendo del metodo crear paciente");
//	}
}
