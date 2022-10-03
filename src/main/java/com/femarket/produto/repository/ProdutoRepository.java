package com.femarket.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.femarket.produto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByCategoria_Id(Long idCategoria);
	List<Produto> findByQtdEstoqueLessThan(Long qtdEstoqueBaixo);
	void deleteByCategoria_Id(Long idCategoria);
	
	List<Produto> findByIdIn(List<Long> idProdutos);
}
