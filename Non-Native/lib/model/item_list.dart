
import 'package:flutter_app/model/item_model.dart';

class ItemList {

static List myItems = [];
static int nextFreeId = 0;


void addItem(String name, String description, double price, int availableQuantity, [String? imgURL]){
  int id = nextFreeId;
  myItems.add(ItemModel(id, name, description, price, availableQuantity, imgURL));
  nextFreeId++;
}

List fetchAll(){
  return myItems;
}

ItemModel getByIndex(int index){
  return myItems[index];
}

ItemModel getById(int id)
{
  return myItems.firstWhere((element) => element.id == id);
}


void deleteItem(int id)
{
  myItems.removeWhere((element) => element.id == id);
}

 int size() {
   return myItems.length;
 }


}

