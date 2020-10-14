package by.it.model;

import lombok.Builder;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@ToString
@Builder
@Entity
@Table(name = "employees_personal_info")
public class EmployeePersonalInfo {

    @Id
    @GeneratedValue
    private long id;

    private String numberPassport;

    public EmployeePersonalInfo() {
    }

    public EmployeePersonalInfo(long id, String numberPassport) {
        this.id = id;
        this.numberPassport = numberPassport;
    }
}
