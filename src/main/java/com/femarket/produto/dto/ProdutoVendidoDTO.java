package com.femarket.produto.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.femarket.produto.model.Produto;

public class ProdutoVendidoDTO {

	private Long id;
	
	private String descricao;
	
	public ProdutoVendidoDTO(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static List<ProdutoVendidoDTO> converter(List<Produto> produtos){
		return produtos.stream().map(ProdutoVendidoDTO::new).collect(Collectors.toList());
	}
	
}
