package com.security.jasyptcli.service;

import com.security.jasyptcli.constants.AlgorithmConstants;
import com.security.jasyptcli.constants.OperationConstants;
import com.security.jasyptcli.exception.JasyptCliException;
import com.security.jasyptcli.exception.constants.ErrorCode;
import com.security.jasyptcli.model.JasyptRequest;
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
   * Procesa la solicitud de cifrado o descifrado.
   *
   * @param jasyptRequest La solicitud que contiene los detalles de la operación.
   * @return El texto cifrado o descifrado.
   * @throws JasyptCliException Si hay un error en la solicitud o durante el proceso.
   */
  public String process(JasyptRequest jasyptRequest) {
    validateRequest(jasyptRequest);

    return switch (jasyptRequest.operation()) {
      case OperationConstants.ENCRYPT -> JasyptUtils.encrypt(jasyptRequest);
      case OperationConstants.DECRYPT -> JasyptUtils.decrypt(jasyptRequest);
      default ->
              throw new JasyptCliException(ErrorCode.INVALID_OPERATION, jasyptRequest.operation());
    };
  }

  private void validateRequest(JasyptRequest jasyptRequest) {
    if (jasyptRequest.operation() == null || jasyptRequest.operation().isBlank()) {
      throw new JasyptCliException(ErrorCode.INVALID_OPERATION, "Operación vacía o nula");
    }
    if (!AlgorithmConstants.ALGORITHM_OPTIONS.containsValue(jasyptRequest.algorithm())) {
      throw new JasyptCliException(ErrorCode.INVALID_ALGORITHM, jasyptRequest.algorithm());
    }
    if (jasyptRequest.password() == null || jasyptRequest.password().isBlank()) {
      throw new JasyptCliException(ErrorCode.MISSING_PASSWORD);
    }
    if (jasyptRequest.input() == null || jasyptRequest.input().isBlank()) {
      throw new JasyptCliException(ErrorCode.MISSING_TEXT);
    }
  }

}
