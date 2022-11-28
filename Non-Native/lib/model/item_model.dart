class ItemModel {
  int? id;
  String name;
  String description;
  double price;
  int availableQuantity;
  String? imgURL = "";

  ItemModel(this.id, this.name, this.description, this.price,
      this.availableQuantity, this.imgURL);

  factory ItemModel.fromJson(Map<String, dynamic> json) => ItemModel(
      json['id'],
      json['name'],
      json['description'],
      json['price'],
      json['availableQuantity'],
      json['imgURL']);

  Map<String, dynamic> toJson() => {
        'id': id,
        'name': name,
        'description': description,
        'price': price,
        'availableQuantity': availableQuantity,
        'imgURL': imgURL
      };

   @override
  String toString() {
    return toJson().toString();
  }
}

