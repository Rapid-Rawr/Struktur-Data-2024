package week4;

import java.io.*;

class Node {
    Barang data;
    Node next;

    Node(Barang b) {
        data = b;
        next = null;
    }
}

public class mandiri {
    Node head; // head of list
    /* Insert last tidak terurut */

    public int insert(Barang brg) {
        Node nn = new Node(brg);
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
        System.out.println("Node baru " + brg + " ditambahkan");
        return 0;
    }

    /* Insert sorted */
    public void insertSorted(Barang brg) {
        Node nn = new Node(brg); // node baru
        Node current = head;
        // Jika list kosong atau data lebih kecil dari head
        if (head == null || brg.getId() >= nn.data.getId()) {
            nn.next = head;
            head = nn;
        } else {
            // Cari posisi yang tepat untuk menyisipkan node
            while (current.next != null && (current.next.data.getId() < nn.data.getId())) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }
        System.out.println("Node baru " + brg + " ditambahkan");
    } // eoinsertSorted

    /* Delete */
    public int delete(int id) {
        // Jika list kosong
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        } else {
            // Cek apakah data yang dicar ada di head
            if (head.data.getId() == id) {
                head = head.next;
                System.out.println("Node dengan id " + id + " telah dihapus");
                return 0;
            } else {
                // jika data yang dicari bukan di head
                Node current = head;
                Node prec = head;
                boolean found = false;
                while (current != null) {
                    if (current.data.getId() == id) {
                        prec.next = current.next;
                        current.next = null;
                        System.out.println("Node dengan id " + id + " telah dihapus");
                        return 0;
                    }
                    prec = current;
                    current = current.next;
                }
            }
        }
        System.out.println("Node dengan id " + id + " tidak ditemukan");
        return 0;
    } // eodelete

    public void printList() {
        Node current = head;
        System.out.print("Single LinkedList: ");
        while (current != null) {
            System.out.println(current.data.info() + " ");
            current = current.next;
        }
        System.out.println("");
    } // eoprintlist

    public static void main(String[] args) {
        mandiri sll = new mandiri();
        sll.runThis();
    }

    void runThis() {
        insert(new Barang(5, "So So", 55));
        insert(new Barang(2, "Clean", 22));
        insert(new Barang(1, "So", 11));
        insert(new Barang(8, "So So Clean", 88));
        insert(new Barang(3, "So Clean", 33));
        insert(new Barang(6, "Clean Clean", 66));
        insert(new Barang(7, "So Clean So Clean", 77));
        insert(new Barang(10, "Clean So So", 100));
        insert(new Barang(9, "So Clean Clean", 99));
        insert(new Barang(4, "Clean So", 44));

        insertSorted(new Barang(5, "So So", 17));
        insertSorted(new Barang(2, "Clean", 65));
        insertSorted(new Barang(1, "So", 15));
        insertSorted(new Barang(8, "So So Clean", 32));
        insertSorted(new Barang(3, "So Clean", 41));
        insertSorted(new Barang(6, "Clean Clean", 100));
        insertSorted(new Barang(7, "So Clean So Clean", 100));
        insertSorted(new Barang(10, "Clean So So", 30));
        insertSorted(new Barang(9, "So Clean Clean", 20));
        insertSorted(new Barang(4, "Clean So", 10));

        printList();
        delete(4);
        delete(1);
        delete(10);
        delete(99);
        printList();

    } // eoRunThis

    public int cariData(int id) {
        if (head == null) {
            System.out.println("List kosong");
            return 0;
        } else {
            // Cek apakah data yang dicar ada di head
            int idx = 1;
            if (head.data.getId() == id) {
                System.out.println("Node " + id + " telah ditemukan pada urutan " + idx);
                return 0;
            } else {
                // jika data yang dicari bukan di head
                Node current = head;
                Node prec = head;
                boolean found = false;
                while (current != null) {
                    if (current.data.getId() == id) {
                        System.out.println("Node " + id + " telah ditemukan pada urutan " + idx);
                        // return 0;
                        if (current.next == null) {
                            return 0;
                        }

                    }
                    idx++;
                    prec = current;
                    current = current.next;
                }
            }
        }
        System.out.println("Node " + id + " tidak ditemukan");
        return 0;
    }

} // eoSingleLinkList

class Barang {
    private int id;
    private String nama;
    private int stok;

    public Barang(int id, String nama, int stok) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public String info() {
        return id + " " + nama + " " + stok;
    }
}
