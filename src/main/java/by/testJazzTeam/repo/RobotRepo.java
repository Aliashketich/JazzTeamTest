package by.testJazzTeam.repo;

import by.testJazzTeam.entity.Robots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepo extends JpaRepository<Robots, Long> {
}
