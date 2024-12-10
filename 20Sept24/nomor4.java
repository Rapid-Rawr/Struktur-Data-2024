import java.util.Scanner;

public class nomor4 {
    static nomor4 kls = new nomor4();
    static Scanner inp = new Scanner(System.in);
    public static void main(String[] args) {
        kls.view();
    }    

    void view(){
        System.out.println("Masukkan Bilangan");
        int bilangan = inp.nextInt();
        cekbil(bilangan); 
    } 

    void cekbil(int bil){
        int jumlah= 0;
        for (int i=1; i<bil ; i++) {
            if (bil%i==0) {
                jumlah+= i;
                System.out.print(i+" ");
            }
        }

        if (jumlah==bil) {
            System.out.print(" -"+bil +" Bilangan sempurna");
        }else{
            System.out.print(" -"+bil+" Tidak Sempurna");
        }
    }
}
 