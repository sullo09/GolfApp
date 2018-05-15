package Model;

/**
 * Created by sullo on 15/05/2018.
 */

public class ListItem {

    private String courseName;
    private String description;

    public ListItem(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

