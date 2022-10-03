package com.femarket.categoria.resource;

import java.util.List;

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

import com.femarket.categoria.dto.CategoriaDTO;
import com.femarket.categoria.form.CategoriaForm;
import com.femarket.categoria.service.CategoriaService;

@RequestMapping("/categoria")
@RestController
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listarCategorias(){
		return this.categoriaService.listarCategorias();
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<CategoriaDTO> listarCategoria (@PathVariable Long idCategoria) {
		return this.categoriaService.listarCategoria(idCategoria);
	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> cadastrarCategoria(@RequestBody CategoriaForm formulario){
		return this.categoriaService.cadastrarCategoria(formulario);
	}
	
	@PutMapping("/{idCategoria}")
	public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long idCategoria, @RequestBody CategoriaForm formulario){
		return this.categoriaService.atualizarCategoria(idCategoria, formulario);
	}
	
	@DeleteMapping("/{idCategoria}")
	public ResponseEntity<CategoriaDTO> deletarCategoria(@PathVariable Long idCategoria){
		return this.categoriaService.deletarCategoria(idCategoria);
	}
	
}
