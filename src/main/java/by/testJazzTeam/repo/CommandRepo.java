package by.testJazzTeam.repo;

import by.testJazzTeam.entity.Commands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepo extends JpaRepository<Commands,Long> {
}
