package com.security.jasyptcli.exception;

import com.security.jasyptcli.exception.constants.ErrorCode;
import lombok.Getter;

/**
 * Excepción personalizada para errores en la aplicación Jasypt CLI.
 */
@Getter
public class JasyptCliException extends RuntimeException {

  /**
   * Código de error asociado a la excepción.
   */
  private final ErrorCode errorCode;

  /**
   * Constructor de la excepción con el código de error.
   *
   * @param errorCode Código de error asociado a la excepción.
   */
  public JasyptCliException(ErrorCode errorCode) {
    super(errorCode.getDescription());
    this.errorCode = errorCode;
  }

  /**
   * Constructor de la excepción con el código de error y un mensaje adicional.
   *
   * @param errorCode Código de error asociado a la excepción.
   * @param message   Mensaje adicional para proporcionar más contexto.
   */
  public JasyptCliException(ErrorCode errorCode, String message) {
    super(errorCode.getDescription() + " Detalle: " + message);
    this.errorCode = errorCode;
  }
}
