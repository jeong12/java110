package bitcamp.java110.cms.domain;

public class Member{
    protected String name;
    protected String emial;
    protected String password;

    //인스턴스의 메모리는 다루는 operator=getter/setter=accessor=property=message
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmial() {
        return emial;
    }
    public void setEmial(String emial) {
        this.emial = emial;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}