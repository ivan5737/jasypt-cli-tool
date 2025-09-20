package com.security.jasyptcli;

import com.security.jasyptcli.console.ConsolePrompt;
import com.security.jasyptcli.constants.Constants;
import com.security.jasyptcli.exception.JasyptCliException;
import com.security.jasyptcli.exception.constants.ErrorCode;
import com.security.jasyptcli.model.JasyptRequest;
import com.security.jasyptcli.service.JasyptCliService;
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
      JasyptRequest jasyptRequest = CONSOLE_PROMPT.getJasyptRequest();
      String result = JASYPT_SERVICE.process(jasyptRequest);

      SCAN_LOG.info("✅ Resultado: {}", result);
      System.exit(Constants.ZERO);

    } catch (JasyptCliException e) {
      log.error("❌ [{}] {}",
              e.getErrorCode().getId(),
              e.getMessage());
      System.exit(e.getErrorCode().getId());

    } catch (Exception e) {
      log.error("❌ [{}] {} Detalle {}",
              ErrorCode.UNEXPECTED_ERROR.getId(),
              ErrorCode.UNEXPECTED_ERROR.getDescription(),
              e.getMessage());
      System.exit(ErrorCode.UNEXPECTED_ERROR.getId());
    }
  }

}