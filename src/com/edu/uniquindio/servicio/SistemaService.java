package com.edu.uniquindio.servicio;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.edu.uniquindio.entidades.Sistema;

public class SistemaService {


	private  static final Logger LOGGER = Logger.getLogger(SistemaService.class.getName());

	@PersistenceContext(unitName = "persistencia")
	EntityManager mgr;

	private String errorMsg;

	public SistemaService(){
		LOGGER.info("Sistema instanciado");
	}

	/**
	 * Conseguir un sistema dando el ID
	 * @param sistemaid
	 * @return Sistema
	 */
	public Sistema ConseguirSistema(int id) throws SistemaServiceException {
		LOGGER.info("Entrando a conseguir sistema[" + id + "]");
		Sistema result = null;
		EntityManager mgr = EMF.get().createEntityManager();
		try {
			result = mgr.find(Sistema.class, id);
		} catch (Exception e) {
			String msg = "Error";
			LOGGER.severe(msg);
			throw new SistemaServiceException(msg);
		} finally {
			mgr.close();
		}
		if (result == null) {
			LOGGER.warning("Ninguno dato retornado ");
		}
		LOGGER.info("Saliendo de conseguir sistema");
		return result;
	}

}
