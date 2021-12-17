package UML_Projet_Centrale;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Centrale c = new Centrale();
        c.subscribe(new Capteur(1, 1, 1000));
        c.subscribe(new Capteur(2, 1, 1000));
        c.subscribe(new Capteur(3, 1, 1000));
        c.subscribe(new Capteur(4, 3, 1000));

        Terminal t = new Terminal();
        c.addTerminal(t);
        t.launchTerminal(c);
    }
}
