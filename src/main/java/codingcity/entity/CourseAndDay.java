package codingcity.entity;

public class CourseAndDay {
    String name;

    Integer day;

    String status;

    public CourseAndDay(String name, Integer day, String status) {
        this.name = name;
        this.day = day;
        this.status = status;
    }

    public CourseAndDay() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
