class Konto {
    private String numerKonta;
    private double saldo;

    public Konto(String numerKonta, double saldo) {
        this.numerKonta = numerKonta;
        this.saldo = saldo;
    }

    public void depozyt(double kwota) {
        saldo += kwota;
    }

    public void wyplata(double kwota) {
        if (kwota <= saldo) {
            saldo -= kwota;
        } else {
            System.out.println("Brak wystarczających środków na koncie.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

class Oszczednosci extends Konto {
    private double oprocentowanie;

    public Oszczednosci(String numerKonta, double saldo, double oprocentowanie) {
        super(numerKonta, saldo);
        this.oprocentowanie = oprocentowanie;
    }

    public void naliczOdsetki() {
        double odsetki = getSaldo() * (oprocentowanie / 100);
        depozyt(odsetki);
    }
}

public class Main {
    public static void main(String[] args) {
        Konto konto = new Konto("1324355768", 5000.0);
        Oszczednosci oszczednosci = new Oszczednosci("0987654321", 1000.0, 7.0);

        konto.depozyt(500.0);
        konto.wyplata(700.0);

        oszczednosci.depozyt(3000.0);
        oszczednosci.naliczOdsetki();

        System.out.println("Saldo konta: " + konto.getSaldo());
        System.out.println("Saldo konta oszczędnościowego: " + oszczednosci.getSaldo());
    }
}
