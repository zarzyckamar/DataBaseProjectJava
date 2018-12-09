import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import hibernate.serialization.toSQL;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestSQL {

    final static Logger logger = Logger.getLogger(String.valueOf(TestSQL.class));
    toSQL sql1 = new toSQL();
    ObjectMapper jsonMapper = new ObjectMapper();
    ObjectMapper xmlMapper = new XmlMapper();

    @Test
    public void trueSaveJSON() throws IOException {
        assertTrue(sql1.deserialize(jsonMapper,5, "json"));
    }

    @Test
    public void falseSaveJSON() throws IOException{
        assertFalse(sql1.deserialize(jsonMapper,0, "json"));
    }

    @Test
    public void trueSaveXML() throws IOException{
        assertTrue(sql1.deserialize(xmlMapper,5,"xml" ));
    }

    @Test
    public void falseSaveXML() throws IOException {
        assertFalse(sql1.deserialize(xmlMapper,0, "xml"));
    }






}
