package ru.clevertec.house.service.person;

import ru.clevertec.house.entity.Person;

import java.util.List;

public interface PersonService {
    long create(Person person);
    Person read (long id) throws Exception;
    boolean update (Person person, Long id);
    boolean delete (Long id);
    List<Person> readAll ();
}
