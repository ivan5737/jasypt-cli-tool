package com.security.jasyptcli;

import com.security.jasyptcli.console.ConsolePrompt;
import com.security.jasyptcli.constants.AlgorithmConstants;
import com.security.jasyptcli.constants.Constants;
import com.security.jasyptcli.constants.OperationConstants;
import com.security.jasyptcli.exception.JasyptCliException;
import com.security.jasyptcli.exception.constants.ErrorCode;
import com.security.jasyptcli.service.JasyptCliService;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Herramienta CLI para cifrado y descifrado usando JASYPT.
 */
@Slf4j
public class JasyptCliTool {

  /**
   * Logger específico para interacciones con el usuario en la consola.
   */
  private static final Logger SCAN_LOG = LoggerFactory.getLogger(Constants.PRINTLN_LOGGER_NAME);

  /**
   * Manejador de prompts en consola.
   */
  private static final ConsolePrompt CONSOLE_PROMPT = new ConsolePrompt();

  /**
   * Servicio para operaciones de cifrado y descifrado.
   */
  private static final JasyptCliService JASYPT_SERVICE = new JasyptCliService();

  /**
   * Punto de entrada de la aplicación.
   *
   * @param args Argumentos de línea de comandos (no utilizados).
   */
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);

      SCAN_LOG.info("🔐 Ingresa la clave maestra (JASYPT password): ");
      String password = scanner.nextLine();


      SCAN_LOG.info("📦 Algoritmos disponibles:");
      AlgorithmConstants.ALGORITHM_OPTIONS.forEach((key, value) ->
              SCAN_LOG.info("{} -> {}", key, value));
      int choiceAlgorithm = CONSOLE_PROMPT.promptSelectionFromMap(
              AlgorithmConstants.ALGORITHM_OPTIONS,
              Constants.PROMPT_MSG_ALGORITHM);
      String algorithm = AlgorithmConstants.ALGORITHM_OPTIONS.get(choiceAlgorithm);
      SCAN_LOG.info("✅ Seleccionaste: {}", algorithm);


      SCAN_LOG.info("🔄 ¿Qué deseas realizar?");
      OperationConstants.OPERATION_OPTIONS.forEach((key, value) ->
              SCAN_LOG.info("{} -> {}", key, value));
      int choiceOperation = CONSOLE_PROMPT.promptSelectionFromMap(
              OperationConstants.OPERATION_OPTIONS,
              Constants.PROMPT_MSG_OPERATION);
      String operation = OperationConstants.OPERATION_OPTIONS.get(choiceOperation);
      SCAN_LOG.info("✅ Seleccionaste: {}", operation);


      SCAN_LOG.info("🔑 Ingresa el texto:");
      String input = scanner.nextLine();


      String result = JASYPT_SERVICE.process(operation, algorithm, password, input);

      SCAN_LOG.info("✅ Resultado: {}", result);
      System.exit(Constants.ZERO);

    } catch (JasyptCliException e) {
      SCAN_LOG.error("❌ [{}] {}", e.getErrorCode().getId(), e.getMessage());
      System.exit(e.getErrorCode().getId());

    } catch (Exception e) {
      SCAN_LOG.error("❌ [{}] {} Detalle {}", ErrorCode.UNEXPECTED_ERROR.getId(),
              ErrorCode.UNEXPECTED_ERROR.getDescription(), e.getMessage());
      System.exit(ErrorCode.UNEXPECTED_ERROR.getId());
    }
  }

}