package GoogleAPIBDD.PageObjectPackage;

public class PutInfo {
    public String PutPayload(){
        String payload = "{\n" +
                "\"place_id\":\"6c6e7339877630403b8f288fe0efeff7\",\n" +
                "\"address\":\"70 Summer walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n";
        return payload;
    }
    public String PutResource(){
        String resource = "/maps/api/place/update/json?key=qaclick123";
        return resource;
    }
}
