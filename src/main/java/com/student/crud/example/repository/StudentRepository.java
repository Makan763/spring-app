package com.student.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.crud.example.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByName(String name);
	

}
