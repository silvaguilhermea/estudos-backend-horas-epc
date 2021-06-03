package com.silvaguilherme.estudoshorasepc.services.exceptions;

public class DataExceptionError extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataExceptionError(String msg)
	{
		super(msg);
	}
	
	public DataExceptionError(String msg, Throwable couse)
	{
		super(msg, couse);
	}
	

}
