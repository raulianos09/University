class ItemModel {
  int id;
  String name;
  String description;
  double price;
  int availableQuantity;
  String? imgURL = "";

  ItemModel(this.id, this.name, this.description, this.price,
      this.availableQuantity, this.imgURL);
}
