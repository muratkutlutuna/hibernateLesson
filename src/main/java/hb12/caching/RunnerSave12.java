package hb12.caching;

import hb09.fetchtypes.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave12 {
    public static void main(String[] args) {

        Student12 s1 = new Student12();
        s1.setName("AAA");
        s1.setGrade(98);

        Student12 s2 = new Student12();
        s2.setName("BBB");
        s2.setGrade(98);

        Student12 s3 = new Student12();
        s3.setName("CCC");
        s3.setGrade(98);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(s1);
        session.save(s2);
        session.save(s3);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
