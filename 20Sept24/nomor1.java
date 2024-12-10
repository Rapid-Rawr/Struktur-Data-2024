import java.util.Scanner;

public class nomor1 {
    Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        nomor1 kls = new nomor1();
        kls.view();

    }

    void view() {
        int bilangan;
        int positif = 0;
        int negatif = 0;
        do {
            System.out.println("Masukkan Bilangan: ");
            bilangan = inp.nextInt();

            // kls.cekbil(bilangan);
            if (bilangan < 0) {
                negatif++;
            } else if (bilangan > 0) {
                positif++;
            }

        } while (bilangan != 0);
        cekbil(positif, negatif);
    }

    public void cekbil(int positif, int negatif) {
        // int positif = 0;
        // int negatif = 0;
        String perbandingan;

        // if (bil<0) {
        // negatif++;
        // }else{
        // positif++;
        // }

        if (positif > negatif) {
            perbandingan = " positif";
        } else if (negatif > positif) {
            perbandingan = " negatif";
        } else {
            perbandingan = " imbang";
        }

        System.out.println(positif + " - " + negatif + perbandingan);
    }

}
