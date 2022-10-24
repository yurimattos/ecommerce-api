package br.com.serratec.ecommerce.exceptions;

public class PedidoInconsistenteException extends RuntimeException{

	public PedidoInconsistenteException(String message) {
		super(message);
	}
}