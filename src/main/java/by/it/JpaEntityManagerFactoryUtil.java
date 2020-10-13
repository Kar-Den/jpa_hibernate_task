package by.it;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManagerFactoryUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("jpa_hibernate_task");
    }

    private JpaEntityManagerFactoryUtil() {}

    public EntityManagerFactory getEntityManagerFactory(){
        return ENTITY_MANAGER_FACTORY;
    }

    public EntityManager getEntityManager(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
