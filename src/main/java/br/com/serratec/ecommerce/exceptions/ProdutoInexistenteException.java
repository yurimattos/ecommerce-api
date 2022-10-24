package br.com.serratec.ecommerce.exceptions;

public class ProdutoInexistenteException extends RuntimeException{

	public ProdutoInexistenteException(String message) {
		super(message);
	}
}