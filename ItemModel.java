import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Created by DELL on 7/13/2017.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
class ItemModel {

  private List<ValueModel> values;
  public ItemModel(){}
  public List<ValueModel> getValues() {
    return values;
  }

  public void setValues(List<ValueModel> values) {
    this.values = values;
  }

  @Override
  public String toString() {
    return "[values=" + values + "]";
  }
}
