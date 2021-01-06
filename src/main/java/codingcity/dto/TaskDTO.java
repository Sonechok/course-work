package codingcity.dto;

public class TaskDTO {
    private Long id;

    private Integer numberOfDay;

    private String task;

    private String links;

    public TaskDTO(Integer numberOfDay, String task, String links) {
        this.numberOfDay = numberOfDay;
        this.task = task;
        this.links = links;
    }

    public TaskDTO(Long id, Integer numberOfDay, String task, String links) {
        this.id = id;
        this.numberOfDay = numberOfDay;
        this.task = task;
        this.links = links;
    }

    public TaskDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(Integer numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }
}
