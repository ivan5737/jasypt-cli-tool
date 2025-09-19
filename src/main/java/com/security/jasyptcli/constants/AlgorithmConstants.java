package com.security.jasyptcli.constants;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.NoArgsConstructor;

/**
 * Constantes relacionadas con los algoritmos de cifrado.
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class AlgorithmConstants {

  // 🔐 Algoritmos clásicos
  public static final String PBE_WITH_MD5_AND_DES = "PBEWithMD5AndDES";
  public static final String PBE_WITH_MD5_AND_TRIPLE_DES = "PBEWithMD5AndTripleDES";
  public static final String PBE_WITH_SHA1_AND_DESEDE = "PBEWithSHA1AndDESede";
  public static final String PBE_WITH_SHA1_AND_RC2_40 = "PBEWithSHA1AndRC2_40";

  // 🔐 Algoritmos SHA-256 con AES (BouncyCastle)
  public static final String PBE_WITH_SHA256_AND_AES_128 = "PBEWITHSHA256AND128BITAES-CBC-BC";
  public static final String PBE_WITH_SHA256_AND_AES_192 = "PBEWITHSHA256AND192BITAES-CBC-BC";
  public static final String PBE_WITH_SHA256_AND_AES_256 = "PBEWITHSHA256AND256BITAES-CBC-BC";

  // 🔐 Algoritmos SHA-1 con AES (BouncyCastle)
  public static final String PBE_WITH_SHA1_AND_AES_128 = "PBEWITHSHA1AND128BITAES-CBC-BC";
  public static final String PBE_WITH_SHA1_AND_AES_192 = "PBEWITHSHA1AND192BITAES-CBC-BC";
  public static final String PBE_WITH_SHA1_AND_AES_256 = "PBEWITHSHA1AND256BITAES-CBC-BC";

  /**
   * Mapa inmutable que contiene las opciones de algoritmos disponibles.
   * La clave es un entero que representa la opción, y el valor es el nombre del algoritmo.
   */
  public static final Map<Integer, String> ALGORITHM_OPTIONS;

  static {
    Map<Integer, String> map = new LinkedHashMap<>();
    map.put(1, PBE_WITH_MD5_AND_DES);
    map.put(2, PBE_WITH_MD5_AND_TRIPLE_DES);
    map.put(3, PBE_WITH_SHA1_AND_DESEDE);
    map.put(4, PBE_WITH_SHA1_AND_RC2_40);
    map.put(5, PBE_WITH_SHA256_AND_AES_128);
    map.put(6, PBE_WITH_SHA256_AND_AES_192);
    map.put(7, PBE_WITH_SHA256_AND_AES_256);
    map.put(8, PBE_WITH_SHA1_AND_AES_128);
    map.put(9, PBE_WITH_SHA1_AND_AES_192);
    map.put(10, PBE_WITH_SHA1_AND_AES_256);
    ALGORITHM_OPTIONS = Collections.unmodifiableMap(map);
  }
}
