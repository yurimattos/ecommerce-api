package br.com.serratec.ecommerce.exceptions;

public class EnderecoInvalidoException extends RuntimeException{
	
	public EnderecoInvalidoException (String message) {
		super(message);
	}
}