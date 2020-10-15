package by.it.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "employees_personal_info")
public class EmployeePersonalInfo {

    @Id
    @GeneratedValue
    private long id;


    @Enumerated(EnumType.STRING)
    @Column (name = "employee_status", length = 50)
    private EmployeeStatus employeeStatus;


    @Column(name = "number_passport", length = 25)
    private String numberPassport;


    @Embedded
    private Address address;


    @OneToOne (mappedBy = "personalInfo", fetch = FetchType.LAZY)
    private Employee employee;


}
