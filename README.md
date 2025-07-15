- ⚠️ **DISCLAIMER:** This project is for learning and employment portfolio purposes only. Do **NOT** copy or submit this work as your own official assignment. Doing so constitutes an academic integrity violation.
- ⚠️ This is for employment purposes, to be included in the projects section of my resume.

# CSCI 2720 - Assignment 2

## Overview

This Java-based command-line application implements a **sorted doubly linked list** using Java generics. The program supports multiple data types (int, double, and string) and provides advanced linked list operations, including:

- Insertion and deletion while maintaining sorted order
- Printing the list forward and in reverse
- Reversing the list in-place
- Deleting a subsection of elements based on bounds
- Swapping alternate nodes in-place
- Dynamic selection of list type via user input

The application reads data from a text file and offers an interactive CLI for managing list operations.

---

## Compile Instructions

Run the following commands from the root of the project:

```bash
javac -d bin src/NodeType.java
javac -cp bin -d bin src/DoublyLinkedList.java
javac -cp bin -d bin src/DoublyLinkedListDriver.java
```

---

## Run Instructions

Execute the driver program as follows:

```bash
java -cp bin cs2720.DoublyLinkedListDriver <file-name>
```

Replace `<file-name>` with the appropriate input file (e.g., `int-input.txt`).

Example:

```bash
java -cp bin cs2720.DoublyLinkedListDriver int-input.txt
```

---

## Function Explanations

### deleteSubsection

- **Description:** Deletes all elements between a lower and upper bound (inclusive).
- **Logic:**
  - Check if the list is empty; return if so.
  - Find the node before the lower bound.
  - Advance through the list until the node after the upper bound is found.
  - Reconnect the preceding node to the node after the upper bound.
  - Handles edge cases where the subsection includes the head or tail.
- **Time Complexity:** O(n)

**Code Snippet:**

```java
if (head != null) {
    while (lower.compareTo(pred.next.info) > 0 && lower.compareTo(pred.next.info) != 0) {
        pred = pred.next;
        loc = pred;
        if (pred.next == null && lower.compareTo(pred.info) > 0) {
            pred = pred.next;
            break;
        } else if (pred.next == null) {
            break;
        }
    }
    while (upper.compareTo(loc.info) > 0 || upper.compareTo(loc.info) == 0) {
        loc = loc.next;
        if (loc == null) {
            break;
        }
    }
    if (pred != null && (lower.compareTo(pred.info) == 0 || lower.compareTo(pred.info) < 0)) {
        if (loc != null) {
            head = loc;
            loc.back = null;
        } else {
            head = null;
        }
    } else if (pred != null) {
        pred.next = loc;
        if (loc != null) {
            loc.back = pred;
        }
    }
}
```

---

### reverseList

- **Description:** Reverses the list in-place without creating a new list.
- **Logic:**
  - Checks if the list is empty or has only one node.
  - Traverses the list, swapping `next` and `back` pointers for each node.
  - Updates the head pointer to point to the new front of the list.
- **Time Complexity:** O(n)

**Code Snippet:**

```java
if (head != null) {
    if (length() > 1) {
        while (loc != null) {
            if (loc.next == null) {
                break;
            }
            pred = loc;
            loc = loc.next;
            pred.next = pred.back;
            pred.back = loc;
            loc.back = loc.next;
            loc.next = pred;
            pred = loc;
            loc = loc.back;
        }
        if (loc == null) {
            head = pred;
        } else {
            loc.back = loc.next;
            loc.next = pred;
            head = loc;
        }
    }
}
```

---

### swapAlternate

- **Description:** Swaps every pair of adjacent nodes in the list.
- **Logic:**
  - If the list is empty or has one node, nothing changes.
  - Uses two pointers to traverse the list and swap adjacent nodes.
  - Special cases are handled for lists with odd lengths or nodes at the end.
- **Time Complexity:** O(n)

**Code Snippet:**

```java
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
        }
        if (pred.next.next == null) {
            pred.next.back = pred;
            break;
        }
        pred.next.back = pred;
        pred = pred.next;
        loc = pred.next;
        pred.back.next = loc;
    }
}
```

---

## Technologies Used

- Java
- Command-Line Interface
- Generics
- Data Structures (Doubly Linked Lists)

---

## Author

Brandon Lin  
[bkl73754@uga.edu](mailto:bkl73754@uga.edu)

---
