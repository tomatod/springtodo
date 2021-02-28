package com.springtodo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class TodoKey implements Serializable {
	@Column(name = "userid")
	private String userId;

	@Column(name = "no")
	private Integer no;
}
