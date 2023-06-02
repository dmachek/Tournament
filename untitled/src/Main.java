public class Main {
    public static void main(String[] args) {

        //Vytvoření turnaje, jediné parametry jsou počet týmů a počet disciplín
        //Turnaj se po inicializaci pokusí o rozřazení
        Tournament tournament = new Tournament(12,12);

        // Zobrazí zbývající disciplíny všech týmů a proti komu již mají zápas
        // tournament.displayAllLeft();

        //Log zápasů
        // System.out.println(tournament.getLog());

    }
}
