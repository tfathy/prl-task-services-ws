package org.dhaman.prl.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.dhaman.prl.entity.CounterParty;
import org.dhaman.prl.repos.CounterPartyRepos;
import org.dhaman.prl.service.CounterPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterPartyServiceImpl implements CounterPartyService{
	
	@Autowired
	private CounterPartyRepos repos;

	@Override
	public List<CounterParty> findAll() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public List<CounterParty> findByTaskType(Integer taskTypeId) {		
		return repos.findByTstId(taskTypeId);
	}

	@Override
	public CounterParty findById(Integer id) {
		Optional<CounterParty> result = repos.findById(id);
		CounterParty entity = null;
		if(result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public CounterParty create(CounterParty entity) {
		// TODO Auto-generated method stub
		return repos.save(entity);
	}

	@Override
	public CounterParty update(CounterParty entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		CounterParty entity = findById(id);
		String output = "Record deleted";
		if(entity == null) {
			return "No records to be deleted";
		}
		repos.deleteById(id);
		return output;
	}

}
