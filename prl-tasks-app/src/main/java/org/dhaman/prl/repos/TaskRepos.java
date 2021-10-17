package org.dhaman.prl.repos;

import org.dhaman.prl.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepos extends JpaRepository<Task, Integer> {

}
