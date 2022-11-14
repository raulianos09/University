import 'package:flutter/material.dart';

import '../utils/app_colors.dart';

class TextFieldWidget extends StatelessWidget {
  final TextEditingController textController;
  final String hintText;
  final double? borderRadius;
  final int? maxLinesNr;

  const TextFieldWidget(
      {Key? key,
      required this.textController,
      required this.hintText,
      this.borderRadius=15,
      this.maxLinesNr=1})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextField(
        
        maxLines: maxLinesNr,
        controller: textController,
        decoration: InputDecoration(
            filled: true,
            fillColor: AppColors.textHolderColor,
            hintText: hintText,
            focusedBorder: OutlineInputBorder(
                borderRadius: BorderRadius.circular(borderRadius!),
                borderSide: const BorderSide(color: Colors.white, width: 1)),
            enabledBorder: OutlineInputBorder(
                borderRadius: BorderRadius.circular(borderRadius!),
                borderSide: const BorderSide(color: Colors.white, width: 1))));
  }
}
