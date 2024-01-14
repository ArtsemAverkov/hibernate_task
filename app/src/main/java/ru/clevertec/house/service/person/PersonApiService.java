package ru.clevertec.house.service.person;

import org.springframework.stereotype.Service;
import ru.clevertec.house.entity.Person;
import ru.clevertec.house.repository.person.PersonRepository;

import java.util.List;

@Service
public class PersonApiService implements PersonService{

    private final PersonRepository personRepository;

    public PersonApiService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public long create(Person person) {
        return personRepository.create(person);
    }

    @Override
    public Person read(long id) throws Exception {
        return personRepository.read(id);
    }

    @Override
    public boolean update(Person person, Long id) {
        return personRepository.update(person, id);
    }

    @Override
    public boolean delete(Long id) {
        return personRepository.delete(id);
    }

    @Override
    public List<Person> readAll() {
        return personRepository.readAll();
    }
}
