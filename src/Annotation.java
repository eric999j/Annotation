import java.lang.annotation.*;
import java.util.Arrays;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface MyAnnotation {
    String[] value();
    String comment() default "hello";
}

@MyAnnotation("John")
class MyTest {
    public static void test(){
        //透過反射取得某個類上的某個注解
        MyAnnotation config = MyTest.class.getAnnotation(MyAnnotation.class);
        System.out.println("value: " + Arrays.toString(config.value()) + ", comment: " + config.comment());
    }
}

public class Annotation{
    public static void main(String[] args) {
        MyTest.test();  //輸出 value: John, comment: hello
    }
}