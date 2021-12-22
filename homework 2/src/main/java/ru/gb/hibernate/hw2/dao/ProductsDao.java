package ru.gb.hibernate.hw2.dao;

import ru.gb.hibernate.hw2.entity.Products;

import java.util.List;

public class ProductsDao {

    Products findById(Long id) {
        DaoServices dS = new DaoServices();
        dS.session = dS.sessionFactory.getCurrentSession();
        dS.session.beginTransaction();
        Products productFromDb = dS.session.get(Products.class, 1L);
        System.out.println(productFromDb);
        dS.session.getTransaction().commit();
        return productFromDb;
    }

    List<Products> findAll() {
        DaoServices dS = new DaoServices();
        dS.session = dS.sessionFactory.getCurrentSession();
        dS.session.beginTransaction();
        List<Products> products = dS.session.createQuery("SELECT i FROM Products i", Products.class).getResultList();
        System.out.println(products);
        dS.session.getTransaction().commit();
        dS.session.close();
        return products;
    }

    void deleteById(Long id) {
        DaoServices dS = new DaoServices();
        dS.session = dS.sessionFactory.getCurrentSession();
        dS.session.beginTransaction();
        Products productFromDb =  dS.session.get(Products.class, 1L);
        dS.session.remove(productFromDb);
        dS.session.getTransaction().commit();
        dS.session.close();
    }

    Products saveOrUpdate(Products product) {
        DaoServices dS = new DaoServices();
        dS.session = dS.sessionFactory.getCurrentSession();
        dS.session.beginTransaction();
        dS.session.saveOrUpdate(product);
        dS.session.getTransaction().commit();
        dS.session.close();
        return product;
    }
}
