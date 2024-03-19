package br.com.ediwaldoneto.fastdelivery.infrastructure.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateEmailException(DuplicateEmailException ex,
			HttpServletRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setMessage(ex.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex,
			HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setMessage(ex.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(GeneralException ex, HttpServletRequest request) {

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setMessage(ex.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(UpdateFailedException.class)
	public ResponseEntity<ErrorResponse> handleUpdateFailedException(UpdateFailedException ex,
			HttpServletRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setMessage(ex.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
}
