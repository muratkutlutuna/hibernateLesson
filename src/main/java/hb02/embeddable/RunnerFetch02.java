package hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student02 student02 = session.get(Student02.class, 1001);
        System.out.println("student02 = " + student02);
        System.out.println("==================================");
        System.out.println(student02.getAddress());

        transaction.commit();
        session.close();
        sessionFactory.close();





    }
}
