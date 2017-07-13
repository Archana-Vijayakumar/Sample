/**
 * Created by DELL on 7/13/2017.
 */
public class ValueModel {
  private String name;
  private String value;

  public  ValueModel(String name, String value){
    this.name = name;
    this.value = value;
  }

  public ValueModel(){}
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
