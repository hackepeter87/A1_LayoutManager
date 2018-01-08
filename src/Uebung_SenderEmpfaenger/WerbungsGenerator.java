package Uebung_SenderEmpfaenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Random;

import static java.lang.Thread.sleep;

public class WerbungsGenerator {
    String[] nomen = {"Aerger", "Aerztin", "Abend", "Abfahrt", "Abflug", "Absender", "Adresse", "Alkohol", "Alter", "Ampel", "Anfang", "Angebot", "Angestellte", "Angst", "Ankunft", "Anmeldung", "Anrede", "Anruf", "Anrufbeantworter", "Ansage", "Anschluss", "Antwort", "Anzeige", "Anzug", "Apfel", "Apotheke", "Appartement", "Appetit", "April", "Arbeit", "Arbeitsplatz", "Arm", "Arzt", "Aufenthalt", "Aufgabe", "Aufzug", "Auge", "August", "Ausbildung", "Ausflug", "Ausgang", "Auskunft", "Auslaender", "Auslaenderin", "Ausland", "Aussage", "Ausstellung", "Ausweis", "Auto", "Autobahn", "Automat", "Baeckerei", "Buero", "Baby", "Bad", "Bahn", "Bahnhof", "Bahnsteig", "Balkon", "Banane", "Bank", "Batterie", "Baum", "Beamte", "Beamtin", "Bein", "Beispiel", "Bekannte", "Benzin", "Beratung", "Berg", "Beruf", "Berufsschule", "Besuch", "Betrag", "Bett", "Bewerbung", "Bier", "Bild", "Bildschirm", "Birne", "Bitte", "Blatt", "Bleistift", "Blick", "Blume", "Bluse", "Blut", "Bogen", "Bohne", "Broetchen", "Bruecke", "Brief", "Briefkasten", "Briefmarke", "Brieftasche", "Briefumschlag", "Brille", "Brot", "Bruder", "Buch", "Buchstabe", "Bus", "Butter", "Café", "CD", "CD-ROM", "Chef", "Computer", "Creme", "Dach", "Dame", "Dank", "Datum", "Dauer", "Deutsche", "Dezember", "Dienstag", "Ding", "Disco", "Doktor", "Dom", "Donnerstag", "Doppelzimmer", "Dorf", "Drucker", "Durchsage", "Durst", "Dusche", "E-Mail", "Ecke", "Ehefrau", "Ehemann", "Ei", "Einfuehrung", "Eingang", "Einladung", "Eintritt", "Einwohner", "Einzelzimmer", "Eis", "Eltern", "Empfaenger", "Empfang", "Ende", "Enkel", "Entschuldigung", "Erdgeschoss", "Erfahrung", "Ergebnis", "Erlaubnis", "Ermaeßigung", "Erwachsene", "Essen", "Export", "Faehre", "Fuehrerschein", "Fuehrung", "Fabrik", "Fahrer", "Fahrkarte", "Fahrplan", "Fahrrad", "Familie", "Familienname", "Familienstand", "Farbe", "Fax", "Februar", "Fehler", "Fenster", "Ferien", "Fernsehgeraet", "Fest", "Feuer", "Feuerwehr", "Feuerzeug", "Fieber", "Film", "Firma", "Fisch", "Flasche", "Fleisch", "Flughafen", "Flugzeug", "Flur", "Fluss", "Formular", "Foto", "Fotoapparat", "Fruehjahr", "Fruehling", "Fruehstueck", "Frage", "Frau", "Freitag", "Freizeit", "Freund", "Freundin", "Friseur", "Frist", "Fuß", "Fußball", "Fundbuero", "Gabel", "Garage", "Garten", "Gas", "Gast", "Gebuehr", "Geburtsjahr", "Geburtsort", "Geburtstag", "Gegenteil", "Geld", "Geldboerse", "Gemuese", "Gepaeck", "Gericht", "Gesamtschule", "Geschaeft", "Geschenk", "Geschirr", "Geschwister", "Gesicht", "Gespraech", "Gesundheit", "Getraenk", "Gewicht", "Gewitter", "Glueck", "Glueckwunsch", "Glas", "Gleis", "Goethe-Institut", "Groeße", "Grenze", "Grippe", "Großeltern", "Großmutter", "Großvater", "Gruß", "Grundschule", "Gruppe", "Guthaben", "Gymnasium", "Haehnchen", "Haar", "Halbpension", "Halle", "Hals", "Haltestelle", "Hand", "Handtuch", "Handy", "Haus", "Hausaufgabe", "Hausfrau", "Haushalt", "Hausmann", "Heimat", "Heizung", "Hemd", "Herbst", "Herd", "Herr", "Herz", "Hilfe", "Hobby", "Holz", "Hose", "Hund", "Hunger", "Idee", "Import", "Industrie", "Information", "Inhalt", "Internet", "Jacke", "Jahr", "Januar", "Job", "Jugendherberge", "Jugendliche", "Juli", "Junge", "Juni", "Kaese", "Koerper", "Kueche", "Kuehlschrank", "Kuendigung", "Kaffee", "Kalender", "Kamera", "Kanne", "Karte", "Kartoffel", "Kasse", "Kassette", "Kassettenrecorder", "Katze", "Keller", "Kellner", "Kenntnisse", "Kennzeichen", "Kette", "Kfz", "Kind", "Kindergarten", "Kinderwagen", "Kino", "Kiosk", "Kirche", "Klasse", "Kleid", "Kleidung", "Kneipe", "Koffer", "Kollege", "Kollegin", "Konsulat", "Kontakt", "Konto", "Kontrolle", "Konzert", "Kopf", "Kosmetik", "Krankenkasse", "Krankheit", "Kredit", "Kreditkarte", "Kreis", "Kreuzung", "Kuchen", "Kugelschreiber", "Kunde", "Kundin", "Kurs", "Loeffel", "Loesung", "Laden", "Lager", "Lampe", "Land", "Landschaft", "Leben", "Lebensmittel", "Leid", "Lehre", "Lehrer", "Lehrerin", "Leute", "Licht", "Lied", "Lkw", "Loch", "Lohn", "Lokal", "Luft", "Lust", "Maedchen", "Maerz", "Moebel", "Muell", "Muelltonne", "Magen", "Mai", "Mal", "Mann", "Mantel", "Markt", "Maschine", "Material", "Mechaniker", "Medikament", "Meer", "Mehrwertsteuer", "Meinung", "Menge", "Mensch", "Messer", "Metall", "Miete", "Milch", "Minute", "Mittag", "Mitte", "Mitteilung", "Mittel", "Mittelschule", "Mittwoch", "Mode", "Moment", "Monat", "Montag", "Morgen", "Motor", "Mund", "Museum", "Musik", "Mutter", "Naehe", "Nachbar", "Nachbarin", "Nachmittag", "Nachrichten", "Nacht", "Name", "Natur", "Nebel", "Norden", "Notarzt", "Note", "Notfall", "Notiz", "November", "Nudel", "Nummer", "Ober", "Obst", "Oktober", "Oma", "Opa", "Operation", "Orange", "Ordnung", "Ort", "Osten", "Oel", "Paeckchen", "Paket", "Panne", "Papier", "Papiere", "Parfuem", "Park", "Partei", "Partner", "Partnerin", "Party", "Pass", "Pause", "Penis", "Pension", "Pkw", "Plan", "Plastik", "Platz", "Polizei", "Pommes frites", "Portion", "Post", "Postleitzahl", "Pruefung", "Praktikum", "Praxis", "Preis", "Problem", "Produkt", "Programm", "Prospekt", "Pullover", "Qualitaet", "Quittung", "Ruecken", "Rabatt", "Radio", "Rathaus", "Raucher", "Raucherin", "Raum", "Realschule", "Rechnung", "Regen", "Reifen", "Reinigung", "Reis", "Reise", "Reisebuero", "Reisefuehrer", "Reparatur", "Restaurant", "Rezept", "Rezeption", "Rind", "Rock", "Rose", "Rundgang", "Sueden", "S-Bahn", "Sache", "Saft", "Salat", "Salz", "Samstag/Sonnabend", "Satz", "Schueler", "Schuelerin", "Schalter", "Scheckkarte", "Schiff", "Schild", "Schinken", "Schirm", "Schluessel", "Schloss", "Schluss", "Schmerzen", "Schnee", "Schnupfen", "Schokolade", "Schrank", "Schuh", "Schule", "Schwein", "Schwester", "Schwimmbad", "See", "Sehenswuerdigkeit", "Seife", "Sekretaerin", "Sekunde", "Sendung", "Senioren", "September", "Service", "Sessel", "Sofa", "Sohn", "Sommer", "Sonderangebot", "Sonne", "Sonntag", "Sorge", "Spuelmaschine", "Spaß", "Spaziergang", "Speisekarte", "Spielplatz", "Sprache", "Sprachschule", "Sprechstunde", "Stueck", "Stadt", "Standesamt", "Stempel", "Steuer", "Stock", "Stoff", "Straße", "Straßenbahn", "Strand", "Streichholz", "Strom", "Student", "Studentin", "Studium", "Stuhl", "Stunde", "Supermarkt", "Suppe", "Tuer", "Tuete", "Tag", "Tankstelle", "Tasche", "Tasse", "Taxi", "Tee", "Teil", "Telefon", "Telefonbuch", "Teller", "Teppich", "Termin", "Test", "Text", "Theater", "Thema", "Ticket", "Tier", "Tipp", "Tisch", "Tochter", "Toilette", "Tomate", "Topf", "Tourist", "Treppe", "Trinkgeld", "Turm", "U-Bahn", "Uhr", "Unfall", "Universitaet", "Unterhaltung", "Unterkunft", "Unterricht", "Unterschied", "Unterschrift", "Untersuchung", "Urlaub", "Uebernachtung", "Vater", "Verbindung", "Verein", "Verkaeufer", "Verkaeuferin", "Verkehr", "Vermieter", "Versicherung", "Verspaetung", "Vertrag", "Video", "Vogel", "Volksschule", "Vormittag", "Vorname", "Vorsicht", "Vorwahl", "Waesche", "Wagen", "Wald", "Wasser", "Weg", "Wein", "Welt", "Werkstatt", "Werkzeug", "Westen", "Wetter", "Wiederhoeren", "Wiedersehen", "Wind", "Winter", "Wirtschaft", "Woche", "Wochenende", "Wochentag", "Wohnung", "Wolke", "Wort", "Wunsch", "Wurst", "Zahl", "Zahn", "Zeit", "Zeitschrift", "Zeitung", "Zentrum", "Zettel", "Zeugnis", "Zigarette", "Zimmer", "Zitrone", "Zoll", "Zucker", "Zug"};
    String[] werbesprueche = new String[50];

    public WerbungsGenerator() {
        this.generateSlogans();
    }

    private String getSlogan() {
        String slogan = nomen[(new Random()).nextInt(nomen.length)];

        String urlParameters = "slogan=" + slogan;
        String request = "http://www.sloganizer.net/outbound.php?" + urlParameters;
        URL url = null;

        try {
            url = new URL(request);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy", 8080)));
            conn.setRequestMethod("GET");
        } catch (IOException e) {
            e.printStackTrace();
        }
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setUseCaches(false);

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputLine = "";
        try {
            sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String ret = "";
        try {
            while ((inputLine = in.readLine()) != null) {
                ret += inputLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ret = ret.split(">")[1].split("<")[0];
        return ret;
    }

    private void generateSlogans() {
        for (int i = 0; i < this.werbesprueche.length; i++) {
            String spruch = this.getSlogan();
            spruch = spruch.replace("&auml;", "ä").replace("&uuml;", "ü").replace("&ouml;", "ö").replace("&amp;szlig;", "ß");
            this.werbesprueche[i] = spruch;
        }
    }

    public String getWerbung() {
        return this.werbesprueche[(new Random()).nextInt(this.werbesprueche.length)];
    }
}
