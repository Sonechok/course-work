package codingcity.repository;

import codingcity.entity.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {
}
