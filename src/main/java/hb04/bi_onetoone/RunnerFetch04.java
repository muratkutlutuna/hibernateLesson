package hb04.bi_onetoone;

import hb03.uni_onetoone.Dairy;
import hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Dairy04.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //get a student and dairy by ID using get method
        Student04 std1 = session.get(Student04.class, 1001);
        System.out.println("std1 = " + std1);

        System.out.println("======= get diary object over student ========");
        System.out.println("std1.getDairy() = " + std1.getDairy());

        System.out.println();
        Dairy04 dry1 = session.get(Dairy04.class, 101);
        System.out.println("dry1 = " + dry1);

        System.out.println("======= get student object over diary ========");
        System.out.println("dry1.getStudent() = " + dry1.getStudent());

        System.out.println("======= get student name through diary obj ========");
        System.out.println("dry1.getStudent().getName() = " + dry1.getStudent().getName());

        System.out.println("************* INNER JOIN *************");//or just JOIN
        String hql1 = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Dairy04 d ON s.id = d.student.id";
        List<Object[]> resultList = session.createQuery(hql1).getResultList();
        resultList.forEach(s-> System.out.println(Arrays.toString(s)));
//        List<Student04> resultList1 = session.createQuery(hql1, Student04.class).getResultList();
//      we cannot set anything like the above line of code, because the expected result is not Student04 class
        //it is just names of both tables.

        System.out.println("************* LEFT JOIN *************");
        String hql2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Dairy04 d ON s.id = d.student.id";
        List<Object[]> resultList2 = session.createQuery(hql2).getResultList();
        resultList2.forEach(s-> System.out.println(Arrays.toString(s)));
 
        System.out.println("======== sql query LEFT JOIN ===========");
        //sql version of the above query
        String sqlQuery = "SELECT s.std_name, d.name FROM t_student04 s LEFT JOIN t_dairy04 d ON s.id=d.std_id";
        List<Object[]> sqlResultList = session.createSQLQuery(sqlQuery).getResultList();
        sqlResultList.forEach(s-> System.out.println(Arrays.toString(s)));
        System.out.println();

        System.out.println("************* RIGHT JOIN *************");
        String hql3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Dairy04 d ON s.id = d.student.id";
        List<Object[]> resultList3 = session.createQuery(hql3).getResultList();
        resultList3.forEach(s-> System.out.println(Arrays.toString(s)));

        System.out.println("************* FULL JOIN *************");
        String hql4 = "SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Dairy04 d ON s.id = d.student.id";
        List<Object[]> resultList4 = session.createQuery(hql4).getResultList();
        resultList4.forEach(s-> System.out.println(Arrays.toString(s)));



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
