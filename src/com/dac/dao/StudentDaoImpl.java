package com.dac.dao;



import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.dac.bean.Student;
import com.dac.util.JPAUtil;

public class StudentDaoImpl implements StudentDao {
	 
	Logger logger;
	
	public StudentDaoImpl() {

		logger = Logger.getLogger(StudentDaoImpl.class);
	}

	@Override
	public boolean save(Student stu) {
		// TODO Auto-generated method stub
		boolean saved = false;
		try{
		EntityManager em = JPAUtil.getEntityManager();
		//em.getTransaction().begin();
		JPAUtil.beginTransaction();
		em.persist(stu);
		//em.getTransaction().commit();
		JPAUtil.commitTransaction();
		saved = true;
		}catch(Exception e){
			logger.error(e.getMessage());
			
		}
		
		return saved;
	}

	@Override
	public Student getStudent(int rollNo) {
		// TODO Auto-generated method stub
		Student student = null;
		
		try{
		EntityManager em = JPAUtil.getEntityManager();
		student =em.find(Student.class, rollNo);
		
		 }catch(Exception e){
			 // logger
		 }
		return student;
	}

	@Override
	public void closeEntityManager() {
		// TODO Auto-generated method stub
		JPAUtil.closeEntityManager();
	}

	@Override
	public boolean deleteStudent(int rollNo) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Student student = null;
		try{
			
			EntityManager em = JPAUtil.getEntityManager();
			student =em.find(Student.class, rollNo);
			JPAUtil.beginTransaction();
			em.remove(student);
			JPAUtil.commitTransaction();
			deleted = true;
			System.out.println(deleted);
			 }catch(Exception e){
				 // logger
			 }
		System.out.println(deleted);
		return deleted;
	}

	@Override
	public boolean updateStudent(Student studentUpdate) {
		// TODO Auto-generated method stub
		boolean updated = false;
		try{
		EntityManager em = JPAUtil.getEntityManager();
		
		Student temp = em.find(Student.class, studentUpdate.getRollNo());
		if(temp == null){
			System.out.println("Student with roll no "+studentUpdate.getRollNo()+" not found");
		}else{
			JPAUtil.beginTransaction();
			em.merge(studentUpdate);
			JPAUtil.commitTransaction();
			updated = true;
		}
		
		}catch(Exception e){
			
		}
		return updated;
	}

}
