package hb09.fetchtypes;

import hb07.bi_onetomany.Book07;
import hb08.manytomany.Book08;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student09")
public class Student09 {
    @Id
    private int id;
    @Column(name="std_name",nullable = false)
    private String name;
    private int grade;
    @OneToMany(mappedBy = "student"
            ,cascade = CascadeType.ALL
            ,fetch = FetchType.EAGER
    )
    private List<Book09> bookList = new ArrayList<>();

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

    public List<Book09> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book09> bookList) {
        this.bookList = bookList;
    }

    //toString

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
