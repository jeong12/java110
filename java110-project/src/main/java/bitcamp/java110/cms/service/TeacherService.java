package bitcamp.java110.cms.service;

import java.util.List;

import bitcamp.java110.cms.domain.Teacher;

public interface TeacherService {
    void add(Teacher teacher);
    Teacher get(int no);
    void delete(int no);
    List<Teacher> list(int pageNo, int pageSize);
}
