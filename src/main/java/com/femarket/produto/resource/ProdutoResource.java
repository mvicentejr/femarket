package com.femarket.produto.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.femarket.produto.dto.ProdutoDTO;
import com.femarket.produto.form.ProdutoForm;
import com.femarket.produto.service.ProdutoService;

@RequestMapping("/produto")
@RestController
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
		return this.produtoService.listarProdutos();
	}
	
	@GetMapping("/{idProduto}")
	public ResponseEntity<ProdutoDTO> listarProduto(@PathVariable Long idProduto){
		return this.produtoService.listarProduto(idProduto);
	}
	
	@GetMapping("/categoria/{idCategoria}")
	public ResponseEntity<List<ProdutoDTO>> listarProdutosDaCategoria(@PathVariable Long idCategoria){
		return this.produtoService.listarProdutosDaCategoria(idCategoria);
	}
	
	@GetMapping("/estoque-baixo")
	public ResponseEntity<List<ProdutoDTO>> listarProdutosEstoqueBaixo(){
		return this.produtoService.listarProdutosEstoqueBaixo();
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> cadastrarProduto(@Valid @RequestBody ProdutoForm produtoForm){
		return this.produtoService.cadastrarProduto(produtoForm);
	}
	
	@PutMapping("/{idProduto}")
	public ResponseEntity<ProdutoDTO> atualizarProduto(@RequestBody ProdutoForm produtoForm, @PathVariable Long idProduto){
		return this.produtoService.atualizarProduto(produtoForm, idProduto);
	}
	
	@DeleteMapping("/{idProduto}")
	public ResponseEntity<ProdutoDTO> deletarProduto(@PathVariable Long idProduto){
		return this.produtoService.deletarProduto(idProduto);
	}
	
	@DeleteMapping("/categoria/{idCategoria}")
	public ResponseEntity<ProdutoDTO> deletarProdutosDaCategoria(@PathVariable Long idCategoria){
		return this.produtoService.deletarProdutosDaCategoria(idCategoria);
	}
	
}
