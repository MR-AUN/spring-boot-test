package it.traing.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.traing.shop.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, String>{
	public List<StudentModel> findByAge(int age);
	public List<StudentModel> findByageBetween(int age1, int age2);
}
