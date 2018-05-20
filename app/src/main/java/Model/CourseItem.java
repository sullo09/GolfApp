package Model;

/**
 * Created by sullo on 15/05/2018.
 */

public class CourseItem {

    private String courseName;
    private String description;

    private String ID;

    public CourseItem(String courseName, String description, String ID) {
        this.courseName = courseName;
        this.description = description;
        this.ID = ID;
    }
    public CourseItem() {
        this.courseName = "";
        this.description = "";
        this.ID = "";
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}

