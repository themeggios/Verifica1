public class Frazione implements Operatore {
    private int numeratore;
    private int denominatore;

    // Costruttore di default
    public Frazione() {
        this.numeratore = 0;
        this.denominatore = 1;
    }

    // Costruttore con parametri
    public Frazione(int numeratore, int denominatore) throws DenZeroException {
        if (denominatore == 0) {
            throw new DenZeroException("Denominatore nullo");
        }
        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    // Metodo per stampare la frazione
    public void stampa() {
        System.out.println(numeratore + "/" + denominatore);
    }

    // Metodo per calcolare il valore reale della frazione
    public double calcola() {
        return (double) numeratore / denominatore;
    }

    // Metodo per convertire la frazione in stringa
    public String toString() {
        return numeratore + "/" + denominatore;
    }

    // Metodo per la somma di due frazioni
    public Frazione add(Frazione frz2) throws DenZeroException {
        int mcdDenominatore = mcd(denominatore, frz2.denominatore);
        int nuovoNumeratore = numeratore * (mcdDenominatore / denominatore) + frz2.numeratore * (mcdDenominatore / frz2.denominatore);
        return new Frazione(nuovoNumeratore, mcdDenominatore);
    }

    // Metodo per la differenza di due frazioni
    public Frazione sub(Frazione frz2) throws DenZeroException {
        int mcdDenominatore = mcd(denominatore, frz2.denominatore);
        int nuovoNumeratore = numeratore * (mcdDenominatore / denominatore) - frz2.numeratore * (mcdDenominatore / frz2.denominatore);
        return new Frazione(nuovoNumeratore, mcdDenominatore);
    }

    // Metodo per la moltiplicazione di due frazioni
    public Frazione mul(Frazione frz2) throws DenZeroException {
        int nuovoNumeratore = numeratore * frz2.numeratore;
        int nuovoDenominatore = denominatore * frz2.denominatore;
        return new Frazione(nuovoNumeratore, nuovoDenominatore);
    }

    // Metodo per la divisione di due frazioni
    public Frazione div(Frazione frz2) throws DenZeroException {
        return mul(frz2.inv());
    }

    // Metodo per invertire la frazione
    public Frazione inv() throws DenZeroException {
        return new Frazione(denominatore, numeratore);
    }

    // Metodo per semplificare la frazione
    public Frazione semplifica() throws DenZeroException {
        int MCD = MCD(numeratore, denominatore);
        return new Frazione(numeratore / MCD, denominatore / MCD);
    }

    // Metodo per calcolare il massimo comun divisore (MCD)
    private int MCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return MCD(b, a % b);
        }
    }

    // Metodo per calcolare il minimo comun denominatore (mcd)
    private int mcd(int a, int b) {
        int max = Math.max(a, b);
        while (true) {
            if (max % a == 0 && max % b == 0) {
                return max;
            }
            max++;
        }
    }

    // Confronto tra due frazioni
    public boolean equals(Frazione frz2) {
        return numeratore == frz2.numeratore && denominatore == frz2.denominatore;
    }

    public boolean isGreat(Frazione frz2) {
        return calcola() > frz2.calcola();
    }

    public boolean isLess(Frazione frz2) {
        return calcola() < frz2.calcola();
    }
}