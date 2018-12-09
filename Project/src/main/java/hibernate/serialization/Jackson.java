package hibernate.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import hibernate.model.Client;
import org.apache.log4j.Logger;
import hibernate.model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Jackson {
    private static List<Client> deserializedClient;
    private static List<Animal> deserializedAnimal;
    private static List<Volunteer> deserializedVolunteer;
    private static List<Vaccination> deserializedVaccination;
    private static List<Adoption> desarializedAdoption;

    final static Logger logger = Logger.getLogger(Jackson.class);


    private static void serializeClient(ObjectMapper mapper, String fileSuffix) throws IOException {

        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectCreator objectsCreator = new ModelObjectCreator();

        List<Client> clients = objectsCreator.getClients();

        String jsonString = mapper.writeValueAsString(clients);
        System.out.println(jsonString);

        //Serialize to file and string
        mapper.writeValue(new File("clients." + fileSuffix), clients);
        //ToString Serial
     /*   List<Client> deserializedEmployee = mapper.readValue(
                new File("clients." + fileSuffix), new TypeReference<List<Client>>() { } );*/
    }

    private static void serializeAnimal(ObjectMapper mapper, String fileSuffix) throws IOException {

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectCreator objectsCreator = new ModelObjectCreator();

        List<Animal> animals = objectsCreator.getAnimals();

        String jsonString = mapper.writeValueAsString(animals);
        System.out.println(jsonString);

        //Serialize to file and string
        mapper.writeValue(new File("animals." + fileSuffix), animals);

        //ToString Serial
        /*List<Client> deserializedEmployee2 = mapper.readValue(
                new File("animals." + fileSuffix), new TypeReference<List<Animal>>() {
                });*/
    }

    public static void serializeVolunteer(ObjectMapper mapper, String fileSuffix) throws IOException {

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectCreator objectsCreator = new ModelObjectCreator();

        List<Volunteer> volunteers = objectsCreator.getVolunteers();
        String jsonString = mapper.writeValueAsString(volunteers);
        System.out.println(jsonString);

        //Serialize to file and string
        mapper.writeValue(new File("volunteers." + fileSuffix), volunteers);

        //ToString Serial
/*        List<Client> deserializedEmployee = mapper.readValue(
                new File("volunteers." + fileSuffix), new TypeReference<List<Volunteer>>() {
                });*/
    }
    public static void serializeVaccination(ObjectMapper mapper, String fileSuffix) throws IOException {

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectCreator objectsCreator = new ModelObjectCreator();

        List<Vaccination> vaccinations = objectsCreator.getVaccinations();
        String jsonString = mapper.writeValueAsString(vaccinations);
        System.out.println(jsonString);

        //Serialize to file and string
        mapper.writeValue(new File("vaccination." + fileSuffix), vaccinations);

        //ToString Serial
/*        List<Client> deserializedEmployee = mapper.readValue(
                new File("vaccination." + fileSuffix), new TypeReference<List<Vaccination>>() {
                });*/
    }

    public static void serializeAdoption(ObjectMapper mapper, String fileSuffix) throws IOException {

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectCreator objectsCreator = new ModelObjectCreator();

        List<Adoption> adoptions = objectsCreator.getAdoptions();
        String jsonString = mapper.writeValueAsString(adoptions);
        System.out.println(jsonString);

        //Serialize to file and string
        mapper.writeValue(new File("adoption." + fileSuffix), adoptions);

        //ToString Serial
/*        List<Client> deserializedEmployee = mapper.readValue(
                new File("adoption." + fileSuffix), new TypeReference<List<Adoption>>() {
                });*/
    }



    public static void serializeJson(ObjectMapper jsonMapper) throws IOException {
        serializeClient(jsonMapper, "json");
        serializeAnimal(jsonMapper, "json");
        serializeVolunteer(jsonMapper, "json");
        serializeVaccination(jsonMapper, "json");
        serializeAdoption(jsonMapper, "json");

    }
    public static void serializeXML(ObjectMapper xmlMapper) throws IOException {
        serializeClient(xmlMapper, "xml");
        serializeAnimal(xmlMapper, "xml");
        serializeVaccination(xmlMapper, "xml");
        serializeAdoption(xmlMapper, "xml");
        serializeVolunteer(xmlMapper, "xml");
    }

    public static void deserialize(ObjectMapper mapper) throws IOException {

        String fileSuffix = "json";
        System.out.println("\n\nOdpalam DESERIAIZACJA");
        deserializedClient = mapper.readValue(new File("/Users/User/IdeaProjects/DataBaseProjectJava/clients." + fileSuffix), new TypeReference<List<Client>>() { } );
        for(int i=0; i<deserializedClient.size(); i++) System.out.println(deserializedClient.get(i).getAllInformation());
       /* deserializedAnimal = mapper.readValue(new File("/Users/User/IdeaProjects/DataBaseProjectJava/animals." + fileSuffix), new TypeReference<List<Animal>>() { } );
        for(int i=0; i<deserializedAnimal.size(); i++) System.out.println(deserializedAnimal.get(i).getAllInf());
        deserializedVolunteer = mapper.readValue(new File("/Users/User/IdeaProjects/DataBaseProjectJava/volunteers." + fileSuffix), new TypeReference<List<Volunteer>>() { } );
        for(int i=0; i<deserializedVolunteer.size(); i++) System.out.println(deserializedVolunteer.get(i).getAllInf());
        deserializedVaccination = mapper.readValue(new File("/Users/User/IdeaProjects/DataBaseProjectJava/vaccination." + fileSuffix), new TypeReference<List<Vaccination>>() { } );
        for(int i=0; i<deserializedVaccination.size(); i++) System.out.println(deserializedVaccination.get(i).getAllInformation());
        desarializedAdoption = mapper.readValue(new File("/Users/User/IdeaProjects/DataBaseProjectJava/adoption." + fileSuffix), new TypeReference<List<Adoption>>() { } );
        for(int i=0; i<desarializedAdoption.size(); i++) System.out.println(deserializedVaccination.get(i).getAllInformation());*/
    }


    public static void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ObjectMapper xmlMapper = new XmlMapper();
        jsonMapper.registerModule(new JodaModule());
        xmlMapper.registerModule(new JodaModule());

        deserialize(jsonMapper);

        serializeJson(jsonMapper);
        serializeXML(xmlMapper);

    }
    public static void main(String[] args) throws IOException {

        init();

    }
}


