package hibernate.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VOLUNTEERS")
public class Volunteer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "fitstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "pupil")
    private int idPupil;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public int getIdPupil() {return idPupil;}

    public void setIdPupil(int idPupil) {this.idPupil = idPupil;}
}

