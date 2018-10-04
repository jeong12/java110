package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/detail")
public class TeacherDetailServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TeacherDao teacherDao = (TeacherDao)this.getServletContext()
                .getAttribute("teacherDao");

        int no = Integer.parseInt(request.getParameter("no"));
        Teacher t = teacherDao.findByNo(no);

        response.setContentType("text/html;Charset=UTF-8");
        
        request.setAttribute("detail",t);
        RequestDispatcher rd = request.getRequestDispatcher("/teacher/detail.jsp");
        rd.include(request, response);
        
       


    }

}
