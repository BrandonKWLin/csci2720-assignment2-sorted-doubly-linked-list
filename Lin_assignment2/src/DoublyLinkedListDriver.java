package cs2720;

import cs2720.NodeType;
import cs2720.DoublyLinkedList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
   Doubly Linked List Driver.
 */
public class DoublyLinkedListDriver {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner input;
        String type;
        String com;
        String inputS;
        Double inputD;
        int inputI;
        DoublyLinkedList<String> listS = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> listI = new DoublyLinkedList<>();
        DoublyLinkedList<Double> listD = new DoublyLinkedList<>();

        System.out.print("Enter list type (i - int, d - double, s - string): ");

        while (true) {

            type = sc.next();

            if (type.equals("i") || type.equals("s") || type.equals("d")) {
                break;
            } else {
                System.out.print("Please enter a proper type (i - int, d - double, s - string): ");
            } // no proper command

        } // type of list : while

        try {
            File file = new File(args[0]);
            input = new Scanner(file);
            while (input.hasNext()) {
                try {
                    if (type.equals("s")) {
                        listS.insertItem(input.next());
                    } else if (type.equals("d")) {
                        listD.insertItem(input.nextDouble());
                    } else if (type.equals("i")) {
                        listI.insertItem(input.nextInt());
                    } // else if
                } catch (IllegalStateException e) {
                } // try catch
            } // while
            input.close();
        } catch (ArrayIndexOutOfBoundsException | IOException ioException) {
            System.err.println("Cannot open file or file not present.");
            System.exit(1);
        }

        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Length");
        System.out.println("(t) - Print reverse");
        System.out.println("(r) - Reverse list");
        System.out.println("(b) - Delete Subsection");
        System.out.println("(s) - Swaps Alternate");
        System.out.println("(q) - Quit program" + "\n");

        System.out.print("Enter a command: ");

        while (true) {

            com = sc.next();

            if (com.equals("i")) {
                if (type.equals("s")) {
                    System.out.print("The list is: ");
                    listS.print();
                    System.out.print("Enter a string to insert: ");
                    inputS = sc.next();
                    try {
                        listS.insertItem(inputS);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    } // try catch
                    System.out.print("The list is: ");
                    listS.print();
                    System.out.print("The reverse list: ");
                    listS.printReverse();
                } else if (type.equals("d")) {
                    System.out.print("The list is: ");
                    listD.print();
                    System.out.print("Enter a number to insert: ");
                    inputD = sc.nextDouble();
                    try {
                        listD.insertItem(inputD);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    } // try catch
                    System.out.print("The list is: ");
                    listD.print();
                    System.out.print("The reverse list: ");
                    listD.printReverse();
                } else if (type.equals("i")) {
                    System.out.print("The list is: ");
                    listI.print();
                    System.out.print("Enter a number to insert: ");
                    inputI = sc.nextInt();
                    try {
                        listI.insertItem(inputI);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    } // try catch
                    System.out.print("The list is: ");
                    listI.print();
                    System.out.print("The reverse list: ");
                    listI.printReverse();
                } // else
                System.out.print("Enter a command: ");
            } // if : command i : Insert value

            else if (com.equals("d")) {
                if (type.equals("s")) {
                    System.out.print("The list is: ");
                    listS.print();
                    System.out.print("Enter a string to delete: ");
                    inputS = sc.next();
                    listS.deleteItem(inputS);
                    System.out.print("The list is: ");
                    listS.print();
                    System.out.print("The reverse list: ");
                    listS.printReverse();
                } else if (type.equals("d")) {
                    System.out.print("The list is: ");
                    listD.print();
                    System.out.print("Enter a number to delete: ");
                    inputD = sc.nextDouble();
                    listD.deleteItem(inputD);
                    System.out.print("The list is: ");
                    listD.print();
                    System.out.print("The reverse list: ");
                    listD.printReverse();
                } else if (type.equals("i")) {
                    System.out.print("The list is: ");
                    listI.print();
                    System.out.print("Enter a number to delete: ");
                    inputI = sc.nextInt();
                    listI.deleteItem(inputI);
                    System.out.print("The list is: ");
                    listI.print();
                    System.out.print("The reverse list: ");
                    listI.printReverse();
                } // else
                System.out.print("Enter a command: ");
            } // if : command d : Delete value

            else if (com.equals("p")) {
                if (type.equals("s")) {
                    System.out.print("The list is: ");
                    listS.print();
                } else if (type.equals("d")) {
                    System.out.print("The list is: ");
                    listD.print();
                } else if (type.equals("i")) {
                    System.out.print("The list is: ");
                    listI.print();
                } // else if
                System.out.print("Enter a command: ");
            } // if : command p : Print list : done

            else if (com.equals("l")) {
                if (type.equals("s")) {
                    System.out.println("The length of the list is " + listS.length());
                } else if (type.equals("d")) {
                    System.out.println("The length of the list is " + listD.length());
                } else if (type.equals("i")) {
                    System.out.println("The length of the list is " + listI.length());
                } // else if
                System.out.print("Enter a command: ");
            } // if : command l : Length : done

            else if (com.equals("t")) {
                if (type.equals("s")) {
                    System.out.print("The reverse list: ");
                    listS.printReverse();
                } else if (type.equals("d")) {
                    System.out.print("The reverse list: ");
                    listD.printReverse();
                } else if (type.equals("i")) {
                    System.out.print("The reverse list: ");
                    listI.printReverse();
                } // else if
                System.out.print("Enter a command: ");
            } // if : command t : Print reverse : done

            else if (com.equals("r")) {
                if (type.equals("s")) {
                    listS.reverseList();
                } else if (type.equals("d")) {
                    listD.reverseList();
                } else if (type.equals("i")) {
                    listI.reverseList();
                } // else if
                System.out.print("Enter a command: ");
            } // if : command r : Reverse list

            else if (com.equals("b")) {
                if (type.equals("s")) {
                    System.out.print("Enter the lower bound: ");
                    inputS = sc.next();
                    String lower = inputS;
                    System.out.print("Enter the upper bound: ");
                    inputS = sc.next();
                    String upper = inputS;
                    listS.deleteSubsection(lower, upper);
                } else if (type.equals("d")) {
                    System.out.print("Enter the lower bound: ");
                    inputD = sc.nextDouble();
                    Double lower = inputD;
                    System.out.print("Enter the upper bound: ");
                    inputD = sc.nextDouble();
                    Double upper = inputD;
                    listD.deleteSubsection(lower, upper);
                } else if (type.equals("i")) {
                    System.out.print("Enter the lower bound: ");
                    inputI = sc.nextInt();
                    int lower = inputI;
                    System.out.print("Enter the upper bound: ");
                    inputI = sc.nextInt();
                    int upper = inputI;
                    listI.deleteSubsection(lower, upper);
                } // else
                System.out.print("Enter a command: ");
            } // if : command b : Delete Subsection

            else if (com.equals("s")) {
                if (type.equals("s")) {
                    listS.swapAlternate();
                } else if (type.equals("d")) {
                    listD.swapAlternate();
                } else if (type.equals("i")) {
                    listI.swapAlternate();
                } // else if
                System.out.print("Enter a command: ");
            } // if : command s : Swap Alternate

            else if (com.equals("q")) {
                System.out.println("Exiting the program...");
                break;
            } // if : command q : quit : done

            else {
                System.out.print("Invalid command try again: " );
            } // else : invalid command : done

        } // command loop : while

    } // main
} // DoublyLinkedListDriver
