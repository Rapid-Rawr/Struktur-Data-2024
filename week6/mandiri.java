import java.io.*;
import java.util.Scanner;

class Node {
    Barang data;
    Node next;

    Node(Barang x) {
        data = x;
        next = null;
    }
}

public class mandiri {
    Node top; // top of stack
    Scanner inp = new Scanner(System.in);

    public void push(int id, String nama, int stok) {
        Barang x = new Barang(id, nama, stok);
        Node newNode = new Node(x);

        if (top == null) {
            // Kasus 1. Jika stack empty
            // maka top diisi dengan node baru
            top = newNode;
        } else {
            // Kasus 2. jika stack ada node
            // New node diletakkan paling, dan top lama menjadi next
            newNode.next = top;
            top = newNode;
        }
        System.out.println("PUSH " + nama);
    }

    public void pop() {
        Node node = null;

        // Kasus 1. Jika stack empty
        if (top == null) {
            // Jika stack kosong, berikan informasi stack kosong
            System.out.println("stack null");
            
            return;
        } else {
            // Jika stack ada, node baru akan diisi dengan top
            // next dari top akan menjadi top baru
            // untuk membersihkan node baru, set next dengan null
            node = top;
            top = node.next;
            node.next = null;
        }
        System.out.println("POP " + node.data.getNama());
    }

    public void delete(int id) {
        if (top == null) {
            // jika stack, tampilkan informasi stack kosong
            System.out.println("stack is null");
            ;
            return;
        }

        // Case 1: Delete the top node
        if (top.data.getId()==id) {
            // jika data yang dicari sama dengan data top
            if (top.next == null) {
                // jika node selanjutnya dari top adalah null
                top = null;
            } else {
                top = top.next;
            }
            System.out.println("DELETE : " + top.data.getNama());
            return;
        }
        Node current = top; // data iterasi yang akan dihapus
        Node prev = top; // node sebelumnya
        // Traverse untuk menemukan node
        while (current != null && current.data.getId() != id) {
            prev = current;
            current = current.next;
        }

        // jika node tidak ditemukan, posisi berada paling akhir
        if (current == null) {
            System.out.println("DELETE barang dengan id : " + id + " NOT FOUND");
            return;
        }

        // jika node ditemukan di pertengahan atau akhir
        if (current.next != null) {
            // jika node bukan bagian paling akhir
            // gunakan prev untuk menghubungkan node prev dan next node
            prev.next = current.next;
        } else {
            // Jika node paling akhir, set next dari prev dengan null
            prev.next = null;
        }
        System.out.println("DELETE id : " + id );
        current = null;
    }

    public void print() {  
        if ( top == null) { 
  //jika stack kosong, tampilkan stack kosong 
            System.out.println("stack null");; 
            return; 
        } else { 
            Node current = top;  
            System.out.print("Stack : ");  
   //Ulang hingga node berada paling akhir 
            while (current != null) {  
                System.out.print(current.data.getNama() + " ");  
                current = current.next;  
            }  
            System.out.println("");  
        } 
 
    }

    public static void main(String[] args) {
        mandiri sl = new mandiri();
        sl.runThis();
    }

    void runThis() {
        push(1, "asus", 2);
        push(2, "gelas", 10);
        push(3, "kursi", 15);
        push(4, "piring", 4);
        push(5, "jaket", 3);
        push(6, "motor", 20);
        push(7, "lampu", 7);
        push(8, "tas", 6 );
        push(9, "meja", 10);
        print();
        pop();
        print();
        pop();
        print();
        delete(2);
        print();
        delete(4);
        print();
        delete(9);
        print();
    }
}

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

    public String getNama(){
        return nama ;
    }

    public String info() {
        return id + " " + nama + " " + stok;
    }
}
