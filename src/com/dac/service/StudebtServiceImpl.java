package com.dac.service;

import com.dac.bean.Student;
import com.dac.dao.StudentDao;
import com.dac.dao.StudentDaoImpl;

public class StudebtServiceImpl implements StudentService {
	StudentDao sDao;
	
	
	public StudebtServiceImpl() {
		sDao = new StudentDaoImpl();
	}


	@Override
	public boolean save(Student stu) {
		// TODO Auto-generated method stub
		
		return sDao.save(stu);
	}


	@Override
	public Student getStudent(int rollNo) {
		// TODO Auto-generated method stub
		
		return sDao.getStudent(rollNo);
	}


	@Override
	public void closeEntityManager() {
		// TODO Auto-generated method stub
		sDao.closeEntityManager();
		
	}


	@Override
	public boolean deleteStudent(int rollNo) {
		// TODO Auto-generated method stub
		return sDao.deleteStudent(rollNo);
		
	}


	@Override
	public boolean updateStudent(Student studentUpdate) {
		// TODO Auto-generated method stub
		return sDao.updateStudent(studentUpdate);
	}

}
