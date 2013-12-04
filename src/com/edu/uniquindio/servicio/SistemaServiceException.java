package com.edu.uniquindio.servicio;

public class SistemaServiceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

    public SistemaServiceException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.msg;
    }

}
