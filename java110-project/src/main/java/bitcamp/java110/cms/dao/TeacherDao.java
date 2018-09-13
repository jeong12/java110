package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Teacher;

public interface TeacherDao {
   
  int insert(Teacher teacher); 
  List<Teacher> findAll();
  default Teacher findByNo(int no) {return null;};
  default Teacher findByEmail(String email) {return null;};
  default int delete(String email){return 0;};
  default int delete(int no) {return 0;}
}
