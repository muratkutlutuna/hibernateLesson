package hb09.fetchtypes;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
        1. If next is Many then default is LAZY
            OnneToMany
            ManyToMany
        2. If next side is One then default is EAGER
            ManyToOne
            OneToOne
 */
public class RunnerFetch09 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student09 student = session.get(Student09.class, 1001);
//        System.out.println("student = " + student);
//        Book09 book = session.get(Book09.class, 101);

//        for (Book09 book :
//                student.getBookList()) {
//            System.out.println(book);
//        }

        transaction.commit();
        session.close();

//Since we set fetch type to EAGER, in our RAM student object will store all info about book..
//so when we want to get book after session close we can get it
        for (Book09 book :
                student.getBookList()) {
            System.out.println(book);
        }
        sessionFactory.close();
    }
}
