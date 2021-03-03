import java.util.Scanner;

public class cTauler {
    //Declaració de constants
    private final static int AMPLE = 8;
    private final static int ALT = 8;
    private int[][] vaixells;
    private int[][] dispars;
    private Scanner scan = new Scanner(System.in);
    private cPortavions p;
    private cCuirassat c;
    private cFragata f;
    private cDestructor d;
    private cSubmari s;

    //Constructor de la classe
    public cTauler() {
        p = new cPortavions();
        d = new cDestructor();
        c = new cCuirassat();
        f = new cFragata();
        s = new cSubmari();
        dispars = new int[ALT][AMPLE];
        vaixells = new int[ALT][AMPLE];

        /*mostrarTauler  ();
        llegirFila     ();
        llegirColumna  ();
        llegirDireccio ();*/
    }

    public void colocarVaixells() {
        int fila;
        int columna;
        boolean direccio;

        // 1. Colocar portavions
        fila = llegirFila();
        columna = llegirColumna();
        direccio = llegirDireccio();
        p.colocar(fila, columna, direccio);
        // Comprovar limitacions


        // desde columna hasta columna + p.tamany del portavions
        // vaixells[fila][columna] = "P"; només si es horizontal
        if (fila > 4 && columna > 4){
            System.out.print("El vaixell en aquesta posició no cap");
        }
        else {
            if (direccio == true) {
                if (fila > 5) {
                    System.out.print("No cap el Portavions");
                } else {
                    for (int i = 0; i < p.tamany; i++) {
                        vaixells[fila][columna +i] = 4;
                    }
                }
            }
            else {
                if (columna > 5){
                    System.out.print("No cap el Portavions");
                }
                else{
                    for (int i = 0; i < p.tamany; i++) {
                        vaixells[fila + i][columna] = 4;
                    }
                }
            }
        }


            // 2. Colocar cuirassat


            // 3. Colocar destructor


            // 4. Colocar fragata


            // 5. Colocar submari

    }

    //Metode de mostrar el tauler del joc.
    protected void mostrarTauler() {
        int num = 65;                               //Variable per a fer a fer les lletres
        System.out.print(" ");
        for (int k = 1; k < 9; k++) {
            System.out.print("   " + (k) + " ");      //Imprimixca els nùmeros
        }
        System.out.println("");
        for (int i = 0; i < ALT; i++) {             //Primer for per a imprimir les files
            char caracter = (char) num;         //Canviar el valor de número per un caracter
            System.out.print(caracter + " ");   //Imprimir el caracter
            num++;                              //Incrementar el valor del nùmero
            for (int j = 0; j < AMPLE; j++) {
                if (vaixells[i][j] == 0) {
                    System.out.print("[" + "__");//Imprimixca els recuadres
                } else if (vaixells[i][j] != 0) {
                    System.out.print("[_" + vaixells[i][j]);
                }
                System.out.print("_]");
            }
            System.out.println("");
        }
    }


    private int llegirFila() {
        int x;
        do {
            System.out.print("Fila a introduir (A-H): ");
            char fila = scan.next().charAt(0);
            fila = Character.toUpperCase(fila);
            x = fila;
            x -= 65;
        }
        while (x < 0 || x > 7);
        return x;
    }

    private int llegirColumna() {
        int y;
        do {
            System.out.print("Columna a introduir (1-8): ");
            y = scan.nextInt();
        }
        while (y < 0 || y > 7);
        return y -1;
    }

    private boolean llegirDireccio() {
        boolean posicion;

        System.out.print("Direcció a introduir (V - H): ");
        char direccion = scan.next().charAt(0);
        direccion = Character.toUpperCase(direccion);
        if (direccion == 'v' || direccion == 'V') {
            posicion = true;
        } else {
            posicion = false;

        }
        return posicion ;
    }
}