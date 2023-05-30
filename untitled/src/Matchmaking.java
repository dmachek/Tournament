public interface Matchmaking {
    boolean match(Team home, Team away);
    void generateTournament();
}
