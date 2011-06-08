/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package explobot;

/**
 *
 * @author joachim
 */
public class Donnee {
    static public int [][] carteInit;
    static private int nbMilieu;
    private int [][] carte;
    private boolean [] milieu;
    private Position pBase;

    public Donnee(int x, int y, Position pBase) {
        carte = new int [x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(x==pBase.getX() && y==pBase.getY())
                    carte[i][j] = 1;
                else
                    carte[i][j] = 0;
            }
        }
        milieu = new boolean [nbMilieu];
        for(int i = 0;i<nbMilieu;i++){
            milieu[i] = false;
        }
        this.pBase = pBase;
    }

    public int getCarte(int i, int j) {
        return carte[i][j];
    }

    public void setCarte(int i, int j, int k) {
        carte[i][j] = k;
    }

    public boolean getMilieu(int i) {
        return milieu[i];
    }

    public void setMilieu(int i, boolean b) {
        milieu[i] = b;
    }

    public Position getpBase() {
        return pBase;
    }

    public void setpBase(Position pBase) {
        this.pBase = pBase;
    }

    /* Prend une donnee en entree d et fait l union entre
     * la carte de l objet courant et celle de d
     * les milieus de l objet courant et ceux de d
     */
    public void union(Donnee d){
        for(int i=0;i<carte.length;i++){
            for(int j=0;j<carte[i].length;j++){
                int k = carte[i][j] | d.getCarte(i,j);
                carte[i][j] = k;
                d.setCarte(i,j,k);
            }
        }
        for(int i=0;i<milieu.length;i++){
            boolean b = milieu[i] || d.getMilieu(i);
            milieu[i] = b;
            d.setMilieu(i,b);
        }
    }
    
    /* Degrise la case visitee et renvoie true si on a decouvert un nouveau milieu */
    public boolean ajout(Position p,int n){
        carte[p.getX()][p.getY()] = 1;
        if(milieu[n] == false){
            milieu[n] = true;
            return true;
        }
        return false;
    }
    
    /* renvoie true si la position sur la carte est deja decouverte */
    public boolean estVisible (Position p){
        return carte[p.getX()][p.getY()] != 0;
    }
}
