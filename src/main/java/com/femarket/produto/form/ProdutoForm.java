package com.femarket.produto.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.femarket.categoria.model.Categoria;
import com.femarket.produto.model.Produto;

public class ProdutoForm {

	@NotEmpty @NotBlank
	private String descricao;
	
	@NotNull @Min(value = 0)
	private Long qtdEstoque;
	
	@NotNull @DecimalMin(value = "0.01") @Digits(integer = 8, fraction = 2)
	private BigDecimal valor;
	
	@NotNull @Min(value = 0)
	private Long idCategoria;
	
	public String getDescricao() {
		return descricao;
	}
	public Long getQtdEstoque() {
		return qtdEstoque;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
		
	public Produto converter(Produto produto, Categoria categoria) {
		produto.setDescricao(this.descricao);
		produto.setQtdEstoque(this.qtdEstoque);
		produto.setValor(this.valor);
		produto.setCategoria(categoria);
		return produto;
	}
	
}
