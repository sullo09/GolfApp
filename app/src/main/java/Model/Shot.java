package Model;

/**
 * Created by sullo on 17/05/2018.
 */

public class Shot {

    public String titleShot;
    public String description;
    public int shotid;

    public Shot() {}

    public Shot(String titleShot, String description) {
        this.titleShot = titleShot;
        this.description = description;
    }

    public String getTitleShot() {
        return titleShot;
    }

    public void setTitleShot(String titleShot) {
        this.titleShot = titleShot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShotid() {
        return shotid;
    }

    public void setShotid(int shotid) {
        this.shotid = shotid;
    }
}
