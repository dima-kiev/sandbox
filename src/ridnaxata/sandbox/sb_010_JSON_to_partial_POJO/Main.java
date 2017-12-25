//package ridnaxata.sandbox.sb_010_JSON_to_partial_POJO;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        String testJSON = "{\"id\":\"aProcessDefinitionId\",\n" +
//                "    \"key\":\"aKey\",\n" +
//                "    \"category\":\"aCategory\",\n" +
//                "    \"description\":\"aDescription\",\n" +
//                "    \"name\":\"aName\",\n" +
//                "    \"version\":42,\n" +
//                "    \"resource\":\"aResourceName\",\n" +
//                "    \"deploymentId\":\"aDeploymentId\",\n" +
//                "    \"diagram\":\"aResourceName\",\n" +
//                "    \"suspended\":true,\n" +
//                "    \"tenantId\":null,\n" +
//                "    \"versionTag\":\"1.0.0\"}";
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        //TODO bound the jackson and check the case
//        //PartialPOJO obj = mapper.convertValue(testJSON, PartialPOJO.class);
//
//        System.out.println("");
//    }
//
//}
//
//class PartialPOJO {
//
//    private String id;
//    private String key;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//}
