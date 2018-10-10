package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@MultipartConfig(maxFileSize=2_000_000)
@WebServlet("/teacher/add")
public class TeacherAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("/teacher/form.jsp");
        rd.include(request, response);
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherDao teacherDao = (TeacherDao)this.getServletContext()
                .getAttribute("teacherDao");
        Teacher m = new Teacher();
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPay(Integer.parseInt(request.getParameter("pay")));
        m.setSubjects(request.getParameter("subjects"));
        
        try {            
            Part part = request.getPart("file1");
            if(part.getSize()>0) { //만약 이걸 지정하지 않으면, 첨부하지 않은 파일도 0바이트로 파일이 생김
                String filename = UUID.randomUUID().toString();
                part.write(this.getServletContext().getRealPath("/upload/" + filename));
                m.setPhoto(filename);
            }
            
            teacherDao.insert(m);
            response.sendRedirect("list");
        }catch(Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "강사 등록 오류!!");
            request.setAttribute("refresh", "3;url=list");
            
            request.getRequestDispatcher("/error").forward(request, response);
        }
    }
    
}
