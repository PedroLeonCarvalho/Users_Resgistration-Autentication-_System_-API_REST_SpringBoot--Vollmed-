package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.domain.ValidacaoException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleError400 (MethodArgumentNotValidException ex) {
      var errors = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacao::new).toList());

    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity tratarErroRegraDeNegocio (ValidacaoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());

    }
    private record DadosErroValidacao (String campo, String mensagem){
        public DadosErroValidacao (FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }


    }

}
