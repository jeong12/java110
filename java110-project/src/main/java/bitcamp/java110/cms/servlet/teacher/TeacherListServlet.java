package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/list")
public class TeacherListServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
  
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        TeacherDao teacherDao = (TeacherDao)this.getServletContext()
                .getAttribute("teacherDao");
        
        response.setContentType("text/plain;Charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        List<Teacher> list = teacherDao.findAll();
        
        for (Teacher t : list) {
            out.printf("%d, %s, %s, %d, [%s]\n",
                    t.getNo(),
                    t.getName(), 
                    t.getEmail(), 
                    t.getPay(),
                    t.getSubjects());
        }
    }
}
