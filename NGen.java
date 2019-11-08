// NGen.java
// A *simplified* generic node class for use with the Stack1Gen class 
// and other data structures as desired; uses generics for the data

public class NGen <T> {
    // constructors
    
    public NGen () {}

    public NGen (T o, NGen <T> link) {
        data = o;
        next = link;
    }

    // selectors

    public T getData() {
        return data;
    }//what is in the node

    public void setData(T o) {
        data = o;
    }//set the value of that node

    public NGen <T> getNext() {//gets the value in the next node
        return next;
    }

    public void setNext(NGen <T> link) {
        next = link;
    }//set the value in the next node

    // instance variables

    private T data;//again, what value the node contains
    private NGen <T> next;//the next node

}  // NGen class
