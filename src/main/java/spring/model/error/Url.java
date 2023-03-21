package spring.model.error;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import spring.model.*;

public class Url {
    private static final SessionFactory connection;

    static {
        connection = new Configuration()
                .setProperty(Environment.DRIVER, "org.postgresql.Driver")
                .setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres")
                .setProperty(Environment.USER, "postgres")
                .setProperty(Environment.PASS, "root")
                .setProperty(Environment.HBM2DDL_AUTO, "update")
                .setProperty(Environment.SHOW_SQL, "true")
                .setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect")
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Groups.class)
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public static SessionFactory getConnection() {
        return connection;
    }

}
