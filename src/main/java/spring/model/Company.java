package spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity//отоброжение сущности обьектов
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )//принимает вырастание чисел айди
    private int id;
    @Column  (name = "companyName")
    private String companyName;
    @Column (name =  "locatedCountry")
    private String locatedCountry;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Course> course;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Groups> groups;


    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", locatedCountry='" + locatedCountry + '\'' +
                '}';
    }

}