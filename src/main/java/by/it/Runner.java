package by.it;

import by.it.dao.EmployeeDao;
import by.it.model.Address;
import by.it.model.Employee;
import by.it.model.EmployeePersonalInfo;
import by.it.model.EmployeeStatus;
import org.h2.tools.Server;
import javax.persistence.EntityManager;
import java.sql.SQLException;

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
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();

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
                        .homNumber("10")
                        .build())
                .build();
        employee.setPersonalInfo(personalInfo);

        Employee employee1 = Employee.builder()
                .name("Иван")
                .surName("Семёнов")
                .age(35)
                .external(false)
                .build();

        EmployeePersonalInfo personalInfo1 = EmployeePersonalInfo.builder()
                .numberPassport("3208057PИ987412")
                .employeeStatus(EmployeeStatus.WORKING)
                .address(Address.builder()
                        .city("Гомель")
                        .street("пр.Речицкий")
                        .homNumber("99")
                        .build())
                .build();
        employee1.setPersonalInfo(personalInfo1);

        Employee employee2 = Employee.builder()
                .name("Алексей")
                .surName("Верезубов")
                .age(30)
                .external(false)
                .build();


        EmployeePersonalInfo personalInfo2 = EmployeePersonalInfo.builder()
                .numberPassport("8519674MB951753")
                .employeeStatus(EmployeeStatus.WORKING)
                .address(Address.builder()
                        .city("Гомель")
                        .street("Весёлая 1-А")
                        .homNumber("55-ххх")
                        .build())
                .build();

        employee2.setPersonalInfo(personalInfo2);

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.saveInDB(employee);
        employeeDao.saveInDB(employee1);
        employeeDao.saveInDB(employee2);

    }
}
