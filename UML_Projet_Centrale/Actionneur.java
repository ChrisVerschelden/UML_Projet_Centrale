package UML_Projet_Centrale;
import java.util.Random;

public class Actionneur implements Objet{

    private long id ;
    private int etats ;
    private int valeur ;

    public Actionneur(long id,int etats,int valeur) {
        this.id = id ;
        this.etats = etats;
        this.valeur = valeur;
    }

    public void faire() {
        System.out.print("L'actionneur fais ce qu'il doit faire");
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
