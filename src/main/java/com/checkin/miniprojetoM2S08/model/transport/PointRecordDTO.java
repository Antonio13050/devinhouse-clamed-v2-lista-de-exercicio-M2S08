package com.checkin.miniprojetoM2S08.model.transport;

import com.checkin.miniprojetoM2S08.model.PointRecord;
import com.checkin.miniprojetoM2S08.model.enums.RegisterType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record PointRecordDTO(Long id, @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime registeredAt, RegisterType type) {

    public PointRecordDTO(PointRecord pointRecord) {
        this(pointRecord.getId(), pointRecord.getRegisteredAt(), pointRecord.getType());
    }
}
