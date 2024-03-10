package hb07.bi_onetomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;


public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student07 std1 = session.get(Student07.class, 1001);
        System.out.println("std1 = " + std1);

        //using student obj, get books
        std1.getBook07().forEach(std-> System.out.println(std));

        Book07 book1 = session.get(Book07.class, 101);
        //using book, get student objs
        System.out.println("book1 = " + book1);

        //fetch student name and book name using SQL
        String sqlQuery1 = "SELECT s.std_name, b.name FROM t_student07 s INNER JOIN t_book07 b ON s.id=b.std_id";
        List<Object[]> nameList = session.createSQLQuery(sqlQuery1).getResultList();
        nameList.forEach(x-> System.out.println(Arrays.toString(x)));



        transaction.commit();
        session.close();
        sessionFactory.close();



    }
}
