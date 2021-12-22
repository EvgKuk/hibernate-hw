package ru.gb.hibernate.hw2.dao;

import ru.gb.hibernate.hw2.entity.Consumers;

import java.util.List;

public class ConsumerDao {

    Consumers findById (Long id){
        DaoServices dS = new DaoServices();
        dS.session = dS.sessionFactory.getCurrentSession();
        dS.session.beginTransaction();
        Consumers consumerFromDb = dS.session.get(Consumers.class, 1L);
        System.out.println(consumerFromDb);
        dS.session.getTransaction().commit();
        return consumerFromDb;
    }

    List<Consumers> findAll(){
        DaoServices dS = new DaoServices();
        dS.session = dS.sessionFactory.getCurrentSession();
        dS.session.beginTransaction();
        List<Consumers> consumers = dS.session.createQuery("SELECT i FROM Consumers i", Consumers.class).getResultList();
        System.out.println(consumers);
        dS.session.getTransaction().commit();
        dS.session.close();
        return consumers;
    }

    void deleteById (Long id){
        DaoServices dS = new DaoServices();
        dS.session = dS.sessionFactory.getCurrentSession();
        dS.session.beginTransaction();
        Consumers consumerFromDb =  dS.session.get(Consumers.class, 1L);
        dS.session.remove(consumerFromDb);
        dS.session.getTransaction().commit();
        dS.session.close();
    }

    Consumers saveOrUpdate(Consumers consumer){
        DaoServices dS = new DaoServices();
        dS.session = dS.sessionFactory.getCurrentSession();
        dS.session.beginTransaction();
        dS.session.saveOrUpdate(consumer);
        dS.session.getTransaction().commit();
        dS.session.close();
        return consumer;
    }
}
