package codingcity.entity;

import javax.persistence.*;

@Entity
@Table(name = "users_progresses")
public class UserProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String progress;

    @OneToOne
    private Task task;

    public UserProgress(Long id, String progress, Task task) {
        this.id = id;
        this.progress = progress;
        this.task = task;
    }

    public UserProgress(Long id, String progress) {
        this.id = id;
        this.progress = progress;
    }

    public UserProgress(String progress, Task task) {
        this.progress = progress;
        this.task = task;
    }

    public UserProgress(String progress) {
        this.progress = progress;
    }

    public UserProgress() {
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
