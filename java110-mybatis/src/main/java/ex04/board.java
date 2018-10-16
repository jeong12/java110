package ex04;

import java.sql.Date;

public class board {
    
    protected int no;
    protected String title;
    protected String content;
    protected int viewCount;
    protected Date creadtedDate;
    protected int memberNo;
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getViewCount() {
        return viewCount;
    }
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
    public Date getCreadtedDate() {
        return creadtedDate;
    }
    public void setCreadtedDate(Date creadtedDate) {
        this.creadtedDate = creadtedDate;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    
    
    
}
