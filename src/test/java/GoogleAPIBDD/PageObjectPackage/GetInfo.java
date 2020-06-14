package GoogleAPIBDD.PageObjectPackage;

public class GetInfo {
    public String GetBaseUri(){
        String baseuri = "https://rahulshettyacademy.com";
        return baseuri;
    }
    public String GetResource(){
        String resource = "/maps/api/place/get/json?key=qaclick123&place_id=6c6e7339877630403b8f288fe0efeff7";
        return resource;
    }
}
