import javax.swing.*;
import java.util.Scanner;


public class TAD {

    // Declaració de constants
    static final int MAX = 10;  // Nombre màxim d'elements dels vectors
    static final int MENU = 11;  // Nombre d'items del menú de l'aplicació
    private int [] arrayEnters;
    private char [] arrayCaracters;
    private String [] arrayMenu;

    int pos, clau;



    Scanner scan = new Scanner(System.in);


    public static void main (String[] args) {
        int opcioMenu = -1;
        char aux;
        TAD programa = new TAD();


        do {
            programa.mostrarMenu();
            if (programa.scan.hasNextInt()){

                opcioMenu = programa.scan.nextInt();

                if (opcioMenu >= 0 && opcioMenu <= 10) {
                    // Crear una funció que es diga per exemple executarAccio(int opcioMenu) esta contindra el switch case
                    programa.executarAccio(opcioMenu);
                }
                else {
                    System.out.println("Opció incorrecta");
                    System.out.print("Apreta Enter per a seguir avant...");
                    programa.presionarEnter();
                }
            }
            else {
                programa.scan.next();
                System.out.println("Valor introduït incorrecte, introdueix un nùmero del 0 - 10");
                System.out.print("Apreta Enter per a seguir avant...");
                programa.presionarEnter();
            }
            if (opcioMenu >= 1 && opcioMenu <= 10){
                System.out.print("\nApreta Enter per a seguir avant...");
                programa.presionarEnter();
                programa.presionarEnter();
            }
            if (opcioMenu >= 6 && opcioMenu <= 10){     //Si toca un nombre d'ordenament que es reinicialit-se asoles el vèctor
                programa.generarArraysAleatoris();
            }
        }
        while (opcioMenu != 0);
    }

    // Constructor de classe TAD
    public TAD () {
        arrayEnters = new int[MAX];
        arrayCaracters = new char[MAX];
        arrayMenu = new String[MENU];
        inicialitzarArrayMenu();
        generarArraysAleatoris();
    }

