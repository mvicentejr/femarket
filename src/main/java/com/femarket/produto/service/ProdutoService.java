package com.femarket.produto.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.femarket.categoria.model.Categoria;
import com.femarket.categoria.service.CategoriaService;
import com.femarket.exception.model.ObjetoNaoEncontradoException;
import com.femarket.produto.dto.ProdutoDTO;
import com.femarket.produto.form.ProdutoForm;
import com.femarket.produto.model.Produto;
import com.femarket.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
		List<Produto> produtos = this.produtoRepository.findAll();
		return ResponseEntity.ok(ProdutoDTO.converter(produtos));
	}

	public ResponseEntity<ProdutoDTO> listarProduto(Long idProduto) {
		Produto produto = this.buscarProduto(idProduto);
		return ResponseEntity.ok(new ProdutoDTO(produto));
	}

	public ResponseEntity<List<ProdutoDTO>> listarProdutosDaCategoria(Long idCategoria) {
		Categoria categoria = this.categoriaService.buscarCategoria(idCategoria);
		List<Produto> produtos = this.produtoRepository.findByCategoria_Id(categoria.getId());
		return ResponseEntity.ok(ProdutoDTO.converter(produtos));
	}

	public ResponseEntity<List<ProdutoDTO>> listarProdutosEstoqueBaixo() {
		long qtdEstoqueBaixo = 4L;
		List<Produto> produtos = this.produtoRepository.findByQtdEstoqueLessThan(qtdEstoqueBaixo);
		return ResponseEntity.ok(ProdutoDTO.converter(produtos));
	}

	@Transactional
	public ResponseEntity<ProdutoDTO> cadastrarProduto(ProdutoForm produtoForm) {
		Categoria categoria = this.categoriaService.buscarCategoria(produtoForm.getIdCategoria());
		Produto produto = produtoForm.converter(new Produto(), categoria);
		produto = this.produtoRepository.save(produto);
		return ResponseEntity.ok(new ProdutoDTO(produto));
	}

	@Transactional
	public ResponseEntity<ProdutoDTO> atualizarProduto(ProdutoForm produtoForm, Long idProduto) {
		Produto produto = this.buscarProduto(idProduto);
		Categoria categoria = this.categoriaService.buscarCategoria(produtoForm.getIdCategoria());
		produto = produtoForm.converter(produto, categoria);
		produto = this.produtoRepository.save(produto);
		return ResponseEntity.ok(new ProdutoDTO(produto));
	}

	@Transactional
	public ResponseEntity<ProdutoDTO> deletarProduto(Long idProduto) {
		Produto produto = this.buscarProduto(idProduto);
		this.produtoRepository.deleteById(produto.getId());
		return ResponseEntity.ok().build();
	}

	@Transactional
	public ResponseEntity<ProdutoDTO> deletarProdutosDaCategoria(Long idCategoria) {
		Categoria categoria = this.categoriaService.buscarCategoria(idCategoria);
		this.produtoRepository.deleteByCategoria_Id(categoria.getId());
		return ResponseEntity.ok().build();
	}
	
	public Produto buscarProduto(Long idProduto) {
		Optional<Produto> optionalProduto = this.produtoRepository.findById(idProduto);
		if (!optionalProduto.isPresent()) {
			throw new ObjetoNaoEncontradoException("Produto com id "+idProduto + " não encontrado!");
		}
		return optionalProduto.get();
	}

}
