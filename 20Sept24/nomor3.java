import java.util.Scanner;

public class nomor3 {
    Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        nomor3 kls = new nomor3();
        kls.view();
    }

    void view() {
        System.out.print("Masukkan Bilangan: ");
        int bil = inp.nextInt();
        // cekbil(bil);

        if (cekbil(bil)) {
            System.out.println(bil + " bilangan prima");
        }else{
            System.out.println(bil + " bukan bilangan prima");
        }
    }

    boolean cekbil(int bil){
        boolean status = false ;
        int cek = 0;
        for (int i = 1 ; i<=bil ; i++) {
            if (bil%i==0) {
                cek++;
            }
        }if (cek==2) {
            status = true;
        }
        return status ;
    }
}