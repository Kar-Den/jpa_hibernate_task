package by.it;

import by.it.dao.EmployeeDao;
import by.it.model.Address;
import by.it.model.Employee;
import by.it.model.EmployeePersonalInfo;
import by.it.model.EmployeeStatus;
import org.h2.tools.Server;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    private final static Server SERVER;

    static {
        try {
            SERVER = Server.createTcpServer().start();
        } catch (SQLException e) {
            throw new RuntimeException("error start server");
        }
    }

    public static void main(String[] args) {

        List<Employee> employeesList = new ArrayList<>();

        //Create Employee
        {
            Employee employee = Employee.builder()
                    .name("Денис")
                    .surName("Карпенко")
                    .age(35)
                    .external(false)
                    .build();
            EmployeePersonalInfo personalInfo = EmployeePersonalInfo.builder()
                    .numberPassport("3210781PB12314")
                    .employeeStatus(EmployeeStatus.WORKING)
                    .address(Address.builder()
                            .city("Гомель, п.Чёнки")
                            .street("ул.Севруковская")
                            .homNumber("1")
                            .flatNumber("10")
                            .build())
                    .build();
            employee.setPersonalInfo(personalInfo);
            employeesList.add(employee);


            employee = Employee.builder()
                    .name("Иван")
                    .surName("Семёнов")
                    .age(35)
                    .external(false)
                    .build();
            personalInfo = EmployeePersonalInfo.builder()
                    .numberPassport("3208057PИ987412")
                    .employeeStatus(EmployeeStatus.WORKING)
                    .address(Address.builder()
                            .city("Гомель")
                            .street("пр.Речицкий")
                            .homNumber("99")
                            .flatNumber("33-k")
                            .build())
                    .build();
            employee.setPersonalInfo(personalInfo);
            employeesList.add(employee);


            employee = Employee.builder()
                    .name("Алексей")
                    .surName("Верезубов")
                    .age(30)
                    .external(false)
                    .build();
            personalInfo = EmployeePersonalInfo.builder()
                    .numberPassport("8519674MB951753")
                    .employeeStatus(EmployeeStatus.WORKING)
                    .address(Address.builder()
                            .city("Гомель")
                            .street("Весёлая 1-А")
                            .homNumber("55-ххх")
                            .flatNumber("33-smile")
                            .build())
                    .build();
            employee.setPersonalInfo(personalInfo);
            employeesList.add(employee);
        }
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.saveAllInDB(employeesList);

        System.out.println();
        System.out.println("find employee by ID:");
        Employee employeeFind = employeeDao.findByID(1L);
        System.out.println(employeeFind.getId() + " " +
                employeeFind.getName() + " " +
                employeeFind.getSurName() + " " +
                employeeFind.getAge() + " " +
                employeeFind.isExternal() + " " +
                employeeFind.getPersonalInfo());

    }
}
