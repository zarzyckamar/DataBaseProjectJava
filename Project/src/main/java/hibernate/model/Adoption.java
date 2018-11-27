package hibernate.model;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADOPTION")
public class Adoption {

    @Id
    @GeneratedValue
    @Column(name = "adoption number")
    private int numberOfAdoption;

    @Column (name = "adoption data")
    private char dataOfAdoption;

    @Column (name = "client id")
    private int idclient;

    @Column(name="animal id")
    private int idanimal;

    public int getNumberOfAdoption() {return numberOfAdoption;}

    public void setNumberOfAdoption(int numberOfAdoption) {this.numberOfAdoption = numberOfAdoption;}

    public char getDataOfAdoption() {return dataOfAdoption;}

    public void setDataOfAdoption(char dataOfAdoption) {this.dataOfAdoption = dataOfAdoption;}

    public int getIdclient() {return idclient;}

    public void setIdclient(int idclient) {this.idclient = idclient;}

    public int getIdanimal() {return idanimal;}

    public void setIdanimal(int idanimal) {this.idanimal = idanimal;}
}