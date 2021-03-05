package com.springtodo.service;

import com.springtodo.entity.User;
import com.springtodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(userid)) throw new UsernameNotFoundException("");

		List<User> users = userRepository.findByUserid(userid);
		if (users.size() == 0) throw new UsernameNotFoundException("");

		User user = users.get(0);
		if (!user.isAccountNonExpired() || !user.isAccountNonLocked() ||
			!user.isCredentialsNonExpired() || !user.isEnabled())
			throw new UsernameNotFoundException("");
		return user;
	}
}
