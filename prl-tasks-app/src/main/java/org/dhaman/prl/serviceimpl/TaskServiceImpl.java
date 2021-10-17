package org.dhaman.prl.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.dhaman.prl.entity.Task;
import org.dhaman.prl.repos.TaskRepos;
import org.dhaman.prl.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepos repos;

	@Override
	public List<Task> findAll() {
		return repos.findAll();
	}

	@Override
	public Task findById(Integer id) {		
		Optional<Task> result = repos.findById(id);
		Task entity = null;
		if(result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public Task create(Task entity) {
	
		return repos.save(entity);
	}

	@Override
	public Task update(Task entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		String output = "record has been deleted";
		Task entity = findById(id);
		if(entity == null) {
			return "record is not found";
		}
		repos.deleteById(id);
		return output;
	}

}
