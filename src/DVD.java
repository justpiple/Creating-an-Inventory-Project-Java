public class DVD extends Product {
  private int length;
  private int ageRating;
  private String filmStudio;

  DVD() {
    super();
    this.length = 0;
    this.ageRating = 0;
    this.filmStudio = "Unknown";
  }

  DVD(int itemNumber, String productName, int qty, double price, int length, int ageRating, String filmStudio) {
    super(itemNumber, productName, qty, price);
    this.length = length;
    this.ageRating = ageRating;
    this.filmStudio = filmStudio;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getAgeRating() {
    return ageRating;
  }

  public void setAgeRating(int ageRating) {
    this.ageRating = ageRating;
  }

  public String getFilmStudio() {
    return filmStudio;
  }

  public void setFilmStudio(String filmStudio) {
    this.filmStudio = filmStudio;
  }

  @Override
  public double getInventoryValue() {
    double totalPrice = getPrice() * getPrice();
    return (totalPrice * 0.05) + totalPrice;
  }

  @Override
  public String toString() {
    return "Item Number\t\t: " + getItemNumber() + "\nName\t\t\t: " + getProductName() + "\nAge Rating\t\t: "
        + this.ageRating + "\nMovie Length\t\t: " + this.length + "\nFilm Studio\t\t: " + this.filmStudio
        + "\nQuantity in stock\t: "
        + getQty()
        + "\nPrice\t\t\t: "
        + getPrice() + "\nStock Value\t\t: " + getInventoryValue() + "\nProduct Status\t\t: "
        + (getStatus() ? "Active" : "Discontinued");
  }

}
