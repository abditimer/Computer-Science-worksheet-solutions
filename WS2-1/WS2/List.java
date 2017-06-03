import java.util.List;

/** 
 * @author Uday Reddy
 * @version 2016-01-13 based on Uday Reddy 2012 and Alexandros 2015
 * 
 * List class defines a recursive type called List, and provides
 * constructor and getter methods. 
 */

public class List {

    private boolean empty;
    private int head;
    private List tail;

    /**
     * The first constructor creates a list consisting of a head, that
     * is, an integer and a tail, which is another list of integers.
     * @param head
     * @param tail
     */
    public List(int head, List tail) {
        this.empty = false; 
        this.head = head;
        this.tail = tail;
    }
    
    /**
     *  The second constructor creates an empty list, i.e., a list
     *  with no elements.  For this list, head and tail remain
     *  undefined, calls to the corresponding getters will have to
     *  result in an exception.
     */
    public List() {
        this.empty = true;
    }
    
    /**
     * Creates a new list from a given head element and a tail List
     */
    public static List cons(int head, List tail) {
        return new List(head,tail);
    }
    
    /**
     * Creates a new empty List
     */
    public static List empty() {
        return new List();
    }
    
    /**
     * returns true
		 if this list is empty
     */
    public boolean isEmpty() {
        return empty;
    }
    
    /**
     * returns the head of this list or throws an exception if the
     * list is empty
     * @throws IllegalStateException if the list is empty
     */
    public int getHead() {
        if (isEmpty()) {
            throw new IllegalStateException(
                          "Trying to access head of an empty list");
        }
        return head;
    }
    
    /**
     * returns the tail of this list or throws an exception if the
     * list is empty
     * @throws IllegalStateException if the list is empty
     */    
    public List getTail() {
        if (isEmpty()) {
            throw new IllegalStateException(
                          "Trying to access tail of an empty list");
        }
        return tail;
    }
    
    public String toString() {
				return "[" + toStringAux() + "]";
    }
  
    public String toStringAux() {
       	if (isEmpty()) {
						return "";
       	} else if (getTail().isEmpty()){
						return getHead() + "";
       	} else {
						return getHead() + ", " + getTail().toStringAux();
       	}
    }
    
    public static boolean equals(List l1, List l2) {
				if (l1.isEmpty() && l2.isEmpty()) {
						return true;
				} else if (l1.isEmpty() || l2.isEmpty()) {
						return false;
				} else if (l1.getHead() == l2.getHead()) {
						return equals(l1.getTail(), l2.getTail());
				} else {
						return false;
				}
    }

    @Override public boolean equals(Object o) {
				List list = (List) o;
				if (this.empty && list.isEmpty())
						return true;
				else if (this.isEmpty() || list.isEmpty()) {
						return false;
				}
				else if ( this.getHead() == list.getHead()) {
						return equals (this.getTail() , list.getTail());
				}
				else {
						return false;
				}
		}
    
    public static int length (List a) {
		if (a.isEmpty())
			return 0;
		/*else if (a.tail.isEmpty())
			return 1;*/
		else
			return 1 + length(a.getTail());
	}
    
    static List prefix(int n, List a) {
    	// requires: n <= length(a)
    	// ensures: result = a list with the first n elements of a
    	if (n ==0)
    	return empty();
    	else
    	return cons(a.getHead(), prefix(n-1, a.getTail()));
    	}

	static List removeDuplicates(List a) {
		// requires: a is a list of integers sorted in increasing order
		// ensures: result = a sorted list with the same elements as
		// a, but with no duplicate copies of elements.
		if (a.isEmpty())
			return empty();
		else if (a.getHead() == a.getTail().getHead()) {
			// remove the second copy and continue
			return removeDuplicates(cons(a.getHead(), a.getTail().getTail()));
		} else
			return cons(a.getHead(), removeDuplicates(a.getTail()));
	}
    
    public static void main(String[] args) {
    	//List actual = List.cons(1, List.cons(2, List.cons(2, List.cons(-4, List.empty()))));
    	List actual = List.cons(9, empty());
    	System.out.println(removeDuplicates(actual));
    }

}
