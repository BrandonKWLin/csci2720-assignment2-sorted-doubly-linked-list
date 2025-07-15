Brandon Lin 
bkl73754@uga.edu 
811724748

Compile commands:
    javac -d bin src/NodeType.java
    javac -cp bin -d bin src/DoublyLinkedList.java
    javac -cp bin -d bin src/DoublyLinkedListDriver.java

Run commands:
    java -cp bin cs2720/DoublyLinkedListDriver <file-name>

    just replace <file-name> with whatever file is called, assuiming the file
    name is int-input.txt, the command would be:

    java -cp bin cs2720/DoublyLinkedListDriver int-input.txt

deleteSubsection function:

The function first checks whether the list is empty and returns immediately if it is. Otherwise, it locates the node just before the position where the lower bound would fall. For example, if the lower bound is 10, the pointer stops at the node immediately preceding 10 (or the closest value below it). From that point, it identifies the upper bound node and advances to the node immediately after it (which might be null). It then reconnects the list by linking the node before the lower bound (prev) to the node after the upper bound (loc). The function also includes checks to handle cases where the subsection to remove is at the very start or end of the list. Its runtime is O(n), since it uses only a single while loop.

            if (head != null) {
            while (lower.compareTo(pred.next.info) > 0 && lower.compareTo(pred.next.info) != 0) {
                pred = pred.next;
                loc = pred;
                if (pred.next == null && lower.compareTo(pred.info) > 0) {
                    pred = pred.next;
                    break;
                } else if (pred.next == null) {
                    break;
                } // else if
            } // while
            while (upper.compareTo(loc.info) > 0 || upper.compareTo(loc.info) == 0) {
                loc = loc.next;
                if (loc == null) {
                    break;
                } // if
            } // while
            if (pred != null && (lower.compareTo(pred.info) == 0 || lower.compareTo(pred.info) < 0)) {
                if (loc != null) {
                    head = loc;
                    loc.back = null;
                } else {
                    head = null;
                } // else
            } else if (pred != null) {
                pred.next = loc;
                if (loc != null) {
                    loc.back = pred;
                } //if
            } // else if
        } // if

reverseList function:

The reverseList function first checks whether the list is empty and exits immediately if so. It also does nothing if the list has only one node, since there’s nothing to reverse in that case. Otherwise, it traverses the list using two temporary nodes, swapping the next and back pointers as it goes. During the loop, it checks whether the list has an odd or even length to determine where to reconnect the head node once the reversal is complete. The function runs in O(n) time because it makes a single pass through the list, updating each node’s pointers.

        if (head != null) {
            if (length() > 1) {
                while (loc != null) {
                    if (loc.next == null) {
                        break;
                    } // if
                    pred = loc;
                    loc = loc.next;
                    pred.next = pred.back;
                    pred.back = loc;
                    loc.back = loc.next;
                    loc.next = pred;
                    pred = loc;
                    loc = loc.back;
                } // while
                if (loc == null) {
                    head = pred;
                } else {
                    loc.back = loc.next;
                    loc.next = pred;
                    head = loc;
                } // if : even length list : else : odd length list
            } // if
        } // if

swapAlternate function:

This function uses two nodes that traverse the list, swapping the nodes they point to by exchanging their next and back pointers. There are a few special cases to handle at the beginning and end of the list, but aside from that, the swapping process is straightforward. The function operates in O(n) time because it relies on a single while loop to complete the traversal and swaps.

            if (length() > 1) {
            loc = head.next;
            pred = head;
            head = loc;
            while (loc != null) {
                loc.back = pred.back;
                pred.next = loc.next;
                pred.back = loc;
                loc.next = pred;
                if (pred.next == null) {
                    break;
                } // if
                if (pred.next.next == null) {
                    pred.next.back = pred;
                    break;
                } // if
                pred.next.back = pred;
                pred = pred.next;
                loc = pred.next;
                pred.back.next = loc;
            } // while
        } // if
