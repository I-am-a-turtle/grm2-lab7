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
  Double half;
  Double tallest;
  int[] currTower;

  public TwoTowers(int n){
    blocks = n;
    half = height(n)/2;
    tallest = (new Integer(0)).doubleValue();
    currTower = new int[n];
  }

  protected Double height(int n){
    Double height = (new Integer(0)).doubleValue();
    for (int i = 0; i < n+1; ++i){
      height += Math.sqrt(1);
    }
    return height;
  }

  protected Double height(int tower[]){
    Double height = (new Integer(0)).doubleValue();
    for (int i = 0; i < tower.length; ++i){
      height += Math.sqrt(tower[i]);
    }
    return height;
  }

  protected void subsetTowers(){
    int[] tower = new int[blocks];
    subsetTowersHelper(blocks, (new Integer(0).doubleValue()), 0, tower);
  }

  protected boolean subsetTowersHelper(int n, Double currHeight, int index, int tower[]){
    if (n == 0 || tallest == half){
      // Have run through all blocks and added them to an index of one tower or the other
      return true;
    } else if (tallest < half) {
      // Still searching for perfect match
      // Copy tower without disturbing it or doing funky reference stuff and see if the next block can be added
      int[] tower1 = new int[blocks];
      for (int i = 0; i < tower.length; ++i){
        tower1[i] = tower[i];
      }
      tower1[index] = n;
      if (tallest < height(tower)){
        // If the next block can be added to the tower without going over half, add it or don't and then keep trying
        tallest = height(tower);
        currTower = tower;
        return subsetTowersHelper((n-1), tallest, (index+1), tower1) || subsetTowersHelper((n-1), tallest, (index+1), tower);
      } else {
        // If the block can't be added, throw it out and keep trying
        return subsetTowersHelper((n-1), tallest, (index+1), tower);
      }
    }
  }

  public static void main(String args[]){
    TwoTowers t = new TwoTowers(15);
    t.subsetTowers();
    System.out.println(t.tallest);
    for (int i = 0; i < t.currTower.length; ++i){
      System.out.println(t.currTower[i]);
    }
  }

}
