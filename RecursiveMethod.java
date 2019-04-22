import java.io.*;
import java.util.Scanner;

public class RecursiveMethod{
  public static int amount;
  public static int quart, dim, nick, pen;
  public static int ways = 1;
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Input the amount between 1 and 99: ");
    int inp = scan.nextInt();
    System.out.println();
    RecursiveMethod update = new RecursiveMethod(inp);
    quart = ways(update, 4);
    dim = ways(update, 3);
    nick = ways(update, 2);
    pen = ways(update, 1);
    printResult(quart, dim, nick, pen);
    System.out.print("\nThere are totally " + result(quart, 
      dim, nick, pen) + " ways.");
    scan.close();
  }

  public static int ways(RecursiveMethod obj, int denomination){
    int denomVal = 0;

    switch(denomination){
      case 4:
        denomVal = 25;
        break;
      case 3:
        denomVal = 10;
        break;
      case 2:
        denomVal = 5;
        break;
      case 1:
        denomVal = 1;
        break;  
    }

    if(obj.getAmount() < denomVal)
      return 0;
    else{
      obj.updating(denomVal);
      return (1 + ways(obj, denomination));
    }
  }

  public static int result(int q, int d, int n, int p){
    if(n > 0){
      ways++;
      printResult(q, d, n - 1, p + 5);
      result(q, d, n - 1, p + 5);
    }
    if(d > 0 & n == 0){
      n += p / 5;
      ways++;
      printResult(q, d - 1, n + 2, p % 5);
      result(q, d - 1, n + 2, p % 5);
    }
    if(q > 0 & d == 0 & n == 0){
      ways++;
      p += 25;
      d += p / 10; 
      p %= 10;
      n += p / 5;
      p %= 5;
      printResult(q - 1, d, n, p);
      result(q - 1, d, n, p);
    }

    return ways;
  }

  public RecursiveMethod(int start){
    amount = start;
  }

  public int getAmount(){
    return amount;
  }

  public void updating(int increment){
    amount -= increment;
  }

  public static void printResult(int q, int d, int n, int p){
    System.out.println("There are " + q + " quarter, " + d
      + " dime, " + n + " nickel, " + p + " penny");
  }
}