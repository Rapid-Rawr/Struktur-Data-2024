import java.io.*;
import java.util.Scanner;

class Node {
   Barang data;
   Node next;
   Node prev;

   Node(Barang d) {
      data = d;
      next = null;
      prev = null;
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
   public String getNama() {
      return nama;
   }

   public String info() {
      return id + " " + nama + " " + stok;
   }
}

public class DoubleLinkedList {
   Node head; // head of list
   Node tail; // tail of list
   Scanner inp = new Scanner(System.in);

   /* Insert last */
   public void insertEnd(int id, String nama, int stock) {
      Barang x = new Barang(id, nama, stock);
      Node nn = new Node(x);
      if (tail == null) {
         head = tail = nn;
      } else {
         tail.next = nn;
         nn.prev = tail;
         tail = nn;
      }
      System.out.println("Node baru " + tail.data.info() + " diposisi belakang");
   }

   /* Insert First */
   public void insertFirst(int id, String nama, int stock) {
      Barang x = new Barang(id, nama, stock);
      Node nn = new Node(x);
      if (head == null) {
         head = tail = nn;
      } else {
         head.prev = nn;
         nn.next = head;
         head = nn;
      }
      System.out.println("Node baru " + head.data.info() + " diposisi depan");
   }

   /* Insert sorted */
   public void insertSorted(int id, String nama, int stock) {
      Barang x = new Barang(id, nama, stock);
      Node newNode = new Node(x);
      // Kasus 1. Jika List empty
      if (head == null) {
         head = tail = newNode;
         System.out.println("Node baru " + head.data.info() + " paling depan");
         return;
      }
      // Kasus 2. Jika new node adalah angka paling kecil
      if (newNode.data.getId() <= head.data.getId()) {
         newNode.next = head;
         head.prev = newNode;
         head = newNode;
         System.out.println("Node baru " + head.data.info() + " paling depan");
         return;
      }
      // Kasus 3: jika new node angka paling besar
      if (newNode.data.getId() >= tail.data.getId()) {
         newNode.prev = tail;
         tail.next = newNode;
         tail = newNode;
         System.out.println("Node baru " + tail.data.info() + " paling belakang");
         return;
      }
      // Kasus 4: diantara head dan tail
      Node current = head;
      while (current != null && current.data.getId() < id) {
         current = current.next;
      }
      // Insert the node before the current node
      newNode.next = current;
      newNode.prev = current.prev;
      if (current.prev != null) {
         current.prev.next = newNode;
      }
      current.prev = newNode;
      System.out.println("Node baru " + newNode.data.info() + " di tengah");
   }

   // Delete node dengan data tertentu
   public void delete(int id) {
      if (head == null) {
         System.out.println("List is empty.");
         return;
      }
      Node current = head;
      // Case 1: Delete the head node
      if (head.data.getId() == id) {
         head = head.next;
         if (head != null) {
            head.prev = null;
         } else {
            tail = null; // If the list becomes empty
         }
         return;
      }
      // Traverse to find the node to delete
      while (current != null && current.data.getId() != id) {
         current = current.next;
      }
      // Case 2: Node not found
      if (current == null) {
         System.out.println("Node dengan id " + id + " tidak ditemukan.");
         return;
      }
      // Case 3: Delete a middle node
      if (current.next != null) {
         current.next.prev = current.prev;
      } else {
         tail = current.prev; // jika node yang dihapus adalah tail
      }
      if (current.prev != null) {
         current.prev.next = current.next;
      }
   }

   public void printListForward() {
      Node current = head;
      System.out.println("Double LinkedList Forward: ");
      while (current != null) {
         System.out.println(current.data.info() + " ");
         current = current.next;
      }
      System.out.println("");
   }

   public void printListBackward() {
      Node current = tail;
      System.out.println("Double LinkedList Backward: ");
      while (current != null) {
         System.out.println(current.data.info() + " ");
         current = current.prev;
      }
      System.out.println("");
   }

   public static void main(String[] args) {
      DoubleLinkedList dll = new DoubleLinkedList();
      dll.runThis();
   }

   void runThis() {
      // INSERT BIASA

      insertFirst(1, "bass", 3);
      insertEnd(5, "asus", 3);
      insertEnd(3, "moofu", 5);
      insertFirst(2, "sasa", 10);
      insertFirst(7, "gelas", 2);
      insertEnd(6, "paseo", 20);
      insertFirst(4, "gunting", 1);
      insertEnd(8, "parfum", 7);
      printListBackward();
      printListForward();

      // INSERT SORTEd
      System.out.println("Pengosongan List");
      head = null ;
      insertSorted(1, "bass", 3);
      insertSorted(5, "asus", 3);
      insertSorted(3, "moofu", 5);
      insertSorted(2, "sasa", 10);
      insertSorted(7, "gelas", 2);
      insertSorted(6, "paseo", 20);
      insertSorted(4, "gunting", 1);
      insertSorted(8, "parfum", 7);
      printListBackward();
      printListForward();

      System.out.println("Melakukan delete idx: 6, 1, 9");
      delete(6);
      delete(1);
      delete(9);
      printListBackward();
      printListForward();
      
   }
}