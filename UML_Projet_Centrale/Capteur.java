package UML_Projet_Centrale;
import java.util.Random;

public class Capteur implements Objet{
    private long id ;
    private int etats ;
    private int valeur ;
    private long freq ;
    private int valeurCritique ;
    private Centrale c ;
    
    public void timer() throws InterruptedException {
        int x = 1 ;
        while (x != 2) {
            Thread.sleep(this.freq); // Wait 10 seconds
            selfCheck();
        }
    }
    

    public Capteur(long id,int etats, long freq) throws InterruptedException {
        this.id = id ;
        this.etats = etats;
        
        this.freq = freq ;
        this.valeurCritique = 30;
        timer();
        Random r = new Random();
        int low = 10;
        int high = 100;
        int randomNumber = r.nextInt(high-low) + low;
        this.valeur = randomNumber;
    }
    public long getId() {
        return this.id;
    }
    public int getEtat() {
        return this.etats;
    }
    public int getValeur() {
        return this.valeur;
    }
    public Centrale getCentrale() {
        return this.c ;
    }

    public void SetCentrale(Centrale c) {
        this.c = c ;
    }

    public void selfCheck() {
        if (this.etats == 1) { //fonctionne
            update();
        }
        else if (this.etats == 3) { //disfonctionnel
            valeurCritiqueDetecte();
        }
        else if (this.etats == 2) { // en mode off
            update();
        }
        
    }
    public void valeurCritiqueDetecte() {
        if (this.valeur >= valeurCritique) {
            this.etats = 3 ;
        }
    }

    @Override
    public void update() {
        Random r = new Random();
        int low = 10;
        int high = 100;
        int randomNumber = r.nextInt(high-low) + low;
        this.valeur = randomNumber ;
    }

    @Override
    public void notifyCentrale() {
        
    }
}
