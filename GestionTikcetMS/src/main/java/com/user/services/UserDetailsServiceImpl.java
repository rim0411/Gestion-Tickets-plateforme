package com.user.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.user.models.TicketM;
import com.user.models.userM;
import com.user.repositories.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	//@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		userM user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}
   public Long loadUserByid(String username  ) throws UsernameNotFoundException {
	Long id2 = userRepository.findByUsername(username).get().getId();
	return id2;
}
   public userM loadUser(String username  ) throws UsernameNotFoundException {
		userM user= userRepository.findByUsername(username).get();
		return user;
	}

	  public List findAll() {
	       return (List) userRepository.findAll();
}
	  public  Optional<userM> findById(Long id) {
	       return userRepository.findById(id);
	   }
	  
	
	    @Transactional
	   public userM save(userM user) {
	       return  userRepository.save(user);
	   }
	   public userM update(userM user) {
	       return  userRepository.saveAndFlush(user);
	   }

	   public void deleteById(Long id) {
		   userRepository.deleteById(id);
	   }

}
