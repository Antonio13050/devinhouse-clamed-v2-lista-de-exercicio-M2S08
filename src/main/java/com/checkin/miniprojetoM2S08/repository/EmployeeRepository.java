package com.checkin.miniprojetoM2S08.repository;

import com.checkin.miniprojetoM2S08.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
