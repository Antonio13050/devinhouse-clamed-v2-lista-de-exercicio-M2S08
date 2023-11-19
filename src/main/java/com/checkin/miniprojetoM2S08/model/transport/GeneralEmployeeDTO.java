package com.checkin.miniprojetoM2S08.model.transport;

import com.checkin.miniprojetoM2S08.model.Employee;

import java.math.BigDecimal;

public record GeneralEmployeeDTO(Long id, String name, String office, BigDecimal wage) {
    public GeneralEmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getOffice(), employee.getWage());
    }
}
