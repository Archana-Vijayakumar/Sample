import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Created by DELL on 7/13/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactAddressModel {
  private String contactKey;
  private List<AttributesModel> attributes;
  public ContactAddressModel(){}
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

  @Override
  public String toString() {
    return "ContactAddressModel [contactKey=" + contactKey + ", attributes=" + attributes + "]";
  }

}
