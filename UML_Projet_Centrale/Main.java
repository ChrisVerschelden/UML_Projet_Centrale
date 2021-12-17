package UML_Projet_Centrale;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Centrale c = new Centrale();
        c.subscribe(new Capteur(1, 1, 1000));
        c.subscribe(new Capteur(2, 1, 1000));
        c.subscribe(new Capteur(3, 2, 1000));
        c.subscribe(new Capteur(4, 3, 1000));

        double[] d = {12.2,3.3,5.0,6.0};
        String[] s = {"1", "2", "3", "4"};
        c.addTerminal(new Terminal(d, s, "bonjour"));
    }
}
