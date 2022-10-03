package com.femarket.enderecoEntrega.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.femarket.enderecoEntrega.model.EnderecoEntrega;

public class EnderecoEntregaDTO {

	private Long id;
	private String cliente;
	private String rua;
	private Long numero;
	private String complemento;
	
	private EnderecoEntregaDTO(EnderecoEntrega enderecoEntrega) {
		this.id = enderecoEntrega.getId();
		this.cliente = enderecoEntrega.getCliente();
		this.rua = enderecoEntrega.getRua();
		this.numero = enderecoEntrega.getNumero();
		this.complemento = enderecoEntrega.getComplemento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public static List<EnderecoEntregaDTO> converter(List<EnderecoEntrega> enderecos){
		return enderecos.stream().map(EnderecoEntregaDTO::new).collect(Collectors.toList());
	}
	
}
