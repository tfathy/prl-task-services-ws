package org.dhaman.prl.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.dhaman.prl.entity.TaskType;
import org.dhaman.prl.repos.TaskTypeRepos;
import org.dhaman.prl.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeServiceImpl implements TaskTypeService {

	@Autowired
	private TaskTypeRepos repos;

	@Override
	public List<TaskType> findAll() {
		return repos.findAll();
	}

	@Override
	public TaskType findById(Integer id) {
		Optional<TaskType> result = repos.findById(id);
		TaskType entity = null;
		if (result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public TaskType create(TaskType entity) {
		return repos.save(entity);
	}

	@Override
	public TaskType update(TaskType entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		String output = "record has been deleted";
		TaskType entity = findById(id);
		if (entity == null) {
			return "record not found";
		}
		repos.deleteById(id);
		return output;
	}

}
