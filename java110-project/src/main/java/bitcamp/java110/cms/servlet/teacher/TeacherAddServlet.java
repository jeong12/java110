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

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.TeacherService;

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
        Teacher t = new Teacher();
        t.setName(request.getParameter("name"));
        t.setEmail(request.getParameter("email"));
        t.setPassword(request.getParameter("password"));
        t.setTel(request.getParameter("tel"));
        t.setPay(Integer.parseInt(request.getParameter("pay")));
        t.setSubjects(request.getParameter("subjects"));
        
        TeacherService teacherService = (TeacherService)this.getServletContext()
                .getAttribute("teacherService");
        
        try {            
            Part part = request.getPart("file1");
            if(part.getSize()>0) { //만약 이걸 지정하지 않으면, 첨부하지 않은 파일도 0바이트로 파일이 생김
                String filename = UUID.randomUUID().toString();
                part.write(this.getServletContext().getRealPath("/upload/" + filename));
                t.setPhoto(filename);
            }
            
            teacherService.add(t);
            response.sendRedirect("list");
        }catch(Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "강사 등록 오류!!");
            request.setAttribute("refresh", "3;url=list");
            
            request.getRequestDispatcher("/error").forward(request, response);
        }
    }
    
}
