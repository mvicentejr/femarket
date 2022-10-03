package com.femarket.produto.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.femarket.categoria.dto.CategoriaDTO;
import com.femarket.produto.model.Produto;

public class ProdutoDTO {

	private Long id;
	
	private String descricao;
	
	private Long qtdEstoque;
	
	private BigDecimal valor;
	
	private CategoriaDTO categoria;

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.qtdEstoque = produto.getQtdEstoque();
		this.valor = produto.getValor();
		this.categoria = new CategoriaDTO(produto.getCategoria());
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

	public Long getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Long qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}
	
	public static List<ProdutoDTO> converter(List<Produto> produtos){
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}
	
}
