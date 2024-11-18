package br.com.aluraflix.videos_api.infra.exception;

public class ValidacaoException extends RuntimeException {

 public ValidacaoException(String mensagem){
     super(mensagem);
 }
}
