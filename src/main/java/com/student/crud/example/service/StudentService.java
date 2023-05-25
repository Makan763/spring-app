package com.student.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.crud.example.entity.Student;
import com.student.crud.example.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	
	private StudentRepository repository;
	
	public Student saveStudent(Student student) {
		return repository.save(student);
		
	}

	public List<Student> getStudents() {
		return repository.findAll();
		
	}
	public Student getStudentById(int id) {
		return repository.findById(id).orElse(null);
		
	}
	public Student getStudentByName(String name) {
		return repository.findByName(name);
		
	}
	public String deleteStudent(int id) {
		 repository.deleteById(id);
		 return "student removed !!"+id;
		
	}
	
	public Student updateStudent(Student student) {		
		Student existingStudent = repository.findById(student.getId()).orElse(null);
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		existingStudent.setPhone(student.getPhone());;
		existingStudent.setAddresse(student.getAddresse());	
		return repository.save(existingStudent);
	}
	 
	
	

}
