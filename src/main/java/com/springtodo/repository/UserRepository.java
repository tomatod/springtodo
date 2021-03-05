package com.springtodo.repository;

import com.springtodo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
	public List<User> findByUserid(String userid);
}
