package apiResult;

public class Score {
    public String winner;
    public String duration;
    public Time fullTime;
    public Time halfTime;
    public Time extraTime;
    public Time penalties;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Time getFullTime() {
        return fullTime;
    }

    public void setFullTime(Time fullTime) {
        this.fullTime = fullTime;
    }

    public Time getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(Time halfTime) {
        this.halfTime = halfTime;
    }

    public Time getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(Time extraTime) {
        this.extraTime = extraTime;
    }

    public Time getPenalties() {
        return penalties;
    }

    public void setPenalties(Time penalties) {
        this.penalties = penalties;
    }
}
