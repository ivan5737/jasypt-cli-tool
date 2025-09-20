package com.security.jasyptcli.console;

import com.security.jasyptcli.constants.AlgorithmConstants;
import com.security.jasyptcli.constants.Constants;
import com.security.jasyptcli.constants.OperationConstants;
import com.security.jasyptcli.model.JasyptRequest;
import java.io.Console;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsolePrompt {

  /**
   * Logger específico para interacciones con el usuario en la consola.
   */
  private static final Logger SCAN_LOG = LoggerFactory.getLogger(Constants.PRINTLN_LOGGER_NAME);

  /**
   * Scanner para leer la entrada del usuario desde la consola.
   */
  private final Scanner scanner = new Scanner(System.in);

  public JasyptRequest getJasyptRequest() {
    // 🔑 Contraseña segura
    String password = promptPassword();

    // 📦 Algoritmo
    SCAN_LOG.info(Constants.PROMPT_ALGORITHM);
    AlgorithmConstants.ALGORITHM_OPTIONS.forEach((key, value) ->
            SCAN_LOG.info(Constants.LIST, key, value));
    int choiceAlgorithm = promptSelectionFromMap(
            AlgorithmConstants.ALGORITHM_OPTIONS,
            Constants.PROMPT_MSG_ALGORITHM);
    String algorithm = AlgorithmConstants.ALGORITHM_OPTIONS.get(choiceAlgorithm);
    SCAN_LOG.info(Constants.SELECTED, algorithm);

    // 🔄 Operación
    SCAN_LOG.info(Constants.PROMPT_OPERATION);
    OperationConstants.OPERATION_OPTIONS.forEach((key, value) ->
            SCAN_LOG.info(Constants.LIST, key, value));
    int choiceOperation = promptSelectionFromMap(
            OperationConstants.OPERATION_OPTIONS,
            Constants.PROMPT_MSG_OPERATION);
    String operation = OperationConstants.OPERATION_OPTIONS.get(choiceOperation);
    SCAN_LOG.info(Constants.SELECTED, operation);

    // 📝 Input
    SCAN_LOG.info(Constants.PROMPT_TEXT);
    String input = scanner.nextLine();

    return new JasyptRequest(operation, algorithm, password, input);
  }

  /**
   * Solicita al usuario que seleccione una opción de un mapa dado.
   *
   * @param options       Mapa de opciones disponibles (clave: número, valor: descripción).
   * @param promptMessage Mensaje para solicitar la selección al usuario.
   * @return Opción seleccionada por el usuario.
   */
  private int promptSelectionFromMap(Map<Integer, String> options, String promptMessage) {
    int min = Collections.min(options.keySet());
    int max = Collections.max(options.keySet());
    String errorMessage = String.format(Constants.INVALID_OPTION, min, max);
    return readValidOption(min, max, promptMessage, errorMessage);
  }

  /**
   * Lee una opción válida del usuario dentro de un rango especificado.
   *
   * @param min      Valor mínimo permitido (inclusive).
   * @param max      Valor máximo permitido (inclusive).
   * @param prompt   Mensaje para solicitar la entrada al usuario.
   * @param errorMsg Mensaje de error en caso de entrada inválida.
   * @return Opción válida seleccionada por el usuario.
   */
  private int readValidOption(int min, int max, String prompt, String errorMsg) {
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
   * Solicita al usuario que ingrese una contraseña de manera segura.
   *
   * @return Contraseña ingresada por el usuario.
   */
  private String promptPassword() {
    Console console = System.console();
    if (console != null) {
      char[] passwordChars = console.readPassword(Constants.PROMPT_PASSWORD);
      return new String(passwordChars);
    } else {
      SCAN_LOG.info(Constants.PROMPT_PASSWORD);
      return scanner.nextLine();
    }
  }
}
