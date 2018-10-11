package bitcamp.java110.cms.service.impl;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

public class AuthServiceImpl implements AuthService{

    ManagerDao managerDao;
    StudentDao studentDao;
    TeacherDao teacherDao;
   
    public ManagerDao getManagerDao() {
        return managerDao;
    }

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    public StudentDao getStudentDao() {
        return studentDao;
    }
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public Member getMember(String email, String password, String type) {
        Member member=null;
        if(type.equals("manager")) {
           member=managerDao.findByEmailPassword(email, password);  
        }else if(type.equals("student")) {
            member=studentDao.findByEmailPassword(email, password);  
        }else if(type.equals("teacher")) {
            member=teacherDao.findByEmailPassword(email, password);  }
        
        return member;

    }

    
}
