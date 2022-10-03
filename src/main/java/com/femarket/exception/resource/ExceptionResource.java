package com.femarket.exception.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.femarket.exception.dto.ErroDeValidacaoDeFormularioDTO;
import com.femarket.exception.dto.ErroPadraoDTO;
import com.femarket.exception.model.EstoqueInsuficienteException;
import com.femarket.exception.model.ObjetoNaoEncontradoException;

@RestControllerAdvice
public class ExceptionResource {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErroDeValidacaoDeFormularioDTO>> formularioInvalido(MethodArgumentNotValidException exception){
		List<ErroDeValidacaoDeFormularioDTO> errosDeValidacao = new ArrayList<>();
		for(FieldError fieldError: exception.getBindingResult().getFieldErrors()) {
			errosDeValidacao.add(
					new ErroDeValidacaoDeFormularioDTO(fieldError.getField(), fieldError.getDefaultMessage()));			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errosDeValidacao);
	}
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ErroPadraoDTO> formularioInvalido(ObjetoNaoEncontradoException exception){
		ErroPadraoDTO erro = new ErroPadraoDTO(exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(EstoqueInsuficienteException.class)
	public ResponseEntity<ErroPadraoDTO> formularioInvalido(EstoqueInsuficienteException exception){
		ErroPadraoDTO erro = new ErroPadraoDTO(exception.getMessage());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
	}
	
}
