package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.DuplicationDaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.manadatoryValueDaoException;
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

            try {
                managerDao.insert(m);
                System.out.println("저장하였습니다.");
            }catch(manadatoryValueDaoException ex) {
                //이름만 봐도 어디서 나는 오류인지 한눈에 알아볼 수 있음. 
                System.out.println(ex.getMessage());
                //System.out.println("필수 값 누락 오류!");
            }catch(DuplicationDaoException ex) {
                System.out.println(ex.getMessage());
                //System.out.println("이메일 중복 오류");
                System.out.print("계속 하시겠습니까?(Y/n) ");
                String answer = keyIn.nextLine();
                if (answer.toLowerCase().equals("n"))
                    break;
            }
        }

    }
}
