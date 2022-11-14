import 'package:flutter/material.dart';
import 'package:flutter_app/model/item_list.dart';
import 'package:flutter_app/screens/add_screen.dart';
import 'package:flutter_app/screens/edit_screen.dart';
import 'package:flutter_app/screens/view_screen.dart';
import 'package:flutter_app/utils/app_colors.dart';
import 'package:flutter_app/widgets/button_widget.dart';
import 'package:flutter_app/widgets/item_widget.dart';
import 'package:get/get.dart';

class ListScreen extends StatefulWidget {
  const ListScreen({Key? key}) : super(key: key);

  @override
  State<ListScreen> createState() => _ListScreenState();
}

class _ListScreenState extends State<ListScreen> {
  ItemList items = ItemList();

  @override
  Widget build(BuildContext context) {
    final leftEditIcon = Container(
      margin: const EdgeInsets.only(bottom: 10),
      color: AppColors.secondaryColor.withOpacity(0.5),
      alignment: Alignment.centerLeft,
      child: const Icon(Icons.edit, color: Colors.white),
    );

    final rightDeleteIcon = Container(
      margin: const EdgeInsets.only(bottom: 10),
      color: Colors.red,
      alignment: Alignment.centerRight,
      child: const Icon(Icons.delete, color: Colors.white),
    );

    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        title: const Text("Items"),
        backgroundColor: AppColors.mainColor,
        actions: <Widget>[
          Padding(
            padding: const EdgeInsets.only(right: 20),
            child: GestureDetector(
              onTap: () async {
                final result = await Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => const AddScreen()),
                );
                setState(() {
                  items.addItem(
                      result[0], result[1], result[2], result[3], result[4]);
                });
              },
              child: const Icon(Icons.add),
            ),
          )
        ],
      ),
      body: Column(
        children: [
          const SizedBox(
            height: 20,
          ),
          Flexible(
            child: ListView.builder(
                itemCount: ItemList.myItems.length,
                itemBuilder: (context, index) {
                  return Dismissible(
                    background: leftEditIcon,
                    secondaryBackground: rightDeleteIcon,
                    onDismissed: ((DismissDirection direction) {}),
                    confirmDismiss: ((DismissDirection direction) async {
                      if (direction == DismissDirection.startToEnd) {
                        showModalBottomSheet(
                            barrierColor: AppColors.mainColor.withOpacity(0.4),
                            backgroundColor: Colors.transparent,
                            context: context,
                            builder: (_) {
                              return Container(
                                  height: 200,
                                  padding: const EdgeInsets.only(
                                      left: 20, right: 20),
                                  child: Column(
                                      mainAxisAlignment:
                                          MainAxisAlignment.center,
                                      children: [
                                        GestureDetector(
                                          onTap: () async {
                                            final item = items.getByIndex(index);
                                            final result = await Navigator.push(
                                              context,
                                              MaterialPageRoute(
                                                  builder: (context) =>
                                                       EditScreen(item: item)),
                                            );

                                            setState(() {
                                              items.editItem(item.id, result[0],result[1],result[2],result[3],result[4]);
                                            });
                                          },

                                          child: const ButtonWidget(
                                              backgroundColor:
                                                  AppColors.mainColor,
                                              text: "Edit",
                                              textColor: Colors.white),
                                        ),
                                        const SizedBox(
                                          height: 20,
                                        ),
                                        GestureDetector(
                                          onTap: () {
                                            Navigator.push(
                                              context,
                                              MaterialPageRoute(
                                                  builder: (context) =>
                                                       ViewScreen(item: items.getByIndex(index))),
                                            );
                                          },
                                          child: const ButtonWidget(
                                              backgroundColor:
                                                  AppColors.mainColor,
                                              text: "View",
                                              textColor: Colors.white),
                                        ),
                                      ]));
                            });
                            
                        return false;
                      } //left to right
                      else {
                        showModalBottomSheet(
                            barrierColor: AppColors.mainColor.withOpacity(0.4),
                            backgroundColor: Colors.transparent,
                            context: context,
                            builder: (_) {
                              return Container(
                                  height: 100,
                                  padding: const EdgeInsets.only(
                                      left: 20, right: 20),
                                  child: Column(
                                      mainAxisAlignment:
                                          MainAxisAlignment.center,
                                      children: [
                                        GestureDetector(
                                          onTap: () {
                                            Navigator.pop(context);
                                            setState(() {
                                              items.deleteByIndex(index);
                                            });
                                          },
                                          child: const ButtonWidget(
                                              backgroundColor:
                                                  AppColors.mainColor,
                                              text: "Confirm Delete",
                                              textColor: Colors.red),
                                        ),
                                      ]));
                            });
                      
                      }
                    }),
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
