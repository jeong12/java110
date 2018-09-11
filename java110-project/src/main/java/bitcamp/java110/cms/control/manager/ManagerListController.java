package bitcamp.java110.cms.control.manager;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerListController { 

    ManagerDao managerDao;
    
<<<<<<< HEAD
    ManagerDao managerDao;
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao=managerDao;
    }
    
    @RequestMapping("manager/list")
    public void list(Scanner keyIn) {
        List<Manager> list=managerDao.findAll();
        for(Manager manager:list) {
            System.out.printf("%s, %s, %s, %s\n", manager.getName(), 
                    manager.getEmail(), manager.getPassword(), 
                    manager.getPosition(), manager.getTel());
=======
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @RequestMapping("manager/list")
    public void list(Scanner keyIn) {
        List<Manager> list = managerDao.findAll();
        for (Manager s : list) {
            System.out.printf("%s, %s, %s, %s, %s\n",
                    s.getName(), 
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getTel(),
                    s.getPosition());
>>>>>>> b1
        }
    }
    
}
