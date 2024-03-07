package hb03.uni_onetoone;

import hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Dairy.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("=============== using get() method fetch students ===================");
        Student03 student1 = session.get(Student03.class, 1001);
        System.out.println("student1 = " + student1);

        System.out.println("=============== using get() method fetch dairy ===================");
        Dairy dairy1 = session.get(Dairy.class, 101);
        System.out.println("dairy1 = " + dairy1);

        System.out.println("=============== using get() method fetch student from dairy ===================");
        System.out.println("dairy1.getStudent() = " + dairy1.getStudent());


        transaction.commit();
        session.close();
        sessionFactory.close();







    }
}
