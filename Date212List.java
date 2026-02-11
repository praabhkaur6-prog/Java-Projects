public abstract class Date212List {
    public Date212Node first; // head node
    protected Date212Node last; // last node
    protected int length; // number of nodes in list

    //constructor
    public Date212List(){
    Date212Node ln = new Date212Node();//empty head node
    first = ln;
    last = ln;
    length = 0;
}

//append function
public void append (Date212 s){
    Date212Node n = new Date212Node(s);
    last.next = n;
    last = n;
    length++;
}

//print all dates in the list 

public void print(){
    Date212Node x = this.first;
    while(x!= null)
    {
        if (x.data != null){ // check for null data
            System.out.println(x.data.toString());
        }
        x = x.next;
    }
}

}
