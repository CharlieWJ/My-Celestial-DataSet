

public class ArrayList <T extends Comparable<T>> implements List<T> {
    private int mag=2;//magnitude, initially 2, but will grow when this.array runs out of room
    private T[] array;// = (T[]) new Comparable[mag]; //instance variable, size is the number of elements in the array

    public ArrayList(){//constructor
        this.array=(T[]) new Comparable[2];
    }

    private void copyAndGrow(){//copies everything in the this.array, doubles the array length, and adds the previous values in this.array to the doubled array.
        mag*=2;
        T[] bigger= (T[]) new Comparable[mag];
        for(int i=0;i<this.array.length;i++){
            bigger[i]=this.array[i]; /*adds the values from this.array to the bigger array */ }
        this.array=bigger;//sets this.array = to the bigger array after all the contents have been copied
    }

    private void viewArray(){//Not an assigned method, but used to view the array.
        for(T t:this.array){System.out.print(t+" ");}}

    @Override
    public boolean add(T element) {
        for(int i=0;i<this.array.length;i++){
            if(element!=null){
                if (this.array[i]==null){
                    this.array[i]=element;//if the object at that index is null, it shall be replaced with the provided element
                    return true; }
                else if(this.array[i]!=null && this.array[this.array.length-1]!=null){//if every index, including the last one, contains an element,,
                    copyAndGrow();//then it will extend the length by a factor of 2*the current length.
                    add(element);//Recursively calls the function after extending the the list.
                    //Update: Works.
                    return true;
                }}}
        return false;}

    @Override
    public boolean add(int index, T element) {
        if(index<this.array.length){
            this.array[index]=element;
            return true; }
        else if(index>=this.array.length){
            copyAndGrow();//avoids index error by making appropriate adjustments
            add(index,element);//recursively calls the function in case multiple calls of copyAndGrow() are needed to add the new element
            return true;
        }
        return false;
    }

    @Override
    public void clear() {//calling clear resets the length to 2
        this.array=(T[]) new Comparable[2];//I think this works. All of the elements are removed and the length is again 2.
        mag=2;
    }//Update: Works.

    @Override
    public boolean contains(T element) {
        for(int i=0;i<this.array.length;i++){
            if(this.array[i]==element){
                return true;//if the element is present returns true
            }
        }
        return false;//else, if it is not present, it returns false
    }

    @Override
    public T get(int index) {
        //Return the element at given index. If index is out-of-bounds, it will return null.
        if(index<this.array.length){
            return this.array[index];
        }
        return null;
    }

    @Override
    public int indexOf(T element) {
        //Return the first index of element in the list. If element is null or not found in the list, return -1.
        int here = 0;
        if(contains(element)){
            if(element==null){
                return -1;
            }
            else{
                for(int i=0;i<this.array.length;i++){
                    if(this.array[i]==element){
                        here=i;
                        break;
                    }
                }
                return here;
            }
        }
        return -1;
    }//works

    @Override
    public boolean isEmpty() {
        for(int i=0;i<this.array.length;i++){
            if(this.array[i]!=null){
                return false;//if it has an element in it, false, signifying that it is not empty
            } }
        return true;//signifies that it is empty.
    }

    @Override
    public int lastIndexOf(T element) {
        //Same as indexOf(), except it will return the last index of element.
        int here = 0;
        if(contains(element)){
            if(element==null){
                return -1;
            }
            else{
                for(int i=0;i<this.array.length;i++){
                    if(this.array[i]==element){
                        here=i;
                    } }
                return here;
            }
        }
        return -1;//works
    }

    @Override
    public T set(int index, T element) {
        T oldElem;
        if(index<this.array.length){
            if(this.array[index]==null){
                return null;//if the element at that index is null, returns null
            }
            else{
                oldElem=this.array[index];
                this.array[index]=element;
                return oldElem;//else, if the element is not null at the index, it replaces the old value at that index with element, and returns the old element at that index
            } }
        return null;
    }

    @Override
    public int size() {
        int counter=0;
        for(int i=0;i<this.array.length;i++){
            if(this.array[i]!=null){
                counter++;
            }
            else{
                counter+=0;
            } }
        return counter;
    }

    @Override
    public void sort(boolean order) {
        /*If order is true, sort the list in increasing (alphabeticaly) order. If order is false, sort the list in decreasing (reverse alphabetical) order.
   * Hint: Since T extends Comparable, you will find it useful to use the public int compareTo(T o) method.
         */
        T temp;
        if(!order){
            for(int i=0;i<this.array.length-1;i++){
                int lower=i;
                for(int z=i+1;z<this.array.length;z++){
                    if(this.array[i].compareTo(this.array[z])<0){
                        temp=this.array[z];
                        this.array[z]=this.array[lower];
                        this.array[i]=temp;
                    } } } }
        else{
            for(int i=0;i<this.array.length-1;i++){
                int lower=i;
                for(int z=i+1;z<this.array.length;z++){
                    if(this.array[i].compareTo(this.array[z])>0){
                        temp=this.array[z];
                        this.array[z]=this.array[lower];
                        this.array[i]=temp;
                    } } } }
    }//sort works with all tests so far, test with something of greater complexity

    @Override
    public boolean remove(T element) {//time complexity of O(n*), for loop
        boolean truthValue=false;
        T temp;
        for(int i=0;i<this.array.length;i++){//finds the first instance of the element
            if(this.array[i]==element) {
                this.array[i] = null;//sets the instance to null.
                //below, int z and the for-loop move all the "null" values to the back of the list.
                //essentially selection sort
            }
                int z=i+1;//checks the index that follows index j.
                for(int j=0;j<this.array.length-1;j++){
                    if(this.array[j]==null){
                            temp=this.array[z];
                            this.array[z]=this.array[j];
                            this.array[j]=temp;
                        } }
            truthValue=true;//Adjusts truthValue appropriately
        }
        return truthValue;//because truthValue is false unless the element is present, works when the either is or isn't present.
    }

    @Override
    public T remove(int index) {//check to see that this works, might need touch up
        T removed=null;
        T temp;
        if(index<this.array.length){
            if(this.array[index]!=null){
                removed=this.array[index];//have to sort now
                this.array[index]=null;
            }
        }
        else if(index>=this.array.length){
            return null;
        }
        for(int i=0;i<this.array.length-1;i++){
            for(int z=i+1;z<this.array.length;z++){
                if(this.array[i]==null){
                    temp=this.array[z];
                    this.array[z]=this.array[i];
                    this.array[i]=temp;
                }
            }
        }
        return removed;
    }

    public static void main(String[] args){
        Comparable thing="this";
        Comparable thing2="this2";
        Comparable thing3="this3";
        Comparable thing4="a";
        Comparable notHere="fake";
        ArrayList custom=new ArrayList();
        custom.add(thing);
        custom.add(thing2);custom.add(thing3);custom.add(thing4);
        System.out.println(custom.size());
        custom.viewArray();System.out.println('\n');
        custom.sort(true);
        custom.viewArray();
        System.out.println(custom.indexOf(thing3)+" ");
        System.out.println(custom.lastIndexOf(thing3));
        custom.remove(2);
        custom.viewArray();
        System.out.println('\n');
        /*
        custom.remove(notHere);
        custom.remove(thing2);
        System.out.println('\n');
        System.out.println(custom.size());
        custom.viewArray();
        System.out.println('\n');
        custom.clear();
        System.out.print(custom.size()+" ");//System.out.println('\n');
        custom.viewArray();

         */
    }
}
