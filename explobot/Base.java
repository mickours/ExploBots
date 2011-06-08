package explobot;

/**
 *
 * @author maxence
 */
public class Base {
    private int rayonCom;
    private Donnee data;
    private Position courant;

    public Base(int rayonCom, Donnee data, Position p) {
        this.rayonCom = rayonCom;
        this.data = data;
        this.courant = p;
    }

    public Donnee getData() {
        return data;
    }

    public Position getCourant() {
        return courant;
    }

    public int getRayonCom() {
        return rayonCom;
    }

    public void setData(Donnee data) {
        this.data = data;
    }

    public void setCourant(Position p) {
        this.courant = p;
    }

    public void setRayonCom(int rayonCom) {
        this.rayonCom = rayonCom;
    }

    
}
