package Uebung_SenderEmpfaenger;

public class Aggregator implements Sender, Empfaenger {
    private Empfaenger[] empfaengers;
    private final String name;

    public Aggregator(String name) {
        this.name = name;
    }

    @Override
    public void empfange(String nachricht) {
        this.sende(nachricht);
    }

    @Override
    public void anmelden(Empfaenger empfaenger) {
        if (this.empfaengers == null) {
            this.empfaengers = new Empfaenger[1];
        }

        for (int i = 0; i < this.empfaengers.length; i++) {
            if (this.empfaengers[i] == null) {
                this.empfaengers[i] = empfaenger;
                return;
            }
        }

        Empfaenger[] temp = new Empfaenger[this.empfaengers.length + 1];
        for (int i = 0; i < this.empfaengers.length; i++) {
            temp[i] = this.empfaengers[i];
        }
        temp[temp.length - 1] = empfaenger;
        this.empfaengers = temp;
    }

    @Override
    public void sende(String nachricht) {
        for (Empfaenger e : this.empfaengers) {
            e.empfange("Nachricht von " + this.name + ": " + nachricht);
        }
    }
}
