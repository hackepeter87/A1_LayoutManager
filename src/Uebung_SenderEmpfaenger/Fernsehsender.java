package Uebung_SenderEmpfaenger;

public class Fernsehsender implements Sender {
    private Empfaenger[] empfaengers;
    private final String name;
    private final WerbungsGenerator wg;

    public Fernsehsender(String name) {
        this.name = name;
        this.wg = new WerbungsGenerator();
    }

    @Override
    public void anmelden(Empfaenger empfaenger) {
        if (this.empfaengers == null) {
            this.empfaengers = new Empfaenger[1];
        }
        for (int i = 0; i < empfaengers.length; i++) {
            if (empfaengers[i] == null) {
                empfaengers[i] = empfaenger;
                return;
            }
        }
        Empfaenger[] temp = new Empfaenger[this.empfaengers.length + 1];
        for (int j = 0; j < this.empfaengers.length; j++) {
            temp[j] = this.empfaengers[j];
        }
        this.empfaengers = temp;
        this.anmelden(empfaenger);
    }

    @Override
    public void sende(String nachricht) {
        for (Empfaenger e : empfaengers) {
            e.empfange(String.format("Fernsehsender <%s> sendet: {%s}{%s}{%s}", this.name, wg.getWerbung() , nachricht, wg.getWerbung()));
        }
    }
}
