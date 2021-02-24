import java.util.Scanner;

public class Assignatura {
    private double [] [] assignatura;
    private double [] [] assignatures;
    private String [] Menu;

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Assignatura programa = new Assignatura();
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
    public Assignatura(){
        assignatura = new double[3][];
        assignatures = new double[3][15];
        Menu = new String[6];
        inicialitzarMenu();
    }


    private void inicialitzarMenu(){
        Menu [0] = "[1] Inserir notes de l'assignatura sel·leccionada";
        Menu [1] = "[2] Inserir totes les notes";
        Menu [2] = "[3] Calcular la nota mitjana de l'assignatura sel·leccionada";
        Menu [3] = "[4] Ordenar les assignatures de forma ascendent";
        Menu [4] = "[5] Estadística";
        Menu [5] = "[6] Eixir de l'aplicació";
    }

    public void mostrarMenu(){
        System.out.print("------------MENÚ------------\n");
        for (String m: Menu) {
            System.out.print(m + "\n");
        }
        System.out.print("Introdueix un valor de 1-6 per a elegir un programa: ");
    }

    public void executarAccio(int opcioMenu){
        int seleccioAssig = -1;
        switch (opcioMenu){
            case 1:
                System.out.print("Elegix una de les tres assignatures: ");
                seleccioAssig = scan.nextInt();
                inserirNotesSelec(seleccioAssig);
                break;
            case 2:
                inserirTotesNotes();
                break;
            case 3:
                calcularMitjana();
                break;
            case 4:
                ordenarAssiganatures();
                break;
            case 5:
                estadistica();
                break;
            case 6:
                System.out.print("Cerrando programa...");
                try {
                    Thread.sleep(3*1000);
                }catch (Exception a){
                    System.out.print(a);
                }
                break;
        }
    }

    //Metodo inserir les notes de la assignatura que vullgam
    public void inserirNotesSelec(int seleccioAssig) {
        if (seleccioAssig == 1) {
            assignatura[0]= new double[15];
            System.out.println("Estas inserint les notes de la assignatura 1 ");
                for (int c = 0; c < 15; c++) {
                    System.out.print("Nota del alumne " + (c + 1) + ": ");
                    assignatura[0][c] = scan.nextDouble();
                    if (assignatura[0][c] > 10 || assignatura[0][c] < 0){
                        c = (c - 1);
                    }
                }
            mostrarNotes(0);
        }
        if (seleccioAssig== 2){
            assignatura[1]= new double[15];
            System.out.println("Estas inserint les notes de la assignatura 2 ");
                for (int c = 0; c < 15; c++) {
                    System.out.print("Nota del alumne " + (c + 1) + ": ");
                    assignatura[1][c] = scan.nextInt();
                    if (assignatura[1][c] > 10 || assignatura[1][c] < 0){
                        c = c - 1;
                    }
                }
            mostrarNotes(1);
        }
        if (seleccioAssig == 3){
            assignatura[2]= new double[15];
            System.out.println("Estas inserint les notes de la assignatura 3 ");
                for (int c = 0; c < 15; c++) {
                    System.out.print("Nota del alumne " + (c + 1) + ": ");
                    assignatura[2][c] = scan.nextInt();
                    if (assignatura[2][c] > 10 || assignatura[2][c] < 0){
                        c = c - 1;
                    }
                }
            mostrarNotes(2);
        }
    }

    //Metodo per afegir totes les notes de les assignatures
    public void inserirTotesNotes() {

        for (int f = 0; f < assignatures.length; f++) {
            System.out.println("--------Assignatura " + (f + 1) + "--------");
            for (int c = 0; c < assignatures[f].length; c++) {
                System.out.print("Nota del alumne " + (c + 1) + ": ");
                assignatures[f][c] = scan.nextDouble();
                if (assignatures[f][c] > 10 || assignatures[f][c] < 0){
                    c = c - 1;
                }
            }
        }
        mostrarTotesNotes();
    }

    //Metode per a mostrar les notes
    public void mostrarTotesNotes(){
        int suma = 1;
        for (int f = 0; f < assignatures.length; f++) {
            System.out.println("--------Assignatura " + suma + "--------");
            suma++;
            for (int c = 0; c < assignatures[f].length; c++) {
                System.out.print("[ " + assignatures[f][c] + " ]");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    //Metode per a calcular la mitjana
    public void calcularMitjana(){
        double media, suma = 0;

        for (int i = 0; i < 3; i++) {
            for (int c = 0; c < 15 ; c++) {                            //Recorre la primera part de la matriu
                suma = suma + assignatures[i][c];                      //Suma els valors
            }
            media = suma / 15;                                        //Trau mitja de totes les notes sumades
            System.out.println("La nota mitja de la Assignatura "+ (i + 1) +" és: " + media);
            suma = 0;
        }


        }


    //Metode per a ordenar les notes de totes les assignatures
    public void ordenarAssiganatures() {
        double aux;
        for (int f = 0; f < assignatures.length; f++) {
            for (int c = 0; c < assignatures[f].length; c++) {
                 aux = assignatures[f][c];
                while ((c > 0) && (assignatures[f][c - 1] > aux)) {
                    assignatures[f][c] = assignatures[f][c - 1];
                    c--;
                }
                assignatures[f][c] = aux;
            }
        }
            mostrarTotesNotes();
    }

    //Metode per a fer la estadistica de les notes de les tres assignatures
    public void estadistica(){

        int persones1 = 0, persones2 = 0, persones3 = 0, persones4 = 0, persones5 = 0;
        for (int f = 0; f < 3 ; f++) {
            for (int c = 0; c < 15 ; c++) {

                if (assignatures[f][c]<= 3 && assignatures[f][c] >= 0){
                    persones1++;
                }
                else if (assignatures[f][c] <= 5 && assignatures[f][c] >= 3.1){
                    persones2++;
                }
                else if (assignatures[f][c] <= 7 && assignatures[f][c] >= 5.1){
                    persones3++;
                }
                else if (assignatures[f][c] <= 9 && assignatures[f][c] >= 7.1){
                    persones4++;
                }
                else{
                    persones5++;
                }
            }
        }
        System.out.println("Hi han " + persones1 + " entre un 0 - 3");
        System.out.println("Hi han " + persones2 + " entre un 3.1 - 5");
        System.out.println("Hi han " + persones3 + " entre un 5.1 - 7");
        System.out.println("Hi han " + persones4 + " entre un 7.1 - 9");
        System.out.println("Hi han " + persones5 + " entre un 9.1 - 10");

    }

    //Metode per a mostrar les notes de la sel·lecció de notes
    public void mostrarNotes(int seleccioAssig){
        System.out.println("--------Assignatura "+(seleccioAssig + 1)+"--------");
        for (int f = 0; f < 1; f++) {
            for (int c = 0; c < assignatura[seleccioAssig].length; c++) {
                System.out.print("[ " + assignatura[seleccioAssig][c] + " ]");
            }
            System.out.println("");
        }
    }
}
