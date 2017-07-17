import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Created by DELL on 7/13/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ContactAddressModel {

  private String contactKey;
  private List<AttributesModel> attributeSet;
  public ContactAddressModel(){}
  public String getContactKey() {
    return contactKey;
  }

  public void setContactKey(String contactKey) {
    this.contactKey = contactKey;
  }

  public List<AttributesModel> getAttributes() {
    return attributeSet;
  }

  public void setAttributes(List<AttributesModel> attributes) {
    this.attributeSet = attributes;
  }

  @Override
  public String toString() {
    return "ContactAddressModel [contactKey=" + contactKey + ", attributes=" + attributeSet + "]";
  }

}
