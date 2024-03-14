package hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

/**
 * 1) First level Cache --->
 *      * default caching, can not be closed
 *      * caches in the same session
 *      * memory is cleared when session is closed
 * 2) Second level Cache --->
 *      * closed by default (needs to be enabled manually)
 *      * caches in Session Factory level (can cache in different sessions)
 * 3) Query Cache
 *      * Used for queries
 *      * needs to be enabled manually
 */
public class RunnerFetch12 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("first get method for atudent whose ID is 1L");
        Student12 student1 = session.get(Student12.class, 1L);

//        session.clear();//it clears cache memory

        System.out.println("second get method for atudent whose ID is 1L");
        Student12 student2 = session.get(Student12.class, 1L);


        transaction.commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        System.out.println("third get method for atudent whose ID is 1L");
        Student12 student3 = session1.get(Student12.class, 1L); //Second level cache is working

        transaction1.commit();
        session1.close();
        sessionFactory.close();
    }
}
