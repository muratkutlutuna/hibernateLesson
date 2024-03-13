package hb11.criteriaapi;

import com.github.javafaker.Faker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave11 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Random random = new Random();
        for (int i = 1; i <= 20; i++) {
            Student11 student = new Student11();//create 20 new students
            student.setName("Student Name "+i);//set name
            student.setGrade(random.nextInt(100));//assign grades randomly btw 1 and 100
            session.save(student);
        }



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
