package UML_Projet_Centrale;

import java.util.ArrayList;

public class Centrale {

    private ArrayList<Objet> listeObjets = new ArrayList<>();
    private ArrayList<Terminal> listeTerminaux = new ArrayList<>();

    public Centrale(){

    }
    
    public void notifySubscribers(){

    }

    public void subscribe(Objet o){
        listeObjets.add(o);
        if(o instanceof Capteur){
            Capteur cap = (Capteur) o;
            cap.SetCentrale(this);
        }
    }

    public void unsubscribe(Object o){
        listeObjets.remove(o);
    }

    public void addTerminal(Terminal t){
        listeTerminaux.add(t);
    }

    public void removeTerminal(Terminal t){
        listeTerminaux.remove(t);
    }

    public void update(){
        for (Terminal t : listeTerminaux) {
        }
    }


    public ArrayList<Objet> getListeObjets() {
        return this.listeObjets;
    }

}