import java.util.Scanner;

public class Matrius {
    private int [] [] matriuA;
    private int [] [] matriuB;
    private int [] [] matriuRes;
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
        Menu = new String[8];
        inicialitzarMatrius();
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

    private void inicialitzarMatrius(){

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
                break;
            case 5:
                multiplicarMatrius();
                break;
            case 6:
                producteMatriu();
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
                    System.out.print("Introdueix els valor de la Matriu A: ");
                    matriuA [i] [j]= scan.nextInt();
                }
            }
        }

    public void emplenarMatriuB(){
        for (int i = 0; i < matriuB.length; i++) {
            for (int j = 0; j < matriuB[i].length; j++) {
                System.out.print("Introdueix els valor de la Matriu B: ");
                matriuB [i] [j] = scan.nextInt();
            }
        }
    }

    public void mostrarMatrius(){
        System.out.print("\nEstos són els valors de la Matriu A: ");
        for (int[] a: matriuA ) {
            for (int b: a) {
                System.out.print(b + " ");
            }
        }
        System.out.print("\nEstos són els valors de la Matriu B: ");
        for (int [] a:matriuB ) {
            for ( int b: a) {
                System.out.print(b + " ");
            }
        }
    }

    public void sumarMatrius(){

    }

    public void multiplicarMatrius(){

    }

    public void producteMatriu(){

    }
    public void transporta(){

    }
}