    public void executarAccio(int opcioMenu){
        switch (opcioMenu) {
            case 0:
                System.out.print("Cerrando programa...");
                try {
                    Thread.sleep(3*1000);
                }catch (Exception a){
                    System.out.print(a);
                }
                break;
            case 1:
                System.out.println("--------ARRAY ENTERS--------");
                mostrarArrayEnters();
                break;
            case 2:
                System.out.println("--------ARRAY CÀRACTERS--------");
                mostrarArrayCaracters();
                break;
            case 3:
                System.out.println("--------REINICIAR ARRAYS--------");
                System.out.println("Reiniciant els arrays...");
                try {
                    Thread.sleep(1*1000);
                }catch (Exception a){
                    System.out.print(a);
                }
                generarArraysAleatoris();
                break;
            case 4:
                System.out.println("--------RECERCA SEQÜENCIAL--------");
                System.out.print("Quin nùmero vols buscar: ");
                sequencial(clau);

                if (scan.hasNextInt())
                    clau = scan.nextInt();

                pos = sequencial(clau);
                if (pos == -1) {
                    System.out.print("No s'ha trobat " + clau);
                }
                else{
                    System.out.print(clau + " esta es la posició " + ++pos);
                }
                break;
            case 5:
                System.out.println("--------RECERCA BINARIA--------");
                System.out.print("Quin nùmero vols buscar: ");

                if (scan.hasNextInt()){
                    clau = scan.nextInt();
                }
                pos = binaria(clau, opcioMenu);
                if (pos == -1){
                    System.out.print("No s'ha trobat el " + clau);
                }
                else{
                    System.out.print(clau + " esta en la posició " + ++pos);
                }
                binaria(clau, opcioMenu);
                System.out.print("Aixina quedaria el Array final :");
                mostrarBambollaAsc();
                break;
            case 6:
                System.out.println("--------ORDENAMENT EN BAMBOLLA--------");
                int opc;
                opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Elegix entre les dues opcions \n"
                        + "1. Bambolla Ascendent \n"
                        + "2. Bambolla Descendent"));
                switch (opc) {
                    case 1:
                        ordenarLlistaAsc(6);
                        System.out.println("--------BAMBOLLA ASCENDENT--------");
                        mostrarBambollaAsc();
                        break;
                    case 2:
                        ordenarLlistaDesc();
                        System.out.println("--------BAMBOLLA DESCENDENT--------");
                        mostrarBambollaDes();
                        break;
                }
                break;
            case 7:
                System.out.println("--------ORDENAMENT QUICKSORT--------");
                mostrarArrayEnters();
                System.out.print("\n");
                quickSort(arrayEnters,0, arrayEnters.length-1);
                mostrarArrayEnters();
                break;
            case 8:
                System.out.println("--------ORDENAMENT SHELL--------");
                shellSort(arrayEnters);
                System.out.print("Este es el Array final: ");
                mostrarArrayEnters();
                break;
            case 9:
                System.out.println("--------ORDENAMENT SEL·LECCIÓ--------");
                generarSellecio();
                System.out.print("Este es el array final: ");
                mostrarArrayEnters();
                break;
            case 10:
                System.out.println("--------ORDENAMENT INSERCIÓ--------");
                insercio(arrayEnters);
                System.out.print("Este es el array final: ");
                mostrarArrayEnters();
                break;
        }
    }

    public void presionarEnter(){
        String entrada;
        do {
            entrada = scan.nextLine();
        }
        while (!(entrada.isEmpty()));
    }

    //Metode que inicialitza el menú de la nostra aplicació.
    private void inicialitzarArrayMenu(){
        arrayMenu [0] = "[0] Eixir del programa";
        arrayMenu [1] = "[1] Mostrar Array Enters";
        arrayMenu [2] = "[2] Mostrar Array Caràcters";
        arrayMenu [3] = "[3] Reinicialitzar Vectors";
        arrayMenu [4] = "[4] Recerca Seqüencial";
        arrayMenu [5] = "[5] Recerca Binària";
        arrayMenu [6] = "[6] Ordenar amb Bambolla";
        arrayMenu [7] = "[7] Ordenar amb Quicksort";
        arrayMenu [8] = "[8] Ordenar amb Shell";
        arrayMenu [9] = "[9] Ordenament per Sel·leció";
        arrayMenu [10] = "[10] Ordenament per Inserció";
    }

    // Metode que mostra el menú d'opcions de la nostra aplicació.
    private void mostrarMenu () {
        System.out.println("\n----------MENÚ----------");
        for (String m: arrayMenu) {
            System.out.print(m + "\n");
        }
        System.out.print("Introduix un valor del 0-10 per a elegir un programa: ");
    }

    // Metode de recerca sequencial
    public int sequencial (int clau) {
            for (int i = 0; i < arrayEnters.length; i++) {
                if (arrayEnters[i] == clau) {
                    return i;
                }
            }
        return -1;
    }


    // Metode de recerca binaria
    public int binaria (int clau, int opcioMenu) {
        int posCentre, posInicial, posFinal, valorCentral;
        posInicial = 0;
        posFinal = arrayEnters.length - 1;
        ordenarLlistaAsc(opcioMenu);
        while (posInicial <= posFinal) {
            posCentre = (posInicial + posFinal) / 2;
            valorCentral = arrayEnters[posCentre];
            if (clau == valorCentral) {
                return posCentre;
            } else if (clau < valorCentral) {
                posFinal = posCentre - 1;
            } else {
                posInicial = posCentre + 1;
            }
        }
        return -1;
    }

    // Metode d'ordenació per bombolla ascendent
    public void ordenarLlistaAsc(int opcioMenu) {
        int aux;
        for (int i = 0; (i < arrayEnters.length); i++) {
            for (int j = 0; (j < arrayEnters.length - 1); j++) {
                if (arrayEnters[j] > arrayEnters[j + 1]){
                    aux = arrayEnters[j];
                    arrayEnters[j] = arrayEnters[j + 1];
                    arrayEnters[j + 1] = aux;
                    if(opcioMenu == 6) {
                        mostrarArrayEnters();
                        System.out.println("");
                    }
                }
            }
            System.out.print("");
        }
        System.out.print("\n");
    }

    //Mostrar Bambolla Ascendent
    public void mostrarBambollaAsc(){
        for (int x:arrayEnters) {
            System.out.print(x + " ");
        }
    }

    //Mostrar Bambolla Descendent
    public void mostrarBambollaDes(){
        for (int y: arrayEnters) {
            System.out.print(y + " ");
        }
    }
    // Metode d'ordenació per bombolla descendent
    public void ordenarLlistaDesc() {
        int aux;
        for (int i = 0; (i < arrayEnters.length); i++) {
            for (int j = 0; (j < arrayEnters.length - 1); j++) {
                if (arrayEnters [j] < arrayEnters[j + 1]){
                    aux = arrayEnters[j];
                    arrayEnters[j] = arrayEnters[j + 1];
                    arrayEnters[j + 1] = aux;
                    mostrarArrayEnters();
                    System.out.println("");
                }
            }
            System.out.print("");
        }
        System.out.print("\n");
    }
    // Metode que mostra per pantalla l'array d'enters
    private void mostrarArrayEnters() {
        for (int e: arrayEnters) {
            System.out.print(e + " ");
        }
    }

    // Metode que mostra per pantalla l'array de caracters
    private void mostrarArrayCaracters() {
        char caracter;
        for (int a: arrayCaracters) {
            caracter = (char) a;
            System.out.print(caracter + " ");
        }
    }

    // Metode per emplenar els arrays de forma aleatòria.
    private void generarArraysAleatoris() {
        for (int i = 0; i < MAX ; i++) {
            arrayEnters[i] = (int) (Math.random() * 100) + 1;
            arrayCaracters[i] = (char) (Math.random() * (122-97) + 97);
        }
    }

    public void insercio (int [] arrayEnters){
        int i, j, aux;
        for (i = 1; i < arrayEnters.length;i++) {
            aux = arrayEnters[i];
            j = i - 1;
            while ((j >= 0) && (aux < arrayEnters[j])){
                arrayEnters[j + 1] = arrayEnters[j];
                j--;
            }
            arrayEnters[j + 1] = aux;
            mostrarArrayEnters();
            System.out.println("");
        }
    }

    public void shellSort(int [] arrayEnters){
        int interval, aux, i;
        boolean cambios;

        for (interval = arrayEnters.length / 2; interval != 0; interval /=2){
            cambios = true;
            while (cambios){ //Mentres s'intercanbien algo
                cambios = false;
                for (i = interval; i < arrayEnters.length; i++){ //Fa una pasada
                    if (arrayEnters[i - interval] > arrayEnters[i]){ //Si estan desordenats
                        aux = arrayEnters[i];                        //S'ordenen
                        arrayEnters[i] = arrayEnters[i - interval];
                        arrayEnters[i -interval] = aux;
                        cambios = true;                              //Marca el canvi
                      mostrarArrayEnters();
                      System.out.println("");
                    }
                }
            }
        }
    }
    public void generarSellecio(){
        int i, j, menor, aux;

        for (i = 0; i < arrayEnters.length -1;i++){
            menor = i;
            for (j = i + 1; j<arrayEnters.length;j++){
                if (arrayEnters[j]<arrayEnters[menor]){
                    menor = j;
                    mostrarArrayEnters(); //Mostre totes les iteracions
                    System.out.print("\n");
                }
            }
            aux = arrayEnters[i];
            arrayEnters[i]=arrayEnters[menor];
            arrayEnters[menor] = aux;
        }
    }

     void quickSort(int []arrayEnters, int menors, int majors){
        int i, j, pivot,central,aux;

        central = (menors+majors)/2;
        pivot = arrayEnters[central];
        i = menors;
        j = majors;

        do {
            while (arrayEnters[i] < pivot){
                i++;
            }
            while (arrayEnters[j] > pivot){
                j--;
            }
            if (i <= j){
                aux = arrayEnters[i];           //Fa el canvi del valor
                arrayEnters[i] = arrayEnters[j];
                arrayEnters[j] = aux;
                i++;
                j--;
                mostrarArrayEnters();
                System.out.print("===>> El Pivot es: " + pivot + " la i és: " + i + " la j és: " + j);
                System.out.println("");
            }

        }
        while (i<=j);
        if ( menors < j){
            quickSort(arrayEnters,menors,j);
        }
        if (i < majors){
            quickSort(arrayEnters, i, majors);
        }
    }
}
