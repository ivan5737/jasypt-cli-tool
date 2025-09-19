package com.security.jasyptcli.constants;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.NoArgsConstructor;

/**
 * Constantes relacionadas con las operaciones de cifrado y descifrado.
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class OperationConstants {

  /**
   * Mapa inmutable que contiene las opciones de operaciones disponibles.
   * La clave es un entero que representa la opción, y el valor es la descripción de la operación.
   */
  public static final Map<Integer, String> OPERATION_OPTIONS;

  static {
    Map<Integer, String> map = new LinkedHashMap<>();
    map.put(1, "🔐 Cifrar");
    map.put(2, "🔓 Descifrar");
    OPERATION_OPTIONS = Collections.unmodifiableMap(map);
  }
}
