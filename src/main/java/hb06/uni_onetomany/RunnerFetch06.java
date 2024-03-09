package hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book06.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("*********** fetch student using get method ***********");
        Student06 std1 = session.get(Student06.class, 1001);
        System.out.println("std1 = " + std1);
        System.out.println("*********** fetch book with id 101 using HQL ***********");
        String hql = "FROM Book06 WHERE id=101";
        Book06 b1 = session.createQuery(hql, Book06.class).uniqueResult();
        System.out.println("b1 = " + b1);
        System.out.println("*********** fetch books of student whose id 1001 using HQL ***********");
        String hql2 = "SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1001";
        List<Object[]> bList = session.createQuery(hql2).getResultList();
        bList.forEach(x-> System.out.println(Arrays.toString(x)));
        System.out.println("*********** fetch books of student whose id 1001 using get() ***********");
        List<Book06> bookList = session.get(Student06.class, 1001).getBookList();
        bookList.forEach(x-> System.out.println(x));


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
