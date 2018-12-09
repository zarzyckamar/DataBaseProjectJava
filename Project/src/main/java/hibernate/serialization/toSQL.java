package hibernate.serialization;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hibernate.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class toSQL {

    private static List<Client> deserializedClient;

    static EntityManager entityManager;
    static EntityManagerFactory entityManagerFactory;

    public static boolean deserialize(ObjectMapper mapper, int j, String fileSuffix) throws IOException {

        Boolean isTrue=true;
        System.out.println("\n\nOdpalam DESERIAIZACJA");
        deserializedClient = mapper.readValue(new File("/Users/User/IdeaProjects/DataBaseProjectJava/clients." + fileSuffix), new TypeReference<List<Client>>() {
        });

        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate_dynamic");

        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if(j==0)
            {
                Client c = new Client();
                c.setCity("Warszawa");
                deserializedClient.add(c);

            }
            for (int i = 0; i < deserializedClient.size(); i++) {
                entityManager.persist(deserializedClient.get(i));
            }

            entityManager.flush();
            entityManager.getTransaction().commit();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            isTrue=false;
        } finally {

            entityManagerFactory.close();
        }
        return isTrue;
    }


}
