/*
Grace Mazzarella

Warmup Questions
1) Expression for the integer whose bit pattern is n zeroes: 0
2) Conventional mathematical expression for the integer whose bit pattern is n ones: (2^n) - 1
   Integer-bitwise expression for the same: (1<<n) -1
3) Given an int M that is to be treated as a bit mask (array) of n bits, a while loop that prints
   the positions of the bits of M whose values are 1, counting from the right is:
   int i = 0;
   while (M != 0){
     int b = M & 1;
     if (b == 1){
      System.out.println("" + i);
    }
    i++;
    M = M>>1;
  }
4) The difference in height for the towers that are the second best solution to the puzzle
   for n = 15: tower 1 = 20.23524408
               tower 2 = 20.23395252
               difference = 0.0013 units
5) While debugging the program, one way to identify a probably optimal solution for n = 15
   is to look for the tower that has a height that is precisely half the height of the sum
   of all the block heights
*/

import java.util.*;
//import java.util.Math;

public class TwoTowers{

  int blocks;
  double total;
  double half;
  double tallest;
  int currTower;

  public TwoTowers(int n){
    blocks = n;
    total = (new Integer(0)).doubleValue();
    for (int i = 1; i < (n+1); ++i){
      total = total + Math.sqrt(i);
    }
    half = total/2;
    currTower = 0;
    tallest = (new Integer(0)).doubleValue();
  }

  protected double height(int tower){
    int i = blocks;
    double height = (new Integer(0)).doubleValue();
    while (tower != 0){
      int b = tower & 1;
      if (b == 1){
        height = height + Math.sqrt(i);
      }
     i--;
     tower = tower>>1;
   }
   return height;
  }

  protected int subsetTowers(){
    for (int i = 0; i < Math.pow(2, blocks); ++i){
      if (height(i) <= half && height(i) > tallest){
        tallest = height(i);
        currTower = i;
      }
    }
    return currTower;
  }

  protected void towerReader(int tower, int read){
    int n = blocks;
    int ct = currTower;
    System.out.println("Tower " + tower);
    while (n > 0){
      int check = ct & 1;
      if (check == read){
        System.out.println("" + n);
      }
      --n;
      ct = ct>>1;
    }
  }

  protected void printInfo(){
    towerReader(1,1);
    towerReader(2,0);
    System.out.println("" + tallest);
    System.out.println("" + (total-tallest));
  }

  public static void main(String args[]){
    TwoTowers t = new TwoTowers(15);
    System.out.println("" + t.subsetTowers());
    System.out.println("" + t.half);
    System.out.println("" + t.tallest);
    t.printInfo();
    }
  }
