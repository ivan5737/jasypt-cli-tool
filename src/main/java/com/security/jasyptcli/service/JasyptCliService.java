package com.security.jasyptcli.service;

import com.security.jasyptcli.constants.AlgorithmConstants;
import com.security.jasyptcli.constants.OperationConstants;
import com.security.jasyptcli.exception.JasyptCliException;
import com.security.jasyptcli.exception.constants.ErrorCode;
import com.security.jasyptcli.util.JasyptUtils;
import java.security.Security;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * Servicio para operaciones de cifrado y descifrado usando JASYPT.
 */
@Slf4j
public class JasyptCliService {

  public JasyptCliService() {
    Security.addProvider(new BouncyCastleProvider());
  }

  /**
   * Procesa la operación de cifrado o descifrado según los parámetros dados.
   *
   * @param operation Operación a realizar ("encrypt" o "decrypt").
   * @param algorithm Algoritmo de cifrado a usar.
   * @param password  Clave maestra para el cifrado/descifrado.
   * @param input     Texto a cifrar o descifrar.
   * @return Resultado de la operación (texto cifrado o descifrado).
   * @throws JasyptCliException Sí hay errores en los parámetros o durante la operación.
   */
  public String process(String operation, String algorithm, String password, String input) {
    if (operation == null || operation.isBlank()) {
      throw new JasyptCliException(ErrorCode.INVALID_OPERATION, "Operación vacía o nula");
    }
    if (!AlgorithmConstants.ALGORITHM_OPTIONS.containsValue(algorithm)) {
      throw new JasyptCliException(ErrorCode.INVALID_ALGORITHM, algorithm);
    }
    if (password == null || password.isBlank()) {
      throw new JasyptCliException(ErrorCode.MISSING_PASSWORD);
    }
    if (input == null || input.isBlank()) {
      throw new JasyptCliException(ErrorCode.MISSING_TEXT);
    }

    return switch (operation) {
      case OperationConstants.ENCRYPT -> JasyptUtils.encrypt(algorithm, password, input);
      case OperationConstants.DECRYPT -> JasyptUtils.decrypt(algorithm, password, input);
      default -> throw new JasyptCliException(ErrorCode.INVALID_OPERATION, operation);
    };
  }

}
