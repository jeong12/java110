package bitcamp.java110.cms.domain;


public class Manager extends Member {

    private static final long serialVersionUID = 1L;
    //Serializable 이라는 인터페이스를 상속 받아야지, byte 단위로 쪼개서 보낼 수 있음.
    
    protected String position;
    protected String tel;

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}

