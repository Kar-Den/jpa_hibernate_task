package by.it.model;


import lombok.Builder;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private long id;

    private String name;

    private String surName;

    private int age;

    @OneToOne
//    @JoinColumn (name = "personal_info_id", referencedColumnName = "id")
    private EmployeePersonalInfo personalInfo;

}
