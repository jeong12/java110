package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Student;


public interface StudentDao {
    
   int insert(Student student);
    
   List<Student> findAll(); 
     
   default Student findByEmail(String email) {return null;};
   default Student findByNo(int no) {return null;};
    
   default int delete(String email) {return 0;};
   default int delete(int no) {return 0;};
   
}








