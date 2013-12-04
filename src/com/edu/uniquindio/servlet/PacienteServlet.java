package com.edu.uniquindio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.edu.uniquindio.entidades.Paciente;
import com.edu.uniquindio.servicio.CuidadorFormalService;
import com.edu.uniquindio.servicio.PacienteService;
import com.edu.uniquindio.servicio.SistemaService;
import com.edu.uniquindio.servicio.SistemaServiceException;
import com.edu.uniquindio.servicio.Validacion;


public class PacienteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger("Administration logger");
	
	private Validacion validacion = new Validacion();

	private static PacienteService pacienteService = new PacienteService();

	public void doGet(final HttpServletRequest req, final HttpServletResponse response)
			throws ServletException, IOException {
		doPost(req, response);
	}

	public void doPost(final HttpServletRequest req, final HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String estatura = req.getParameter("estatura");
		String cedula = req.getParameter("cedula");

		String dia = req.getParameter("dia");
		String mes = req.getParameter("mes");
		String anio = req.getParameter("anio");

		String fechaNacimiento= dia+"/"+mes+"/"+anio;

		String peso = req.getParameter("peso");
		String rh = req.getParameter("rh");
		String eps = req.getParameter("eps");
		String genero = req.getParameter("genero");

		Paciente paciente = new Paciente();
		paciente.setNombre(nombre);
		paciente.setApellido(apellido);
		paciente.setCedula(cedula);
		paciente.setEstatura(estatura);
		paciente.setFechanacimiento(fechaNacimiento);
		paciente.setPeso(peso);
		paciente.setRh(rh);
		paciente.setEps(eps);
		paciente.setGenero(genero);

		if (nombre.equals("") || apellido.equals("") || cedula.equals("") || estatura.equals("Escoger medidad")||
				dia.equals("Dia")||mes.equals("Mes")|| anio.equals("Año") || peso.equals("")||
				rh.equals("Seleccione uno") || eps.equals("") || genero.equals("Seleccione uno")){
			out.println("<html><head></head><body><h1>Falta informacion por ingresar!<h1>");
			out.println("</body></html>");
			logger.log(Level.INFO, "Parametros invalidos");

		}
		else if(!validacion.isNumeric(peso) ){
			out.println("<html><head></head><body>No se admiten letras en la casilla</body></html>"+" peso por favor hacer "
					+ "click en retrodecer pagina para seguir en el proceso de registro de paciente");
			out.println("</body></html>");
			logger.log(Level.INFO, "Parametros con tipo de dato erroneo");
			;	
		}	
		else if(!validacion.isNumeric(cedula)){
			out.println("<html><head></head><body>No se admiten letras en la casilla</body></html>"+" Cedula"
					+ "click en retrodecer pagina para seguir en el proceso de registro de paciente");
			out.println("</body></html>");
			logger.log(Level.INFO, "Parametros con tipo de dato erroneo");

		}
		else if(!validacion.esPalabraCaracteres(nombre)){
			out.println("<html><head></head><body>No se admiten numeros en la casilla</body></html>"+" Nombre"
					+ "click en retrodecer pagina para seguir en el proceso de registro de paciente");
			out.println("</body></html>");
			logger.log(Level.INFO, "Parametros con tipo de dato erroneo");

		}
		else if(!validacion.esPalabraCaracteres(apellido)){
			out.println("<html><head></head><body>No se admiten numeros en la casilla </body></html>"+" Apellido"
					+ "click en retrodecer pagina para seguir en el proceso de registro de paciente");
			out.println("</body></html>");
			logger.log(Level.INFO, "Parametros con tipo de dato erroneo");
		}
		else {
			logger.log(Level.INFO, "Parametros validos");

			try {
				pacienteService.crearPaciente(paciente);
				out.println("<html><head></head><body><h1>Se registro el paciente exitosamente !<h1>");
				out.println("</body></html>");
				response.setHeader("Refresh", "3; url=/pacientecrear.jsf");
			} catch (Exception e) {
				out.println("<html><head></head><body>Error !</body></html>");
			}
		}
		
	}
}
