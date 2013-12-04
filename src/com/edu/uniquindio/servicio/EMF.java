package com.edu.uniquindio.servicio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {

	 private static final EntityManagerFactory emfInstance = Persistence
		        .createEntityManagerFactory("persistencia");

		    private EMF() {
		    }

		    public static EntityManagerFactory get() {
		        return emfInstance;
		    }
		    
	
}
