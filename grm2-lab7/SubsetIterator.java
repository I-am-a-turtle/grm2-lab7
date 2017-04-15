/*
Grace Mazzarella
*/

import java.util.*;

public class SubsetIterator<E> implements Iterator<E> {

  protected Stack<E> stack;

  public SubsetIterator(Iterator<E> it, int bitMask){
    this.stack = new Stack<E>();
  }

  public boolean hasNext(){
    // True if there are more elements in this subset
    return true;
  }

  public E next(){
    // Returns the next element and increments the iterator
    return this.stack.pop();
  }

  public void remove(){
    // Does nothing
  }
}
