package com.checkin.miniprojetoM2S08.model.transport;

import com.checkin.miniprojetoM2S08.model.Employee;

import java.math.BigDecimal;
import java.util.List;

public record DetailedEmployeeDTO(Long id, String name, String office, BigDecimal wage, List<PointRecordDTO> records) {

    public DetailedEmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getOffice(), employee.getWage(), employee.getPointRecordsAsObject());
    }
}
