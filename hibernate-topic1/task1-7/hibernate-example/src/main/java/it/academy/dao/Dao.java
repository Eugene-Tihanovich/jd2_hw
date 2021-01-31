package it.academy.dao;

import it.academy.model.Person;
import it.academy.model.Pet;

public interface Dao {

    void savePerson(Person person);

    void deletePerson(Integer id);

    Person getPersonById(Integer id);

    void savePet(Pet pet);

}