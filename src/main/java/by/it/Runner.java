package by.it;

import by.it.model.Employee;
import by.it.model.EmployeePersonalInfo;
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
                .build();

        EmployeePersonalInfo personalInfo = EmployeePersonalInfo.builder().numberPassport("3210781PB12314").build();
        employee.setPersonalInfo(personalInfo);


        em.getTransaction().begin();
        em.persist(personalInfo);
        em.persist(employee);
        em.getTransaction().commit();
        em.close();

    }
}
