package bitcamp.java110.cms.dao;

public class DuplicationDaoException extends RuntimeException{

    //분류를 편하게 하기 위하여
    
    private static final long serialVersionUID = 1L;

    public DuplicationDaoException() {
        super(); //호풀은 서브클래스부터, 실행은 슈퍼 클래스부터
    }

    public DuplicationDaoException(String message, Throwable cause) {
       // super(message, cause); 이렇게 생략하면 super 의 default 생성자를 호출
       // 만약 default 생성자가 없으면 오류!
        super(message, cause);
    }

    public DuplicationDaoException(String message) {
        super(message);
    }
    
    
}
