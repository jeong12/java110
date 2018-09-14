package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController { 

    ManagerDao managerDao;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @RequestMapping("manager/add")
    public void add(Scanner keyIn) {
        while (true) {
            Manager m = new Manager();

            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());

            System.out.print("이름? ");
            m.setName(keyIn.nextLine());

            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());

            System.out.print("직위? ");
            m.setPosition(keyIn.nextLine());

            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());

            
                managerDao.insert(m); 
                //insert에 mouse를 갖다 대면 인터페이스를 보여주고, 거기서 오류확인 가능
                System.out.println("저장하였습니다.");
            
                System.out.print("계속 하시겠습니까?(Y/n) ");
                String answer = keyIn.nextLine();
                if (answer.toLowerCase().equals("n"))
                    break;
            
        }

    }
}
