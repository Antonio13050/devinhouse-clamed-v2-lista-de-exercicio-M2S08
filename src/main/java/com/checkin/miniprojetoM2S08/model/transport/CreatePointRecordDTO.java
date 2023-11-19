package com.checkin.miniprojetoM2S08.model.transport;

import com.checkin.miniprojetoM2S08.model.enums.RegisterType;
import jakarta.validation.constraints.NotNull;

public record CreatePointRecordDTO(@NotNull RegisterType type){
}
