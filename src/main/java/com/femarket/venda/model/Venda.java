package com.femarket.venda.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.femarket.enderecoEntrega.model.EnderecoEntrega;
import com.femarket.produto.model.Produto;


@Entity
@Table(name = "Venda")
public class Venda {

	@Id
	@Column(name = "id_venda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "valor_total", columnDefinition = "Decimal(10,2)")
	private BigDecimal valorTotal;
	
	@Column(name = "data_venda")
	private LocalDate dataVenda;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private EnderecoEntrega enderecoEntrega;
	
	@ManyToMany
	@JoinTable(
			name = "Produto_Vendido", 
			joinColumns = @JoinColumn(name = "id_venda"),
			inverseJoinColumns = @JoinColumn(name = "id_produto")
			)
	private  List<Produto> produtosVendidos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public EnderecoEntrega getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public List<Produto> getProdutosVendidos() {
		return produtosVendidos;
	}

	public void setProdutosVendidos(List<Produto> produtosVendidos) {
		this.produtosVendidos = produtosVendidos;
	}
	
		
}
