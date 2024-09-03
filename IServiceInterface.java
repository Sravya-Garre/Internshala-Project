package com.nt.service;

import java.util.List;

import com.nt.model.Student;

public interface IServiceInterface {
	public String registerStudent(Student student);
	public List<Student> fetchAllStudents();
	public String updateStudentDetails(Student student);
	public String removeStudentById(int id);

}
