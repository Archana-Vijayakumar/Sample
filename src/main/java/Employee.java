import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by DELL on 7/12/2017.
 */
@JsonIgnoreProperties({"eId", "eAge"})
public class Employee {
  @JsonIgnore
  private String eName;
  private Integer eId;
  private Integer eAge;
  private Integer eSalary;

  Employee(){}
  public Employee(String eName, Integer eId, Integer eAge, Integer eSalary){
    this.eName = eName;
    this.eId = eId;
    this.eAge = eAge;
    this.eSalary = eSalary;
  }
  public String geteName() {
    return eName;
  }

  public void seteName(String eName) {
    this.eName = eName;
  }

  public Integer geteId() {
    return eId;
  }

  public void seteId(Integer eId) {
    this.eId = eId;
  }

  public Integer geteAge() {
    return eAge;
  }

  public void seteAge(Integer eAge) {
    this.eAge = eAge;
  }

  public Integer geteSalary() {
    return eSalary;
  }

  public void seteSalary(Integer eSalary) {
    this.eSalary = eSalary;
  }

  //@JsonValue
  public static String toJson(Employee employee){
    return employee.geteName() + "\n" + employee.geteId() + "\n" + employee.geteAge() + "\n" + employee.geteSalary();
  }

  public String toString(){
    return eName+" "+eId+ " "+eAge+ " " +eSalary;
  }
}
