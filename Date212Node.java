public class Date212Node {
    
    protected Date212 data; // the Date212 stored in this node
    protected Date212Node next; // pointer to next node in list

    //constructor for a node that holds a data
    public Date212Node(Date212 w)
     {
        this.data = w;
        this.next = null;
    }

    //Constructor for an empty node
    public Date212Node()
    {
        this.data = null;
        this.next = null;
    }
}