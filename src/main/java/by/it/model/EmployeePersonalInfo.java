package by.it.model;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
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

    @Override
    public String toString() {
        return "EmployeePersonalInfo{" +
                "id=" + id +
                ", employeeStatus=" + employeeStatus +
                ", numberPassport='" + numberPassport + '\'' +
                ", address=" + address.toString() +
                '}';
    }
}
