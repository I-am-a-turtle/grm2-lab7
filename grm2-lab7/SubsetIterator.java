/*
Grace Mazzarella
*/

import java.util.*;

public class SubsetIterator<E> implements Iterator<E> {

  Iterator<E> iter;
  int bm;

  public SubsetIterator(Iterator<E> it, int bitMask){
    iter = it;
    bm = bitMask;
  }

  public boolean hasNext(){
    // True if there are more elements in this subset
    return iter.hasNext();
  }

  public E next(){
    // Returns the next element and increments the iterator
    while (bm != 0){
      int check = bm & 1;
      if (check == 1){
        bm = bm>>1;
        return iter.next();
     }
     bm = bm>>1;
     iter.next();
   }
   return null;
  }

  public void remove(){
    // Does nothing
  }

  public static void main(String args[]){
    Vector<Integer> v = new Vector<Integer>();
    v.add(1); v.add(5); v.add(20); v.add(31);

    Iterator<Integer> it = new SubsetIterator<Integer>(v.iterator(), 13);
    while (it.hasNext()){
      System.out.println(it.next());
    }
  }
}
