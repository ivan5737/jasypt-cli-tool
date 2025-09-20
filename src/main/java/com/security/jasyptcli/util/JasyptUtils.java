package com.security.jasyptcli.util;

import com.security.jasyptcli.model.JasyptRequest;
import javax.crypto.Cipher;
import lombok.NoArgsConstructor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class JasyptUtils {

  /**
   * Cifra una cadena de texto plano usando JASYPT.
   *
   * @param jasyptRequest La solicitud que contiene los detalles de la operación.
   * @return Texto cifrado en base64.
   */
  public static String encrypt(JasyptRequest jasyptRequest) {
    StandardPBEStringEncryptor encryptor =
            createEncryptor(jasyptRequest.password(), jasyptRequest.algorithm());
    return encryptor.encrypt(jasyptRequest.input());
  }

  /**
   * Descifra una cadena de texto cifrado usando JASYPT.
   *
   * @param jasyptRequest La solicitud que contiene los detalles de la operación.
   * @return Texto plano descifrado.
   */
  public static String decrypt(JasyptRequest jasyptRequest) {
    StandardPBEStringEncryptor encryptor =
            createEncryptor(jasyptRequest.password(), jasyptRequest.algorithm());
    return encryptor.decrypt(jasyptRequest.input());
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
