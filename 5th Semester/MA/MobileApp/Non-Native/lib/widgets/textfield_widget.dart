import 'package:flutter/material.dart';

import '../utils/app_colors.dart';

class TextFieldWidget extends StatelessWidget {
  final TextEditingController textController;
  final String hintText;
  final double? borderRadius;
  final int? maxLinesNr;
  final bool? readOnly;

  const TextFieldWidget(
      {Key? key,
      required this.textController,
      required this.hintText,
      this.borderRadius = 15,
      this.maxLinesNr = 1,
      this.readOnly})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextField(
        readOnly: readOnly ?? false,
        maxLines: maxLinesNr,
        controller: textController,
        decoration: InputDecoration(
            label: Text.rich(
              TextSpan(
                children: <InlineSpan>[
                  WidgetSpan(
                    child: Text(
                      hintText,
                    ),
                  ),
                ],
              ),
            ),
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
