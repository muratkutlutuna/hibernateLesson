package hb10.idgeneration;



import com.github.javafaker.Faker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.Random;

public class RunnerSave10 {
    public static void main(String[] args) {
        Student10 student = new Student10();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        student.setName(name);
        int grade = faker.number().numberBetween(45,100);
        student.setGrade(grade);


        Student10 student2 = new Student10();
        String name2 = faker.name().fullName();
        student2.setName(name2);
        int grade2 = faker.number().numberBetween(45,100);
        student2.setGrade(grade2);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Serializable returnID = session.save(student);//returns id as Serializable
        session.persist(student2);



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
