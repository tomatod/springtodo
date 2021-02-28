package com.springtodo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import com.springtodo.entity.Todo;
import com.springtodo.entity.TodoKey;

public interface TodoRepository extends JpaRepository<Todo, TodoKey> {
	@Query(value = "SELECT * FROM todos WHERE userid = :userId ORDER BY completed ASC, no DESC", nativeQuery = true)
	public List<Todo> findByUserId(@Param("userId") String userId);

	@Query(value = "SELECT * FROM todos WHERE userid = :userId AND completed = 0 ORDER BY userid, no DESC", nativeQuery = true)
	public List<Todo> findByUserIdNotCompleted(@Param("userId") String userId);

	@Modifying
	@Query(value = "INSERT INTO todos (userid, no, completed, todo) SELECT :userId, (SELECT NVL(MAX(no), 0)+1 FROM todos WHERE userid = :userId), :completed, :todo", nativeQuery = true)
	public Integer insertByUserId(
		@Param("userId") String userId,
		@Param("completed") boolean completed,
		@Param("todo") String todo
	);
	
	@Modifying
	@Query(value = "UPDATE todos SET completed = :completed, todo = :todo WHERE userid = :userId AND no = :no", nativeQuery = true)
	public Integer updateByPk(
		@Param("completed") boolean completed,
		@Param("todo") String todo,
		@Param("userId") String userId,
		@Param("no") int no
	);
}
