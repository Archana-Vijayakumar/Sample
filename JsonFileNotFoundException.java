import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * Created by DELL on 7/14/2017.
 */
public class JsonFileNotFoundException extends IOException {

  JsonFileNotFoundException(String message){
    super(message);
  }
}
