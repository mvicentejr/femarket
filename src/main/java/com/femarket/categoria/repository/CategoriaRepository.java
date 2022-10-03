package com.femarket.categoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.femarket.categoria.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
