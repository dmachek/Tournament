import java.util.ArrayList;
public class Tournament implements Matchmaking {
    private final int teamsCount;
    private final int eventsCount;
    private ArrayList<Team> teams;
    private ArrayList<String> events;

    public Tournament(int teamsCount, int eventsCount) {
        this.teamsCount = teamsCount;
        this.eventsCount = eventsCount;
        this.teams = createTeams();
        this.events = createEvents();
    }

    public int getTeamsCount() {
        return teamsCount;
    }

    public int getEventsCount() {
        return eventsCount;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<String> getEvents() {
        return events;
    }
    public void listTeams(){
        this.teams.forEach(t -> System.out.println(t.getName()));
    }

    public ArrayList<Team> createTeams(){
        ArrayList<Team> teams = new ArrayList<Team>();
        for (int i = 0; i < this.teamsCount; i++){
            Team team = new Team("Team"+(i+1), createEvents(), (teamsCount/2), (teamsCount/2));
            teams.add(team);
        }
        return teams;
    }

    public ArrayList<String> createEvents(){
        ArrayList<String> events = new ArrayList<String>();
        for (int i = 0; i < eventsCount; i++){
            events.add("Event"+(i+1));
        }
        return events;
    }

    private boolean playedEachOther(Team home, Team away){
        if(home.getPlayedAgainst().contains(away.getName()) || away.getPlayedAgainst().contains(home.getName())){
            return true;
        }
        return false;
    }

    @Override
    public boolean match(Team home, Team away){
        // Check jestli nehraje proti sam sobě
        if(home.getName() == away.getName()){
            // System.out.println("Tým nemůže hrát sám se sebou");
            return false;
        }
        // check jestli se již nepotkaly
        if(playedEachOther(home, away)){
            // System.out.println("Tým " + home.getName() + " již hrál proti týmu " + away.getName());
            return false;
        }

        for (int i = 0; i < home.getEvents().size(); i++){
            // check jestli oba týmy mohou hrát stejnou disciplínu
            if(away.getEvents().contains(home.getEvents().get(i))){
                String eventPlayed = home.getEvents().get(i);
                // Check jestli můžou hrát ráno
                if((home.getMorningSlots() > 0 && away.getMorningSlots() > 0)){
                    System.out.println(home.getName() + " vs " + away.getName() + " disciplína: " + home.getEvents().get(i) + " ráno");
                    home.setPlayedAgainst(away.getName());
                    away.setPlayedAgainst(home.getName());
                    home.getEvents().remove(eventPlayed);
                    away.getEvents().remove(eventPlayed);
                    home.setMorningSlots(home.getMorningSlots() - 1);
                    away.setMorningSlots(away.getMorningSlots() - 1);
                    return true;
                }
                // pokud nemůžou hrát ráno check jestli můžou hrát odpoledne
                else if((home.getNoonSlots() > 0 && away.getNoonSlots() > 0)){
                    System.out.println(home.getName() + " vs " + away.getName() + " disciplína: " + home.getEvents().get(i) + " odpoledne");
                    home.setPlayedAgainst(away.getName());
                    away.setPlayedAgainst(home.getName());
                    home.getEvents().remove(eventPlayed);
                    away.getEvents().remove(eventPlayed);
                    home.setNoonSlots(home.getNoonSlots() - 1);
                    away.setNoonSlots(away.getNoonSlots() - 1);
                    return true;
                } else {
                    // System.out.println("Nebyl nalezen společný časový slot");
                    return false;
                }

            }
        }
        // System.out.println("Tyto týmy nemají možnost hrát disciplínu, který ani jeden nehrál");
        return false;
    }

    @Override
    public void generateTournament() {
       for(int i = 0; i < this.teamsCount; i++){
           for(int j = 0; j < this.teamsCount; j++){
               match(this.teams.get(i), this.teams.get(j));
           }
       }
       for (int i = this.teamsCount; i > 0; i--){
           int num = i - 1;
           for (int j = this.teamsCount; j > 0; j--){
               match(this.teams.get(num), this.teams.get(j-1));
           }
       }
    }
    public ArrayList<String> displayEventsLeft(Team team){
        return team.getEvents();
    }

    public void displayAllLeft(){
        for(int i = 0; i < this.teamsCount; i++){
            Team currentTeam = teams.get(i);
            System.out.println("Tým " + currentTeam.getName() + " již hrál proti: " + currentTeam.getPlayedAgainst());
            System.out.println("Týmu " + currentTeam.getName() + " zbývají disciplíny: " + currentTeam.getEvents() + "\n ");
        }
    }
}



