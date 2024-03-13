package hb09.fetchtypes;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {
        Student09 s1 = new Student09();
        s1.setId(1001);
        s1.setName("AAA");
        s1.setGrade(98);

        Student09 s2 = new Student09();
        s2.setId(1002);
        s2.setName("BBB");
        s2.setGrade(98);

        Student09 s3 = new Student09();
        s3.setId(1003);
        s3.setName("CCC");
        s3.setGrade(98);

        //Book objects

        Book09 book1 = new Book09();
        book1.setId(101);
        book1.setName("Math Book");

        Book09 book2 = new Book09();
        book2.setId(102);
        book2.setName("Phys Book");

        Book09 book3 = new Book09();
        book3.setId(103);
        book3.setName("Chemistry Book");

        Book09 book4 = new Book09();
        book4.setId(104);
        book4.setName("Art Book");

        Book09 book5 = new Book09();
        book5.setId(105);
        book5.setName("Hibernate Book");


        //Set student to book
        //the owner relation is book class, so we have to set otherwise foreign key will be null
        book1.setStudent(s1);
        book2.setStudent(s1);
        book3.setStudent(s2);
        book4.setStudent(s2);
        book5.setStudent(s3);

        //add books to the students
        //since we are using cascadeType.PERSIST we have to set books to student obj
        s1.getBookList().add(book1);
        s1.getBookList().add(book2);

        s2.getBookList().add(book3);
        s2.getBookList().add(book4);

        s3.getBookList().add(book5);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(s1);
        session.save(s2);
        session.save(s3);

//when we use cascade = CascadeType.ALL,(PERSIST) we do not need to store child class
//        if you try to save books you will not get any exception
//        session.save(book1);
//        session.save(book2);
//        session.save(book3);
//        session.save(book4);
//        session.save(book5);



        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
