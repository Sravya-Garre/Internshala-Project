package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Student;
import com.nt.service.IServiceInterface;

@RestController
@RequestMapping("/student")
public class StudentOperationsController {
	@Autowired
	private IServiceInterface service;

	@PostMapping("/register")
	public ResponseEntity<String> enrollStudent(@RequestBody Student student){
		try {
			//use service
			String resultmsg=service.registerStudent(student);
			return new ResponseEntity<String>(resultmsg,HttpStatus.CREATED);//201 content Created Successfully
		}
		catch(Exception e) {
			return new ResponseEntity<String>("problem in student registration",
					HttpStatus.INTERNAL_SERVER_ERROR);//500 ERROR
		}
	}
	@GetMapping("/findall")
	public ResponseEntity<?> displayStudents(){
		try {
			List<Student> list=service.fetchAllStudents();
			return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Students",
					                                      HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/modify")
	public ResponseEntity<String> modifyStudent(@RequestBody Student student){
		try {
			String msg=service.updateStudentDetails(student);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
	    try {
	        String msg = service.removeStudentById(id);
	        return new ResponseEntity<>(msg, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
