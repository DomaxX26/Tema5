public class main {
    public static void main(String[] args) {
        System.out.println("******************************************");
        System.out.println("***** BENVINGUTS A LA BATALLA NAVAL *****");
        System.out.println("******************************************");
        cTauler joc = new cTauler();
        joc.mostrarTauler();

       joc.colocarVaixells();
       joc.mostrarTauler();
    }
}
