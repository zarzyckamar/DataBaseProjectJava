package hibernate.model;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ANIMALS")
public class Animal {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column (name = "name")
    private String nameAnimals;

    @Column (name = "race")
    private String race;

    @Column(name="age")
    private int age;

    @Column(name="is_adopted")
    private boolean is_adopted;

  /*  @OneToOne (mappedBy="ANIMALS")
    private List<Client> client;
*/
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="id")
    private Volunteer idPupil;


    @OneToMany (mappedBy="vacc")
    private List<Vaccination> vaccinations;



    public Animal(Volunteer idPupil, List<Vaccination> vaccinations) {
        this.idPupil = idPupil;
        this.vaccinations = vaccinations;
    }

    public int getId() {
        return id;
    }

    public String getNameAnimals() {
        return nameAnimals;
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    public boolean isIs_adopted() {
        return is_adopted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameAnimals(String nameAnimals) {
        this.nameAnimals = nameAnimals;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIs_adopted(boolean is_adopted) {
        this.is_adopted = is_adopted;
    }



}
