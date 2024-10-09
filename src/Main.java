public class Main {
    public static void main(String[] args) {
        try {


            // Crea frazioni
            Frazione f1 = new Frazione(5, 7);
            //f1 = new Frazione(-5, 7); //test per frazione negativa
            //f1 = new Frazione(5, 0); //test per denominatore zero
            Frazione f2 = new Frazione(135, 945);


            // Stampa frazioni
            System.out.println("Frazione 1:");
            f1.stampa();
            System.out.println("Frazione 2:");
            f2.stampa();


            // Semplifica
            f2 = f2.semplifica();
            System.out.println("Frazione 2 semplificata:");
            f2.stampa();


            // Stampa calcoli
            System.out.println("Valore reale di Frazione 1: " + f1.calcola());
            System.out.println("Valore reale di Frazione 2: " + f2.calcola());


            // Operazioni
            Frazione f3 = f1.add(f2);
            System.out.println("Frazione 1 + Frazione 2:");
            f3.stampa();

            Frazione f4 = f1.mul(f2);
            System.out.println("Frazione 1 * Frazione 2:");
            f4.stampa();

            Frazione f5 = f1.sub(f2);
            System.out.println("Frazione 1 - Frazione 2:");
            f5.stampa();

            Frazione f6 = f1.div(f2);
            System.out.println("Frazione 1 / Frazione 2:");
            f6.stampa();


            //  Confronta frazioni
            System.out.println("Frazione 1 è uguale a Frazione 2? " + f1.equals(f2));
            System.out.println("Frazione 1 è maggiore di Frazione 2? " + f1.isGreat(f2));
            System.out.println("Frazione 1 è minore di Frazione 2? " + f1.isLess(f2));


        } catch (InvalidArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}