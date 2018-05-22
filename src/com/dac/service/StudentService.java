package com.dac.service;

import com.dac.bean.Student;

public interface StudentService {

	boolean save(Student stu);

	Student getStudent(int rollNo);

	void closeEntityManager();

	boolean deleteStudent(int rollNo);

	boolean updateStudent(Student studentUpdate);

}
