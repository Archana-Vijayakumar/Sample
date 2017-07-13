/**
 * Created by DELL on 7/12/2017.
 */

import static spark.Spark.*;
public class Sample1 {
  public String sampleMethod(String name){
    if("vue_data".equals(name)){
      return "String Match";
    } else{
      return "String Not Matched";
    }
  }
  public static void main(String[] args) {
    setPort(8080);
    get("/hello/:name", (request, response) -> {
      if (request.params(":name").equals("vue_data")) {
        return "INSIDE IF";
      } else {
        halt(400,"something wrong in url");
      }
      return "SUCCESS";
    });
  }
}