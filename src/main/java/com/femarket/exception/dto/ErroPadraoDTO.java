package com.femarket.exception.dto;

public class ErroPadraoDTO {

	String mensagem;
	
	public ErroPadraoDTO(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
