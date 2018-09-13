package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerDao {
   
   int insert(Manager manager) 
           throws manadatoryValueDaoException,DuplicationDaoException;
   List<Manager> findAll();
   default Manager findByEmail(String email) {return null;} ; 
   default Manager findByNo(int no) {return null;};
   default int delete(String email) {return 0;};
   default int deleteByNo(int no) {return 0;}
}
