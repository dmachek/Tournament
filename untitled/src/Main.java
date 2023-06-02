public class Main {
    public static void main(String[] args) {

        //Vytvoření turnaje, jediné parametry jsou počet týmů a počet disciplín
        Tournament tournament = new Tournament(12,12);

        //Vytvoří rozpis zápasůna základě požadavků
        tournament.generateTournament();

        // Zobrazí zbývající disciplíny všech týmů a proti komu již mají zápas
        tournament.displayAllLeft();

    }
}
