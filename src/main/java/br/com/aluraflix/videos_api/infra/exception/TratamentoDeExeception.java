package br.com.aluraflix.videos_api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeExeception{

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tramentoError400(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tramentoErro400(MethodArgumentNotValidException methodArgumentNotValidException){
        var erro = methodArgumentNotValidException.getFieldErrors();
        return ResponseEntity.badRequest().body(erro.stream().map(DadosErroValidacao::new).toList());
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity tratemento400(ValidacaoException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    public record DadosErroValidacao(String campo,String mensagem){
        public DadosErroValidacao(FieldError error){
           this(error.getField(), error.getDefaultMessage());
        }

    }

}
