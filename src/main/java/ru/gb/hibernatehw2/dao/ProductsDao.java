package ru.gb.hibernatehw2.dao;

import ru.gb.hibernatehw2.entity.Products;

import java.util.List;

public class ProductsDao {

    Products findById (Long id){
        return id;
    }

    List<Products> findAll(){

    }

    void deleteById (Long id){

    }

    Products saveOrUpdate(Products products){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        session.close();
    }



}
