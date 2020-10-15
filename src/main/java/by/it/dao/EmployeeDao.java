package by.it.dao;

import by.it.JpaEntityManagerFactoryUtil;
import by.it.model.Employee;

import javax.persistence.EntityManager;

public class EmployeeDao {

    public void saveInDB(Employee employee){
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
    }

}
