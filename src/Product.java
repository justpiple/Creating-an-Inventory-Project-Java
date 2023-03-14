public class Product {
  private int itemNumber;
  private String productName;
  private int qty;
  private double price;
  private Boolean status = true;

  // Default value
  Product() {
    itemNumber = 0;
    productName = "Barang";
    qty = 0;
    price = 0;
  }

  // Custom value
  Product(int itemNumber, String productName, int qty, double price) {
    this.itemNumber = itemNumber;
    this.productName = productName;
    this.qty = qty;
    this.price = price;
  }

  public void addToInventory(int quantity) {
    if (status)
      this.qty += quantity;
  }

  public void deductFromInventory(int quantity) {
    this.qty -= quantity;
  }

  // getter and setter variable
  public void setItemNumber(int itemNumber) {
    this.itemNumber = itemNumber;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public int getItemNumber() {
    return itemNumber;
  }

  public String getProductName() {
    return productName;
  }

  public int getQty() {
    return qty;
  }

  public double getPrice() {
    return price;
  }

  public Boolean getStatus() {
    return status;
  }

  public double getInventoryValue() {
    return qty * price;
  }

  public void setActive(boolean status) {
    this.status = status;
  }

  public String toString() {
    return "Item Number\t\t: " + itemNumber + "\nName\t\t\t: " + productName + "\nQuantity in stock\t: " + qty
        + "\nPrice\t\t\t: "
        + price + "\nStock Value\t\t: " + getInventoryValue() + "\nProduct Status\t\t: "
        + (status ? "Active" : "Discontinued");
  }
}
