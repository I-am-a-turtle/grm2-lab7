public class Test{

  public static void main(String args[]){
    int i = 0;
    int M = 15;
    while (M != 0){
      int b = M & 1;
      if (b == 1){
       System.out.println("" + i);
     }
     i++;
     M = M>>1;
   }
  }
}
