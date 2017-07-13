import java.util.List;

/**
 * Created by DELL on 7/13/2017.
 */
class ItemModel {
  private List<ValueModel> values;

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
