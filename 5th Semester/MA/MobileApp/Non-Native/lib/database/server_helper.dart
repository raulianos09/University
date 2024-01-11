import 'dart:convert';
import 'dart:developer';

import 'package:http/http.dart';
import '../model/item_model.dart';

class ServerHelper {
  static Future<List<ItemModel>?> getAllItems() async {
    Response res = await get(Uri.parse("http://10.0.2.2:8080/item"));
    if (res.statusCode == 200) {
      var jsonResponse = json.decode(res.body);
      List<ItemModel> items = List<ItemModel>.from(
          jsonResponse.map((model) => ItemModel.fromJson(model)));
      return items;
    }
  }

  static Future<int> addItem(ItemModel item) async {
    Response id = await get(Uri.parse("http://10.0.2.2:8080/currentID"));
    item.id = json.decode(id.body);
    Response res = await post(Uri.parse("http://10.0.2.2:8080/item"),
        headers: {"Content-Type": "application/json"},
        body: json.encode(item.toJson()));
    if (res.statusCode == 200) {
      var jsonResponse = json.decode(res.body);
      return jsonResponse["id"];
    }
    return -1;
  }

  static void updateItem(ItemModel item) async {
    var URI = "http://10.0.2.2:8080/item/";
    URI += item.id.toString();
    Response res = await put(Uri.parse(URI),
        headers: {"Content-Type": "application/json"},
        body: json.encode(item.toJson()));
    if (res.statusCode == 200) {
      var jsonResponse = json.decode(res.body);
    }
  }

  static void deleteItem(ItemModel item) async {
    var URI = "http://10.0.2.2:8080/item/";
    URI += item.id.toString();
    Response res = await delete(Uri.parse(URI));
  }
}
