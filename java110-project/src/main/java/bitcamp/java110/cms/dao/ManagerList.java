package bitcamp.java110.cms.dao;

import bitcamp.java110.cms.domain.Manager;

public class ManagerList {

    static Manager [] Managers = new Manager[5];
    static int managerIndex =0;

    public static void add(Manager manager) {
        if(managerIndex == Managers.length) {
            increaseStorage();
        }
        Managers[managerIndex++] = manager;

    }

    private static void increaseStorage() {
        Manager[] newList=new Manager[Managers.length+3];
        for(int i=0;i<Managers.length;i++) {
            newList[i]=Managers[i];
        }
        Managers=newList;
    }
    
    public static void remove(int no) {
        if(no<0 || no>=managerIndex) {
            return;
        }
        for(int i=no;i<managerIndex-1;i++) {
            Managers[i]=Managers[i+1];
        }
        managerIndex--;
    }
    
    public static int size() {
        return managerIndex;
    }

    public static Manager get(int no) {
        if(no<0 || no>=ManagerList.size()) {
            System.out.println("unvailed number");
            return null;
        }
        return Managers[no];
    }
}
    





