package codingcity.entity;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number_of_day", nullable = false)
    private Integer numberOfDay;

    @Column(nullable = false)
    private String task;

    private String links;

    /*@OneToOne
    private UserProgress progress;*/

    public Task(Long id, Integer numberOfDay, String task, String links) {
        this.id = id;
        this.numberOfDay = numberOfDay;
        this.task = task;
        this.links = links;
        //this.progress = progress;
    }

    public Task(Integer numberOfDay, String task, String links) {
        this.numberOfDay = numberOfDay;
        this.task = task;
        this.links = links;
    }

    public Task() {
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

    /*public UserProgress getProgress() {
        return progress;
    }

    public void setProgress(UserProgress progress) {
        this.progress = progress;
    }*/
}
