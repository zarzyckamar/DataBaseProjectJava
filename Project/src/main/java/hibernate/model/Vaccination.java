package hibernate.model;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANIMALS")
public class Vaccination {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int idvaccination;

    @Column(name = "vaccination_name")
    private String namevaccinaiton;

    @ManyToOne(fetch=FetchType.LAZY)
    @Column(name = "id_of_animal")
    private Animal idanimal;

    @Column(name = "data")
    private String data;


    public int getIdvaccination() {return idvaccination;}

    public void setIdvaccination(int idvaccination) {this.idvaccination = idvaccination;}

    public String getNamevaccinaiton() {return namevaccinaiton;}

    public void setNamevaccinaiton(String namevaccinaiton) {this.namevaccinaiton = namevaccinaiton;}

    public int getIdanimal() {return idanimal;}

    public void setIdanimal(int idanimal) {this.idanimal = idanimal;}

    public String getData() {return data;}

    public void setData(String data) {this.data = data;}
}