package it.academy.loader;

import it.academy.dao.DaoImp;
import it.academy.model.Person;

public class PersonLoader {
    public static void main(String[] args) {

        Person person = new Person(null, 35, "Yuli", "Slabko");

        DaoImp daoImp = new DaoImp();
        //daoImp.savePerson(person);
        //daoImp.deletePerson(4);
        System.out.println(daoImp.getPersonById(3));

    }
}