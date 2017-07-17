import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Created by DELL on 7/13/2017.
 */

class AttributesModel {
  private String name;
  private List<ItemModel> items;
  public AttributesModel(){}
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<ItemModel> getItems() {
    return items;
  }

  public void setItems(List<ItemModel> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "[name=" + name + ", items=" + items + "]";
  }
}
