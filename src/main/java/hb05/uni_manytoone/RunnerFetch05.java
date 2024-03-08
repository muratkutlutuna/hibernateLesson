package hb05.uni_manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml");
//                .
//                addAnnotatedClass(Student05.class).
//                addAnnotatedClass(University.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //get method
        Student05 student1 = session.get(Student05.class, 1001);
        System.out.println("student1 = " + student1+"\n");
        University university = session.get(University.class, 101);
        university=session.get(University.class,student1.getUniversity().getId());
        //using student1 obj we can reach to university
        university = student1.getUniversity();
        System.out.println("university = " + university+"\n");

        //fetch students whose univ id is 101 using hql
        String hql = "FROM Student05 s WHERE s.university.id=101";
        List<Student05> studentList = session.createQuery(hql, Student05.class).getResultList();
        System.out.println("studentList = " + studentList);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
