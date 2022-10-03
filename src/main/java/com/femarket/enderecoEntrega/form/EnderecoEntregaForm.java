package com.femarket.enderecoEntrega.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.femarket.enderecoEntrega.model.EnderecoEntrega;

public class EnderecoEntregaForm {

	@NotBlank
	private String cliente;
	@NotBlank
	private String rua;
	@NotNull @Min(0)
	private Long numero;
	private String complemento;
	
	public String getCliente() {
		return cliente;
	}
	public String getRua() {
		return rua;
	}
	public Long getNumero() {
		return numero;
	}
	public String getComplemento() {
		return complemento;
	}
	
	public EnderecoEntrega converter(EnderecoEntrega enderecoEntrega) {
		enderecoEntrega.setCliente(cliente);
		enderecoEntrega.setRua(rua);
		enderecoEntrega.setNumero(numero);
		enderecoEntrega.setComplemento(complemento);
		return enderecoEntrega;
	}
	
}
