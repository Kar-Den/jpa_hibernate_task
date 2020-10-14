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
    private EmployeeStatus employeeStatus;

    private String numberPassport;

    @Embedded
    private Address address;
}
