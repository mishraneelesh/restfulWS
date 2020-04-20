package com.neelesh.restws.restWebServices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UseRresourceController {

	@Autowired
	private UserDaoImpl dao;
	
	@GetMapping("/users")
	public List<UserBean> finfAll(){
		return dao.findAll();
	}
	
	@GetMapping("/users/{id}")
	public UserBean finfAll(@PathVariable int id){
		UserBean user=dao.findone(id);
		if(user == null) {
			throw new UserNotFoundException("User not found, id- "+ id);
		}
		return user;
	}
	
	@GetMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id){
		UserBean user=dao.userDeleteById(id);
		if(user == null) {
			throw new UserNotFoundException("User not found, id- "+ id);
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> save(@Valid @RequestBody UserBean user){
		UserBean user1 = dao.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
