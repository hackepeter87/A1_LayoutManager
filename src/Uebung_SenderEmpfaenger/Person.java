package Uebung_SenderEmpfaenger;

public class Person implements Empfaenger {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void empfange(String nachricht) {
        System.out.println(this.name + ":" + nachricht);
    }
}
