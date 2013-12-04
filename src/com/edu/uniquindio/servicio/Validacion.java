package com.edu.uniquindio.servicio;

public class Validacion {

	public static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

	public static boolean esPalabraCaracteres(String palabra){ 
		for(int i = 0; i < palabra.length(); i++){ 
			if(!((palabra.charAt(i) > 64 && palabra.charAt(i) < 91) || 
					(palabra.charAt(i) > 96 && palabra.charAt(i) < 123))) 
				return false; 
		} 
		return true; 
	} 
}
