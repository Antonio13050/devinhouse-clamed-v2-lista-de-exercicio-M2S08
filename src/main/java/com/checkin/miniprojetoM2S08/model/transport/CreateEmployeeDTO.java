package com.checkin.miniprojetoM2S08.model.transport;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateEmployeeDTO(@NotBlank String name, @NotBlank String office, @NotNull BigDecimal wage) {
}
