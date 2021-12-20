package ru.gb.hibernatehw1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateHw1Application {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.addAnnotatedClass(Prodtable.class)
				.buildSessionFactory();

		Session session = null;


//		// Реализация CREATE
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Prodtable prodtable = new Prodtable("кофе",350);
		System.out.println(prodtable);
		session.save(prodtable);
		System.out.println(prodtable);
		session.getTransaction().commit();

		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Prodtable prodtable1 = new Prodtable("сливки",100);
		System.out.println(prodtable1);
		session.save(prodtable1);
		System.out.println(prodtable1);
		session.getTransaction().commit();

		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Prodtable prodtable2 = new Prodtable("сахар",80);
		System.out.println(prodtable2);
		session.save(prodtable2);
		System.out.println(prodtable2);
		session.getTransaction().commit();


		// Реализация READ
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Prodtable prodFromDb = session.get(Prodtable.class, 1L);
		System.out.println(prodFromDb);
		session.getTransaction().commit();

		// Реализация READ 2
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Prodtable prodFromDb4 = (Prodtable) session.createQuery("SELECT i FROM Prodtable i WHERE i.id = :id", Prodtable.class)
						.setParameter("id", 4L)
						.getSingleResult();
		System.out.println(prodFromDb4);
		session.getTransaction().commit();

		// Реализация READ ALL
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Prodtable> products = session.createQuery("SELECT i FROM Prodtable i",Prodtable.class).getResultList();
		System.out.println(products);
		session.getTransaction().commit();

		// Реализация UPDATE
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Prodtable prodFromDb3 = session.get(Prodtable.class, 1L);
		System.out.println(prodFromDb3);
		prodFromDb.setPrice(100);
		prodFromDb.setTitle("молоко");
		session.getTransaction().commit();

		// Реализация DELETE
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Prodtable prodFromDb2 = session.get(Prodtable.class, 1L);
		session.remove(prodFromDb2);
		session.getTransaction().commit();


		// Реализация DELETE 2
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Prodtable prodFromDb1 = (Prodtable) session.createQuery("SELECT i FROM Prodtable i WHERE i.id = :id", Prodtable.class)
				.setParameter("id", 3L)
				.getSingleResult();
		session.remove(prodFromDb1);
		System.out.println(prodFromDb1);
		session.getTransaction().commit();




		sessionFactory.close();
	}

}
