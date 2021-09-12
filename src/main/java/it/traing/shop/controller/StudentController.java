package it.traing.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.traing.shop.model.StudentModel;
import it.traing.shop.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentServcice;
	@GetMapping("/")
	public ResponseEntity<StudentModel>  home() {
		StudentModel model = new StudentModel();
		
		model.setName("Kiattisak");
		model.setSurname("Janjam");
		model.setStdId("63011211014");
		model.setAge(19);
		return ResponseEntity.ok(model);
	}
	
	@GetMapping("/2")
	public ResponseEntity<StudentModel[]> student2() {
			StudentModel[] modelArray = new StudentModel[3];
			modelArray[0] = new StudentModel();
			modelArray[0].setStdId("63011211014");
			modelArray[0].setName("test");
			modelArray[0].setSurname("lol");
			modelArray[0].setAge(12);
			
			modelArray[1] = new StudentModel();
			modelArray[1].setStdId("63011211014");
			modelArray[1].setName("testtest");
			modelArray[1].setSurname("haha");
			modelArray[1].setAge(16);
			
			modelArray[2] = new StudentModel();
			modelArray[2].setStdId("63011211014");
			modelArray[2].setName("kai");
			modelArray[2].setSurname("o");
			modelArray[2].setAge(15);
			return ResponseEntity.ok(modelArray);
	}
	
	@GetMapping("/3")
	public ResponseEntity<List<StudentModel>> student3() {
		List<StudentModel> modelList = new ArrayList<StudentModel>();
		StudentModel model = new StudentModel();
		
		model.setStdId("63011211014");
		model.setName("test");
		model.setSurname("lol");
		model.setAge(12);
		modelList.add(model);

		model = new StudentModel();
		model.setStdId("63011211014");
		model.setName("testtest");
		model.setSurname("haha");
		model.setAge(16);
		modelList.add(model);
		
		model = new StudentModel();
		model.setStdId("63011211014");
		model.setName("kai");
		model.setSurname("o");
		model.setAge(15);
		modelList.add(model);
		return ResponseEntity.ok(modelList);
	}
	
	@PostMapping("/4")
	public ResponseEntity<StudentModel> student4(@RequestBody StudentModel  std){
		
		StudentModel result = std;
		
		int newage = std.getAge() + 5;
		String newName = "Mr."+std.getName();
		
		result.setAge(newage);
		result.setName(newName);
		
		return ResponseEntity.ok(result);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<StudentModel>> student5() {
		List<StudentModel> result = studentServcice.getAllStudent();
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addStd(@RequestBody StudentModel student) {
		studentServcice.addStudent(student);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/getStudent/{age}")
	public ResponseEntity<List<StudentModel>> getByAge(@PathVariable int age) {
		List<StudentModel> result = studentServcice.getStudentByAge(age);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getStudentAge/{age1}/{age2}")
	public ResponseEntity<List<StudentModel>> getStudentListByAgebetween(@PathVariable int age1,@PathVariable int age2){
		List<StudentModel> result = studentServcice.getStudentByAgeBetween(age1, age2);
		return ResponseEntity.ok(result);
	}
}
