package hibernate.model;


import org.joda.time.DateTime;

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

    @Column (name = "adoption_data")
    private DateTime dataOfAdoption;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idanimal", referencedColumnName = "id")
    Animal animal;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idclient", referencedColumnName = "id")
    Client client;

    public Adoption(DateTime dataOfAdoption, Animal animal, Client client) {
        this.dataOfAdoption = dataOfAdoption;
        this.animal = animal;
        this.client = client;
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

    public DateTime getDataOfAdoption() {
        return dataOfAdoption;
    }

    public void setDataOfAdoption(DateTime dataOfAdoption) {
        this.dataOfAdoption = dataOfAdoption;
    }
}