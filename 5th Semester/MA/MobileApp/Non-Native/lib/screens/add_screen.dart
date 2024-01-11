import 'package:flutter/material.dart';
import 'package:flutter_app/utils/app_colors.dart';
import 'package:flutter_app/widgets/button_widget.dart';
import 'package:flutter_app/widgets/textfield_widget.dart';

class AddScreen extends StatefulWidget {
  const AddScreen({Key? key}) : super(key: key);

  @override
  State<AddScreen> createState() => _AddScreenState();
}

class _AddScreenState extends State<AddScreen> {
  @override
  Widget build(BuildContext context) {
    TextEditingController nameController = TextEditingController();
    TextEditingController descriptionController = TextEditingController();
    TextEditingController priceController = TextEditingController();
    TextEditingController availableQuantityController = TextEditingController();
    TextEditingController imageController = TextEditingController();

    return Scaffold(
      body: Container(
          width: double.maxFinite,
          height: double.maxFinite,
          padding: const EdgeInsets.only(left: 20, right: 20),
          child:
              Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
            Column(children: [
              const SizedBox(
                height: 60,
              ),
              IconButton(
                  onPressed: () {
                    Navigator.pop(context);
                  },
                  icon: const Icon(
                    Icons.arrow_back,
                    color: AppColors.mainColor,
                  ))
            ]),
            Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  TextFieldWidget(
                      textController: nameController, hintText: "Item name"),
                  const SizedBox(
                    height: 20,
                  ),
                  TextFieldWidget(
                      textController: descriptionController,
                      hintText: "Description",
                      maxLinesNr: 5,
                      borderRadius: 15),
                  const SizedBox(
                    height: 20,
                  ),
                  TextFieldWidget(
                      textController: priceController, hintText: "Price"),
                  const SizedBox(
                    height: 20,
                  ),
                  TextFieldWidget(
                      textController: availableQuantityController,
                      hintText: "Available Quantity"),
                  const SizedBox(
                    height: 20,
                  ),
                  TextFieldWidget(
                      textController: imageController, hintText: "Image URL"),
                  const SizedBox(
                    height: 120,
                  ),
                  GestureDetector(
                      onTap: () { 
                        Navigator.pop(context,[nameController.text,descriptionController.text,
                        double.parse(priceController.text),
                        int.parse(availableQuantityController.text),
                        imageController.text]);

                      },
                      child: const ButtonWidget(
                          backgroundColor: AppColors.mainColor,
                          text: "Add Item",
                          textColor: Colors.white))
                ])
          ])),
    );
  }
}
