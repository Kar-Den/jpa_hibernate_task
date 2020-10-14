package by.it.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees_personal_info")
public class EmployeePersonalInfo {

    @Id
    private long id;
}
