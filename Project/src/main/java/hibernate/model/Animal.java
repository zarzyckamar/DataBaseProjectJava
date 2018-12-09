package hibernate.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ANIMAL")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true)
    private int id;

    @Column (name = "name")
    private String nameAnimals;

    @Column (name = "type")
    private String type;

    @Column(name="age")
    private int age;

    @Column(name="is_adopted")
    private boolean is_adopted;

    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="volunteer")
    private Volunteer volunteer;

    @OneToMany (mappedBy="animal")
    private List<Vaccination> vaccinations;


    public Animal(String nameAnimals, String type, boolean is_adopted, int age) {
        this.nameAnimals = nameAnimals;
        this.type = type;
        this.is_adopted = is_adopted;
        this.age = age;
    }
    public Animal (String nameAnimals, String type, boolean is_adopted, int age,int id) {
        this.id=id;
        this.nameAnimals = nameAnimals;
        this.type = type;
        this.is_adopted = is_adopted;
        this.age = age;
    }


    @JsonIgnore
    public String getAllInf()
    {
        return id + " " + nameAnimals + " " + type + " " + is_adopted + " " + volunteer.getAllInf();
    }
    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public boolean is_adopted() {
        return is_adopted;
    }

    public void setIs_adopted(boolean is_adopted) {
        this.is_adopted = is_adopted;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String race) {
        this.type = race;
    }

    public String getNameAnimals() {
        return nameAnimals;
    }

    public void setNameAnimals(String nameAnimals) {
        this.nameAnimals = nameAnimals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

