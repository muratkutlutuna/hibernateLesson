package hb03.uni_onetoone;


import javax.persistence.*;

@Entity
@Table(name="t_diary")
public class Dairy {//this will be default "diary"

    @Id
    private int id;
    private String name;

    @OneToOne//in my diary new column be added with default name "student_id"
    @JoinColumn(name="std_id")
    private Student03 student;

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    //toString

    @Override
    public String toString() {
        return "Dairy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
