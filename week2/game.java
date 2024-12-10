package week2.Game;

import java.util.Scanner;
import java.util.ArrayList;

public class game {

    private static Scanner inp = new Scanner(System.in);
    Petualang[] player;

    public static void main(String[] args) {
        game gm = new game();
        gm.view();
    }

    public void view() {

        System.out.print("Masukkan jumlah player: ");
        int jumPet = inp.nextInt();

        player = new Petualang[jumPet];
        for (int i = 0; i < jumPet; i++) {
            addMember(i);
        }
        jumlahPlayer();

    }

    public void jumlahPlayer(){
        for (int i = 0 ; i<player.length;i++) {
            System.out.println("Total coding power petualang "+(i+1)+ " : "
            + player[i].allPower());
        }
    }

    public void addMember(int idx) {

        System.out.println("Untuk petualang "+(idx+1));
        System.out.print("Masukkan LOgic power: ");
        int LogPow= inp.nextInt();
        System.out.print("Masukkan BugTracerPower: ");
        int BugTrace = inp.nextInt();
        System.out.print("masukkan Endurance power: ");
        int endurance = inp.nextInt();

        Petualang plyr = new Petualang(LogPow, BugTrace, endurance);
        player[idx]= plyr;
    }
}

class Petualang {
    private int LogPwr;
    private int BTPwr;
    private int EndurPwr;

    public Petualang(int Logical, int BTP, int Endurance) {
        LogPwr = Logical;
        BTPwr = BTP;
        EndurPwr = Endurance;
    }

    public double allPower() {
        return (2 * LogPwr) + (3 * BTPwr) + (0.5 * EndurPwr);
    }

}
