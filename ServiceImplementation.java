import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by DELL on 7/13/2017.
 */
public class ServiceImplementation {

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
