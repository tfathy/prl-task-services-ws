package org.dhaman.prl.service;

import java.util.List;

import org.dhaman.prl.entity.Task;


public interface TaskService {
	
	public List<Task> findAll();

	public Task findById(Integer id);

	public Task create(Task entity);

	public Task update(Task entity, Integer id);

	public String delete(Integer id);

}
