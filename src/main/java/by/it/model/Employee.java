package by.it.model;

import lombok.*;
import javax.persistence.*;

@EqualsAndHashCode (exclude = "personalInfo")
@NoArgsConstructor
@AllArgsConstructor
@ToString (exclude = "personalInfo")
@Data
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true)
    private long id;


    @Column (length = 50)
    private String name;


    @Column (name = "sur_name", length = 50)
    private String surName;

    private int age;

    private boolean external;


    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private EmployeePersonalInfo personalInfo;


}
