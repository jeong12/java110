package bitcamp.java110.cms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //value이름이고, 값이 하나일때는 생략 가능!!
public @interface Component {
    /*annotation의 용도. "부가 데이터 다룰려고!(meta data)"
    *일반 주석은 compile하면 주석이 날아감. 
    *클래스를 관리할 목적으로 붙였다가 사용할 목적으로 사용!
    *주 데이터는 아니지만, 주 데이터를 관리,설명하기 위해 작성 : 부가 데이터, meta data
    *annotation은 meta data를 다루기 위한 문법. 
         일반주석과 달리, 주석 자체를 조직화, 할 수 있음.*/ 
 
    
    //String vaule(); //field 형식의 이름을 가진 proerty. 아무것도 지정하지 않으면 필수값
    
    /* 유지정책
     * class : 컴파일 한 후에도, .class 파일에 남겨 둔다. 단, 실행할 때는 참조할 수 없다.
     *       : reflection API로 클래스 파일에서 annotation 정보를 추출할 수 없다.
     *       : default 값.
     * source: 컴파일 할 때 제거된다. 즉 .class 파일에 남겨 두지 않는다.
     * runtime: 컴파일 한 후에도 .class 파일에 남겨둔다. 실행할 때도 참조할 수 있다.  
     *          = reflection API로 클래스에서 annotation 정보를 추출할 수 있다.
    */
    
    String value() default ""; //변수 선언하지 않으면 default 값이 들어감
}

