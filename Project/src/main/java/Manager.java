import hibernate.model.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

class Manager {

    static EntityManager entityManager;
    static EntityManagerFactory entityManagerFactory;
    final static Logger logger = Logger.getLogger(Manager.class);

    public static void main(String[] args) {

        System.out.println("Start");

        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate_dynamic");

        entityManager = entityManagerFactory.createEntityManager();
        try {


            entityManager.getTransaction().begin();

            Animal animal1 = new Animal("Falafel", "dog", false, 5);
            Animal animal2 = new Animal("PrincessCarolyn", "cat", false, 2);
            Animal animal3 = new Animal("Tyran", "dog", true, 7);
            entityManager.persist(animal1);
            entityManager.persist(animal2);
            entityManager.persist(animal3);


            Volunteer vol1 = new Volunteer("Marlena", "Zarzycka", 18);
            Volunteer vol2 = new Volunteer("Aleksandra", "Sadurszczak", 21);

            entityManager.persist(vol1);
            entityManager.persist(vol2);

            animal1.setVolunteer(vol1);
            animal2.setVolunteer(vol1);
            animal3.setVolunteer(vol2);


            Client client1 = new Client("Kamil", "Pyrek", "Czestochowa", "ul.Zwycieska");
            Client client2 = new Client("Ola", "Zarzycka", "Boleslawiec", "ul.Garncarska");
            Client client3 = new Client("Stefan", "Grzyb", "Poznan", "ul.Slowianska");
            Client client4 = new Client("Malwina", "Chudzinka", "Poznan", "ul.Grochowska");
            entityManager.persist(client1);
            entityManager.persist(client2);
            entityManager.persist(client3);
            entityManager.persist(client4);

            Vaccination vac1 = new Vaccination("parainflueza", animal1, "2018-07-21");
            Vaccination vac2 = new Vaccination("bordetella", animal3, "2018-07-21");
            entityManager.persist(vac1);
            entityManager.persist(vac2);

            Adoption adoption1 =new Adoption("2017-07-23", animal3, client3);
            entityManager.persist(adoption1);

            //  DateTime date1 = new DateTime();
            // DateTime date1 = DateTime.Now;
          //  DateTime dt = new DateTime("2004-12-13T21:39:45.618-08:00");



            ///QUERIES\\\\\
            getAllPerson();
            getSomeAnimal();
            getAdultVolunteer();
            getPersonFromPoznan();
            getAllAnimalByPage();


            entityManager.flush();
            entityManager.getTransaction().commit();


            System.out.println("Done");

            entityManager.close();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }

    public static void getAllPerson() {
        Query query = entityManager.createQuery("SELECT k FROM Client k");
        System.out.println("\n\nList of Clients");
        List<Client> result = query.getResultList();
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i).getAllInformation());
    }

    public static void getSomeAnimal() {

        Query query = entityManager.createQuery("SELECT k FROM Animal k WHERE k.type='dog'");
        System.out.println("\n\nList of Dogs");
        List<Animal> result = query.getResultList();

        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i).getAllInf());
    }

    public static void getAdultVolunteer() {

        Query query = entityManager.createQuery("SELECT k FROM Volunteer k WHERE k.age>=18");
        System.out.println("\n\nList of adult Volunteer");
        List<Volunteer> result = query.getResultList();

        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i).getAllInf());
    }

    public static void getPersonFromPoznan() {

        Query query = entityManager.createQuery("SELECT k FROM Client k WHERE k.city='Poznan'");
        System.out.println("\n\nList of People from Poznan");
        List<Client> result = query.getResultList();

        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i).getPoznanPeople());
    }

    public static void getAllAnimalByPage() {
        Query query = entityManager.createQuery("From Animal");
        int pageNumber = 1;
        int pageSize = 2;
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<Animal> empList = query.getResultList();
        for(Animal animal : empList)
            System.out.println(animal.getAllInf());
    }


}







