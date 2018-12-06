package hibernate.model;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable=false)
    private int id;

    @Column(name = "fitstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "city")
    private String city;

    @Column(name = "streetname")
    private String street;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) { this.firstName = firstName;   }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setCity(String city) { this.city = city;}

    public void setStreet(String street) { this.street = street;}

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}
