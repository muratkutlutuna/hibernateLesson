package hb04.bi_onetoone;

import hb03.uni_onetoone.Dairy;
import hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Dairy04.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //get student and dairy by Id using get method
        Student04 std1 = session.get(Student04.class, 1001);
        System.out.println("std1 = " + std1);
        System.out.println("std1.getDairy() = " + std1.getDairy());
        Dairy04 dry1 = session.get(Dairy04.class, 101);
        System.out.println("dry1 = " + dry1);
        System.out.println("dry1.getStudent() = " + dry1.getStudent());


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
