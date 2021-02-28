package com.springtodo.controller.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.springtodo.entity.*;
import com.springtodo.repository.*;

@RequestMapping(path="/api/todos")
@RestController
public class TodoController {
	@Autowired
	private TodoRepository todoRepository;

	@RequestMapping(path="/{userId}", method = RequestMethod.GET)
	public @ResponseBody Iterable<Todo> getTodosOfUser(@PathVariable("userId") String userId) {
		return todoRepository.findByUserId(userId);
	}

	@RequestMapping(path="/{userId}/notCompleted", method = RequestMethod.GET)
	public @ResponseBody Iterable<Todo> getNotCompletedTodosOfUser(@PathVariable("userId") String userId) {
		return todoRepository.findByUserIdNotCompleted(userId);
	}

	@Transactional
	@RequestMapping(path="/{userId}", method = RequestMethod.POST)
	public @ResponseBody CommonResponse getTodosOfUser(@RequestBody List<Todo> todos) {
		int count = 0;
		for(Todo todo : todos) {
			Integer result = 0;
			if(todo.getTodoKey().getNo() == -1) {
				if(todo.getTodo().equals("")) continue;
				result = todoRepository.insertByUserId(todo.getTodoKey().getUserId(), todo.isCompleted(), todo.getTodo());
			} else {
				result = todoRepository.updateByPk(todo.isCompleted(), todo.getTodo(), todo.getTodoKey().getUserId(), todo.getTodoKey().getNo());
			}
			if(result != 1) throw new RuntimeException("TODOの更新または作成に失敗しました。");
			count++;
		}
		return new CommonResponse(String.format("%d件のデータを更新しました。", count));
	}

	@ExceptionHandler(Exception.class)
	public @ResponseBody ErrorResponse exception(Exception e) {
		return new ErrorResponse(1, e.getMessage());
	}
}
