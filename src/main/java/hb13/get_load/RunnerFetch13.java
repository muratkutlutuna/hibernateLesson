package hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        System.out.println("************* get method starts ***************");
//        Student13 student1 = session.get(Student13.class, 1L);
//        System.out.println("************* get method ends ***************");
//
//        System.out.println("student1.getId() = " + student1.getId());
//        System.out.println("student1.getName() = " + student1.getName());
//        System.out.println("student1.getGrade() = " + student1.getGrade());

//        System.out.println("************* load method starts ***************");
//        Student13 student2 = session.load(Student13.class, 1L);
//        System.out.println("************* load method ends ***************");
//
//        System.out.println("student2.getId() = " + student2.getId());
//        System.out.println("student2.getName() = " + student2.getName());
//        System.out.println("student2.getGrade() = " + student2.getGrade());

//        System.out.println("************* get method starts for data which does not exist ***************");
//        Student13 student3 = session.get(Student13.class, 10L);//student3 = null
//        System.out.println("************* get method ends for data which does not exist ***************");
//        if (student3 != null) {
//            System.out.println(student3.getName());
//        }
//        System.out.println("student3.getGrade() = " + student3.getGrade());//java.lang.NullPointerException

        System.out.println("************* load method starts for data which does not exist ***************");
        Student13 student4 = session.load(Student13.class, 10L);//returns fake / proxy obj
        //student4 is not null and a fake object whose id is 10
        System.out.println("************* load method ends for data which does not exist ***************");
        if (student4 != null) {
            System.out.println(student4.getId());//no exception
        }
        if (student4 != null) {
            System.out.println(student4.getName());//org.hibernate.ObjectNotFoundException
        }

        //If you are sure that obj is in your DB, and if you are not going to use any field (lazy loading)
        //then you can use load method. Because it will not fetch data from database, and you will save time


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
