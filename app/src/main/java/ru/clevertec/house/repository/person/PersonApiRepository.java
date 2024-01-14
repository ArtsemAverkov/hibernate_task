package ru.clevertec.house.repository.person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.clevertec.house.entity.Person;
import ru.clevertec.house.hibernate.HibernateI;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class PersonApiRepository implements PersonRepository{

    private final HibernateI hibernateI;

    public PersonApiRepository(HibernateI hibernateI) {
        this.hibernateI = hibernateI;
    }

    @Override
    public long create(Person person) {
        SessionFactory sessionFactory = hibernateI.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
            return person.getId();
        }
    }

    @Override
    public Person read(long id) throws Exception {
        SessionFactory sessionFactory = hibernateI.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            return session.get(Person.class, id);
        }
    }

    @Override
    public boolean update(Person person, Long id) {
        SessionFactory sessionFactory = hibernateI.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Person existingPerson = session.get(Person.class, id);
            if (existingPerson != null) {
                existingPerson.setName(person.getName());
                existingPerson.setSurname(person.getSurname());
                existingPerson.setSex(person.getSex());
                existingPerson.setPassportSeries(person.getPassportSeries());
                existingPerson.setPassportNumber(person.getPassportNumber());
                session.update(existingPerson);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        }
    }

    @Override
    public boolean delete(Long id) {
        SessionFactory sessionFactory = hibernateI.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Person existingPerson = session.get(Person.class, id);
            session.delete(existingPerson);
            return true;
        }
    }

    @Override
    public List<Person> readAll() {
        SessionFactory sessionFactory = hibernateI.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
            criteriaQuery.from(Person.class);
            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
