package UML_Projet_Centrale;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Capteur implements Objet{
    private long id ;
    private int etats ;
    private int valeur ;
    private long freq ;
    private int valeurCritique ;
    private Centrale c ;
    

    public Capteur(long id,int etats, long freq) throws InterruptedException {
        this.id = id ;
        this.etats = etats;
        
        this.freq = freq ;
        this.valeurCritique = 90;
        runCapteur(this);
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

    public void runCapteur(Capteur c){
        
        Runnable runnable = new Runnable() {
            public void run() {
                Random r = new Random();
                int low = 10;
                int high = 100;
                int randomNumber = r.nextInt(high-low) + low;
                c.valeur = randomNumber;
                notifyCentrale();
            }
        };
        
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }

    @Override
    public void update() {
               
    }

    @Override
    public void notifyCentrale() {
        this.c.update();
    }
}
