package cs2720;

import cs2720.NodeType;

/**
   Doubly Linked List class with all implemented methods.
 */
public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head;

    /**
       Makes a new Doubly Linked List.
    */
    public DoublyLinkedList() {
    } // DoublyLinkedList

    /**
       Gets the length of the Linked List.
       @return length the length of the Linked list.
     */
    public int length() {
        int length = 0;
        if (head == null) {
            return 0;
        } else {
            length++;
            NodeType<T> node = head;
            while (node.next != null) {
                node = node.next;
                length++;
            } // while
        } // else
        return length;
    } // length

    /**
       Prints the list.
     */
    public void print() {
        if (head == null) {
            System.out.print("\n");
        } else {
            NodeType<T> node = head;
            System.out.print(node.info);
            while (node.next != null) {
                node = node.next;
                System.out.print(" " + node.info);
            } // while
            System.out.print("\n");
        } // else
    } // print

    /**
       Prints the reversed list.
     */
    public void printReverse() {

        if (head == null) {
            System.out.print("\n");
        } else {
            NodeType<T> node = head;
            while (node.next != null) {
                node = node.next;
            } // while
            System.out.print(node.info);
            while (node.back != null) {
                node = node.back;
                System.out.print(" " + node.info);
            } // while
            System.out.print("\n");
        } // else
    } // printReverse

    /**
       Inserts an item into the list according to its value.
       @param item the new item being inserted.
     */
    public void insertItem(T item) {
        NodeType<T> node = new NodeType<T>();
        node.info = item;
        node.next = null;
        node.back = null;
        NodeType<T> loc = head;
        NodeType<T> pred = null;

        if (head == null) {
            head = node;
        } else {
            while (item.compareTo(loc.info) > 0) {
                pred = loc;
                loc = loc.next;
                if (loc == null) {
                    break;
                } // if
            } // while
            if (loc == null) {
                pred.next = node;
                node.back = pred;
            } else if (pred == null && item.compareTo(loc.info) != 0) {
                head = node;
                node.next = loc;
                loc.back = node;
            } else if (item.compareTo(loc.info) < 0) {
                pred.next = node;
                node.next = loc;
                node.back = pred;
                loc.back = node;
            } else if (item.compareTo(loc.info) == 0) {
                throw new IllegalStateException("Item already exists");
            } // else if
        } // else
    } // insertItem

    /**
       Deletes the node in the list that contains an item equal to the
       item parameter.
       @param item the item to be removed.
    */
    public void deleteItem(T item) {
        NodeType<T> loc = head;
        NodeType<T> pred = null;

        if (head == null) {
            System.out.println("You cannot delete from an empty list");
        } else {
            while (item.compareTo(loc.info) != 0) {
                pred = loc;
                loc = loc.next;
                if (loc == null) {
                    break;
                } // if
            } // while
            if (loc == null) {
                System.out.println("The item is not present in the list");
            } else if (pred == null) {
                if (length() > 1) {
                    head = loc.next;
                    head.back = null;
                } else {
                    head = null;
                } // if else
            } else {
                pred.next = loc.next;
                if (loc.next != null) {
                    loc.next.back = pred;
                } // if
            } // else
        } // else
    } // deleteItem

    /**
       Reverses the list by going through and changing all next's
       to back's and back's to next's.
     */
    public void reverseList() {
        NodeType<T> loc = head;
        NodeType<T> pred = null;

        System.out.print("The original list: ");
        print();
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
        System.out.print("The reversed list: ");
        print();
    } // reverseList

    /**
       Deletes the subsection of items between the two given (inclusive).
       @param lower lower bound of the subsection
       @param upper upper bound of the subsection
     */
    public void deleteSubsection(T lower, T upper) {
        NodeType<T> loc = head;
        NodeType<T> pred = head;

        System.out.print("The original list: ");
        print();
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
        System.out.print("The modified list: ");
        print();
        if (length() != 0) {
            System.out.print("The reverse list: ");
            printReverse();
        } // if
    } // deleteSubsection

    /**
       Swaps every other node in the list.
     */
    public void swapAlternate() {
        NodeType<T> loc = head;
        NodeType<T> pred = null;

        System.out.print("The original list: ");
        print();
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
        System.out.print("The modified list: ");
        print();
        System.out.print("The reverse list: ");
        printReverse();
    } // swapAlternate

} // DoublyLinkedList
