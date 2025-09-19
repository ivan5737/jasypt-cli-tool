package com.security.jasyptcli.service;

import com.security.jasyptcli.constants.Constants;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import javax.crypto.Cipher;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servicio para operaciones de cifrado y descifrado usando JASYPT.
 */
@Slf4j
public class JasyptCliService {

  /**
   * Logger específico para interacciones con el usuario en la consola.
   */
  private static final Logger SCAN_LOG = LoggerFactory.getLogger(Constants.PRINTLN_LOGGER_NAME);

  /**
   * Solicita al usuario que seleccione una opción de un mapa dado.
   *
   * @param scanner       Scanner para leer la entrada del usuario.
   * @param options       Mapa de opciones disponibles (clave: número, valor: descripción).
   * @param promptMessage Mensaje para solicitar la entrada al usuario.
   * @return Opción seleccionada por el usuario.
   */
  public int promptSelectionFromMap(Scanner scanner, Map<Integer, String> options,
                                    String promptMessage) {
    int min = Collections.min(options.keySet());
    int max = Collections.max(options.keySet());
    String errorMessage = String.format("❌ Valor inválido. Solo se permite %d️⃣ a %d️⃣.", min, max);
    return readValidOption(scanner, min, max, promptMessage, errorMessage);
  }

  /**
   * Lee una opción válida del usuario dentro de un rango específico.
   *
   * @param scanner  Scanner para leer la entrada del usuario.
   * @param min      Valor mínimo permitido (inclusive).
   * @param max      Valor máximo permitido (inclusive).
   * @param prompt   Mensaje para solicitar la entrada al usuario.
   * @param errorMsg Mensaje de error en caso de entrada inválida.
   * @return Opción válida ingresada por el usuario.
   */
  private int readValidOption(Scanner scanner, int min, int max, String prompt, String errorMsg) {
    int choice;
    while (true) {
      SCAN_LOG.info(prompt);
      if (scanner.hasNextInt()) {
        choice = scanner.nextInt();
        scanner.nextLine();
        if (choice >= min && choice <= max) {
          break;
        }
      } else {
        scanner.nextLine();
      }
      SCAN_LOG.warn(errorMsg);
    }
    return choice;
  }

  /**
   * Cifra una cadena de texto usando JASYPT.
   *
   * @param input     Texto a cifrar.
   * @param password  Clave maestra para el cifrado.
   * @param algorithm Algoritmo de cifrado a usar.
   * @return Texto cifrado en base64.
   */
  public String encrypt(String input, String password, String algorithm) {
    StandardPBEStringEncryptor encryptor = createEncryptor(password, algorithm);
    return encryptor.encrypt(input);
  }

  /**
   * Descifra una cadena de texto cifrada usando JASYPT.
   *
   * @param input     Texto cifrado en base64.
   * @param password  Clave maestra para el descifrado.
   * @param algorithm Algoritmo de cifrado usado originalmente.
   * @return Texto descifrado.
   */
  public String decrypt(String input, String password, String algorithm) {
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
  private StandardPBEStringEncryptor createEncryptor(String password, String algorithm) {
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
  private boolean isAlgorithmAvailable(String algorithm) {
    try {
      Cipher.getInstance(algorithm, "BC");
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
