public class Test{

  /*protected double height(int tower){
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
 }*/

  public static void main(String args[]){
    int i = 0;
    int M = 13;
    while (M != 0){
      int b = M & 1;
      if (b == 1){
       System.out.println("" + M + "->" + i);
     }
     i++;
     M = M>>1;
   }
  }
}
