import java.util.Scanner;
//Puto
public class Matrius {
    private int [] [] matriuA;
    private int [] [] matriuB;
    private int [] [] matriuRes;
    private int [] [] matriuMul;
    private int [] [] matriuTra1;
    private int [] [] matriuTra2;
    private String [] Menu;

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Matrius programa = new Matrius();
        int opcioMenu = -1;
        do {
            programa.mostrarMenu();
            if (programa.scan.hasNextInt()){
                opcioMenu = programa.scan.nextInt();

                if (opcioMenu >= 1 && opcioMenu <= 8){
                    programa.executarAccio(opcioMenu);
                }
                else {
                    System.out.print("Opció incorrecta");
                }
            }
            else {
                System.out.print("Valor introduït incorrecte, introdueix un nùmero del 1 - 8");
                programa.scan.next();
            }
        }

        while (opcioMenu != 8);
    }
    //Constructor de la classe Matrius.
    public Matrius(){
        matriuA = new int[3][3];
        matriuB = new int[3][3];
        matriuRes = new int[3][3];
        matriuTra1 = new int[3][3];
        matriuTra2 = new int[3][3];
        matriuMul = new int[matriuB.length][matriuA[0].length];
        Menu = new String[8];
        inicialitzarMenu();
    }


    private void inicialitzarMenu(){
        Menu [0] = "[1] Emplena la primera matriu";
        Menu [1] = "[2] Emplena la segona matriu";
        Menu [2] = "[3] Visualitza les matrius";
        Menu [3] = "[4] Suma les matrius";
        Menu [4] = "[5] Multiplica per un escalar";
        Menu [5] = "[6] Producte de matrius";
        Menu [6] = "[7] Transporta";
        Menu [7] = "[8] Eixir";
    }

    private void mostrarMenu(){
        System.out.print("------------MENÚ------------\n");
        for (String m: Menu) {
            System.out.print(m + "\n");
        }
        System.out.print("Introdueix un valor de 1-8 per a elegir un programa: ");
    }


    public void executarAccio(int opcioMenu){
        switch (opcioMenu){
            case 1:
                emplenarMatriuA();
                break;
            case 2:
                emplenarMatriuB();
                break;
            case 3:
                mostrarMatrius();
                break;
            case 4:
                sumarMatrius();
                System.out.println("El resultat de la matriu es: ");
                mostrarResultatSuma();
                break;
            case 5:
                multiplicarMatrius();
                break;
            case 6:
                producteMatriu();
                mostrarResultatMultiplicació();
                break;
            case 7:
                transporta();
                break;
            case 8:
                System.out.print("Cerrando programa...");
                try {
                    Thread.sleep(3*1000);
                }catch (Exception a){
                    System.out.print(a);
                }
                break;
        }
    }

    public void emplenarMatriuA(){
        for (int i = 0; i < matriuA.length ; i++) {
            for (int j = 0; j < matriuA[i].length; j++) {
                    System.out.print("Introdueix els valor de la Matriu A, estas rellenant la posició [" + i +", " + j +"]: ");
                    matriuA [i] [j]= scan.nextInt();
                }
            }
        }

    public void emplenarMatriuB(){
        for (int i = 0; i < matriuB.length; i++) {
            for (int j = 0; j < matriuB[i].length; j++) {
                System.out.print("Introdueix els valor de la Matriu B, estas rellenant la posició [" + i +", " + j +"]: ");
                matriuB [i] [j] = scan.nextInt();
            }
        }
    }

    public void mostrarMatrius(){
        System.out.println("\nEstos són els valors de la Matriu A: ");
        for (int[] a: matriuA ) {
            for (int b: a) {
                System.out.print("[ " + b + " ]");
            }
            System.out.println("");
        }
        System.out.println("\nEstos són els valors de la Matriu B: ");
        for (int [] a:matriuB ) {
            for ( int b: a) {
                System.out.print("[ "+ b + " ]");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void sumarMatrius(){
        for (int f = 0; f < matriuA.length; f++) {
            for (int c = 0; c < matriuA.length; c++) {
                matriuRes[f][c] = matriuA[f][c] + matriuB[f][c];
            }
        }
    }

    public void multiplicarMatrius(){
        System.out.print("Introduiex un valor per multiplicar per la matriu: ");
        int num = scan.nextInt();
        int mul;
        for (int f = 0; f < matriuA.length; f++) {
            for (int c = 0; c < matriuA.length; c++) {
                    mul = matriuA[f][c] * num;

                matriuMul[f][c] = mul;
            }
        }
        for (int[] a: matriuMul) {
            for (int b: a) {
                System.out.print("[ " + b + " ]");
            }
            System.out.println("");
        }
    }

    public void producteMatriu(){
        for (int c = 0; c < matriuB[0].length; c++) {
            for (int f = 0; f < matriuA.length; f++) {
                int suma = 0;
                for (int m = 0; m <matriuA[0].length ; m++) {
                    suma += matriuA[f][m] * matriuB[m][c];
                }
                matriuMul[f][c] = suma;
            }
        }
    }
    public void transporta(){
        System.out.println("Este és el metode transporta en la matriu A: ");
        for (int f = 0; f < matriuA.length; f++) {
            for (int c = 0; c < matriuA[f].length; c++){
                matriuTra1[c][f] = matriuA[f][c];
            }
        }
        for (int[] a: matriuTra1) {
            for (int b: a) {
                System.out.print("[ " + b + " ]");
            }
            System.out.println("");
        }

        System.out.println("Este és el metode transporta en la matriu B: ");
        for (int f = 0; f < matriuB.length; f++) {
            for (int c = 0; c < matriuB[f].length; c++){
                matriuTra2[c][f] = matriuB[f][c];
            }
        }
        for (int[] a: matriuTra2) {
            for (int b: a) {
                System.out.print("[ " + b + " ]");
            }
            System.out.println("");
        }
    }

    public void mostrarResultatSuma(){

        for (int f = 0; f < matriuA.length; f++) {
            for (int c = 0; c < matriuA.length; c++) {
                System.out.print("[ " + matriuA[f][c] + " ]");
            }

            if (f == 1){
                System.out.print("  +   ");
            }
            else {
                System.out.print("      ");
            }

            for (int c = 0; c < matriuB.length; c++) {
                    System.out.print("[ " + matriuB[f][c] + " ]");

            }
            if (f == 1){
                System.out.print("  =   ");
            }
            else {
                System.out.print("      ");
            }
            for (int c = 0; c < matriuRes.length; c++) {
                System.out.print("[ " + matriuRes[f][c] + " ]");
            }

            System.out.println("");
        }
    }

    public void mostrarResultatMultiplicació(){
        for (int f = 0; f < matriuA.length; f++) {
            for (int c = 0; c < matriuA.length; c++) {
                System.out.print("[ " + matriuA[f][c] + " ]");
            }

            if (f == 1){
                System.out.print("  *   ");
            }
            else {
                System.out.print("      ");
            }

            for (int c = 0; c < matriuB.length; c++) {
                System.out.print("[ " + matriuB[f][c] + " ]");

            }
            if (f == 1){
                System.out.print("  =   ");
            }
            else {
                System.out.print("      ");
            }
            for (int c = 0; c < matriuMul.length; c++) {
                System.out.print("[ " + matriuMul[f][c] + " ]");
            }

            System.out.println("");
        }
    }
}
