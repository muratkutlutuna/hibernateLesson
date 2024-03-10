package hb06.uni_onetomany;


import javax.persistence.*;

@Entity
@Table(name = "t_book06")
public class Book06 {
    @Id
    private int id;
    @Column(name = "book_name")
    private String name;

    @ManyToOne
    private Student06 student;

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

    //toString

    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
