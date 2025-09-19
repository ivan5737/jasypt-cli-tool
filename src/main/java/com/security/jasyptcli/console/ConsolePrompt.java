package com.security.jasyptcli.console;

import com.security.jasyptcli.constants.Constants;
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

  /**
   * Solicita al usuario que seleccione una opción de un mapa dado.
   *
   * @param options       Mapa de opciones disponibles (clave: número, valor: descripción).
   * @param promptMessage Mensaje para solicitar la entrada al usuario.
   * @return Opción seleccionada por el usuario.
   */
  public int promptSelectionFromMap(Map<Integer, String> options, String promptMessage) {
    int min = Collections.min(options.keySet());
    int max = Collections.max(options.keySet());
    String errorMessage = String.format("❌ Valor inválido. Solo se permite %d️ a %d️", min, max);
    return readValidOption(scanner, min, max, promptMessage, errorMessage);
  }

  /**
   * Lee una opción válida del usuario dentro de un rango especificado.
   *
   * @param scanner  Scanner para leer la entrada del usuario.
   * @param min      Valor mínimo permitido (inclusive).
   * @param max      Valor máximo permitido (inclusive).
   * @param prompt   Mensaje para solicitar la entrada al usuario.
   * @param errorMsg Mensaje de error en caso de entrada inválida.
   * @return Opción válida seleccionada por el usuario.
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
}
