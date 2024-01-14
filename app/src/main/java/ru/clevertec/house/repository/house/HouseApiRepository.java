package ru.clevertec.house.repository.house;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.clevertec.house.entity.House;
import ru.clevertec.house.hibernate.HibernateI;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class HouseApiRepository implements HouseRepository {

    private final HibernateI hibernateI;

    public HouseApiRepository(HibernateI hibernateI) {
        this.hibernateI = hibernateI;
    }
    @Override
    public long create(House house) {
        SessionFactory sessionFactory = hibernateI.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(house);
            transaction.commit();
            return house.getId();
        }
    }

    @Override
    public House read(long id) throws Exception {
        SessionFactory sessionFactory = hibernateI.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            return session.get(House.class, id);
        }
    }

    @Override
    public boolean update(House house, Long id) {
        SessionFactory sessionFactory = hibernateI.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            House existingHouse = session.get(House.class, id);
            if (existingHouse != null) {
                existingHouse.setArea(house.getArea());
                existingHouse.setCountry(house.getCountry());
                existingHouse.setCity(house.getCity());
                existingHouse.setStreet(house.getStreet());
                existingHouse.setNumber(house.getNumber());
                existingHouse.getResidents().clear();
                existingHouse.getResidents().addAll(house.getResidents());
                existingHouse.getOwners().clear();
                existingHouse.getOwners().addAll(house.getOwners());
                session.update(existingHouse);
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
            House existingHouse = session.get(House.class, id);
            session.delete(existingHouse);
            return true;
        }
    }

    @Override
    public List<House> readAll() {
        SessionFactory sessionFactory = hibernateI.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<House> criteriaQuery = builder.createQuery(House.class);
            criteriaQuery.from(House.class);
            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
