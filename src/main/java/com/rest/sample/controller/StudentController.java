package com.rest.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.sample.model.Student;
import com.rest.sample.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;

	@RequestMapping(path="/Students", produces="application/xml")	
	public List<Student> getStudents()
	{
         return repo.findAll();
	}
	
	@RequestMapping(path="/Student/{id}", produces="application/json")
	public Optional<Student> getStudent(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
	
	@DeleteMapping(path="/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
		repo.deleteById(id);
		return "Deleted Successfully....!";
	}
	
	@PostMapping(path="/createStudent")
	public Student createStudent(@RequestBody Student student)
	{
		return repo.save(student);
	}
	
	@PutMapping(path="/updateStudent")
	public Student saveOrUpdateStudent(@RequestBody Student student)
	{
	   return repo.save(student);
	}
	

}
