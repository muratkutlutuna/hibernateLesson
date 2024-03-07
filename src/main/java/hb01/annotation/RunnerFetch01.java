package hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * This class is used to read data
 */
public class RunnerFetch01 {

    public static void main(String[] args) {


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        /*
            In order to fetch data from DB, there are 3 ways
                1. get();
                2. SQL query
                3. HQL query
         */

        //=========== 1st way: get() ================
//        Student01 student1 = session.get(Student01.class, 1001);
//        Student01 student2 = session.get(Student01.class, 1002);
//        Student01 student3= session.get(Student01.class, 1003);
//
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
        // get method will run select query. If you want to fetch different student each time
        // select query will run

        //=========== 2nd way: SQL query ================
//        String sqlQuery = "select * from t_student01";
//
//        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
//
//        for (Object[] std : resultList) {
//            System.out.println(Arrays.toString(std));
//        }
        //=========== 3rd way: HQL query ================
//        String hqlQuery1 = "FROM Student01";
//        List<Student01> resultList2 = session.createQuery(hqlQuery1, Student01.class).getResultList();
//
//        for (Student01 std : resultList2) {
//            System.out.println(std);
//        }

        //If you want to fetch some unique data using hql
//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE std_name = 'Cigdem'";
//        Object[] studentCigdem = (Object[])session.createSQLQuery(sqlQuery2).uniqueResult();
//
//        System.out.println(Arrays.toString(studentCigdem));
//        System.out.println(studentCigdem[0]+" "+studentCigdem[1]+" "+studentCigdem[2]);

        //if you want to fetch some unique data using hql

//        String hqlQuery2 = "FROM Student01 WHERE name = 'Marian'";
//        String hqlQuery2 = "FROM Student01 s WHERE s.name = 'Marian'";
//        Student01 std = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(std);

        //if you want to fetch students whose id is less 1003 using hql
        String hqlQuery3 = "SELECT name FROM Student01 s WHERE s.id<1003";
        List<String> resultList = session.createQuery(hqlQuery3).getResultList();
        resultList.forEach(x-> System.out.println(x));
        System.out.println("==================================");
        String hqlQuery4 = "FROM Student01 s WHERE s.id<1003";
        List<Student01> resultLis4 = session.createQuery(hqlQuery4, Student01.class).getResultList();
        resultLis4.forEach(x-> System.out.println(x));
        System.out.println("==================================");
        String hqlQuery5 = "SELECT s.name, s.id FROM Student01 s WHERE s.id<1003";
        List<Object[]> resultLis5 = session.createQuery(hqlQuery5).getResultList();
        resultLis5.forEach(x-> System.out.println(Arrays.toString(x)));
/*
Hibernate:
    select
        student01x0_.std_name as col_0_0_
    from
        t_student01 student01x0_
    where
        student01x0_.id<1003
Cigdem
Marian
==================================
Hibernate:
    select
        student01x0_.id as id1_0_,
        student01x0_.grade as grade2_0_,
        student01x0_.std_name as std_name3_0_
    from
        t_student01 student01x0_
    where
        student01x0_.id<1003
Student01{id=1001, name='Cigdem', grade=99}
Student01{id=1002, name='Marian', grade=98}
==================================
Hibernate:
    select
        student01x0_.std_name as col_0_0_,
        student01x0_.id as col_1_0_
    from
        t_student01 student01x0_
    where
        student01x0_.id<1003
[Cigdem, 1001]
[Marian, 1002]
 */

        tx.commit();
        session.close();
        sf.close();


    }

}
