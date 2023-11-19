package com.checkin.miniprojetoM2S08.controller;

import com.checkin.miniprojetoM2S08.model.transport.*;
import com.checkin.miniprojetoM2S08.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<GeneralEmployeeDTO> create(@RequestBody @Valid CreateEmployeeDTO body){
        GeneralEmployeeDTO response = this.employeeService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<GeneralEmployeeDTO>> list(@PageableDefault(size = 12, sort = "name")Pageable pageable){
        Page<GeneralEmployeeDTO> response = this.employeeService.listAll(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedEmployeeDTO> getById(@PathVariable("id") Long id){
        DetailedEmployeeDTO response = this.employeeService.getEmployee(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/point-records")
    public ResponseEntity<PointRecordDTO> createPointRecord(@PathVariable("id") Long id, @RequestBody @Valid CreatePointRecordDTO body){
        PointRecordDTO response = this.employeeService.createPointRecord(id, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
