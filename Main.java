package explobot;

/**
 * @author maxence
 */
public class Main {

    public static void main(String[] args) {
        int x = 20;
        int y = 20;
        Donnee.carteInit = new int [x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                Donnee.carteInit[i][j] = 1;
            }
        }
        Donnee d = new Donnee(20,20,new Position(5,5,Position.Cap.N));
        Robot r = new Robot(2, d, new Position(10,10,Position.Cap.N),3);
        Ordonnanceur n = new Ordonnanceur(r);
        n.executer();
    }
}
