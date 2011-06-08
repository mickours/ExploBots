/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package explobot;

/**
 *
 * @author joachim
 */
class Position {

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.cap = Cap.N;
    }
    public enum Cap {N,S,E,O,NE,NO,SE,SO}
    private int x;
    private int y;
    private Cap cap;
    
    public Position(int x, int y, Cap cap) {
        this.x = x;
        this.y = y;
        this.cap = cap;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cap getCap() {
        return cap;
    }

    public void avancer(){
        if(cap == Cap.N){
            x--;
        }
        else if (cap == Cap.NE){
            x--;
            y++;
        }
        else if (cap == Cap.E){
            y++;
        }
        else if (cap == Cap.SE){
            x++;
            y++;
        }
        else if (cap == Cap.S){
            x++;
        }
        else if (cap == Cap.SO){
            x++;
            y--;
        }
        else if (cap == Cap.O){
            y--;
        }
        else{
            x--;
            y--;
        }

    }

    public void tourner(Cap cap){
        this.cap = cap;
    }

    public boolean equals(Position p) {
        return x == p.getX() && y == p.getY();
    }

    @Override
    public String toString() {
        return "Position{" + "x=" + x + "y=" + y + "cap=" + cap + '}';
    }
    
}
