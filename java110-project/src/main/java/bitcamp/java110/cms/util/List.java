package bitcamp.java110.cms.util;

public interface List<T> {
    void add(T obj);
    T get(int index);
    T remove(int index);
    int size();
    //intention to default
    //if add rules, exists class affected.
    //so exists class need to make new method added
    //default is to solve this problem.
    // it means default appear not to affect exists class 
    default void insert(int index, T obj) {};
    // method of interface is a rule
    // 하위호환을 위해서 메서드를 추가하고 구현하더라고 실제 많은 작업을 처리하게 구현해서는 안된다.
    // 구현 클래스들에 영향을 끼치지 않게 하는 정도만 코드를 작성해야 한다.
}
