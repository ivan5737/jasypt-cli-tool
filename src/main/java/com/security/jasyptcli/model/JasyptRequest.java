package com.security.jasyptcli.model;

import lombok.Builder;

@Builder
public record JasyptRequest(
        String operation,
        String algorithm,
        String password,
        String input
) {
}
