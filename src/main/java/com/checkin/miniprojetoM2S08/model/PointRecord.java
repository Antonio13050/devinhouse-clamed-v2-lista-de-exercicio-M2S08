package com.checkin.miniprojetoM2S08.model;

import com.checkin.miniprojetoM2S08.model.enums.RegisterType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class PointRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime registeredAt;

    @Enumerated(EnumType.STRING)
    private RegisterType type;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private Employee employee;

    public PointRecord() {
    }

    public PointRecord(RegisterType type, Employee employee) {
        this.registeredAt = LocalDateTime.now();
        this.type = type;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public RegisterType getType() {
        return type;
    }

    public Employee getEmployee() {
        return employee;
    }
}
