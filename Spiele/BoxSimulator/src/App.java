import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

public class App {
    static Boolean Spielläuft = true;
    static Random random = new Random();
    static Kämpfer[] KämpferArray = new Kämpfer[3];
    static Scanner scanner = new Scanner(System.in);
    public class Spieler{
        static String Name;
        static int HP = random.nextInt(3) + 2;
        static int Angriffsstärke = random.nextInt(3) + 1;
        static int Schnelligkeit = random.nextInt(3) + 1;
        static int Ausdauer = random.nextInt(3) + 1;
    }
    public static class Kämpfer{
        String Name;
        int HP;
        int Angriffsstärke;
        int Schnelligkeit;
        int Ausdauer;
    }
    public static void main(String[] args) throws Exception {
        SpielStarten(scanner);
            for(int e = 0; e < 3; e++){
            KämpferArray[e] = new Kämpfer();
            KämpferArray[e].Name = randomNameGenerator();
            KämpferArray[e].HP = random.nextInt(3) + 2;
            KämpferArray[e].Angriffsstärke = random.nextInt(3) + 1;
            KämpferArray[e].Schnelligkeit = random.nextInt(3) + 1;
            KämpferArray[e].Schnelligkeit = random.nextInt(3) + 1;
            KämpferArray[e].Ausdauer = random.nextInt(3) + 1;
        }
        Menü(scanner);
    }
    public static void SpielStarten(Scanner scanner){
        System.out.println("Willkommen zum Box Simulator wo du dich vom Niemand zum Starboxer hocharbeiten kannst! Wie ist dein Name?");
        Spieler.Name = scanner.nextLine();
    }

    public static void Stats(Scanner scanner){
        System.out.println("------Stats------");
        System.out.println("Name: " + Spieler.Name);
        System.out.println("HP: " + Spieler.HP);
        System.out.println("Ausdauer: " + Spieler.Ausdauer);
        System.out.println("Angriffsstärke: " + Spieler.Angriffsstärke);
        System.out.println("Schnelligkeit: " + Spieler.Schnelligkeit);
        System.out.println("Um zurückzukehren gib 'zurueck' ein");
        String Eingabe = scanner.nextLine();
        System.out.println(Eingabe);
        if(Eingabe.equals("zurueck")){
            Menü(scanner);
        }

    }

    public static void Menü(Scanner scanner){
        System.out.println("Mit folgenden Befehlen kannst du mit der Spielwelt interagieren:");
        System.out.println("Stats - damit kannst du dir die Stats deines Charakters ansehen");
        System.out.println("Arena - damit kannst du in die Arene gehen und an einem Kampf teilnehmen");
        String Eingabe = scanner.nextLine();
        switch(Eingabe){
            case "Stats": Stats(scanner);
                break;
            case "Arena": Arena(scanner);
                break;
        }
    }
    public static void Arena(Scanner scanner){
        System.out.println("Das sind deine Gegner um einen auszuwählen gib eine Zahl von 1-3 ein:");
        for(int k = 0; k < 3; k++){
            System.out.println("-------------------------------------");
            System.out.println(KämpferArray[1].Name);
            System.out.println("Name: " + KämpferArray[k].Name);
            System.out.println("HP: " + KämpferArray[k].HP);
            System.out.println("Ausdauer: " + KämpferArray[k].Ausdauer);
            System.out.println("Angriffsstärke: " + KämpferArray[k].Angriffsstärke);
            System.out.println("Schnelligkeit: " + KämpferArray[k].Schnelligkeit);
            System.out.println("Ausdauer: " + KämpferArray[k].Name);
        }
        String Eingabe = scanner.nextLine();
            switch(Eingabe){
                case "1": Kampf(1); break;
                case "2": Kampf(2); break;
                case "3": Kampf(2); break;
            }
    }

    public static String randomNameGenerator(){
        int Zahl = random.nextInt(6) + 1;
        String Name;
            switch(Zahl){
                case 1: Name = "Theo";
                    break;
                case 2: Name = "Timo";
                    break;
                case 3: Name = "Andre";
                    break;
                case 4: Name = "Dimitry";
                    break;
                case 5: Name = "Mattheo";
                    break;
                case 6: Name = "Uwe";
                    break;
                default: Name = "Tim";
            }
        return Name;
    }
    public static void Kampf(int Kämpfernummer){
        while(Spielläuft){
            System.out.println("Was willst du tun?");
            System.out.println("treten");
            System.out.println("schlagen");
            String Eingabe = scanner.nextLine();
            int Glück = random.nextInt(2) + 1;
            switch(Eingabe){
                case "treten":  if(Glück == 1){
                                System.out.println("Du hast " + KämpferArray[Kämpfernummer].Name + "getreten!");
                                KämpferArray[Kämpfernummer].HP =+ Spieler.Angriffsstärke;}
                                else{
                                System.out.println("Du hast versucht " + KämpferArray[Kämpfernummer].Name + "zu treten, aber er konnte ausweichen!");
                                }
                            break;
                case "schlagen": if(Glück == 1){
                                System.out.println("Du hast " + KämpferArray[Kämpfernummer].Name + "geschlagen!");
                                KämpferArray[Kämpfernummer].HP =+ Spieler.Angriffsstärke;}
                                else{
                                    System.out.println("Du hast versucht " + KämpferArray[Kämpfernummer].Name + "zu schlagen, aber er konnte ausweichen!");
                                }
                            break;
            }
            int Reaktion = random.nextInt(2) + 1;
            switch (Reaktion) {
                case 1: System.out.println(KämpferArray[Kämpfernummer].Name + ": Autsch!");
                    break;
                case 2: System.out.println(KämpferArray[Kämpfernummer].Name + ": Spuckt auf Boden");
                    break;
                default: System.out.println(KämpferArray[Kämpfernummer].Name + " beleidigt dich");
                    break;
            }
            int GegnerAngriff = random.nextInt(2);
            Glück = random.nextInt(2) +1;
            switch(GegnerAngriff){
                case 1: if(Glück == 1){
                        System.out.println(KämpferArray[Kämpfernummer].Name + " tritt dich");
                        Spieler.HP =- KämpferArray[Kämpfernummer].Angriffsstärke;
                        }
                        else{
                            System.out.println(KämpferArray[Kämpfernummer].Name + " hat versucht dich zu treten, aber du konntest ausweichen!");
                        }
                        break;
                case 2: System.out.println(KämpferArray[Kämpfernummer].Name + " schlägt dich");
                        Spieler.HP =- KämpferArray[Kämpfernummer].Angriffsstärke;
                        break;
                }
            if(Spieler.HP <= 0 || KämpferArray[Kämpfernummer].HP <= 0){
                Spielläuft = false;
                }
        }
        if(Spieler.HP <=0){
            System.out.println("Du hast verloren!");
        }
        else{
            System.out.println("Du hast gewonnen!");
        }
    }
}