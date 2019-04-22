// Program Name: Recursive Method
// Programmer: Kevin Saravia, 1478627
// Assignment Number: Project #3
/* Purpose: This program uses recursion to find out how many 
            different combos of coins you can get from a given 
            cent amount less than $1*/
import java.io.*;
import java.util.Scanner;

public class RecursiveMethod{
  public static int q = 0, d = 0, n = 0, p = 0;
  public static int ways = 1;
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Input the amount between 1 and 99: ");
    int inp = scan.nextInt();
    while(inp < 1 || inp > 99){
      System.out.println("Error: Invalid Input.");
      System.out.print("Input the amount between 1 and 99: ");
      inp = scan.nextInt();
    }
    System.out.println();

    logicalDivide(inp, 4);
    printResult(q, d, n, p);
    System.out.print("\nThere are totally " 
      + ways(inp, 4) + " ways.");
    scan.close();
  }

  public static int ways(int amounts, int denomination){
    if(n > 0){
      ways++;
      n -= 1;
      p += 5;
      printResult(q, d, n, p);
      ways(amounts, denomination);
    }
    if(d > 0 & n == 0){
      ways++;
      n += p / 5 + 2;
      p %= 5;
      d -= 1;
      printResult(q, d, n, p);
      ways(amounts, denomination);
    }
    if(q > 0 & d == 0 & n == 0){
      ways++;
      p += 25;
      d += p / 10; 
      p %= 10;
      n += p / 5;
      p %= 5;
      q -= 1;
      printResult(q, d, n, p);
      ways(amounts, denomination);
    }

    return ways;
  }

  public static void logicalDivide(int amt, int den){
    int denomVal = 0;

    if(amt != 0){
      switch(den){
        case 4:
          denomVal = 25;
          if(amt >= denomVal)
            q++;
          break;
        case 3:
          denomVal = 10;
          if(amt >= denomVal)
            d++;
          break;
        case 2:
          denomVal = 5;
          if(amt >= denomVal)
            n++;
          break;
        case 1:
          denomVal = 1;
          if(amt >= denomVal)
            p++;
          break;  
      }

      if(amt < denomVal)
        logicalDivide(amt, den - 1);
      else
        logicalDivide(amt - denomVal, den);
    }
  }

  public static void printResult(int qu, int di, int ni, int pe){
    System.out.println("There are " + qu + " quarter, " + di
      + " dime, " + ni + " nickel, " + pe + " penny");
  }
}
