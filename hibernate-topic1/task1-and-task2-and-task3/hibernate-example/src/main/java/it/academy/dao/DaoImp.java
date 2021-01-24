package it.academy.dao;

import it.academy.model.Person;
import it.academy.util.HibernateUtil;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoImp implements Dao {

    @Override
    public void savePerson(Person person) {
        Session session = HibernateUtil.getSession();

        //session.setFlushMode(FlushMode.AUTO); - IDEA говорит, что данный метод и его типы устарели

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void deletePerson(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Id entered incorrectly. Please, write the correct id!");
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Person getPersonById(Integer id) {
        Session session = HibernateUtil.getSession();
        Person person = session.get(Person.class, id);
        if (person == null) {
            throw new NullPointerException("Person with such id not found. Please, write the correct id!");
        }
        session.close();
        return person;
    }
}