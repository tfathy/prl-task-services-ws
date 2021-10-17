package org.dhaman.prl.controller;

import java.util.List;

import org.dhaman.prl.entity.CounterParty;
import org.dhaman.prl.entity.Member;
import org.dhaman.prl.entity.Task;
import org.dhaman.prl.entity.TaskAssignee;
import org.dhaman.prl.entity.TaskType;
import org.dhaman.prl.service.CounterPartyService;
import org.dhaman.prl.service.MemberService;
import org.dhaman.prl.service.TaskAssigneeService;
import org.dhaman.prl.service.TaskService;
import org.dhaman.prl.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class PrlTaskController {

	@Autowired
	private CounterPartyService counterPartyService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private TaskAssigneeService taskAssigneeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private TaskTypeService taskTypeService;

	/*****************************************************************************
	 * CounterParty
	 *****************************************************************************/
	@GetMapping(value = "/counter-party", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<CounterParty>> findAllCounterPary() {
		List<CounterParty> resultList = counterPartyService.findAll();
		if (resultList == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resultList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(resultList);

	}

	@GetMapping(value = "/counter-party/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CounterParty> findCounterParyById(@PathVariable Integer id) {
		CounterParty body = counterPartyService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@GetMapping(value = "/counter-party/task-type/{tstId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<CounterParty>> findCounterPartByTstId(@PathVariable Integer tstId) {
		List<CounterParty> body = counterPartyService.findByTaskType(tstId);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/counter-party", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CounterParty> saveCounterParty(@RequestBody CounterParty entity) {
		CounterParty body = null;
		try {
			body = counterPartyService.create(entity);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(body);

	}

	@PutMapping(value = "/counter-party/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CounterParty> updateCounterParty(@RequestBody CounterParty entity, @PathVariable Integer id) {
		CounterParty body = null;
		try {
			body = counterPartyService.update(entity, id);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(body);

	}

	@DeleteMapping(value = "/counter-party/{id}")
	public ResponseEntity<String> deleteCounterParty(@PathVariable Integer id) {
		String body = null;
		try {
			body = counterPartyService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	/*****************************************************************************
	 * Members
	 *****************************************************************************/
	@GetMapping(value = "/member", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Member>> findAllMember() {
		List<Member> resultList = memberService.findAll();
		if (resultList == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resultList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(resultList);

	}

	@GetMapping(value = "/member/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Member> findMemberById(@PathVariable Integer id) {
		Member body = memberService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/member", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Member> saveMember(@RequestBody Member entity) {
		Member body = null;
		try {
			body = memberService.create(entity);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(body);

	}

	@PutMapping(value = "/member/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Member> updateMember(@RequestBody Member entity, @PathVariable Integer id) {
		Member body = null;
		try {
			body = memberService.update(entity, id);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(body);

	}

	@DeleteMapping(value = "/TaskType/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable Integer id) {
		String body = null;
		try {
			body = memberService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	/*****************************************************************************
	 * Task Assignee
	 *****************************************************************************/
	@GetMapping(value = "/task-assignee", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<TaskAssignee>> findAllTaskAssignee() {
		List<TaskAssignee> resultList = taskAssigneeService.findAll();
		if (resultList == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resultList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(resultList);

	}

	@GetMapping(value = "/task-assignee/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TaskAssignee> findTaskAssigneeId(@PathVariable Integer id) {
		TaskAssignee body = taskAssigneeService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/task-assignee", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TaskAssignee> saveTaskAssignee(@RequestBody TaskAssignee entity) {
		TaskAssignee body = null;
		try {
			body = taskAssigneeService.create(entity);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(body);

	}

	@PutMapping(value = "/task-assignee/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TaskAssignee> updateTaskAssignee(@RequestBody TaskAssignee entity, @PathVariable Integer id) {
		TaskAssignee body = null;
		try {
			body = taskAssigneeService.update(entity, id);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(body);

	}

	@DeleteMapping(value = "/task-assignee/{id}")
	public ResponseEntity<String> deleteTaskAssignee(@PathVariable Integer id) {
		String body = null;
		try {
			body = taskAssigneeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	/*****************************************************************************
	 * Task
	 *****************************************************************************/
	@GetMapping(value = "/task", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Task>> findAllTask() {
		List<Task> resultList = taskService.findAll();
		if (resultList == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resultList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(resultList);

	}

	@GetMapping(value = "/task/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Task> findTaskById(@PathVariable Integer id) {
		Task body = taskService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/task", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Task> saveTaskType(@RequestBody Task entity) {
		Task body = null;
		try {
			body = taskService.create(entity);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(body);

	}

	@PutMapping(value = "/task/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Task> updateTaskType(@RequestBody Task entity, @PathVariable Integer id) {
		Task body = null;
		try {
			body = taskService.update(entity, id);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(body);

	}

	@DeleteMapping(value = "/task/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
		String body = null;
		try {
			body = taskService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	/*****************************************************************************
	 * Task Type
	 *****************************************************************************/

	@GetMapping(value = "/task-type", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<TaskType>> findAllTaskType() {
		List<TaskType> resultList = taskTypeService.findAll();
		if (resultList == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resultList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(resultList);

	}

	@GetMapping(value = "/task-type/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TaskType> findTaskTypeById(@PathVariable Integer id) {
		TaskType body = taskTypeService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/task-type", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TaskType> saveTaskType(@RequestBody TaskType entity) {
		TaskType body = null;
		try {
			body = taskTypeService.create(entity);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(body);

	}

	@PutMapping(value = "/task-type/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TaskType> updateTaskType(@RequestBody TaskType entity, @PathVariable Integer id) {
		TaskType body = null;
		try {
			body = taskTypeService.update(entity, id);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(body);

	}

	@DeleteMapping(value = "/task-type/{id}")
	public ResponseEntity<String> deleteTaskType(@PathVariable Integer id) {
		String body = null;
		try {
			body = taskTypeService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
}
