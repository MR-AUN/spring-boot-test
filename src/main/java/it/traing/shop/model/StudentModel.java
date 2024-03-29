package it.traing.shop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class StudentModel {
	@Id
	private String stdId;
	private String name;
	private String surname;
	private int age;
	
	public StudentModel() {
		
	}
	
	public StudentModel(String stdId, String name, String surname, int age) {
		super();
		this.stdId = stdId;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "StudentModel [stdId=" + stdId + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
	
	
}
