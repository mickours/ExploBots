/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package explobot;

/**
 *
 * @author joachim
 *
 * TODO :
 *  - Fonction Echange a faire à chaque deplacement de robot
 */
public class Ordonnanceur {
    private Robot b;

    public Ordonnanceur(Robot b) {
        this.b = b;
    }

    public void executer(){
        boolean bool = true;
        while (bool){
            System.out.println(b.getCourant().toString());
            b.executer();
            if (b.getCourant().equals(b.getObjectif())) bool = false;
        }
        System.out.println("position final : "+b.getCourant().toString());

    }

}
