package ex1;

import java.util.Scanner;

public class Ex1{
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Invalid expression");
      return;
    }
    String firstNumber = args[0];
    String operator = args[1];
    String secondNumber = args[2];
    try {
      int num1 = Integer.parseInt(firstNumber);
      int num2 = Integer.parseInt(secondNumber);
      int result = 0;

      switch (operator) {
        case "+":
          result = num1 + num2;
          break;
        case "-":
          result = num1 - num2;
          break;
        case "x":
          result = num1 * num2;
          break;
        case "/":
          result = num1 / num2;
          break;
        case "^":
          result = (int) Math.pow(num1, num2);
          break;
        default:
          System.out.println("Unsupported operator");
      }

      System.out.println(result);
    } catch (NumberFormatException e) {
      System.out.println("Invalid expression");
    }


  }
}

