import 'dart:developer';

import 'package:flutter_app/database/database_helper.dart';
import 'package:flutter_app/model/item_model.dart';

class ItemList {
  static List<ItemModel> myItems = [];

  ItemList() {
    var itm;
    DatabaseHelper.getAllItems()
        .then((value) => itm = value)
        .whenComplete(() => myItems = itm);
  }

  void populate() async {
    DatabaseHelper.getAllItems().then((value) => {
          for (var it in value!) {log(it.toString())},
          myItems = value ?? []
        });
  }

  void addItem(
      String name, String description, double price, int availableQuantity,
      [String? imgURL]) {
    ItemModel itm =
        ItemModel(null, name, description, price, availableQuantity, imgURL);
    DatabaseHelper.addItem(itm).then((id) => myItems.add(
        ItemModel(id, name, description, price, availableQuantity, imgURL)));
  }

  List fetchAll() {
    return myItems;
  }

  ItemModel getByIndex(int index) {
    return myItems[index];
  }

  ItemModel getById(int id) {
    return myItems.firstWhere((element) => element.id == id);
  }

  void deleteItem(int id) {
    var itm = getById(id);
    myItems.removeWhere((element) => element.id == id);
    DatabaseHelper.deleteItem(itm);
  }

  void deleteByIndex(int index) {
    deleteItem(myItems[index].id!);
  }

  int size() {
    return myItems.length;
  }

  void editItem(int id, String name, String description, double price,
      int availableQuantity,
      [String? imgURL]) {
    ItemModel itemToEdit = getById(id);
    itemToEdit.name = name;
    itemToEdit.description = name;
    itemToEdit.price = price;
    itemToEdit.availableQuantity = availableQuantity;
    itemToEdit.imgURL = imgURL;
    DatabaseHelper.updateItem(itemToEdit);
  }
}
