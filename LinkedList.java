//Note: Some of the comments I make may appear to be obvious, however I keep them there in case I need a refresher for later.

public class LinkedList<T extends Comparable<T>> implements List<T> {
    private LinkedList<T> list;
    private NGen head;//front of the list
    private NGen tail;//back of the list
    private int len;private int biggestIndex;


    public LinkedList(){//initializes the list to an empty list.
        this.head=null;//At the start the LinkedList only contains one node (the first one), which has a value of null.
        this.len=0; }

    public void viewList(LinkedList list) {
        NGen current=this.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (current!=null) {
            // Print the data at current node
            System.out.print(current.getData()+" ");
            // Go to next node
            current=current.getNext();
        }
    }

    @Override
    public boolean add(T element) {//need a head and a tail, will add to the tail.
        NGen next=this.head;//starts at the first index
        NGen temp= new NGen();
        temp.setData(element);//temporary node is set to the value "element" for further use, and to avoid possible future errors
        if(element==null){
            return false;
        }
        else if(this.head==null){//checks if head contains a value
            this.head=new NGen();
            this.head.setData(element);
        }
        else{
            while(next.getNext()!=null){
                next=next.getNext();//moves to the next line
            }
            next.setNext(temp);
            len++;
        }
        return true;
    }

    @Override
    public boolean add(int index, T element){
        NGen temp = this.head;
        NGen another=new NGen();
        another.setData(element);
        NGen holder=new NGen();
        if(element==null){
            return false;
        }
        for(int i=0; i < index-1 && temp.getNext()!=null; i++) {
            temp=temp.getNext();
        }
        if(temp!=null){//if the current index contains a value, then it will push it to the next index and add the element there.
            //System.out.println("");
            holder=temp.getNext();
            temp.setNext(another);
            temp = temp.getNext();
            temp.setNext(holder);
        }
        /*else{//otherwise,
            System.out.println("");
            //System.out.println(temp.getNext().getData());
            holder = temp.getNext();
            temp.setNext(another);//=new NGen();
            temp = temp.getNext();
            temp.setNext(holder);
        }
         */
        biggestIndex=index+1;
        //System.out.println(biggestIndex);
        len++;
        return true;
    }
    /*
    @Override
    public boolean add(int index, T element) {
        NGen next=this.head;
        NGen temp=new NGen();
        NGen holder=new NGen();
        temp.setData(element);
        if(element==null){
            return false;
        }
        else if(next.getData()!=null){
            next=next.getNext();
            for(int i=0;i<index-1 && next.getNext()!=null;i++){//increments up each index to see if that index is null or not
                holder.setData(next.getNext().getData());
                //holder is set to the value at that index, and pushes it to the right of the list
                next.setNext(holder);
            }}
        temp.setNext(next.getNext());
        next.setNext(temp);
        len++;
        return true;
    }
     */

    @Override
    public void clear() {
        this.list=new LinkedList();//resets the list to an empty list
    }

    @Override
    public boolean contains(T element) {//Works
        NGen next=this.head;
        NGen temp=new NGen();temp.setData(element);
        if(element==null){
            return false; }
        for (int i = 0;i<size();i++) {
            next=next.getNext();
            if(temp.getData().equals( next.getData() ) ) { return true; } }
        return false;
    }

    @Override
    public T get(int index) {
        NGen finder=this.head;
        T giver=null;
        for(int i=0;i<index;i++){
            finder=finder.getNext();
        }
        if(index<0){
            return null;
        }
        //T item=finder.getData();
        giver= (T) finder.getData();
        return giver;//works
    }

    @Override
    public int indexOf(T element) {
        //if the element is null or cannot be found within the the list ,line 119, the return value is -1, otherwise, it shall be index
        NGen finder=this.head;
        if(element==null){
            return -1;
        }
        int index=0;
        while(finder.getData()!=element){
            finder=finder.getNext();
            index++;//for each index in which the finder is not comparable to the element, the index shall be incremented by 1 until it exceeds the maximum index, or is == to element
            if(index>biggestIndex){
                return -1;
            } }
        return index;}

    @Override
    public boolean isEmpty() {
        return size()>0;
    }

    @Override
    public int lastIndexOf(T element) {//Works
        int index=0;int counter=0;
        NGen finder=this.head;
        NGen temp=new NGen();
        temp.setData(element);
        for(int i=0;i<size();i++){ finder=finder.getNext();index++;
            //System.out.println(index);
            if(finder.getData().equals(element)){ counter=index; } }
        return counter;
    }

    @Override
    public T set(int index, T element) {
        NGen next=this.head;
        int counter=0;
        if(element==null || index<0){
            return null;
        }
        NGen holder=new NGen();
        NGen temp=new NGen();temp.setData(element);
        if(element!=null){
            for(int i=0;i<size() && next.getNext()!=null;i++){
                next=next.getNext();
                counter++;
                if(counter==index){
                    holder.setData(next.getData());
                    //holder=next;
                    next.setData(temp.getData());
                }
            }
        }
        return (T) holder.getData();
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public void sort(boolean order) {//pro tip from Dovolis, turn the list into a headed list TODO

    }

    @Override
    public boolean remove(T element) {//TODO

        return false;
    }

    @Override
    public T remove(int index) {//TODO
        return null;
    }

    public static void main(String[] args){
        System.out.println("Hello World");
        LinkedList custom= new LinkedList<>();
        Comparable first="1";Comparable second="2";Comparable third="3";Comparable lastOne="99";
        custom.add(first);
        custom.add(second);custom.add(third);
        //custom.viewList(custom);
        custom.add(2,lastOne);

        //System.out.println(custom.indexOf(lastOne));

        custom.add(first);
        //System.out.println(custom.get(2));

        //System.out.println(custom.indexOf("3"));

        System.out.println(custom.lastIndexOf(first));

        System.out.println(custom.set(3,lastOne));

        custom.viewList(custom);

    }

}
