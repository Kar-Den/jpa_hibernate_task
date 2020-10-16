package by.it.dao;

import by.it.JpaEntityManagerFactoryUtil;
import by.it.model.Employee;
import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDao {

    public void saveInDB(Employee employee) {
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
    }

    public void saveAllInDB(List<Employee> employees) {
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();

        /**todo Правильно сохраняю?
        *  уходят ли запросы в БД при этом пачкой?
         *  есть ли способ сначало выдать всем employee из списка id (заранее зарезервированные хибернейтом)
         *  в сделать вставку одним инсертом. Похоже на ерунду :)
         *  http://joxi.ru/52abE77CkedWBA*/
        em.getTransaction().begin();
        for (Employee employee : employees) {
            em.persist(employee);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Employee findByID(Long id){
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        Employee employee = em.find(Employee.class, id);
        return employee;
    }

}
