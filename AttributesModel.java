import java.util.List;

/**
 * Created by DELL on 7/13/2017.
 */
class AttributesModel {
  private String name;
  private ItemModel items;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ItemModel getItems() {
    return items;
  }

  public void setItems(ItemModel items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "[name=" + name + ", items=" + items + "]";
  }
}
