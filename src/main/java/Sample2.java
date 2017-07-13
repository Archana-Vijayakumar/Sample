import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.post;
import static spark.SparkBase.setPort;

/**
 * Created by DELL on 7/12/2017.
 */
public class Sample2 {
  public static void main(String args[]){
    setPort(8080);
    Sample1 s = new Sample1();
    get("/hello", (request, response) -> "SIMPLE GET METHOD");
    post("/hello", (request, response) -> "SIMPLE POST METHOD" +request.body());
    get("/private", (request, response) ->
    {
      response.status(401);
      return "UN_AUTHORIZED";
    });
    get("/hello/:fname", ((request, response) ->
    {
      return "Hai, Hello "+request.params();
    }));
    get("/news/:section", (request, response) -> {
      response.type("text/xml");
      return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><news>" + request.params("section") + "</news>";
    });
    get("/protected", (request, response) -> {
      halt(400,"Bad Request");
      return null;
    });
    get("/redirect", (request, response) -> {
      response.redirect("/hello");
      return null;
    });
    get("/sampleMethod/:name", (request, response) ->
        {
          if(request.params(":name").equals("vue_data")){
            s.sampleMethod(request.params(":name"));
          }else{
            return null;
          }
          return null;
        }

    );
  }
}
