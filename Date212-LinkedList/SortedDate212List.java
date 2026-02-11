public class SortedDate212List extends Date212List {

    public SortedDate212List() {}

    public void add(Date212 date) {
        Date212Node n = new Date212Node(date);

        // Case 1: empty list (only head node)
        if (this.length == 0) {
            this.append(date);
            return;
        }

        Date212Node prev = this.first;
        Date212Node curr = this.first.next;

        // Traverse until we find the insertion point
        while (curr != null && date.compareTo(curr.data) > 0) {
            prev = curr;
            curr = curr.next;
        }

        // Insert the new node between prev and curr
        n.next = curr;
        prev.next = n;

        // Update last pointer if inserted at end
        if (curr == null) {
            this.last = n;
        }

        length++;
    }
}


