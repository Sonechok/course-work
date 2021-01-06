package codingcity.dto;


public class UserProgressDTO {
    private Long id;

    private String progress;

    public UserProgressDTO() {
    }

    public UserProgressDTO(Long id, String progress) {
        this.id = id;
        this.progress = progress;
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
