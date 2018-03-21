package ua.springboot.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.Visitor;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.repository.VisitorRepository;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired private VisitorRepository visitorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Visitor entity = visitorRepository.findVisitorForAuthentication(email);
		if(entity == null) throw new UsernameNotFoundException("User not found");
		
		
		return UserMapper.toSecurityUser(entity);
	}

}
