import java.io.*;

class Pasien {
    int noUrut;
    String nama;

    Pasien(int nu, String nama) {
        this.noUrut = nu;
        this.nama = nama;
    }

    String info() {
        return noUrut + " " + nama;
    }

    int getNoUrut() {
        return noUrut;
    }

}

class Node {
    Pasien data;
    Node next;

    Node(Pasien d) {
        data = d;
        next = null;
    }
}

public class QueueListPasien {
    Node head; // head of list
    Node tail; // tail of list

    /* Tambah antrian */
    public int enqueue(String nama) {
        int u;
        if (head == null) {
            u = 1;
        } else {
            u = tail.data.getNoUrut() + 1;
        }
        Pasien temp = new Pasien(u, nama);
        Node que = new Node(temp);

        if (head == null) {
            head = que;
            tail = que;
        } else {
            tail.next = que;
            tail = que;
        }
        System.out.println("pasien "+nama +" telah di tambah, urutan "+u);
        return 0;

        // Pastikan bahwa no urut pasien akan selalu terurut, sehingga
        // Jika Queue kosong, no urut dari 1
        // Jika Queue tidak kosong, no urut diambil dari no urut last node +1

    }

    /* Ambil Urutan */
    public int dequeue() {
        // Pengambilan node urutan dari yang paling ujung
        Node current = null;
        if (head == null) {
            System.out.println("antrian kosong");
            return 0;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            current = head;
            head = current.next;
            current.next = null;
        }
        System.out.println("pasien " + current.data.info() + " telah di ambil");
        return 0;
    }

    /* jika no antrian depan tidak ada, maka ambil antrian yang ada */
    public int ambilAntrianTengah(int noUrut) {          
        // Jika list kosong 
        Node current = null; 
        Node prev = null; 
        if (head == null) { 
            //Jika List kosong 
            System.out.println("antrian kosong");
            return 0; 
        } else if ((head.data.getNoUrut() == noUrut) && (head==tail)){ 
            //jika hanya ada 1 node 
            head=null;
            tail=null;
            System.out.println("Pasien urutan: "+noUrut +" telah di ambil");
                return 0; 
        } else{ 
            current=head;
            while (current!=null) {
                if (current.data.getNoUrut()==noUrut) {
                    head= current.next;
                    current.next=null;
                }

                prev=current;
                current=current.next;
            }
            System.out.println("mengambil pasien pada urutan "+noUrut);
                //Jika pasien yang datang sesuai no urut tidak ada, maka akan diambil nextnya sampai ketemu 
    //Lakukan pemanggilan pasien sesuai urutan hingga ketemu atau hingga akhir Queue 
            return 0; 
        }
    }

    public void printList() {
        Node current = head;
        System.out.println("Daftar antrian : ");
        while (current != null) {
            System.out.println(current.data.info());
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        QueueListPasien sll = new QueueListPasien();
        sll.runThis();
    }

    void runThis() {
        enqueue("Gandalf The Grey");
        enqueue("Aragorn");
        enqueue("Legolas");
        enqueue("Gimli");
        enqueue("Boromir");
        enqueue("Frodo Baggins");
        enqueue("Samwise Gamgee");
        enqueue("Meri");
        enqueue("Pippin");
        printList();

        ambilAntrianTengah(5);
        printList();

        dequeue();
        printList();

        enqueue("Gandalf The White");
        printList();
    }
}
