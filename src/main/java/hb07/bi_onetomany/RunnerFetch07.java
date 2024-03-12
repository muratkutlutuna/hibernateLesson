package hb07.bi_onetomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;


public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).
                addAnnotatedClass(Book07.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Student07 std1 = session.get(Student07.class, 1001);
//        System.out.println("std1 = " + std1);
//
//        //using student obj, get books
//        std1.getBook07().forEach(std-> System.out.println(std));
//
//        Book07 book1 = session.get(Book07.class, 101);
//        //using book, get student objs
//        System.out.println("book1 = " + book1);
//
//        //fetch student name and book name using SQL
//        String sqlQuery1 = "SELECT s.std_name, b.name FROM t_student07 s INNER JOIN t_book07 b ON s.id=b.std_id";
//        List<Object[]> nameList = session.createSQLQuery(sqlQuery1).getResultList();
//        nameList.forEach(x-> System.out.println(Arrays.toString(x)));
//
//        //fetch student name and book name from students who have books using HQL
//        String hqlQuery1 = "SELECT s.name, b.name FROM Student07 s INNER JOIN Book07 b ON s.id=b.student.id";
//        List<Object[]> nameListWithBooks = session.createQuery(hqlQuery1).getResultList();
//        nameListWithBooks.forEach(x-> System.out.println(Arrays.toString(x)));

        //if we want to use data from different tables than we use FETCH, but in HQL we do not use FETCH

        //if between two tables have owner relationship CASCADE keyword
        // deletes not only respective table also related data or table

//        //DELETE records from Book07 using SQL
//        String sqlQuery2 = "DELETE FROM t_book07";
//        int numberOfDeletedRecords = session.createSQLQuery(sqlQuery2).executeUpdate();
//        System.out.println("numberOfDeletedRecords = " + numberOfDeletedRecords);

//        //DELETE records from Student using SQL
//        String sqlQuery3 = "DELETE FROM t_student07";
//        int numberOfDeletedRecords2 = session.createSQLQuery(sqlQuery3).executeUpdate();
//        System.out.println("numberOfDeletedRecords2 = " + numberOfDeletedRecords2);


//        //DELETE records from Book using HQL
//        String hqlQuery3 = "DELETE FROM Book07";
//        int numberOfDeletedRecords4 = session.createQuery(hqlQuery3).executeUpdate();
//        System.out.println("numberOfDeletedRecords4 = " + numberOfDeletedRecords4);
//
//        //DELETE records from Student using HQL
//        String hqlQuery2 = "DELETE FROM Student07";
//        int numberOfDeletedRecords3 = session.createQuery(hqlQuery2).executeUpdate();
//        System.out.println("numberOfDeletedRecords3 = " + numberOfDeletedRecords3);
//
//        //if you don't delete ownership order, then it throws exception

        //Delete Book records which name as "Art Book" using HQL
//        String hqlQuery4 = "DELETE FROM Book07 WHERE name='Art Book'";
//        int numberOfDeletedRecords5 = session.createQuery(hqlQuery4).executeUpdate();
//        System.out.println("numberOfDeletedRecords5 = " + numberOfDeletedRecords5);

        //delete student object with get method() id 1001

        //remove with cascade
//        Student07 std = session.get(Student07.class, 1001);
//        System.out.println(std.getBook07());
//        session.delete(std);
//
//        //remove with OrphanRemove
//        Student07 std2 = session.get(Student07.class, 1002);
//        std2.getBook07().set(0, null);
//        System.out.println(std2.getBook07());

        //write a HQL query which will bring students whose book name has the word "java";
        String hqlQueryJava = "SELECT s FROM Student07 s JOIN s.book07 b WHERE b.name LIKE '%Java%'";
        List<Student07> javaBookStd = session.createQuery(hqlQueryJava, Student07.class).getResultList();
        javaBookStd.forEach(x-> System.out.println(x));


        transaction.commit();
        session.close();
        sessionFactory.close();



    }
}
