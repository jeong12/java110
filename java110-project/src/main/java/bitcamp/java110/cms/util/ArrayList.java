package bitcamp.java110.cms.util;


public class ArrayList {
    
    //개별적으로 관리해야 할 값이라면 인스턴스 변수를 사용
    Object [] List = new Object[5];
    int index =0;

    public void add(Object obj) {
        if(index == List.length) {
            increaseStorage();
        }
        List[index++] = obj;

    }

    private void increaseStorage() {
        Object[] newList=new Object[List.length+3];
        for(int i=0;i<List.length;i++) {
            newList[i]=List[i];
        }
        List=newList;
    }
    
    public void remove(int no) {
        if(no<0 || no>=index) {
            return;
        }
        for(int i=no;i<index-1;i++) {
            List[i]=List[i+1];
        }
        index--;
    }
    
    public int size() {
        return index; 
                      
    }
    
   /* public int size() {
        return index; 
        //this 생략 됨. 인스턴스 호출에 따라 this값이 달라짐! (모든 인스턴스 변수가 가지고 있는)내장변수니까. this는 무조건 있어야 함. 
         static은 this를 가지고 있지 않음(사용할 수 없음) 인스턴스 메서드는 인스턴스가 있어야 가능 ->인스턴스별로 작업!
      
      public int size(int index) {
      return this.index; 
      //이 때는 this를 꼭 써야 함! 왜냐하면  this를 쓰지 않으면 가르키는 대상이 모호해짐. (로컬인지 아닌지)  
    }*/
                        
    public Object get(int no) {
        if(no<0 || no>=index) {
            System.out.println("unvailed number");
            return null;
        }
        return List[no];
    }
}
    





