/*
Grace Mazzarella
*/

public class SubsetInterator<E> implements Iterator<E> {

  public SubsetIterator(Iterator<E> it, int bitMask);

  public boolean hasNext(){
    // True if there are more elements in this subset
  }

  public E next(){
    // Returns the next element and increments the iterator
  }

  public void remove(){
    // Does nothing
  }
}
