package br.com.serratec.ecommerce.exceptions;

public class CategoriaInexistenteException extends RuntimeException{

	public CategoriaInexistenteException(String message) {
		super(message);
	}
}