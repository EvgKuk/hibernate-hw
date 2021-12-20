package ru.gb.hibernatehw2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.hibernatehw2.entity.Consumers;
import ru.gb.hibernatehw2.entity.Products;

public class HibernateHw2App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Products.class)
                .addAnnotatedClass(Consumers.class)
                .buildSessionFactory();

        Session session = null;
    }
}
