package it.academy.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.Serializable;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonTest {

    private SessionFactory factory;

    @Before
    public void setUp() throws Exception {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.test.xml").build();
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void Acreate() {
        Person person = new Person(8, 35, "Yuli", "Slabko");

        Session session = factory.openSession();
        Transaction tx = null;
        Serializable id = null;
        try {
            tx = session.beginTransaction();
            id = session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        assertNotNull(id);
    }

    @Test
    public void Bget(){
        Session session = factory.openSession();
        Person expectedPerson = session.get(Person.class, 8);
        Person actualPerson = new Person(8, 35, "Yuli", "Slabko");
        assertEquals(expectedPerson, actualPerson);
        session.close();
    }

    @Test
    public void Cdelete() {
        Session session = factory.openSession();
        Person person = session.get(Person.class, 8);
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }

        assertNull(session.get(Person.class, 8));
        session.close();
    }

    @After
    public void tearDown() throws Exception {
        factory.close();
    }
}