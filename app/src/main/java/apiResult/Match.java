package apiResult;

import java.util.List;

public class Match {
    public String id;
    public Season season;
    public String utcDate;
    public String status;
    public String matchday;
    public String stage;
    public String group;
    public String lastUpdated;
    public Odds odds;
    public Score score;
    public Team homeTeam;
    public Team awayTeam;
    public List<Referee> referees;
}
