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
/*        List<Client> deserializedEmployee = mapper.readValue(
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
     /*   List<Client> deserializedEmployee2 = mapper.readValue(
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

   public static void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ObjectMapper xmlMapper = new XmlMapper();
        jsonMapper.registerModule(new JodaModule());
        //serializeDemo(jsonMapper, "json");
        //serializeDemo(xmlMapper, "xml");
     //   deserialize(jsonMapper);

        serializeJson(jsonMapper);
        serializeXML(xmlMapper);

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

   /* public static void deserialize(ObjectMapper mapper) throws IOException {

        String fileSuffix = "json";
        String fileSuffix2 = "xml";
        deserializedPerson = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/person." + fileSuffix), new TypeReference<List<Person>>() { } );
        System.out.println(deserializedPerson);
        deserializedCourse = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/course." + fileSuffix), new TypeReference<List<Course>>() { } );
        deserializedSpeaker = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/speakers." + fileSuffix), new TypeReference<List<Speaker>>() { } );
        deserializedAddress = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/address." + fileSuffix), new TypeReference<List<Address>>() { } );
        deserializedOpinion = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/opinion." + fileSuffix), new TypeReference<List<Opinion>>() { } );
        deserializedPerson2 = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/person." + fileSuffix), new TypeReference<List<Person>>() { } );
        deserializedCourse2 = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/course." + fileSuffix), new TypeReference<List<Course>>() { } );
        deserializedSpeaker2 = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/speakers." + fileSuffix), new TypeReference<List<Speaker>>() { } );
        deserializedAddress2 = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/address." + fileSuffix), new TypeReference<List<Address>>() { } );
        deserializedOpinion2 = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/opinion." + fileSuffix), new TypeReference<List<Opinion>>() { } );

    }*/
   public static void main(String[] args) throws IOException {

       init();

   }
}


