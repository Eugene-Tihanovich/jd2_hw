package it.academy.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory factory;
    private static StandardServiceRegistry registry;

    static {
        try {
            registry = new StandardServiceRegistryBuilder().configure().build();
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            System.out.println("Cannot get session factory");
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Session getSession() throws HibernateException {
        return factory.openSession();
    }
}