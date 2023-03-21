package spring.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name ="lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
//    @Column(name = "studentFormat")
//    private StudentForms studentForms;

    @ManyToOne
    @JoinColumn(name = "groupsId")
    private Groups group;

    public Student(String firstName, String lastName, String email
//            , StudentForms studentForms
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
//        this.studentForms = studentForms;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
//                ", studentForms=" + studentForms +
                '}';
    }


}
