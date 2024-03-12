package hb07.bi_onetomany;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_student07")
public class Student07 {
    @Id
    private int id;
    @Column(name="std_name",nullable = false)
    private String name;
    private int grade;
    @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.REMOVE)// mappedby sets the owner of relation
//    @JoinColumn()//this will give exception because mappedBy means set relation from the other side...
    //It means: "I gave up, do not try to add new column on my side."
    private List<Book07> book07 = new ArrayList<>();

    //getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book07> getBook07() {
        return book07;
    }

    public void setBook07(List<Book07> book07) {
        this.book07 = book07;
    }

    //toString

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
//                ", book07=" + book07 +
                '}';
    }

    //constructor with parameters

    public Student07(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //empty constructor
    public Student07() {
    }
}
