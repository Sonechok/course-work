package codingcity.entity;

public class Statistic {
    private long countOfUsers;
    private long countOfCourses;
    private long countOfAppliedUsers;

    public Statistic() {
    }

    public Statistic(Integer countOfUsers, Integer countOfCourses, Integer countOfAppliedUsers) {
        this.countOfUsers = countOfUsers;
        this.countOfCourses = countOfCourses;
        this.countOfAppliedUsers = countOfAppliedUsers;
    }

    public long getCountOfUsers() {
        return countOfUsers;
    }

    public void setCountOfUsers(long countOfUsers) {
        this.countOfUsers = countOfUsers;
    }

    public long getCountOfCourses() {
        return countOfCourses;
    }

    public void setCountOfCourses(long countOfCourses) {
        this.countOfCourses = countOfCourses;
    }

    public long getCountOfAppliedUsers() {
        return countOfAppliedUsers;
    }

    public void setCountOfAppliedUsers(long countOfAppliedUsers) {
        this.countOfAppliedUsers = countOfAppliedUsers;
    }
}
