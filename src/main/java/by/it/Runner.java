package by.it;

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

    }
}
