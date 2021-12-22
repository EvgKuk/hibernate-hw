package ru.gb.hibernate.hw2.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.hibernate.hw2.entity.Consumers;
import ru.gb.hibernate.hw2.entity.Products;

public class DaoServices {
    SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Products.class)
            .addAnnotatedClass(Consumers.class)
            .buildSessionFactory();
    Session session = null;
}
