package by.it.model;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private long id;


    @Column (length = 50)
    private String name;


    @Column (name = "sur_name", length = 50)
    private String surName;

    private int age;

    private boolean external;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private EmployeePersonalInfo personalInfo;


}
