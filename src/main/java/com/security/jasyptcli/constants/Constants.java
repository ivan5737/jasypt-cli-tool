package com.security.jasyptcli.constants;

import lombok.NoArgsConstructor;

/**
 * Constantes generales utilizadas en la aplicación.
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Constants {

  /**
   * Mensaje para solicitar al usuario que elija un algoritmo.
   */
  public static final String PROMPT_MSG_ALGORITHM = "🔐 Elige un algoritmo:";

  /**
   * Mensaje para solicitar al usuario que elija una operación (cifrar o descifrar).
   */
  public static final String PROMPT_MSG_OPERATION = "🔐 Elige cifrar o descifrar:";

  /**
   * Nombre del logger utilizado para imprimir mensajes en la consola.
   */
  public static final String PRINTLN_LOGGER_NAME = "PromptLogger";

  /**
   * Constante que representa el valor cero.
   */
  public static final int ZERO = 0;

  // Mensajes de prompt
  public static final String PROMPT_PASSWORD = "🔐 Ingresa la clave maestra (JASYPT password): ";

  public static final String PROMPT_ALGORITHM = "📦 Selecciona un algoritmo:";

  public static final String PROMPT_OPERATION = "🔄 Selecciona la operación (Cifrar/Descifrar):";

  public static final String PROMPT_TEXT = "📝 Ingresa el texto a procesar:";

  public static final String LIST = "{} -> {}";

  public static final String SELECTED = "✅ Seleccionaste: {}";

  // Mensajes de validación
  public static final String INVALID_OPTION = "❌ Valor inválido. Solo se permite %d a %d";

}
