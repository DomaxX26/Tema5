import javax.swing.*;
import java.util.Scanner;

public class cTauler {
    //Declaració de constants
    private final static int AMPLE = 8;
    private final static int ALT = 8;
    private int [] [] vaixells;
    int [][] dispars;
    cPortavions p;
    cCuirassat c;
    cFragata f;
    cDestructor d;
    cSubmari s;

    //Constructor de la classe
    public cTauler(){
        p = new cPortavions();
        d = new cDestructor();
        c = new cCuirassat();
        f = new cFragata();
        s = new cSubmari();
        dispars = new int[ALT][AMPLE];
        vaixells = new int[8][8];
        //tamanyTauler();
    }

    /*private int llegirFila(){
        System.out.print("En quina fila vols introduir?: ");

    }

    private int llegirColumna(){
        System.out.print("En quina columna vols introduir?: ");
    }

    private boolean llegirDireccio(){
        System.out.print("En quina direcció vols introduir?: ");
    }

    private void omplirMatriu(){
        for (int f = 0; f < vaixells.length; f++) {
            for (int c = 0; c < vaixells.length; c++) {
                //vaixells[f][c] = scan.nextInt();
            }
        }
    }
    public void colocarVaixell(){
        int fila = llegirFila();
        int columna = llegirColumna();
        boolean direccio = llegirDireccio();
    }
    public static void tamanyTauler(){
        JFrame tauler = new JFrame("Batalla Naval");
        tauler.setSize(500, 500);
        tauler.setVisible(true);
        tauler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
*/
}
