package hb08.manytomany;

import hb07.bi_onetomany.Book07;
import hb07.bi_onetomany.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {
    public static void main(String[] args) {
        Student08 s1 = new Student08();
        s1.setId(1001);
        s1.setName("Sara");
        s1.setGrade(90);

        Student08 s2 = new Student08();
        s2.setId(1002);
        s2.setName("Cigdem");
        s2.setGrade(97);

        Student08 s3 = new Student08();
        s3.setId(1003);
        s3.setName("Sinan");
        s3.setGrade(90);

        //Book objects

        Book08 book1 = new Book08();
        book1.setId(101);
        book1.setName("Math Book");

        Book08 book2 = new Book08();
        book2.setId(102);
        book2.setName("Chemistry Book");

        Book08 book3 = new Book08();
        book3.setId(103);
        book3.setName("Java Book");

        Book08 book4 = new Book08();
        book4.setId(104);
        book4.setName("Hibernate Book");

        Book08 book5 = new Book08();
        book5.setId(105);
        book5.setName("JDBC Book");

        //set books to the students
        s1.getBookList().add(book1);
        s1.getBookList().add(book2);

        s2.getBookList().add(book3);
        s2.getBookList().add(book4);

        s3.getBookList().add(book5);

//        //set students to books
//        book1.getStudents().add(s1);
//        book2.getStudents().add(s1);
//        book3.getStudents().add(s2);
//        book4.getStudents().add(s2);
//        book5.getStudents().add(s3);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Book08.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(s1);
        session.save(s2);
        session.save(s3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);



        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
