package hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Random;

public class RunnerFetch11 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        /*
            CRUD (Create, Read, Update, Delete)
            C --> session.save(), session.persist()
            R --> session.get(), HQL, SQL
            U --> session.update(), updateQuery()
            D --> session.delete(), HQL, SQL
         */

        //1. update existing data
//        Student11 student = session.get(Student11.class, 1L);
//        System.out.println("Before update "+student);
//        student.setName("Updated " + student.getName());
//        session.update(student);
//        System.out.println("After update "+student);

        //2. update student using query
        //update grades that are less than 50 to 70

        int sGrade = 70;
        int lGrade = 59;

//        String hqlQuery = "UPDATE Student11 s SET s.grade = 70 WHERE s.grade<50";
        String hqlQuery = "UPDATE Student11 s SET s.grade = :sMath WHERE s.grade<:lMath";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("sMath", sGrade);
        query.setParameter("lMath", lGrade);

        int numOfUpdatedRecords = query.executeUpdate();
        System.out.println("Number of updated records: "+numOfUpdatedRecords);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
