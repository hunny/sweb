package hh.learnweb.controller;

import hh.learnweb.model.User;
import hh.learnweb.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("userController")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private IUserService userService;
	
	//showUser.do?id=1
	@RequestMapping(value="showUser", method=RequestMethod.GET)
	public String showUser(Long id, Model model) {
		logger.debug("showUser");
		User user = userService.findUserById(id);
		logger.debug("user:" + user);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	//1/showUserForJson.do
	@RequestMapping(value="{id}/showUserForJson", method=RequestMethod.GET)
	@ResponseBody
	public User showUserForJson(@PathVariable("id") Long id) {
		logger.debug("showUserForJson");
		User user = userService.findUserById(id);
		logger.debug("user:" + user);
		return user;
	}
	
	//showUserRestful/1.do
	@RequestMapping(value="showUserRestful/{id}", method=RequestMethod.GET)
	public String showUserRestful(@PathVariable("id") Long id, Model model) {
		logger.debug("showUser");
		User user = userService.findUserById(id);
		logger.debug("user:" + user);
		model.addAttribute("user", user);
		return "showUser";
	}
	
    // same as above method, just showing different URL mapping
	//showUserFromParam.do?id=1
    @RequestMapping(value="showUserFromParam", params="id")
    @ResponseBody
    public User getByIdFromParam(@RequestParam Long id) {
        return userService.findUserById(id);
    }
	
//	@RequestMapping("person/random")
//    @ResponseBody
//    public Person randomPerson() {
//        return personService.getRandom();
//    }
// 
//    @RequestMapping("person/{id}")
//    @ResponseBody
//    public Person getById(@PathVariable Long id) {
//        return personService.getById(id);
//    }
//     
//    // handles person form submit
//    @RequestMapping(value="person", method=RequestMethod.POST)
//    @ResponseBody
//    public String savePerson(Person person) {
//        personService.save(person);
//        return "Saved person: " + person.toString();
//    }

}
