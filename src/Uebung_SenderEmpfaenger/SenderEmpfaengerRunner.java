package Uebung_SenderEmpfaenger;

public class SenderEmpfaengerRunner {
    public static void main(String[] args) {
        System.out.println("Dieses Programm braucht zwingend einen Internetzugang, da ich zu Fau ...\n... es technisch nicht möglich ist, Werbeslogans ohne Internet zu generieren.\n\n");

        Empfaenger archiv = new NachrichtenArchiv();
        Empfaenger klaus = new Person("Klaus");
        Empfaenger gustav = new Person("Gustav");
        Empfaenger pavel = new Person("Pavel");

        Sender zeitung = new Zeitung("WochenZeitung");
        Sender radio = new Radiosender("HipFM");
//        Sender tv = new Fernsehsender("Das Nullte");

        Sender aggregator = new Aggregator("NachrichtenAggregator");

        zeitung.anmelden((Empfaenger) aggregator);
        radio.anmelden((Empfaenger) aggregator);
//        tv.anmelden((Empfaenger) aggregator);

        aggregator.anmelden(archiv);
        aggregator.anmelden(klaus);
        aggregator.anmelden(pavel);
        aggregator.anmelden(gustav);

//        tv.sende("American Sniper. Sonntag - 20:15 Uhr");
        zeitung.sende("Glatteiswelle in Deutschland");
//        tv.sende("Fernsehen der Zukunft - jetzt mit Werbung zwischen der Werbung");
        radio.sende("Die Hits von gestern, vorgestern und vorvorgestern");
//        tv.sende("Es folgt Sendeschluss. Vorher Werbung.");

        System.out.println("---------------------");
//        System.out.println(archiv);


        SenderGui sender = new SenderGui(radio);
        GuiEmpfaenger empfaenger = new GuiEmpfaenger();
        sender.doAnmelden(empfaenger);

    }
}
