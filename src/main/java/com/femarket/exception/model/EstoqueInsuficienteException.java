package com.femarket.exception.model;

public class EstoqueInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EstoqueInsuficienteException(String mensagem) {
		super(mensagem);
	}
	
}
