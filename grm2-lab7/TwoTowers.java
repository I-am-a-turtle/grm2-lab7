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
  double half;
  double tallest;
  int currTower;
  Vector<Integer> towers;

  public TwoTowers(int n){
    blocks = n;
    half = (new Integer(0)).doubleValue();
    for (int i = 1; i < (n+1); ++i){
      half = half + Math.sqrt(i);
    }
    half = half/2;
    currTower = 0;
    tallest = (new Integer(0)).doubleValue();
    towers = new Vector<Integer>();
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

  protected void subsetTowers(){
    while (!towers.contains(towerGenerator("", 15))){
      towerGenerator("", 15);
    }
  }

  protected boolean towerGenerator(String t, int n){
    if (n == 0){
      System.out.println(t);
      return n == 0;
    } else {
      return towerGenerator(t + "1", n-1) || towerGenerator(t + "0", n-1);
    }
  }

  protected boolean subsetTowersHelper(String tower, int n){
    if (n == 0 || tallest == half){
      // Have run through all blocks and added them to an index of one tower or the other
      // Or have found perfect match
      System.out.println("This is your final tower: " + tower);
      currTower = Integer.parseInt(tower);
      return n == 0;
    } else if (tower == ""){
      // Get values in the tower so we can calculate height
      return subsetTowersHelper(tower + "1", n-1) || subsetTowersHelper(tower + "0", n-1);
    } else {
      // Still have block to add or searching for perfect match
      System.out.println("Current tower: " + tower);
      Integer t = Integer.parseInt(tower + "1", 2);
      if (height(t) > half){
        // Adding a block will go over the halfway mark, don't add it and keep trying
        System.out.println(tower);
        System.out.println("NO ADD, current height:" + height(Integer.parseInt(tower, 2)));
        System.out.println("");
        return subsetTowersHelper(tower + "0", n-1);
      } else {
        // Height must be less than half
        // If adding a block doesn't go over the halfway mark, either add or don't add it
        System.out.println(tower);
        System.out.println("Height = " + height(t));
        System.out.println("");
        if (height(t) > tallest){
          tallest = height(t);
          return subsetTowersHelper(tower + "1", n-1) || subsetTowersHelper(tower + "0", n-1);
        } else {
          return subsetTowersHelper(tower + "1", n-1) || subsetTowersHelper(tower + "0", n-1);
        }
      }
    }
  }

  public static void main(String args[]){
    TwoTowers t = new TwoTowers(15);
    t.subsetTowersHelper("", 15);
    }
  }
