import 'package:flutter/material.dart';
import 'package:flutter_app/utils/app_colors.dart';

class ItemWidget extends StatelessWidget {

final String text;
final Color? color;

  const ItemWidget({super.key, required this.text, this.color});
  
  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.maxFinite,
      height: MediaQuery.of(context).size.height/14,
      decoration: BoxDecoration(
        color: AppColors.textHolderColor,
        borderRadius: BorderRadius.circular(10),
      ),
      child:Center(
        child: Text(text, style: const TextStyle(
          fontSize: 20,
          color: Colors.blueGrey
        ),),
      )
    );
  }
}