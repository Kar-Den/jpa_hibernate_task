package by.it.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private long id;

    private String name;

    private String surName;

    private Character age;

    @OneToOne
    private EmployeePersonalInfo personalInfo;

}
