import java.util.Scanner;

public class ProductTester {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int maxSize, menuChoice;

    maxSize = getNumProducts(in);
    if (maxSize == 0)
      System.out.println("No products required!");
    else {
      Product[] products = new Product[maxSize];
      addToInventory(products, in);
      do {
        menuChoice = getMenuOption(in);
        executeMenuChoice(menuChoice, products, in);
      } while (menuChoice != 0);
      // Product[] array = products.toArray();
      // displayInventory(products);
    }
  }

  public static void executeMenuChoice(int menuChoice, Product[] products, Scanner in) {
    // System.out.println("View Product List\nAdd Stock\nDeduct Stock\nDiscontinue
    // Stock");
    switch (menuChoice) {
      case 1:
        System.out.println("======View Product List======");
        displayInventory(products);
        break;
      case 2:
        System.out.println("======Add Stock======");
        addInventory(products, in);
        break;
      case 3:
        System.out.println("======Deduct Stock======");
        deductInventory(products, in);
        break;
      case 4:
        System.out.println("======Discontinue Stock======");
        discontinueInventory(products, in);
        break;
    }
  }

  public static void discontinueInventory(Product[] products, Scanner in) {
    int productChoice;

    productChoice = getProductNumber(products, in);
    products[productChoice].setActive(false);
  }

  public static void addInventory(Product[] products, Scanner in) {
    int productChoice;
    int updateValue = -1;

    productChoice = getProductNumber(products, in);

    do {
      try {
        System.out.print("How many products do you want to add? ");
        updateValue = in.nextInt();
        if (updateValue < 0)
          System.out.println("Incorrect Value entered");
      } catch (Exception e) {
        System.out.println("Incorrect data type entered!");
        in.nextLine();
      }
    } while (updateValue < 0);
    products[productChoice].addToInventory(updateValue);
  }

  public static void deductInventory(Product[] products, Scanner in) {
    int productChoice, qty;
    int updateValue = -1;

    productChoice = getProductNumber(products, in);
    qty = products[productChoice].getQty();
    do {
      try {
        System.out.print("How many products do you want to deduct? ");
        updateValue = in.nextInt();
        if (updateValue < 0 || updateValue > qty)
          System.out.println("Incorrect Value entered");
      } catch (Exception e) {
        System.out.println("Incorrect data type entered!");
        in.nextLine();
      }
    } while (updateValue < 0 || updateValue > qty);
    products[productChoice].deductFromInventory(updateValue);
  }

  public static int getMenuOption(Scanner in) {
    System.out.println(
        "=====MENU=====\n1. View Inventory\n2. Add Stock\n3. Deduct Stock\n4. Discontinue Product\n0. Exit");
    int choice = 0;
    do {
      try {
        System.out.print("Please enter a menu option:");
        choice = in.nextInt();
        if (choice > 4 || choice < 0)
          System.out.println("Incorrect Value entered");
      } catch (Exception e) {
        System.out.println("Incorrect data type entered!");
        in.nextLine();
      }
    } while (choice > 4 || choice < 0);
    return choice;
  }

  public static void addToInventory(Product[] products, Scanner in) {
    int tempNumber, tempQty;
    double tempPrice;
    String tempName;
    for (int i = 0; i < products.length; i++) {
      System.out.println("=====Product " + (i + 1) + "=====");
      // in.nextLine();
      // System.out.print("Item Number: ");
      // tempNumber = in.nextInt();

      in.nextLine();// clear input buffer
      System.out.print("Product Name: ");
      tempName = in.nextLine();

      System.out.print("Quantity: ");
      tempQty = in.nextInt();

      System.out.print("Price: ");
      tempPrice = in.nextDouble();
      products[i] = new Product(i + 1, tempName, tempQty, tempPrice);
    }
  }

  public static void displayInventory(Product[] parameter) {
    for (int i = 0; i < parameter.length; i++) {
      System.out.println("=====Product " + (i + 1) + "=====");
      System.out.println(parameter[i].toString());
    }
  }

  public static int getProductNumber(Product[] products, Scanner in) {
    int productChoice = -1;
    for (int i = 0; i < products.length; i++) {
      System.out.println((i + 1) + ". " + products[i].getProductName());
    }
    System.out.println("================");
    do {
      try {
        System.out.print("Enter number: ");
        productChoice = in.nextInt();
        if (productChoice < 0 || productChoice > products.length)
          System.out.println("Incorrect Value entered");
      } catch (Exception e) {
        System.out.println("Incorrect data type entered!");
        in.nextLine();
      }
    } while (productChoice < 0 || productChoice > products.length);
    return productChoice - 1;
  }

  public static int getNumProducts(Scanner in) {
    int maxSize = -1;

    System.out.println(
        "Enter the number of products you would like to add\nEnter 0 (zero) if you do not wish to add products");

    do {
      try {
        System.out.print("Enter number: ");
        maxSize = in.nextInt();
        if (maxSize < 0)
          System.out.println("Incorrect Value entered");
      } catch (Exception e) {
        System.out.println("Incorrect data type entered!");
        in.nextLine();
      }
    } while (maxSize < 0);
    return maxSize;
  }

}
