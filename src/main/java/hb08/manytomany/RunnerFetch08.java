package hb08.manytomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch08 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Book08.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //get student by id with get method
        Student08 s1 = session.get(Student08.class, 1001);
        System.out.println("s1 = " + s1);

        //get book by id with get method
        Book08 b1 = session.get(Book08.class, 101);
        System.out.println("b1 = " + b1);





        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
