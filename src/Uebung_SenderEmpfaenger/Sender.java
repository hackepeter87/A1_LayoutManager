package Uebung_SenderEmpfaenger;

public interface Sender {
    void anmelden(Empfaenger empfaenger);
    void sende(String nachricht);
}
