package by.it.model;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
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

    private boolean external;

}
