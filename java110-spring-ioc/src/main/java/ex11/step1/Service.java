package ex11.step1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
    
    @Autowired Dao3 dao3;
    @Autowired Dao2 dao2;
    @Autowired Dao1 dao1;
    
    public void add() {
        // 메서드를 호출하기 전/후에 실행될 코드는 다음과 같이 직접 삽입해야 한다.
        System.out.println("Service.add() 호출 전에 해야할 일!");
        dao1.insert();
        dao2.insert();
        dao3.insert();
        System.out.println("Service.add() 호출 후에 해야할 일!");
    }
}
