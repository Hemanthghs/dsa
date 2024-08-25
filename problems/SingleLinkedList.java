class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void deleteAtStart() {
        if (head == null) {
            listEmptyError();
        } else if (head.next == null) {
            head = null;
            System.out.println("Deleted at start");
        } else {
            head = head.next;
            System.out.println("Deleted at start");
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            listEmptyError();
        } else if (head.next == null) {
            head = null;
            System.out.println("Deleted at end");
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            System.out.println("Deleted at end");
        }
    }

    public void display() {
        if (head == null) {
            listEmptyError();
        } else {
            Node current = head;
            while (current.next != null) {
                System.out.print(current.data + "->");
                current = current.next;
            }
            System.out.print(current.data + "->null\n");
        }
    }

    public void reverseList() {
        if (head == null) {
            listEmptyError();
            return;
        }
        if (head.next == null) {
            return;
        }
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    private void listEmptyError() {
        System.out.println("List is empty");
    }
}

public class SingleLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtStart(11);
        list.insertAtStart(22);
        list.insertAtStart(33);
        list.insertAtStart(44);
        list.insertAtStart(55);
        list.insertAtEnd(77);
        list.insertAtEnd(88);
        list.insertAtEnd(99);
        list.display();
        list.deleteAtStart();
        list.display();
        list.deleteAtEnd();
        list.display();
        list.reverseList();
        list.display();
    }
}
