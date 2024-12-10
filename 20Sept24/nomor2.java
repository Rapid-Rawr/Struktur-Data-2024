import java.util.Scanner;
import java.util.ArrayList;

public class nomor2 {
    Scanner inp = new Scanner(System.in);
    // ArrayList<Integer> angka = new ArrayList<Integer>();

    public static void main(String[] args) {
        nomor2 kls = new nomor2();
        kls.view();
    }

    void view() {
        int bil;
        int jumlah = 0;
        int terbesar=0;
        do {
            System.out.print("Masukkan bilangan: ");
            bil = inp.nextInt();
            // jumlah= cekbil(bil);
            // if (bil % 2 == 0) {
            // angka.add(bil);
            // }
            // terbesar=terbesar(bil);
            if (bil>0) {
                // cekbil(bil);   
                if (bil%2==0) {
                    jumlah++;
                }
            }
            if (bil>terbesar) {
                terbesar=bil;
            }
        } while (bil != 0);

        System.out.println(jumlah+" "+terbesar);
    }

    // void cekbil(int bil) {
    //     // int jumlah= 0;
    //     // // int terbesar= 0;
    //     // if (bil%2==0) {
    //     // jumlah++;
    //     // }
    //     // // if (bil>terbesar) {
    //     // // terbesar=bil;
    //     // // }
    //     // return jumlah;

    //     if (bil % 2 == 0) {
    //         angka.add(bil);
    //     }
    // }

    // int terbesar() {
    //     int terbesar = 0;
    //     for (int i = 0; i < angka.size(); i++) {
    //         if (angka.get(i) > terbesar) {
    //             terbesar=angka.get(i);
    //         }
    //     }
    //     return terbesar;
    // }
}
