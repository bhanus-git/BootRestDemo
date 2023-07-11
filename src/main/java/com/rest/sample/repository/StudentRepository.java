package com.rest.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.rest.sample.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
