package com.femarket.venda.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.femarket.venda.dto.VendaDTO;
import com.femarket.venda.form.VendaForm;
import com.femarket.venda.service.VendaService;

@RequestMapping("/venda")
@RestController
public class VendaResource {

	@Autowired
	private VendaService vendaService;
	
	@GetMapping
	public ResponseEntity<List<VendaDTO>> listarVendas(){
		return this.vendaService.listarVendas();
	}
	
	@GetMapping("/{idVenda}")
	public ResponseEntity<VendaDTO> listarVenda(@PathVariable Long idVenda){
		return this.vendaService.listarVenda(idVenda);
	}
	
	@PostMapping
	public ResponseEntity<VendaDTO> cadastrarVenda(@Valid @RequestBody VendaForm vendaForm){
		return this.vendaService.cadastrarVenda(vendaForm);
	}
}
