package week3;

import java.io.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class mandiri {
    Node head; // head of list
    /* Insert last tidak terurut */

    public int insert(int data) {
        Node nn = new Node(data);
        Node current = head;
        if (current == null) {
            nn.next = null;
            head = nn;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }
        System.out.println("Node baru " + data + " ditambahkan");
        return 0;
    }

    /* Insert sorted */
    public void insertSorted(int data) {
        Node nn = new Node(data); // node baru
        Node current = head;
        // Jika list kosong atau data lebih kecil dari head
        if (head == null || head.data >= nn.data) {
            nn.next = head;
            head = nn;
        } else {
            // Cari posisi yang tepat untuk menyisipkan node
            while (current.next != null && (current.next.data < nn.data)) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }
        System.out.println("Node baru " + data + " ditambahkan");
    } // eoinsertSorted

    /* Delete */
    public int delete(int data) {
        // Jika list kosong
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        } else {
            // Cek apakah data yang dicar ada di head
            if (head.data == data) {
                head = head.next;
                System.out.println("Node " + data + " telah dihapus");
                return 0;
            } else {
                // jika data yang dicari bukan di head
                Node current = head;
                Node prec = head;
                boolean found = false;
                while (current != null) {
                    if (current.data == data) {
                        prec.next = current.next;
                        current.next = null;
                        System.out.println("Node " + data + " telah dihapus");
                        return 0;
                    }
                    prec = current;
                    current = current.next;
                }
            }
        }
        System.out.println("Node " + data + " tidak ditemukan");
        return 0;
    } // eodelete

    public void printList() {
        Node current = head;
        System.out.print("Single LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    } // eoprintlist

    public static void main(String[] args) {
        mandiri sll = new mandiri();
        sll.runThis();
    }

    void runThis() {
        // Buat proses pengisian data
        insert(5); insert(1); insert(3); insert(2);
        insert(7); insert(6); insert(9); insert(8);

        printList();
        head = null;

        insertSorted(5); insertSorted(1); insertSorted(3); insertSorted(2);
        insertSorted(7); insertSorted(6); insertSorted(9); insertSorted(7);
        printList();

        delete(5); delete(1); delete(9); delete(99);
        printList();
        cariData(7);
        cariData(99);

    } // eoRunThis

    public int cariData(int elm){
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        } else {
            // Cek apakah data yang dicar ada di head
            int idx = 1;
            if (head.data == elm) {
                System.out.println("Node " + elm + " telah ditemukan pada urutan "+idx);
                return 0;
            } else {
                // jika data yang dicari bukan di head
                Node current = head;
                Node prec = head;
                boolean found = false;
                while (current != null) {
                    if (current.data == elm) {
                        System.out.println("Node " + elm + " telah ditemukan pada urutan "+idx);
                        // return 0;
                        if (current.next==null) {
                            return 0 ;
                        }

                    }idx++;
                    prec = current;
                    current = current.next;
                } 
            }
        }
        System.out.println("Node " + elm  + " tidak ditemukan");
        return 0;
    }

} // eoSingleLinkList