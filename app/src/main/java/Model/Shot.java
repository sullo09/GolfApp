package Model;

/**
 * Created by sullo on 17/05/2018.
 */

public class Shot {

    public String titleShot;
    public String timestamp;
    public int shotid;

    public Shot() {}

    public Shot(String titleShot, String timestamp, int shotid) {
        this.titleShot = titleShot;
        this.timestamp = timestamp;
        this.shotid = shotid;
    }

    public String getTitleShot() {
        return titleShot;
    }

    public void setTitleShot(String titleShot) {
        this.titleShot = titleShot;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getShotid() {
        return shotid;
    }

    public void setShotid(int shotid) {
        this.shotid = shotid;
    }
}
