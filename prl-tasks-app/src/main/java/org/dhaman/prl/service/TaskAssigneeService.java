package org.dhaman.prl.service;

import java.util.List;

import org.dhaman.prl.entity.TaskAssignee;



public interface TaskAssigneeService {

	public List<TaskAssignee> findAll();

	public TaskAssignee findById(Integer id);

	public TaskAssignee create(TaskAssignee entity);

	public TaskAssignee update(TaskAssignee entity, Integer id);

	public String delete(Integer id);

}
