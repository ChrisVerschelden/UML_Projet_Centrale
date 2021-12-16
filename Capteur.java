public class Capteur extends Object{
    private long id ;
    private String etats ;
    private int valeur ;
    private long freq ;

    public Capteur(long id,String etats,int valeur, long freq) {
        this.id = id ;
        this.etats = etats;
        this.valeur = valeur;
        this.freq = freq ;
    }

    public void selfCheck() {
        
    }
    public void valeurCritiqueDetecte() {
        
    }
}
