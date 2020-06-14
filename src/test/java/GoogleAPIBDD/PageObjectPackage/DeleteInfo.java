package GoogleAPIBDD.PageObjectPackage;

public class DeleteInfo {
    public String DeletePayload(){
        String payload = "{\n" +
                "    \"place_id\":\"6c6e7339877630403b8f288fe0efeff7\"\n" +
                "}\n";
        return payload;
    }
    public String DeleteResource(){
        String resource = "/maps/api/place/delete/json?key=qaclick123";
        return resource;
    }
}
