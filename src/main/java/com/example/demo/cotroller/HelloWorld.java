package com.example.demo.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;

@RestController
@RequestMapping("/test")
public class HelloWorld {
    @Autowired
    private PersonDAO personDAO;
    
	@RequestMapping("hello")
    public String hello() {
		List<Person> list = personDAO.findAll();
		Person p = list.get(0);
		return list.size() + p.getName() + p.getSex();
    }
}
