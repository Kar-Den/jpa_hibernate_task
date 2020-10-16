package by.it.model;


import lombok.*;

import javax.persistence.*;

//@EqualsAndHashCode(exclude = "personalInfo")
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Setter
//@Getter
@Data
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column (length = 50)
    private String name;


    @Column (name = "sur_name", length = 50)
    private String surName;


    private boolean external;

    private int age;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private EmployeePersonalInfo personalInfo;


}
