/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdraft;

import java.util.Scanner;

/**
 *
 * @author lefte
 */
public class Jdbcdraft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String epilogi = "";
        int ep;
        String lname = "";
        System.out.println("epelexe:\n 0 gia na deis oles tis times\n 1 gia na baleis 5 times \n 2 gia na alaxeis me basi to last name \n 3 na deos tis times me basi  fname lname\n 4 gia na deis posa record exeis \n 5 na dimiourgiseis ena pinaka \n 6 na baleis ta stoixeia ston birthdays meso tou member \n 7 des pioi anthropoi exoun tin idia imerominia ");
        epilogi = stdin.nextLine();
        ep = Integer.valueOf(epilogi);

        Diabasmakaiorasi kl = new Diabasmakaiorasi();

        if (ep == 0) {
            kl.Diabasmakaiorasi();
        }
        if (ep == 1) {
            kl.insertInt();
        } else if (ep == 2) {
            kl.changeN();
        } else if (ep == 3) {
            kl.showrec();
        } else if (ep == 4) {
        } else if (ep == 5) {
            kl.dimpin();
        } else if (ep == 6) {
            kl.eisBirthday();
        }
    }
}
