package br.ufc.vaccinapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.vaccinapp.model.User;
import br.ufc.vaccinapp.repository.UserRepository;


@Service
public class UserService {
	  
	@Autowired
	UserRepository userRepo;
	    
	    public User addUser(User users) {
	        return userRepo.save(users);
	    }
	    
	    public boolean removeUser(Integer id) {
	        if(userRepo.existsById(id)) {
	            userRepo.deleteById(id);
	            return true;
	        }
	        
	        return false;
	    }
	    
	    public List<User> getUsers() {
	        return userRepo.findAll();
	    }
	    
	    public User getUser(Integer id) {
	        return userRepo.findById(id).get();
	    }
	    
	    public User getUserByCpf(String cpf) {
	        return userRepo.findFirstByCpf(cpf);
	    }
	    
	    public User updateUser(Integer id, String cpf, String password) {
	        User userAux = userRepo.findById(id).get();
	        
	        if(userAux != null) {
	          userAux.setCpf(cpf);
	          userAux.setPassword(password);
	          userRepo.save(userAux);         
	        }
	        
	        return userAux;
	    }
}
