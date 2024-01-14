package ru.clevertec.house.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


@Component
public interface HibernateI {
    SessionFactory getSessionFactory();
}
