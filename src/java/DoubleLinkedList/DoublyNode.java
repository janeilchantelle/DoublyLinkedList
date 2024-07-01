package DoubleLinkedList;

public class DoublyNode {
    public int value;
    public DoublyNode next;
    public DoublyNode prev;

    public DoublyNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
