package com.wired.api.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wired.api.model.User;
import com.wired.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found, Id: " 
		+ id + ", Type: " + User.class.getName(), user));
	}
	
	public void deleteById(Long id) throws Exception {
		if (!userRepository.existsById(id)) {
			throw new Exception("User not found!");
		}
		userRepository.deleteById(id);
	}
	
	public User update (Long id, User user) {
		User newUser = findById(id);
		newUser.setName(user.getName());
		newUser.setDob(user.getDob());
		newUser.setAddress(user.getAddress());
		newUser.setDescription(user.getDescription());
		newUser.setCreatedAt(user.getCreatedAt());
		return userRepository.save(newUser);
	}

}
