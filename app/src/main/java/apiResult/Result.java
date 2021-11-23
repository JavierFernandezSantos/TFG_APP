package apiResult;

import java.util.List;

public class Result {
    public String count;
    public Filters filters;
    public Competition competition;
    public List<Match> matches;

    public String getCount() {
        return count;
    }

    public Filters getFilters() {
        return filters;
    }

    public Competition getCompetition() {
        return competition;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
