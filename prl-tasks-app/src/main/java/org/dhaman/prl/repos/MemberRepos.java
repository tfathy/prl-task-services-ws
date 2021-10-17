package org.dhaman.prl.repos;

import org.dhaman.prl.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepos extends JpaRepository<Member, Integer> {

}
