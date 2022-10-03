package com.femarket.categoria.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.femarket.categoria.dto.CategoriaDTO;
import com.femarket.categoria.form.CategoriaForm;
import com.femarket.categoria.model.Categoria;
import com.femarket.categoria.repository.CategoriaRepository;
import com.femarket.exception.model.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
		List<Categoria> categorias = this.categoriaRepository.findAll();
		return ResponseEntity.ok(CategoriaDTO.converter(categorias));
	}

	public ResponseEntity<CategoriaDTO> listarCategoria(Long idCategoria) {
		Categoria categoria = this.buscarCategoria(idCategoria);
		return ResponseEntity.ok(new CategoriaDTO(categoria));
	}

	public ResponseEntity<CategoriaDTO> cadastrarCategoria(CategoriaForm formulario) {
		Categoria categoria = new Categoria();
		categoria.setDescricao(formulario.getDescricao());
		categoriaRepository.save(categoria);
		return ResponseEntity.ok(new CategoriaDTO(categoria));
	}

	@Transactional
	public ResponseEntity<CategoriaDTO> atualizarCategoria(Long idCategoria, CategoriaForm formulario) {
		Categoria categoria = this.buscarCategoria(idCategoria);
		categoria.setDescricao(formulario.getDescricao());
		return ResponseEntity.ok(new CategoriaDTO(categoria));
		
	}

	@Transactional
	public ResponseEntity<CategoriaDTO> deletarCategoria(Long idCategoria) {
		Categoria categoria = this.buscarCategoria(idCategoria);
		this.categoriaRepository.deleteById(categoria.getId());
		return ResponseEntity.ok().build();
	}

	public Categoria buscarCategoria(Long idCategoria) {
		Optional<Categoria> optionalCategoria = this.categoriaRepository.findById(idCategoria);
		if (!optionalCategoria.isPresent()) {
			throw new ObjetoNaoEncontradoException("Categoria com id "+idCategoria + " não encontrada!");
		}
		return optionalCategoria.get();
	}
	
}
