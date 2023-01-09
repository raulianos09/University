import 'dart:developer';

import 'package:flutter_app/database/database_helper.dart';
import 'package:flutter_app/database/server_helper.dart';
import 'package:flutter_app/model/item_model.dart';

class ItemList {
  static List<ItemModel> myItems = [];

  ItemList(List<ItemModel> itms) {
    myItems = itms;
  }

  Future<bool> addItem(
      String name, String description, double price, int availableQuantity,
      [String? imgURL]) async {
    ItemModel itm =
        ItemModel(null, name, description, price, availableQuantity, imgURL);

    //add to local db
    //var id = await DatabaseHelper.addItem(itm);
    //add to server
    var id = await ServerHelper.addItem(itm);
    // add to inmemory repo
    myItems.add(
        ItemModel(id, name, description, price, availableQuantity, imgURL));
    return id != null;
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
    ServerHelper.deleteItem(itm);
    //DatabaseHelper.deleteItem(itm);
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
    itemToEdit.description = description;
    itemToEdit.price = price;
    itemToEdit.availableQuantity = availableQuantity;
    itemToEdit.imgURL = imgURL;
    //DatabaseHelper.updateItem(itemToEdit);
    ServerHelper.updateItem(itemToEdit);
  }
}
