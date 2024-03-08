package hb05.uni_manytoone;

import hb04.bi_onetoone.Dairy04;
import hb04.bi_onetoone.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        Student05 student1 = new Student05();
        student1.setId(1001);
        student1.setName("Sinan");
        student1.setGrade(95);

        Student05 student2 = new Student05();
        student2.setId(1002);
        student2.setName("Sara");
        student2.setGrade(95);

        Student05 student3 = new Student05();
        student3.setId(1003);
        student3.setName("Aykut");
        student3.setGrade(95);

        University university = new University();
        university.setId(101);
        university.setName("TPE University");

        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml");
//                .
//                addAnnotatedClass(Student05.class).
//                addAnnotatedClass(University.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(university);

        session.save(student1);
        session.save(student2);
        session.save(student3);





        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
