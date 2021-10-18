package org.dhaman.prl.security.repos;

import org.dhaman.prl.security.entity.SmmUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmmUsersRepos extends JpaRepository<SmmUsers, Integer> {
	
	public SmmUsers findByLoginName(String loginName);
	public SmmUsers findByUserId(String userId);	
}
