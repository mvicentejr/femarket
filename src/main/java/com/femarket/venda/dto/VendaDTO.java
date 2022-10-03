package com.femarket.venda.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.femarket.enderecoEntrega.model.EnderecoEntrega;
import com.femarket.produto.dto.ProdutoVendidoDTO;
import com.femarket.venda.model.Venda;

public class VendaDTO {

	private Long id;
	
	private BigDecimal valorTotal;
	
	private LocalDate dataVenda;
	
	private EnderecoEntrega enderecoEntrega;
	
	private  List<ProdutoVendidoDTO> produtosVendidos;
	
	public VendaDTO(Venda venda) {
		this.id = venda.getId();
		this.valorTotal = venda.getValorTotal();
		this.dataVenda = venda.getDataVenda();
		this.enderecoEntrega = venda.getEnderecoEntrega() == null ? null : venda.getEnderecoEntrega();
		this.produtosVendidos = ProdutoVendidoDTO.converter(venda.getProdutosVendidos());
	}
	
	public static List<VendaDTO> converter(List<Venda> vendas){
		return vendas.stream().map(VendaDTO::new).collect(Collectors.toList());
	}

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

	public List<ProdutoVendidoDTO> getProdutosVendidos() {
		return produtosVendidos;
	}

	public void setProdutosVendidos(List<ProdutoVendidoDTO> produtosVendidos) {
		this.produtosVendidos = produtosVendidos;
	}	
		
}
