package it.academy.dao;

import it.academy.model.Person;

public interface Dao {

    void savePerson(Person person);

    void deletePerson(Integer id);

    Person getPersonById(Integer id);

}