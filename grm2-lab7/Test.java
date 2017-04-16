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
    /*int i = 0;
    int M = 13;
    while (M != 0){
      int b = M & 1;
      if (b == 1){
       System.out.println("" + M + "->" + i);
     }
     i++;
     M = M>>1;
   }*/
   int i = 0;
   int n = 0;
   while (i < 100){
     if (n%2 == 0){
       i = (1<<n);
       System.out.println(i);
       System.out.println(Integer.toBinaryString(i));
       ++n;
     } else {
       i = (1<<n)-1;
       System.out.println(i);
       System.out.println(Integer.toBinaryString(i));
       ++n;
     }
   }
  }
}
