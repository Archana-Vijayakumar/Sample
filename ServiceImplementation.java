import static spark.Spark.get;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 7/13/2017.
 */
public class ServiceImplementation {


    public ValueModel setValueModel(String s1,String s2) {

      ValueModel valueModel = new ValueModel();
      valueModel.setName(s1);
      valueModel.setValue(s2);
      return valueModel;
    }

    public AttributesModel setAttributeModel(String s, ItemModel itemModels){
      AttributesModel attributesModel = new AttributesModel();
      attributesModel.setName(s);
      attributesModel.setItems(itemModels);
      return attributesModel;
    }

    public ContactAddressModel setContactAddressModel(String s, List<AttributesModel> attributesModels){
      ContactAddressModel contactAddressModel = new ContactAddressModel();
      contactAddressModel.setContactKey("6dcb271e-06db-4100-bebb-b145469cd4d1");
      contactAddressModel.setAttributes(attributesModels);
      return contactAddressModel;
    }
    public ContactAddressModel setValues(){

      ItemModel itemModel2 = new ItemModel();
      List<ValueModel> valueModelList2 = new ArrayList<>();
      valueModelList2.add(setValueModel("Email Address", "preethi@usermind.com"));
      valueModelList2.add(setValueModel("HTML Enabled", "true"));
      itemModel2.setValues(valueModelList2);
      List<AttributesModel> attributesModelList = new ArrayList<>();
      attributesModelList.add(setAttributeModel("test data1",itemModel2));

      ItemModel itemModel1 = new ItemModel();
      List<ValueModel> valueModelList1 = new ArrayList<>();
      valueModelList1.add(setValueModel("Email Address", "preethi@usermind.com"));
      valueModelList1.add(setValueModel("First Name", "Preethi"));
      itemModel1.setValues(valueModelList1);
      attributesModelList.add(setAttributeModel("test data2",itemModel1));

      return setContactAddressModel("6dcb271e-06db-4100-bebb-b145469cd4d1",attributesModelList);
    }

    public static void main(String[] args){
      ServiceImplementation serviceImplementation = new ServiceImplementation();
      System.out.println(new Gson().toJson(serviceImplementation.setValues()));
      get("/getDetails",(request, response) ->
      {
        return new Gson().toJson(serviceImplementation.setValues());
      });
    }
}
