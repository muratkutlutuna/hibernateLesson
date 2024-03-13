package hb08.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_book08")
public class Book08 {
    @Id
    private int id;
    private String name;
    @ManyToMany(mappedBy = "bookList")
    private List<Student08> students = new ArrayList<>();

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

    public List<Student08> getStudents() {
        return students;
    }

    public void setStudents(List<Student08> students) {
        this.students = students;
    }

    //toString


    @Override
    public String toString() {
        return "Book08{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", students=" + students + //in manytomany relationship to handle
//                stackoverflow exception you can delete students from book08 in the toString method class or
//                bookList from Student08 class in the toString method
                '}';
    }
}
