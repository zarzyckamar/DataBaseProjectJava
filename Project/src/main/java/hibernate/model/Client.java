package hibernate.model;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true)
    private int id;

    @Column(name = "fitstname")
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "city")
    private String city;

    @Column(name = "streetname")
    private String street;

    public int getId() {
        return id;
    }

    public Client(String firstName, String lastName, String city, String street) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAllInformation()
    {
        return id + " " + firstName + " " + lastName + " " + city + " " + street;
    }

    public String getPoznanPeople() { return id + " " + firstName + " " + lastName;}

    public Client() {}

    public static Client copyClient(Client cli) {
        Client person = new Client();
        person.setId(cli.getId());
        person.setFirstName(cli.getFirstName());
        person.setLastName(cli.getLastName());
        person.setCity(cli.getCity());
        person.setStreet(cli.getStreet());
        return person;
    }
}
