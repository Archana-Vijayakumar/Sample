
import static javafx.scene.input.KeyCode.J;
import static spark.Spark.get;
import static spark.Spark.put;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.ws.RequestWrapper;
import spark.Request;
import spark.Response;


/**
 * Created by DELL on 7/12/2017.
 */
public class EmpService {


  public static void main(String[] args) {
    EmpService service = new EmpService();
    get("/getEmployee", (request, response) ->
        getEmployee()

    );
    put("/updateEmployee", (request, response) ->
        {
          Employee employee = new Gson().fromJson(request.body(), Employee.class);
          return updateEmployee(employee);
        }
    );
  }
 public static String getEmployee(){
   Employee e= new Employee("name1",null,null,10000);
   Gson gson = new Gson();
   return gson.toJson(e);
 }

 public static String updateEmployee(Employee employee){
  /* System.out.println(s1);
   System.out.println(s2);
   System.out.println(s3);
   System.out.println(s4);*/
   //Employee e = new Gson().fromJson(s , Employee.class);
   System.out.println(employee);
   Employee updatedEmployee = new Employee();
   /*updatedEmployee.seteName(e.geteName());
   updatedEmployee.seteAge(e.geteAge());
   updatedEmployee.seteId(e.geteId());
   updatedEmployee.seteSalary(e.geteSalary());
   return Employee.toJson(updatedEmployee);*/
   return null;
 }


}
