package Model;

/**
 * Created by sullo on 17/05/2018.
 */

public class Shot {

    public String shot;
    public String timestamp;

    public String shotid;

    public Shot() {}

    public Shot(String shot, String timestamp, String shotid) {
        this.shot = shot;
        this.timestamp = timestamp;
        this.shotid = shotid;
    }

    public String getshot() {
        return shot;
    }

    public void setshot(String shot) {
        this.shot = shot;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getShotid() {
        return shotid;
    }

    public void setShotid(String shotid) {
        this.shotid = shotid;
    }

}
