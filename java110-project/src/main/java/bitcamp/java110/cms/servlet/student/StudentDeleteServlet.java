package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    StudentMysqlDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentMysqlDao();
        DataSource datasource= new DataSource();
        studentDao.setDataSource(datasource);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        int no = Integer.parseInt(request.getParameter("no"));
        
        response.setContentType("text/plain;Charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if (studentDao.delete(no) > 0) {
            out.println("삭제하였습니다.");
        } else {
            out.println("번호에 해당하는 강사가 없습니다.");
        }
    }
}
