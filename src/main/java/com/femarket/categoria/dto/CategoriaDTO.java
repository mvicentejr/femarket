package com.femarket.categoria.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.femarket.categoria.model.Categoria;

public class CategoriaDTO {

	private Long id;
	private String descricao;
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.descricao = categoria.getDescricao();
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
	
	public static List<CategoriaDTO> converter(List<Categoria> categorias){
		return categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
	}
}
