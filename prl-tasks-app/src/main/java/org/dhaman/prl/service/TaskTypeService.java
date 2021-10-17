package org.dhaman.prl.service;

import java.util.List;

import org.dhaman.prl.entity.TaskType;



public interface TaskTypeService {
	
	public List<TaskType> findAll();

	public TaskType findById(Integer id);

	public TaskType create(TaskType entity);

	public TaskType update(TaskType entity, Integer id);

	public String delete(Integer id);


}
