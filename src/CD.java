public class CD extends Product {
  private String artist;
  private int numberOfSongs;
  private String label;

  CD() {
    super();
    this.artist = "Unknown";
    this.numberOfSongs = 0;
    this.label = "Unknown";
  }

  CD(int itemNumber, String productName, int qty, double price, String artist, int numberOfSongs, String label) {
    super(itemNumber, productName, qty, price);
    this.artist = artist;
    this.numberOfSongs = numberOfSongs;
    this.label = label;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public int getNumberOfSongs() {
    return numberOfSongs;
  }

  public void setNumberOfSongs(int numberOfSongs) {
    this.numberOfSongs = numberOfSongs;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return "Item Number\t\t: " + getItemNumber() + "\nName\t\t\t: " + getProductName() + "\nArtist\t\t\t: "
        + this.artist + "\nSongs on Album\t: " + this.numberOfSongs + "\nRecord label\t\t: " + this.label
        + "\nQuantity in stock\t: "
        + getQty()
        + "\nPrice\t\t\t: "
        + getPrice() + "\nStock Value\t\t: " + getInventoryValue() + "\nProduct Status\t\t: "
        + (getStatus() ? "Active" : "Discontinued");
  }
}
