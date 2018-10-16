package bitcamp.java110.cms.service.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

public class AuthServiceImpl implements AuthService {

    SqlSessionFactory sqlSessionFactory;
     
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Member getMember(
            String email, String password, String memberType) {
        
        try(SqlSession session = sqlSessionFactory.openSession()){
        HashMap<String, Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        
        if (memberType.equals("manager")) {
            ManagerDao managerDao = session.getMapper(ManagerDao.class);
            return managerDao.findByEmailPassword(params);
            
        } else if (memberType.equals("student")) {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            return studentDao.findByEmailPassword(params);
            
        } else if (memberType.equals("teacher")) {
            TeacherDao teacherDao = session.getMapper(TeacherDao.class);
            return teacherDao.findByEmailPassword(params);
            // session.getMapper() : 실행하는 시점에서 인터페이스를 구현한 Proxy 객체(패턴)이 생김. 이것을 리턴함.
            // 여기서 규칙! 인터페이스와 같은 xml과 메서드 이름과 파라미터 타입이 일치한 메서드를 찾음. 
        } else {
            return null;
        }
    }
    }
}










