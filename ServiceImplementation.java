import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 7/13/2017.
 */
public class ServiceImplementation {

    List<ContactAddressModel> contactAddressModelList = new ArrayList<>();
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
      contactAddressModel.setContactKey(s);
      contactAddressModel.setAttributes(attributesModels);

      contactAddressModelList.add(contactAddressModel);

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

      get("/getDetails",(request, response) ->
      {
        return new Gson().toJson(serviceImplementation.setValues());
      });

      post("/createDetail", (request, response) -> {

        ObjectMapper mapper = new ObjectMapper();
        ContactAddressModel contactAddressModel = null;
        try {
          contactAddressModel = mapper.readValue(request.body(), ContactAddressModel.class);
        } catch (IOException e) {
          e.printStackTrace();
        }
        return serviceImplementation.createValue(contactAddressModel);
        /*ContactAddressModel newModel = new Gson().fromJson(request.body(), ContactAddressModel.class);
        return new Gson().toJson(serviceImplementation.createValue(newModel));*/
      });

      put("/updateDetail", (request, response) ->{
        ContactAddressModel newModel = new Gson().fromJson(request.body(), ContactAddressModel.class);
        return  new Gson().toJson(serviceImplementation.updateDetail(newModel));
      });
    }

    public String createValue(ContactAddressModel newModel){

      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(newModel);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
      return null;
     /* ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      String json = ow.writeValueAsString(object);*/
      /*ContactAddressModel createdModel = new ContactAddressModel();
      createdModel.setContactKey(newModel.getContactKey());

      List<AttributesModel> attributesModelList = new ArrayList<>();


      for(int i = 0; i < newModel.getAttributes().size(); i++){
        List<ValueModel> valueModelList = new ArrayList<>();
        AttributesModel attributesModel = newModel.getAttributes().get(i);
        ItemModel itemModel = attributesModel.getItems();
        for(int j=0; j < itemModel.getValues().size(); j++){
          ValueModel valueModel = new ValueModel();
          valueModel.setName(itemModel.getValues().get(j).getName());
          valueModel.setValue(itemModel.getValues().get(j).getValue());
          valueModelList.add(valueModel);
        }
        itemModel.setValues(valueModelList);
        attributesModelList.add(attributesModel);
      }
      createdModel.setAttributes(attributesModelList);
      System.out.print(new Gson().toJson(createdModel));
      contactAddressModelList.add(createdModel);
      return createdModel;*/

    }

    public ContactAddressModel updateDetail(ContactAddressModel model){
        return model;
    }
}
