import 'package:flutter_app/model/item_model.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

class DatabaseHelper {
  static const int _version = 1;
  static const String _dbName = "Items.db";

  static Future<Database> _getDB() async {
    return openDatabase(join(await getDatabasesPath(), _dbName),
        onCreate: ((db, version) async => await db.execute(
            "CREATE TABLE Items(id INTEGER PRIMARY KEY, name TEXT NOT NULL, description TEXT NOT NULL, price DOUBLE, availableQuantity INTEGER, imgURL TEXT)")),
        version: _version);
  }

  static Future<int> addItem(ItemModel item) async{
    final db = await _getDB();
    return await db.insert("Items", item.toJson());
  }

  static Future<int> updateItem(ItemModel item) async{
    final db = await _getDB();
    return await db.update("Items", item.toJson(), where: 'id = ?', whereArgs: [item.id]);
  }

  static Future<int> deleteItem(ItemModel item) async{
    final db = await _getDB();
    return await db.delete("Items",where: 'id = ?', whereArgs: [item.id]);
  }

  static Future<List<ItemModel>?> getAllItems() async {
    final db = await _getDB();

    final List<Map<String,dynamic>> maps = await db.query("Items");

    if(maps.isEmpty){
      return null;
    }

    return List.generate(maps.length, (index) => ItemModel.fromJson(maps[index]));
  }

}
