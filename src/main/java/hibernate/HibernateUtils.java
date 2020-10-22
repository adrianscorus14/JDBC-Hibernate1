package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

import static org.example.App.*;

public class HibernateUtils {

    // singleton
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // initializeaza-l
            //  Configuration > Properties > ServiceRegistry
            Configuration myConfiguration = new Configuration();

            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.URL, DATABASE_HOST);
            settings.put(Environment.USER, DATABASE_USERNAME);
            settings.put(Environment.PASS, DATABASE_PASSWORD);
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            myConfiguration.setProperties(settings);
            myConfiguration.addAnnotatedClass(Department.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(myConfiguration.getProperties()).build();

            sessionFactory = myConfiguration.buildSessionFactory();

        }
        return sessionFactory;
    }
}