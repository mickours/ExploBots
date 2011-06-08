package explobot;

import explobot.Position.Cap;

/**
 *
 * @author maxence
 *
 * TODO
 *  - Parametriser fonction rechercheSuivant()
 *  - Ajouter un random sur le choix de chemin (rechercheSuivant())
 *  - Ajouter minicarte de Colision (position des autres robot + "obstacles")
 *       Tableau[visibilité du robot]
 */
public class Robot extends Base {
    private int nbEchantillonMax;
    private int nbEchantillonCourant;
    private Position objectif;

    public Robot(int rayonCom, Donnee data, Position p, int nbEchantillonMax) {
        super(rayonCom,data,p);
        this.nbEchantillonMax = nbEchantillonMax;
        this.nbEchantillonCourant = 0;
    }

    public void executer(){
        //Recherche d'une zone à découvrire
        if (nbEchantillonCourant != nbEchantillonMax
                && (objectif == null || getData().estVisible(objectif))) {
            objectif = rechercheObjectif();
        }
        //Retour à la base
        else if (objectif == null
                || !objectif.equals(getData().getpBase())) {
            objectif = getData().getpBase();
        }
        //tourner ou avancer
        Cap c = rechercheSuivant();
        if( c == getCourant().getCap()){
            getCourant().avancer();
        }
        else{
            getCourant().tourner(c);
        }
    }

    private Position.Cap rechercheSuivant() {
        //TODO : Verifier qu'il n'y a pas de robot sur la nouvelle case
        int n,m,x,y; //
        Cap cap = getCourant().getCap();
        //Objectif sur la meme ligne
        if (getCourant().getX()== objectif.getX()){
            if ((getCourant().getY() - objectif.getY())<0){
                cap = Cap.E;
            }
            else{
               cap = Cap.O;
            }
        }
        //Objectif sur la meme colonne
        else if(getCourant().getY() == objectif.getY())
        {
            if ((getCourant().getX() - objectif.getX())<0){
                cap = Cap.S;
            }
            else{
               cap = Cap.N;
            }
        }
        //Objectif sur les diagonals
        else {
            n = objectif.getX() - getCourant().getX();
            m = objectif.getY() - getCourant().getY();
            boolean choix = Math.random() > 0.5;
            //coin inferieur droit
            if (n > 0 &&  m > 0){
                //sur diagonal
                if (n == m || (getCourant().getCap() == Cap.SE) ) {
                    cap = Cap.SE;
                }
                //au dessus diag
                else if (n < m){
                    cap = Cap.E;
                }
                //en dessous diag
                else{
                    cap = Cap.S;
                }
            }
            //coin superieur gauche
            else if(n < 0 && m < 0)
            {
                //sur diagonal
                if (n == m || (getCourant().getCap() == Cap.NO)){
                    cap = Cap.NO;
                }
                //au dessus diag
                else if (n < m){
                    cap = Cap.N;
                }
                //en dessous diag
                else{
                    cap = Cap.O;
                }
            }
            //coin superieur droit
            else if(n < 0)
            {
                //sur diagonal
                if (n == -m || (getCourant().getCap() == Cap.NE)){
                    cap = Cap.NE;
                }
                //au dessus diag
                else if (-n < m){
                    cap = Cap.N;
                }
                //en dessous diag
                else{
                    cap = Cap.E;
                }
            }
            //coin inferieur gauche
            else if(m < 0)
            {
                //sur diagonal
                if (n == -m || (getCourant().getCap() == Cap.SO)){
                    cap = Cap.SO;
                }
                //au dessus diag
                else if (n < -m){
                    cap = Cap.O;
                }
                //en dessous diag
                else{
                    cap = Cap.S;
                }
            }
        }
        return cap;
    }


    private Position rechercheObjectif() {
        return new Position(2,3);
    }

    public Position getObjectif() {
        return objectif;
    }
}
