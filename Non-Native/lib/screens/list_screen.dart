import 'package:flutter/material.dart';
import 'package:flutter_app/model/item_list.dart';
import 'package:flutter_app/model/item_model.dart';
import 'package:flutter_app/screens/add_screen.dart';
import 'package:flutter_app/utils/app_colors.dart';
import 'package:flutter_app/widgets/item_widget.dart';

class ListScreen extends StatefulWidget {
  const ListScreen({Key? key}) : super(key: key);

  @override
  State<ListScreen> createState() => _ListScreenState();
}

class _ListScreenState extends State<ListScreen> {

  ItemList items = ItemList();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        title: const Text("Items"),
        backgroundColor: AppColors.mainColor,
        actions: <Widget>[
          Padding(
            padding: const EdgeInsets.only(right: 20),
            child: GestureDetector(
              onTap: () async {final result = await Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const AddScreen()),
                );
                setState(() {
                  items.addItem(result[0], result[1], result[2], result[3], result[4]);
                });
              },
              child: const Icon(Icons.add),
            ),
          )
        ],
      ),
      body: 
      Column(
        children: [ const SizedBox(
                    height: 20,
                  ),
          Flexible(
            child: ListView.builder(
                itemCount: ItemList.myItems.length,
                itemBuilder: (context, index) {
                  return Dismissible(
                    key: ObjectKey(index),
                    child: Container(
                        margin: const EdgeInsets.only(
                            left: 20, right: 20, bottom: 10),
                        child: ItemWidget(text: ItemList.myItems[index].name)),
                  );
                }),
          )
        ],
      ),
    );
  }
}
