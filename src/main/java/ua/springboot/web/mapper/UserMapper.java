package ua.springboot.web.mapper;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.springboot.web.domain.EditUserRequest;
import ua.springboot.web.domain.RegisterRequest;
import ua.springboot.web.domain.VisitorProfileRequest;
import ua.springboot.web.entity.Visitor;
import ua.springboot.web.entity.enumeration.Role;

public interface UserMapper {

	public static User toSecurityUser(Visitor entity) {
		return new User(
			     entity.getEmail(),
			     entity.getPassword(),
			     AuthorityUtils
			             .createAuthorityList(String.valueOf(entity.getRole())));
		}
	
	
	public static Visitor registerToUser(RegisterRequest request) {
		Visitor visitor = new Visitor();
		visitor.setEmail(request.getEmail());
		visitor.setPassword(request.getPassword());
		visitor.setLogin(request.getLogin());
		visitor.setRole(Role.ROLE_USER);
		return visitor;
	}
	
	public static VisitorProfileRequest entityToProfile(Visitor entity) {
		VisitorProfileRequest request = new VisitorProfileRequest();
		request.setId(entity.getId());
		
		request.setLogin(entity.getLogin());
		request.setEmail(entity.getEmail());
		request.setAge(entity.getAge());
		request.setFirstName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setGender(entity.getGender());
		request.setMobile(entity.getMobile());
		
		return request;
	}
	
	public static EditUserRequest entityToEditUser(Visitor entity) {
		EditUserRequest request = new EditUserRequest();
		request.setId(entity.getId());
		request.setLogin(entity.getLogin());
		request.setEmail(entity.getEmail());
		request.setAge(entity.getAge());
		request.setFirstName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setMobile(entity.getMobile());
		request.setGender(entity.getGender());
		
		request.setPassword(entity.getPassword());
		
		return request;
	}
	
	public static Visitor editRequestToEntity(EditUserRequest request) {
		Visitor entity = new Visitor();
		entity.setId(request.getId());
		entity.setLogin(request.getLogin());
		entity.setEmail(request.getEmail());
		entity.setAge(request.getAge());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setVisitorImage(request.getFile().getOriginalFilename());
		entity.setMobile(request.getMobile());
		entity.setGender(request.getGender());
		entity.setRole(Role.ROLE_USER);
		
		entity.setPassword(request.getPassword()); 
		
		return entity;
	}
	
}
