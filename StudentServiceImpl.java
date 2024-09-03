package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Student;
import com.nt.repository.IStudentRepository;
@Service
public class StudentServiceImpl implements IServiceInterface {
	@Autowired
	private IStudentRepository studentRepo;

	@Override
	public String registerStudent(Student student) {
		int idval=studentRepo.save(student).getStid();
		return "Student is registered having the id value::"+idval;
	}

	@Override
	public List<Student> fetchAllStudents() {
	   List<Student> list=studentRepo.findAll();
	   list.sort((t1,t2)->t1.getStid().compareTo(t2.getStid()));
		return list;
	}

	@Override
	public String updateStudentDetails(Student student)  {
		Optional<Student> optional=studentRepo.findById(student.getStid());
		if(optional.isPresent()) {
			studentRepo.save(student);
			return student.getStid()+" Student is Updated";
		}
		else {
			return (student.getStid()+" Student Not Found");
		}
	}

	@Override
	public String removeStudentById(int id) {
		// TODO Auto-generated method stub
		Optional<Student> opt=studentRepo.findById(id);
		if(opt.isPresent()) {
			studentRepo.deleteById(id);
			return id+" These Stid Student is found and deleted";
		}
		else {
			return id+"Student is not found for deletion";
		}
			
	}

}
