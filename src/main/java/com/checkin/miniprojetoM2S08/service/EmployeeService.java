package com.checkin.miniprojetoM2S08.service;

import com.checkin.miniprojetoM2S08.model.Employee;
import com.checkin.miniprojetoM2S08.model.PointRecord;
import com.checkin.miniprojetoM2S08.model.transport.*;
import com.checkin.miniprojetoM2S08.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public GeneralEmployeeDTO create(CreateEmployeeDTO body){
        LOGGER.info("Iniciando a criação de um employee");
        Employee newEmployee = this.employeeRepository.save(new Employee(body));
        return new GeneralEmployeeDTO(newEmployee);
    }

    public Page<GeneralEmployeeDTO> listAll(Pageable pageable){
        return this.employeeRepository.findAll(pageable).map(GeneralEmployeeDTO::new);
    }

    public DetailedEmployeeDTO getEmployee(Long id){
        return this.employeeRepository.findById(id).map(DetailedEmployeeDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));
    }

    @Transactional
    public PointRecordDTO createPointRecord(Long id, CreatePointRecordDTO body){
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));

        PointRecord pointRecord = new PointRecord(body.type(), employee);
        employee.getPointRecords().add(pointRecord);

        return new PointRecordDTO(pointRecord);
    }
}
