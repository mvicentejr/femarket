package com.femarket.venda.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.femarket.enderecoEntrega.model.EnderecoEntrega;
import com.femarket.exception.model.EstoqueInsuficienteException;
import com.femarket.exception.model.ObjetoNaoEncontradoException;
import com.femarket.produto.model.Produto;
import com.femarket.produto.repository.ProdutoRepository;
import com.femarket.venda.dto.VendaDTO;
import com.femarket.venda.form.VendaForm;
import com.femarket.venda.model.Venda;
import com.femarket.venda.repository.VendaRepository;


@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public ResponseEntity<List<VendaDTO>> listarVendas() {
		List<Venda> vendas = this.vendaRepository.findAll();
		return ResponseEntity.ok(VendaDTO.converter(vendas));
	}

	public ResponseEntity<VendaDTO> listarVenda(Long idVenda) {
		Venda venda = this.buscarVenda(idVenda);
		return ResponseEntity.ok( new VendaDTO(venda));
	}
	
	public Venda buscarVenda(Long idVenda) {
		Optional<Venda> optionalVenda = this.vendaRepository.findById(idVenda);
		if (!optionalVenda.isPresent()) {
			throw new ObjetoNaoEncontradoException("Venda com id "+idVenda + " não encontrada!");
		}
		return optionalVenda.get();
	}

	@Transactional
	public ResponseEntity<VendaDTO> cadastrarVenda(VendaForm vendaForm) {
		Venda venda = this.prepararVenda(vendaForm, new Venda());
		venda = this.vendaRepository.save(venda);
		return ResponseEntity.ok(new VendaDTO(venda));
	}

	private Venda prepararVenda(VendaForm vendaForm, Venda venda) {
		List<Long> idProdutosVendidos = vendaForm.getIdProdutosVendidos();
		List<Produto> produtos = this.produtoRepository.findByIdIn(idProdutosVendidos);
		
		if (produtos.size() != idProdutosVendidos.stream().distinct().count()) {
			throw new ObjetoNaoEncontradoException("os ids dos produtos informados são inválidos!");
		}
			
		BigDecimal valorTotal = new BigDecimal("0.00");
		for(Produto produto: produtos) {
			Long qtdeProduto = idProdutosVendidos.stream().filter(id -> id == produto.getId()).count();
			if(qtdeProduto > produto.getQtdEstoque()) {
				throw new EstoqueInsuficienteException("o estoque do produto(id="+produto.getId()+") é insuficiente!");
			}
			produto.setQtdEstoque(produto.getQtdEstoque() - qtdeProduto);
			valorTotal = valorTotal.add(produto.getValor().multiply(new BigDecimal(qtdeProduto)));
			for(Long i=0L; i<qtdeProduto; i++) {
				venda.getProdutosVendidos().add(produto);
			}
		}
		venda.setValorTotal(valorTotal);
		venda.setEnderecoEntrega(vendaForm.getEndereco() == null ? null : vendaForm.getEndereco().converter(new EnderecoEntrega()));
		venda.setDataVenda(LocalDate.now());
		return venda;
	}
}
