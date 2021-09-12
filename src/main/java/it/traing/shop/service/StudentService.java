package it.traing.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.traing.shop.model.StudentModel;
import it.traing.shop.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public List<StudentModel> getAllStudent() {
		
		return studentRepository.findAll();
	}
	
	public void addStudent(StudentModel student) {
		studentRepository.save(student);
	}
	
	public List<StudentModel> getStudentByAge(int age) {
		return studentRepository.findByAge(age);
	}
	
	public List<StudentModel> getStudentByAgeBetween(int age1,int age2){
		return studentRepository.findByageBetween(age1, age2);
	}
}
