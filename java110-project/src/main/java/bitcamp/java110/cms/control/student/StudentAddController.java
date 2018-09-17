package bitcamp.java110.cms.control.student;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class StudentAddController {
    
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping("student/add")
    public void add(Request request, Response response) {
       PrintWriter out = response.getWriter();
       Student s=new Student();
       s.setName(request.getParameter("name"));
       s.setEmail(request.getParameter("email"));
       s.setPassword(request.getParameter("password"));
       s.setTel(request.getParameter("tel"));
       s.setSchool(request.getParameter("school"));
              
       boolean r=false;
       if(request.getParameter("work").contains("t")) {
           r=true;
       }else {
           r=false;
       }
       
       s.setWorking(r);
       studentDao.insert(s);
       out.println("등록하였습니다.");
        
        }
  
}
