package bitcamp.java110.cms.control;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class StudentController {
    
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
    
    @RequestMapping("student/delete")
    public void delete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        int no=Integer.parseInt(request.getParameter("no"));
        
        if (studentDao.delete(no) > 0) {
            out.println("삭제하였습니다.");
        } else {
            out.println("번호에 해당하는 학생이 없습니다.");
        }
    }
    
    @RequestMapping("student/detail")
    public void detail(Request request, Response response) {
        PrintWriter out = response.getWriter();
        int no=Integer.parseInt(request.getParameter("no"));
        Student student = studentDao.findByNo(no);
        
        if (student == null) {
            System.out.println("해당 번호의 학생 정보가 없습니다!");
            return;
        }
        
        out.printf("이메일: %s\n", student.getEmail());
        out.printf("이름: %s\n", student.getName());
        out.printf("암호: %s\n", student.getPassword());
        out.printf("최종학력: %s\n", student.getSchool());
        out.printf("전화: %s\n", student.getTel());
        out.printf("재직여부: %b\n", student.isWorking());
    }
    
    @RequestMapping("student/list")
    public void list(Request request, Response response) {
        PrintWriter out = response.getWriter();
        List<Student> list = studentDao.findAll();
        
        for (Student s : list) {
           out.printf("%d,%s, %s, %s, %b\n",
                    s.getNo(),
                    s.getEmail(), 
                    s.getName(), 
                    s.getSchool(),
                    s.isWorking());
        }
    }
  
}
