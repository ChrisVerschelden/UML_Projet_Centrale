package UML_Projet_Centrale;
import java.util.Random;

public class Capteur implements Objet{
    private long id ;
    private int etats ;
    private int valeur ;
    private long freq ;
    private int valeurCritique ;
    private Centrale c ;

    public Capteur(long id,int etats,int valeur, long freq) {
        this.id = id ;
        this.etats = etats;
        this.valeur = valeur;
        this.freq = freq ;
        this.valeurCritique = 30;       
    }

    public void selfCheck() {
        if (this.etats == 1) {
            System.out.println("Le Capteur marche");
            update(c);
        }
        else if (this.etats == 3) {
            System.out.print("Le Capteur est a une valeur critique");
            valeurCritiqueDetecte();
        }
        else if (this.etats == 2) {
            System.out.println("Le capteur ne fonctionne pas");
            update(c);
        }
        
    }
    public void valeurCritiqueDetecte() {
        if (this.valeur >= valeurCritique) {
            this.etats = 3 ;
        }
    }

    @Override
    public void update(Centrale c) {
        Random r = new Random();
        int low = 10;
        int high = 100;
        int randomNumber = r.nextInt(high-low) + low;
        this.valeur = randomNumber ;
    }

    @Override
    public void notifyCentrale(Object o) {
        System.out.println(this.etats);
    }
}
