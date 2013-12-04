package com.edu.uniquindio.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.edu.uniquindio.entidades.Ciudad;
import com.edu.uniquindio.servicio.EMF;

@SuppressWarnings("serial")
public class TelecareuqServlet extends HttpServlet {
	
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        String nombre = req.getParameter("nombre");
	        String nombreDepto = req.getParameter("nombreDepto");
	        String nombrePais = req.getParameter("nombrePais");
	      
	        EntityManager em = EMF.get().createEntityManager();
	        EntityTransaction tx = em.getTransaction();
	        
	        try {
	            tx.begin();
//	            em.persist(ciudad);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            Logger log = Logger.getLogger("TelecareuqServlet");
	            log.log(Level.WARNING, "Rolling Back:", e);
	            tx.rollback();
	        } finally {
	            em.close();
	        }
	        resp.setHeader("Refresh", "0; url=/guestbook.jsp");
	    }

}
