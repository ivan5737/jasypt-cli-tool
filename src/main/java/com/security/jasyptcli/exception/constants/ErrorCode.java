package com.security.jasyptcli.exception.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Códigos de error utilizados en la aplicación Jasypt CLI.
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

  INVALID_OPERATION(1001, "Operación inválida. Usa 'Cifrar' o 'Descifrar'."),
  INVALID_ALGORITHM(1002, "Algoritmo no soportado. Usa --list para ver opciones."),
  MISSING_PASSWORD(1003, "La contraseña no puede estar vacía."),
  MISSING_TEXT(1004, "El texto a procesar no puede estar vacío."),
  UNEXPECTED_ERROR(9999, "Error inesperado en la ejecución.");

  /**
   * Código numérico del error.
   */
  private final int id;

  /**
   * Descripción del error.
   */
  private final String description;
}
