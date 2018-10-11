package bitcamp.java110.ex13;

import bitcamp.java110.Member;

public class Inventory2 {
    
    // Member 객체를 각 Thread의 변수로 만든다. 
    
    ThreadLocal<Member> mylocal=new ThreadLocal<>();

    public Member getMember() {
        return mylocal.get();
    }

    public void setMember(Member member) {
        this.mylocal.set(member);
    }
}
