package com.dac.dao;

import com.dac.bean.Student;

public interface StudentDao {

	boolean save(Student stu);

	Student getStudent(int rollNo);

	void closeEntityManager();

	boolean deleteStudent(int rollNo);

	boolean updateStudent(Student studentUpdate);

}
