package DoubleLinkedList;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    // ANSI codes for colour
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";

    // Create a Double Linked List
    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode(nodeValue);
        tail = head;
        size = 1;
        System.out.println(ANSI_BLUE + "DLL created with value: " + nodeValue + ANSI_RESET);
        return head;
    }

    // Insert into a Double Linked List
    public void insertDLL(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode(nodeValue);
        if (head == null) {
            createDLL(nodeValue);
        } else if (location == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            newNode.prev = tempNode;
            tempNode.next.prev = newNode;
            tempNode.next = newNode;
        }
        size++;
        System.out.println(ANSI_PURPLE + "Inserted value: " + nodeValue + " at location: " + location + ANSI_RESET);
    }

    // Traverse a Linked List
    public void traverseDLL() {
        if (head == null) {
            System.out.println(ANSI_CYAN + "DLL does not exist" + ANSI_RESET);
        } else {
            DoublyNode tempNode = head;
            while (tempNode != null) {
                System.out.print(ANSI_BLUE + tempNode.value + ANSI_RESET);
                if (tempNode.next != null) {
                    System.out.print(ANSI_PURPLE + " <-> " + ANSI_RESET);
                }
                tempNode = tempNode.next;
            }
            System.out.println();
        }
    }

    // Reverse Traverse
    public void reverseTraverseDLL() {
        if (tail == null) {
            System.out.println(ANSI_CYAN + "DLL does not exist" + ANSI_RESET);
        } else {
            DoublyNode tempNode = tail;
            while (tempNode != null) {
                System.out.print(ANSI_BLUE + tempNode.value + ANSI_RESET);
                if (tempNode.prev != null) {
                    System.out.print(ANSI_PURPLE + " <-> " + ANSI_RESET);
                }
                tempNode = tempNode.prev;
            }
            System.out.println();
        }
    }

    // Search Node
    public boolean searchDLL(int nodeValue) {
        if (head == null) {
            System.out.println(ANSI_CYAN + "DLL does not exist" + ANSI_RESET);
            return false;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (tempNode != null) {
                if (tempNode.value == nodeValue) {
                    System.out.println(ANSI_PURPLE + "Node found at location: " + index + ANSI_RESET);
                    return true;
                }
                tempNode = tempNode.next;
                index++;
            }
            System.out.println(ANSI_CYAN + "Node not found" + ANSI_RESET);
            return false;
        }
    }

    // Deletion Method
    public void deleteNodeDLL(int location) {
        if (head == null) {
            System.out.println(ANSI_CYAN + "The DLL does not exist" + ANSI_RESET);
            return;
        } else if (location == 0) {
            System.out.println(ANSI_PURPLE + "Deleted node with value: " + head.value + " from location: " + location + ANSI_RESET);
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else if (location >= size - 1) {
            System.out.println(ANSI_PURPLE + "Deleted node with value: " + tail.value + " from location: " + location + ANSI_RESET);
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            System.out.println(ANSI_PURPLE + "Deleted node with value: " + tempNode.next.value + " from location: " + location + ANSI_RESET);
            tempNode.next = tempNode.next.next;
            if (tempNode.next != null) {
                tempNode.next.prev = tempNode;
            }
        }
        size--;
    }

    // Delete entire Double Linked List
    public void deleteDLL() {
        DoublyNode tempNode = head;
        while (tempNode != null) {
            DoublyNode nextNode = tempNode.next;
            tempNode.prev = null;
            tempNode.next = null;
            tempNode = nextNode;
        }
        head = null;
        tail = null;
        size = 0;
        System.out.println(ANSI_PURPLE + "The DLL has been deleted" + ANSI_RESET);
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Creating the Double Linked List
        dll.createDLL(5);

        // Inserting elements
        dll.insertDLL(10, 1);
        dll.insertDLL(15, 2);
        dll.insertDLL(20, 3);

        // Traversing the Double Linked List
        dll.traverseDLL();

        // Reverse traversing the Double Linked List
        dll.reverseTraverseDLL();

        // Searching for elements
        dll.searchDLL(10);
        dll.searchDLL(25);

        // Deleting a node
        dll.deleteNodeDLL(2);
        dll.traverseDLL();

        // Deleting the entire Double Linked List
        dll.deleteDLL();
        dll.traverseDLL();
    }
}
