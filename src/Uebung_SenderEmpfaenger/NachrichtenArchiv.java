package Uebung_SenderEmpfaenger;

/**
 * Die Klasse baut ein {@link NachrichtenArchiv} auf
 */
public class NachrichtenArchiv implements Empfaenger {
    StringBuilder sb;

    public NachrichtenArchiv() {
        this.sb = new StringBuilder();
        this.sb.append("Nachrichtenarchiv:\n");
    }

    @Override
    public void empfange(String nachricht) {
        sb.append(nachricht + '\n');
    }

    @Override
    public String toString() {
        return this.sb.toString();
    }
}
