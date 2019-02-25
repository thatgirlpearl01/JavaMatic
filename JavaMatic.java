
import java.util.*;

public class JavaMatic{

  public static Ingredient[] ingredient  = new Ingredient[9];

  public static void restock(){
    ingredient[0] = new Ingredient("Coffee", 10, 0.75);
    ingredient[1] = new Ingredient("Sugar", 10, 0.25);
    ingredient[2] = new Ingredient("Decaf Coffee", 10, 0.75);
    ingredient[3] = new Ingredient("Cream", 10, 0.25);
    ingredient[4] = new Ingredient("Steamed Milk", 10, 0.35);
    ingredient[5] = new Ingredient("Foamed Milk", 10, 0.35);
    ingredient[6] = new Ingredient("Espresso", 10, 1.10);
    ingredient[7] = new Ingredient("Cocoa", 10, 0.90);
    ingredient[8] = new Ingredient("Whipped Cream", 10, 1.00);
  }

  public static void printInventory(){
    System.out.println("Inventory: ");
    for (int i = 0; i < ingredient.length; i++) {
      System.out.println(ingredient[i].name + "," + ingredient[i].quantity);
    }
    System.out.println();
  }

  public static void printMenu(){
    boolean instck;

    System.out.println("Menu: ");

    //check if sufficient ingredient is in stock and display menu
    if(inStock(6, 3)) instck = true; else instck = false;
    System.out.println("1,Caffe Americano,$3.30," + instck);

    if(inStock(6, 2) && inStock(4, 1)) instck = true; else instck = false;
    System.out.println("2,Caffe Latte,$2.55," + instck);

    if(inStock(6, 1) && inStock(7, 1) && inStock(4, 1) && inStock(8, 1)) instck = true; else instck = false;
    System.out.println("3,Caffe Mocha,$3.35," + instck);

    if(inStock(6, 2) && inStock(4, 1) && inStock(5, 1)) instck = true; else instck = false;
    System.out.println("4,Cappuccino,$2.90," + instck);

    if(inStock(0, 3) && inStock(1, 1) && inStock(3, 1)) instck = true; else instck = false;
    System.out.println("5,Coffee,$2.75," + instck);

    if(inStock(2, 3) && inStock(1, 1) && inStock(3, 1)) instck = true; else instck = false;
    System.out.println("6,Decaf Coffee,$2.75," + instck);


    System.out.println();
  }

  //use array index and quantity required to check instock
  public static boolean inStock(int index, int q){
    if(ingredient[index].quantity >= q) return true;
    return false;
  }

  //adjiust inventory ingredien
  public static void useIngredient(int index, int quantity){
    ingredient[index].quantity = ingredient[index].quantity - quantity;
  }


  public static void main(String[] args){

    restock();
    printInventory();
    printMenu();

    Scanner s = new Scanner(System.in);
    String str = s.nextLine();

    while(!str.equals("q")){
      switch(str){
        case "r":
        case "R":
         restock();
         printInventory();
         printMenu();
         break;

         case "1":
           if(inStock(6, 3)){
             useIngredient(6, 3);
             System.out.println("Dispensing: Caffe Americano");
             printInventory();
             printMenu();
           }else System.out.println("Out of stock: Caffe Americano");
           break;

        case "2":
          if(inStock(6, 2) && inStock(4, 1)){
            useIngredient(6, 2);
            useIngredient(4, 1);
            System.out.println("Dispensing: Caffe Latte");
            printInventory();
            printMenu();
          }else System.out.println("Out of stock: Caffe Latte");
          break;

         case "3":
           if(inStock(6, 1) && inStock(7, 1) && inStock(4, 1) && inStock(8, 1)){
             useIngredient(6, 1);
             useIngredient(7, 1);
             useIngredient(4, 1);
             useIngredient(8, 1);
             System.out.println("Dispensing: Caffe Mocha");
             printInventory();
             printMenu();
           }else System.out.println("Out of stock: Caffe Mocha");
           break;

        case "4":
          if(inStock(6, 2) && inStock(4, 1) && inStock(5, 1)){
            useIngredient(6, 2);
            useIngredient(4, 1);
            useIngredient(5, 1);
            System.out.println("Dispensing: Cappuccino");
            printInventory();
            printMenu();
          }else System.out.println("Out of stock: Cappuccino");
          break;

        case "5":
          if(inStock(0, 3) && inStock(1, 1) && inStock(3, 1)){
            useIngredient(0, 3);
            useIngredient(1, 1);
            useIngredient(3, 1);
            System.out.println("Dispensing: Coffee");
            printInventory();
            printMenu();
          }else System.out.println("Out of stock: Coffee");
          break;

        case "6":
          if(inStock(2, 3) && inStock(1, 1) && inStock(3, 1)){
            useIngredient(2, 3);
            useIngredient(1, 1);
            useIngredient(3, 1);
            System.out.println("Dispensing: Decaf Coffee");
            printInventory();
            printMenu();
          }else System.out.println("Out of stock: Decaf Coffee");
          break;

        case "q":
        case "Q":
          break;

        default:
          System.out.println("Invalid selection: " + str);
          break;
      }//end switch
      str = s.nextLine();

    }//end while

  }//end main

}//end class
