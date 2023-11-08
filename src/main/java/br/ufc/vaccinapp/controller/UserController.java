package br.ufc.vaccinapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.vaccinapp.model.User;
import br.ufc.vaccinapp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
    UserService userService;
 
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<User> getUserByCpf(@RequestParam("cpf") String cpf) {
        return new ResponseEntity<User>(userService.getUserByCpf(cpf), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.addUser(new User(user.getCpf(), user.getPassword())),
                HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        return new ResponseEntity<User>(userService.updateUser(id, user.getCpf(), user.getPassword()), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        if(userService.removeUser(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);         
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);          
    }
	
}
