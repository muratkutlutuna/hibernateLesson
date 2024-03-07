package hb03.uni_onetoone;

import hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        //create some objects

        Student03 student01 = new Student03();
        student01.setId(1001);
        student01.setName("cem");
        student01.setGrade(90);

        Student03 student02 = new Student03();
        student02.setId(1002);
        student02.setName("yusuf");
        student02.setGrade(91);

        Student03 student03 = new Student03();
        student03.setId(1003);
        student03.setName("burak");
        student03.setGrade(95);

        //create daiy objects

        Dairy dairy1 = new Dairy();
        dairy1.setId(101);
        dairy1.setName("cem's diary");
        dairy1.setStudent(student01);

        Dairy dairy2 = new Dairy();
        dairy2.setId(102);
        dairy2.setName("yusuf's diary");
        dairy2.setStudent(student02);

        Dairy dairy3 = new Dairy();
        dairy3.setId(103);
        dairy3.setName("burak's diary");
        dairy3.setStudent(student03);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Dairy.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(student01);
        session.save(student02);
        session.save(student03);

        session.save(dairy1);
        session.save(dairy2);
        session.save(dairy3);



        transaction.commit();
        session.close();
        sessionFactory.close();




    }
}
