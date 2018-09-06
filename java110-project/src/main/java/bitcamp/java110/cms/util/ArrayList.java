package bitcamp.java110.cms.util;


public class ArrayList {

    static Object [] List = new Object[5];
    static int index =0;

    public static void add(Object obj) {
        if(index == List.length) {
            increaseStorage();
        }
        List[index++] = obj;

    }

    private static void increaseStorage() {
        Object[] newList=new Object[List.length+3];
        for(int i=0;i<List.length;i++) {
            newList[i]=List[i];
        }
        List=newList;
    }
    
    public static void remove(int no) {
        if(no<0 || no>=index) {
            return;
        }
        for(int i=no;i<index-1;i++) {
            List[i]=List[i+1];
        }
        index--;
    }
    
    public static int size() {
        return index;
    }

    public static Object get(int no) {
        if(no<0 || no>=ArrayList.size()) {
            System.out.println("unvailed number");
            return null;
        }
        return List[no];
    }
}
    





