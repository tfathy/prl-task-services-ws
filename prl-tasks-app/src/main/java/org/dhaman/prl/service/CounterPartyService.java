package org.dhaman.prl.service;

import java.util.List;

import org.dhaman.prl.entity.CounterParty;

public interface CounterPartyService {
	
	public List<CounterParty> findAll();

	public List<CounterParty> findByTaskType(Integer taskTypeId);

	public CounterParty findById(Integer id);

	public CounterParty create(CounterParty entity);

	public CounterParty update(CounterParty entity, Integer id);

	public String delete(Integer id);

}
