package org.dhaman.prl.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.dhaman.prl.entity.TaskAssignee;
import org.dhaman.prl.repos.TaskAssigneeRepos;
import org.dhaman.prl.service.TaskAssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskAssigneeServiceImpl implements TaskAssigneeService {

	@Autowired
	private TaskAssigneeRepos repos;

	@Override
	public List<TaskAssignee> findAll() {
		return repos.findAll();
	}

	@Override
	public TaskAssignee findById(Integer id) {
		Optional<TaskAssignee> result = repos.findById(id);
		TaskAssignee entity = null;
		if (result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public TaskAssignee create(TaskAssignee entity) {
		return repos.save(entity);
	}

	@Override
	public TaskAssignee update(TaskAssignee entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		String output = "record has been deleted";
		TaskAssignee entity = findById(id);
		if (entity == null) {
			return "no records to be deleted";
		}
		repos.deleteById(id);
		return output;

	}

}
