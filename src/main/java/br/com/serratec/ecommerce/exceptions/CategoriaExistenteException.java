package br.com.serratec.ecommerce.exceptions;

public class CategoriaExistenteException extends RuntimeException{

	public CategoriaExistenteException (String message) {
		super(message);
	}
}