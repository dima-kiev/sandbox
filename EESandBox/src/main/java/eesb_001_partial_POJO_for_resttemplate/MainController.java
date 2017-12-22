package eesb_001_partial_POJO_for_resttemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    String home() {

    String testJSON = "{\"id\":\"aProcessDefinitionId\",\n" +
            "    \"key\":\"aKey\",\n" +
            "    \"category\":\"aCategory\",\n" +
            "    \"description\":\"aDescription\",\n" +
            "    \"name\":\"aName\",\n" +
            "    \"version\":42,\n" +
            "    \"resource\":\"aResourceName\",\n" +
            "    \"deploymentId\":\"aDeploymentId\",\n" +
            "    \"diagram\":\"aResourceName\",\n" +
            "    \"suspended\":true,\n" +
            "    \"tenantId\":null,\n" +
            "    \"versionTag\":\"1.0.0\"}";

        ObjectMapper mapper = new ObjectMapper();

        PartialPOJO obj = mapper.convertValue(testJSON, PartialPOJO.class);

        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
    }
}

class PartialPOJO {

    private String id;
    private String key;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}