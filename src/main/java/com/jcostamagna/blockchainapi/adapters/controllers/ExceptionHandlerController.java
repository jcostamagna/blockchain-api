package com.jcostamagna.blockchainapi.adapters.controllers;

import com.jcostamagna.blockchainapi.adapters.exceptions.BadRequestException;
import com.jcostamagna.blockchainapi.adapters.exceptions.ClientExeption;
import com.jcostamagna.blockchainapi.adapters.response.ResponseError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

  private final Logger logger = LogManager.getLogger(ExceptionHandlerController.class);

  @ExceptionHandler(BadRequestException.class)
  protected ResponseEntity<ResponseError> handleRestClientException(BadRequestException exception) {
    logger.error(exception);

    ResponseError response =
        buildResponseError("Bad Request", exception.getMessage(), HttpStatus.BAD_REQUEST.value());

    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(ClientExeption.class)
  protected ResponseEntity<ResponseError> handleClientException(ClientExeption exception) {
    logger.error(exception);

    ResponseError response =
        buildResponseError(
            "Client exception", exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());

    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity handleException(Exception exception) {
    logger.error(exception);

    ResponseError response =
        buildResponseError(
            "Internal Server Error",
            exception.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR.value());

    return ResponseEntity.internalServerError().body(response);
  }

  private ResponseError buildResponseError(String error, String message, int status) {
    return ResponseError.builder().error(error).message(message).status(status).build();
  }
}
