package UML_Projet_Centrale;

public class Actionneur implements Objet{

    private long id ;
    private String Etats ;
    private int valeur ;

    public Actionneur(long id,String Etats,int valeur) {
        this.id = id ;
        this.Etats = Etats;
        this.valeur = valeur;
    }

    public void faire() {

    }

    
}
