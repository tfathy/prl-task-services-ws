package org.dhaman.prl.repos;

import java.util.List;

import org.dhaman.prl.entity.CounterParty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterPartyRepos extends JpaRepository<CounterParty, Integer> {
 public List<CounterParty> findByTstId(Integer tstId);
}
