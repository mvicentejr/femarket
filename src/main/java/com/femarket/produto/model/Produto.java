package com.femarket.produto.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.femarket.categoria.model.Categoria;

@Entity
@Table(name = "Produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;
	
	private String descricao;
	
	@Column(name = "qte_estoque")
	private Long qtdEstoque;
	
	@Column(columnDefinition = "Decimal(10,2)")
	private BigDecimal valor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
