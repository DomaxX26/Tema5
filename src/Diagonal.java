public class Diagonal {
    private int matriuDiagonal [][];
    public Diagonal(){
        matriuDiagonal = new int[10][10];
    }
    public static void main(String[] args) {
        Diagonal programa = new Diagonal();
        for (int i = 0; i < programa.matriuDiagonal.length ; i++) {
            for (int j = 0; j < programa.matriuDiagonal.length; j++) {
                if (i == j){
                    System.out.print("*");
                }
                else{
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
    }
}
