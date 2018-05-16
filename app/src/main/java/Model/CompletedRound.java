package Model;

/**
 * Created by sullo on 16/05/2018.
 */

/** class used to upload a score to database **/
public class CompletedRound {

    public String coursePlayed;
    public String playerName;
    public String playerScore;
    public String timestamp;
    public String userid;

    public CompletedRound() {
    }

    public CompletedRound(String coursePlayed, String playerName, String playerScore, String timestamp, String userid) {
        this.coursePlayed = coursePlayed;
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.timestamp = timestamp;
        this.userid = userid;
    }

    public String getCoursePlayed() {
        return coursePlayed;
    }

    public void setCoursePlayed(String coursePlayed) {
        this.coursePlayed = coursePlayed;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(String playerScore) {
        this.playerScore = playerScore;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
