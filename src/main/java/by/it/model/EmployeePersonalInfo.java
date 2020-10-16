package by.it.model;

import lombok.*;
import javax.persistence.*;

@EqualsAndHashCode(exclude = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employees_personal_info")
public class EmployeePersonalInfo {

    @Id
    private long id;


    @Enumerated(EnumType.STRING)
    @Column (name = "employee_status", length = 50)
    private EmployeeStatus employeeStatus;


    @Column(name = "number_passport", length = 25)
    private String numberPassport;


    @Embedded
    private Address address;


    @OneToOne (fetch = FetchType.LAZY)
    @MapsId
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
