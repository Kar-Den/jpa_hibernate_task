package by.it.model;


import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@ToString
@Setter
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String surName;

    private int age;

    @OneToOne(orphanRemoval = true)
//    @JoinColumn (name = "personal_info_id", referencedColumnName = "id")
    private EmployeePersonalInfo personalInfo;

    public Employee() {
    }

    public Employee(long id, String name, String surName, int age, EmployeePersonalInfo personalInfo) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.personalInfo = personalInfo;
    }

}
