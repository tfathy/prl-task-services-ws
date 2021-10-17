package org.dhaman.prl.repos;

import org.dhaman.prl.entity.TaskAssignee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAssigneeRepos extends JpaRepository<TaskAssignee, Integer> {

}
