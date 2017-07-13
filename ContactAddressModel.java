import java.util.List;

/**
 * Created by DELL on 7/13/2017.
 */
public class ContactAddressModel {
  private String contactKey;
  private List<AttributesModel> attributes;

  public String getContactKey() {
    return contactKey;
  }

  public void setContactKey(String contactKey) {
    this.contactKey = contactKey;
  }

  public List<AttributesModel> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<AttributesModel> attributes) {
    this.attributes = attributes;
  }
}
