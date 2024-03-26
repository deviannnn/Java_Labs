package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Read all products");
            System.out.println("2. Read a product by id");
            System.out.println("3. Add a new product");
            System.out.println("4. Delete a product");
            System.out.println("5. Update a product by id");
            System.out.println("6. Exit");
            System.out.print("\nYour choice: ");

            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    ArrayList<Product> all = ProductDAO.getInstance().readAll();
                    for (Product p : all) {
                        System.out.println("{Product| Id: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice() + ", Color: " + p.getColor() + "}");
                    }
                    break;

                case 2:
                    boolean checkC2 = false;
                    int idC2;
                    Product pC2;
                    do {
                        System.out.print("\nEnter product id: ");
                        idC2 = sc.nextInt();
                        pC2 = ProductDAO.getInstance().read(idC2);
                        if (pC2 == null) {
                            System.out.println("Product doesn't exist. Please enter id again!");
                            checkC2 = true;
                        } else {
                            checkC2 = false;
                        }
                    } while (checkC2);
                    System.out.println("{Product| Id: " + pC2.getId() + ", Name: " + pC2.getName() + ", Price: " + pC2.getPrice() + ", Color: " + pC2.getColor() + "}");
                    break;

                case 3:
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter product price: ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter product color: ");
                    String color = sc.nextLine();
                    Product temp = new Product(name, price, color);
                    ProductDAO.getInstance().add(temp);
                    break;

                case 4:
                    boolean checkC4 = false;
                    int idC4;
                    do {
                        System.out.print("\nEnter product id: ");
                        idC4 = sc.nextInt();
                        if (ProductDAO.getInstance().read(idC4) == null) {
                            System.out.println("Product doesn't exist. Please enter id again!");
                            checkC4 = true;
                        } else {
                            checkC4 = false;
                        }
                    } while (checkC4);
                    ProductDAO.getInstance().delete(idC4);
                    break;

                case 5:
                    boolean checkC5 = false;
                    int idC5;
                    do {
                        System.out.print("\nEnter product id: ");
                        idC5 = sc.nextInt();
                        if (ProductDAO.getInstance().read(idC5) == null) {
                            System.out.println("Product doesn't exist. Please enter id again!");
                            checkC5 = true;
                        } else {
                            checkC5 = false;
                        }
                    } while (checkC5);
                    sc.nextLine();
                    System.out.print("Enter new product name: ");
                    String nameC5 = sc.nextLine();
                    System.out.print("Enter new product price: ");
                    int priceC5 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new product color: ");
                    String colorC5 = sc.nextLine();

                    ProductDAO.getInstance().update(new Product(idC5, nameC5, priceC5, colorC5));
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("ERROR");
                    break;
            }
            System.out.print("\n");
        }

    }
}