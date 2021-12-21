package ru.gb.hibernatehw2.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.hibernatehw2.entity.Products;

import java.util.List;

public class ProductsDao {
    SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Products.class)
            .buildSessionFactory();
    Session session = null;


    Long findById(Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Products productFromDb = session.get(Products.class, 1L);
        System.out.println(productFromDb);
        session.getTransaction().commit();
        return id;
    }

    List<Products> findAll() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Products> products = session.createQuery("SELECT i FROM Products i", Products.class).getResultList();
        System.out.println(products);
        session.getTransaction().commit();
        session.close();

        return products;
    }

    void deleteById(Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Products productFromDb = session.get(Products.class, 1L);
        session.remove(productFromDb);
        session.getTransaction().commit();
        session.close();
    }

    Products saveOrUpdate(Products product) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        session.close();
        return product;
    }
}
