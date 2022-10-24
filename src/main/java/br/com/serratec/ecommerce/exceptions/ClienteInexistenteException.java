package br.com.serratec.ecommerce.exceptions;

public class ClienteInexistenteException extends RuntimeException{
	
	public ClienteInexistenteException (String message) {
		super(message);
	}
}