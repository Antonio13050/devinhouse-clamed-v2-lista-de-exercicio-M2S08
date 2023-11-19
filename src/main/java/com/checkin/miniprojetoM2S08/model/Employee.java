package com.checkin.miniprojetoM2S08.model;

import com.checkin.miniprojetoM2S08.model.transport.CreateEmployeeDTO;
import com.checkin.miniprojetoM2S08.model.transport.PointRecordDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String office;

    @Column(nullable = false)
    private BigDecimal wage;

    @OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<PointRecord> pointRecords = new ArrayList<>();

    public Employee() {
    }

    public Employee(CreateEmployeeDTO body) {
        this.name = body.name();
        this.office = body.office();
        this.wage = body.wage();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOffice() {
        return office;
    }

    public BigDecimal getWage() {
        return wage;
    }

    public List<PointRecord> getPointRecords() {
        return pointRecords;
    }

    public List<PointRecordDTO> getPointRecordsAsObject() {
        return this.pointRecords.stream().map(PointRecordDTO::new).toList();
    }
}
