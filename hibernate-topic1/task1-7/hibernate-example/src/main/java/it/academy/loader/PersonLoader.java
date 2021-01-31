package it.academy.loader;

import it.academy.dao.DaoImp;
import it.academy.model.Address;
import it.academy.model.Person;
import it.academy.model.Pet;

public class PersonLoader {
    public static void main(String[] args) {

        Person person = new Person(null, 35, "Yuli", "Slabko");

        DaoImp daoImp = new DaoImp();
//        daoImp.savePerson(person);
//        daoImp.deletePerson(4);
//        System.out.println(daoImp.getPersonById(4));
//        System.out.println(daoImp.getPersonById(4).getId());

        Pet pet = new Pet();
        pet.setPetType("Cat");
        pet.setPetName("Baton");
        pet.setPetAge(1);
        pet.setPetColorEyes("blue");

//       daoImp.savePet(pet);

        Pet pet1 = new Pet(null, "Dog", "Bob", 5, "grey",
                new Address("Sadovay", "Minsk"));
        daoImp.savePet(pet1);
    }
}