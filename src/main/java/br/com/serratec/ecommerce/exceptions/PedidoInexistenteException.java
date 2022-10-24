package br.com.serratec.ecommerce.exceptions;

public class PedidoInexistenteException extends RuntimeException{

	public PedidoInexistenteException(String message) {
		super(message);
	}
}