package com.security.jasyptcli.util;

import javax.crypto.Cipher;
import lombok.NoArgsConstructor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class JasyptUtils {

  /**
   * Cifra una cadena de texto usando JASYPT.
   *
   * @param algorithm Algoritmo de cifrado a usar.
   * @param password  Clave maestra para el cifrado.
   * @param input     Texto plano a cifrar.
   * @return Texto cifrado en base64.
   */
  public static String encrypt(String algorithm, String password, String input) {
    StandardPBEStringEncryptor encryptor = createEncryptor(password, algorithm);
    return encryptor.encrypt(input);
  }

  /**
   * Descifra una cadena de texto cifrado usando JASYPT.
   *
   * @param algorithm Algoritmo de cifrado a usar.
   * @param password  Clave maestra para el descifrado.
   * @param input     Texto cifrado en base64 a descifrar.
   * @return Texto plano descifrado.
   */
  public static String decrypt(String algorithm, String password, String input) {
    StandardPBEStringEncryptor encryptor = createEncryptor(password, algorithm);
    return encryptor.decrypt(input);
  }

  /**
   * Crea y configura un encriptado JASYPT con los parámetros dados.
   *
   * @param password  Clave maestra para el cifrado/descifrado.
   * @param algorithm Algoritmo de cifrado a usar.
   * @return Encriptado configurado.
   */
  private static StandardPBEStringEncryptor createEncryptor(String password, String algorithm) {
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword(password);
    encryptor.setAlgorithm(algorithm);
    encryptor.setKeyObtentionIterations(1000);
    if (isAlgorithmAvailable(algorithm)) {
      encryptor.setProviderName("BC");
    }
    return encryptor;
  }

  /**
   * Verifica si un algoritmo de cifrado está disponible en el entorno actual.
   *
   * @param algorithm Nombre del algoritmo a verificar.
   * @return true si el algoritmo está disponible, false en caso contrario.
   */
  private static boolean isAlgorithmAvailable(String algorithm) {
    try {
      Cipher.getInstance(algorithm, "BC");
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
