package hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {
        Student06 s1 = new Student06();
        s1.setId(1001);
        s1.setName("AAA");
        s1.setGrade(88);

        Student06 s2 = new Student06();
        s2.setId(1002);
        s2.setName("BBB");
        s2.setGrade(99);

        Student06 s3 = new Student06();
        s3.setId(1003);
        s3.setName("CCC");
        s3.setGrade(77);


        Book06 b1 = new Book06();
        b1.setId(101);
        b1.setName("Math Book");

        Book06 b2 = new Book06();
        b2.setId(102);
        b2.setName("Hibernate Book");

        Book06 b3 = new Book06();
        b3.setId(103);
        b3.setName("JDBC Book");

        s1.getBookList().add(b1);
        s1.getBookList().add(b2);
        s2.getBookList().add(b3);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book06.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(b1);
        session.save(b2);
        session.save(b3);

        session.save(s1);
        session.save(s2);
        session.save(s3);





        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
