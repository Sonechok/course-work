package codingcity.error;

public class ResourceNotFoundException extends RuntimeException  {
    public ResourceNotFoundException(String resource, String valueOfResource) {
        super("Resource ["+ resource +"] with value" + valueOfResource + " was not found");
    }
}
