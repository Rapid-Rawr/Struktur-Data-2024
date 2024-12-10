package week2;
import java.util.Scanner;

class KelolaArrayInteger {
    int n = 10;
    int[] arry = new int[n];
    Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        KelolaArrayInteger kai = new KelolaArrayInteger();
        kai.inputAndSort();
        kai.traversal();
    }// eomain

    void inputAndSort() {
        int val = 0;
        int temp = -999;
        for (int a = 0; a < n; a++) {
            System.out.print("nilai : ");
            val = inp.nextInt();
            if (a > 0) {
                for (int b = 0; b < a; b++) {
                    if (val > arry[b]) {
                        temp = arry[b];
                        arry[b] = val;
                        val = temp;
                    }
                }
            }
            arry[a] = val;
        }
    }// eorunthis

    void traversal() {
        for (int a = 0; a < n; a++) {
            System.out.print(arry[a] + " ");
        }
    }// eotraversal
}// eof
