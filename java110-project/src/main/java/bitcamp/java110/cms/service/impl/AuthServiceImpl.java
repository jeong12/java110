package bitcamp.java110.cms.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired ManagerDao managerDao;
    @Autowired TeacherDao teacherDao;
    @Autowired StudentDao studentDao;

    @Override
    public Member getMember(
            String email, String password, String memberType) {
        
        HashMap<String, Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        
        if (memberType.equals("manager")) {
            return managerDao.findByEmailPassword(params);
            
        } else if (memberType.equals("student")) {
            return studentDao.findByEmailPassword(params);
            
        } else if (memberType.equals("teacher")) {
            return teacherDao.findByEmailPassword(params);
            // session.getMapper() : 실행하는 시점에서 인터페이스를 구현한 Proxy 객체(패턴)이 생김. 이것을 리턴함.
            // 여기서 규칙! 인터페이스와 같은 xml과 메서드 이름과 파라미터 타입이 일치한 메서드를 찾음. 
        } else {
            return null;
        }
    }
    }










