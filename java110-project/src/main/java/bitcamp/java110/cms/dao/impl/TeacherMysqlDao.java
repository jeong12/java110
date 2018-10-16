package bitcamp.java110.cms.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

public class TeacherMysqlDao implements TeacherDao {

    SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insert(Teacher teacher) {
        
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.insert("bitcamp.java110.cms.dao.TeacherDao.insert",teacher);
         }
    }
    
    public List<Teacher> findAll(Map<String,Object> params) {
        
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.selectList("bitcamp.java110.cms.dao.TeacherDao.findAll",params);
         }

    }
    
    public Teacher findByEmail(String email) {
        
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.selectOne("bitcamp.java110.cms.dao.TeacherDao.findByEmail",email);
         }

    }
    
    public Teacher findByNo(int no) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.selectOne("bitcamp.java110.cms.dao.TeacherDao.findByNo",no);
         }
    }
    
    public int delete(int no){
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.delete("bitcamp.java110.cms.dao.TeacherDao.delete",no);
         }
    }
    
    @Override
    public Teacher findByEmailPassword(Map<String,Object> params) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.selectOne("bitcamp.java110.cms.dao.TeacherDao.findByEmailPassword",params);
         }
        
    }
}









