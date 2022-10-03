package com.femarket.venda.form;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.femarket.enderecoEntrega.form.EnderecoEntregaForm;

public class VendaForm {

	@Valid
	private EnderecoEntregaForm endereco;
	@NotEmpty
	private List<@Min(0) @NotNull Long> idProdutosVendidos;
	
	public EnderecoEntregaForm getEndereco() {
		return endereco;
	}
	public List<Long> getIdProdutosVendidos() {
		return idProdutosVendidos;
	}
	
	
	
}
