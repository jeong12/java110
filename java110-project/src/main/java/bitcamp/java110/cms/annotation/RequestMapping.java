package bitcamp.java110.cms.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

<<<<<<< HEAD
@Target({ElementType.TYPE,ElementType.METHOD}) //하나는 {}생략 가능.
=======
@Target({ElementType.TYPE,ElementType.METHOD})
>>>>>>> b1
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";
}
