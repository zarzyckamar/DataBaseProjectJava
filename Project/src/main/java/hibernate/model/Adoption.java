package hibernate.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADOPTION")
public class Adoption {

    @Id
    @GeneratedValue
    @Column(name = "adoption_number")
    private int numberOfAdoption;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column (name = "adoption_data")
    private DateTime dataOfAdoption;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idanimal", referencedColumnName = "id")
    Animal animal;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idclient", referencedColumnName = "id")
    Client client;

    @JsonIgnore
    public Adoption(DateTime dataOfAdoption, Animal animal, Client client) {
        this.dataOfAdoption = dataOfAdoption;
        this.animal = animal;
        this.client = client;
    }

    public Adoption(DateTime dataOfAdoption, Animal animal, Client client, int id) {
        this.dataOfAdoption = dataOfAdoption;
        this.animal = animal;
        this.client = client;
        this.numberOfAdoption=id;
    }

    public int getNumberOfAdoption() {
        return numberOfAdoption;
    }

    public void setNumberOfAdoption(int numberOfAdoption) {
        this.numberOfAdoption = numberOfAdoption;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


    public void setDataOfAdoption(DateTime dataOfAdoption) {
        this.dataOfAdoption = dataOfAdoption;
    }
}