package hb07.bi_onetomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        //Student with param constructor
        Student07 student1 = new Student07(1001,"Cigdem",89);

        //Student with empty constructor
        Student07 student2 = new Student07();
        student2.setId(1002);
        student2.setName("Marian");
        student2.setGrade(90);

        Student07 student3 = new Student07();
        student3.setId(1003);
        student3.setName("CCC");
        student3.setGrade(95);

        //Book objects
        Book07 book1 = new Book07();
        book1.setId(101);
        book1.setName("Java Book");

        Book07 book2 = new Book07();
        book2.setId(102);
        book2.setName("Math Book");

        Book07 book3 = new Book07();
        book3.setId(103);
        book3.setName("Hibernate Book");

        Book07 book4 = new Book07();
        book4.setId(104);
        book4.setName("Art Book");

        Book07 book5 = new Book07();
        book5.setId(105);
        book5.setName("Chemistry Book");

        //set books to student class
        //when we use mappedBy, the owner of relation will be books side
//        student1.getBook07().add(book1);
//        student1.getBook07().add(book2);

        //Set student to book
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);

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
