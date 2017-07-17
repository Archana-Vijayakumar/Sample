import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;


/**
 * Created by DELL on 7/13/2017.
 */
public class ServiceImplementation {

    Logger logger = Logger.getLogger(ServiceImplementation.class);
      public static void main(String[] args){
      ServiceImplementation serviceImplementation = new ServiceImplementation();

      get("/getDetails",(request, response) ->{
            try {
              return serviceImplementation.newValue();
            } catch (JsonFileNotFoundException e) {
              e.printStackTrace();
            }
            return null;
          }
      );

      post("/createDetail", (request, response) -> {

        ObjectMapper mapper = new ObjectMapper();
        ContactAddressModel contactAddressModel = null;
        try {
          contactAddressModel = mapper.readValue(request.body(), ContactAddressModel.class);
        } catch (IOException e) {
          e.printStackTrace();
        }
        return serviceImplementation.createValue(contactAddressModel);
      });

      put("/updateDetail", (request, response) ->{
        ContactAddressModel newModel = new Gson().fromJson(request.body(), ContactAddressModel.class);
        return  new Gson().toJson(serviceImplementation.updateDetail(newModel));
      });
    }

    public String createValue(ContactAddressModel newModel){
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
          return ow.writeValueAsString(newModel);
        } catch (JsonProcessingException e) {
          e.printStackTrace();
        }
      return null;
     }

    public ContactAddressModel updateDetail(ContactAddressModel model){
        return model;
    }

    public ContactAddressModel newValue() throws JsonFileNotFoundException{
      logger.info("Inside the Method used to create the new value");
      ObjectMapper mapper = new ObjectMapper();
      mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
      ContactAddressModel contactAddressModel = null;
      try {
        contactAddressModel = mapper.readValue(new File("src/main/resources/Content1.json"),ContactAddressModel.class);
      } catch (IOException e) {
          throw new JsonFileNotFoundException("File is Not Accessible");
      }
      return contactAddressModel;
    }
}
