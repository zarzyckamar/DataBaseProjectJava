package hibernate.serialization;
import com.sun.org.apache.xpath.internal.operations.Mod;
import hibernate.model.*;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class ModelObjectCreator {

    private Client cli1;
    private Client cli2;
    private Client cli3;
    private Client cli4;

    private Animal ani1;
    private Animal ani2;
    private Animal ani3;

    private Volunteer vol1;
    private Volunteer vol2;

    private Vaccination vac1;
    private Vaccination vac2;
    private Vaccination vac3;

    private Adoption ad1;
    private Adoption ad2;
    private Adoption ad3;

    List<Client> clients;
    List<Animal> animals;
    List<Volunteer> volunteers;
    List<Vaccination> vaccinations;
    List<Adoption> adoptions;

    List<Client> getClients(){return clients;}
    List<Animal> getAnimals(){return animals;}
    List<Volunteer> getVolunteers(){return volunteers;}
    List<Vaccination> getVaccinations(){return vaccinations;}
    List<Adoption> getAdoptions() {return adoptions;}

    public void model() {

        Client cli1 = new Client("Kamil", "Pyrek", "Czestochowa", "ul.Zwycieska");
        Client cli2 = new Client("Ola", "Zarzycka", "Boleslawiec", "ul.Garncarska");
        Client cli3 = new Client("Stefan", "Grzyb", "Poznan", "ul.Slowianska");
        Client cli4 = new Client("Malwina", "Chudzinka", "Poznan", "ul.Grochowska");

        clients = new ArrayList<Client>();
        clients.add(cli1);
        clients.add(cli2);
        clients.add(cli3);
        clients.add(cli4);


        Animal ani1 = new Animal("Falafel","dog", false,1,1);
       Animal ani2 = new Animal("PrincessCarolyn", "cat", false, 2,2);
       Animal ani3 = new Animal("Tyran", "dog", true, 7,3);

        animals = new ArrayList<Animal>();
        animals.add(ani1);
        animals.add(ani2);
        animals.add(ani3);


        Volunteer vol1 = new Volunteer("Marlena", "Zarzycka", 18, 6);
        Volunteer vol2 = new Volunteer("Aleksandra", "Sadurszczak", 21,7 );

        volunteers = new ArrayList<Volunteer>();
        volunteers.add(vol1);
        volunteers.add(vol2);


        Vaccination vac1 = new Vaccination("parainflueza", ani1, "2018-07-21",4);
        Vaccination vac2 = new Vaccination("bordetella", ani2, "2018-07-21",5);

        vaccinations = new ArrayList<Vaccination>();
        vaccinations.add(vac1);
        vaccinations.add(vac2);

        Adoption ad1 =new Adoption(DateTime.now(), ani3, cli3,8);
        Adoption ad2 = new Adoption(DateTime.now(), ani1, cli2,9);

        adoptions = new ArrayList<Adoption>();
        adoptions.add(ad1);
        adoptions.add(ad2);


    }

    public ModelObjectCreator(){
        model();
    }
}
