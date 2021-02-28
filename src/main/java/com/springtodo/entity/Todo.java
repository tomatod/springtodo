package com.springtodo.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="todos")
public class Todo {
	@EmbeddedId
	private TodoKey todoKey;

	@Column(name = "completed")
	private boolean completed;

	@Column(name = "todo")
	private String todo;
}
