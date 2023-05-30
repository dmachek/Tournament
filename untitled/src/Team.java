import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<String> events;
    private int morningSlots;
    private int noonSlots;
    private ArrayList<String> playedAgainst;

    public Team(String name, ArrayList<String> events, int morningSlots, int noonSlots) {
        this.name = name;
        this.events = events;
        this.morningSlots = morningSlots;
        this.noonSlots = noonSlots;
        this.playedAgainst = new ArrayList<String>();
    }

    public Team() {
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getEvents() {
        return events;
    }

    public int getMorningSlots() {
        return morningSlots;
    }

    public int getNoonSlots() {
        return noonSlots;
    }

    public void setMorningSlots(int morningSlots) {
        this.morningSlots = morningSlots;
    }

    public void setNoonSlots(int noonSlots) {
        this.noonSlots = noonSlots;
    }

    public ArrayList<String> getPlayedAgainst() {
        return playedAgainst;
    }

    public void setPlayedAgainst(String team){
        this.playedAgainst.add(team);
    }

}
