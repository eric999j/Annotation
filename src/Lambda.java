@FunctionalInterface
interface TestAnnotation {
    String myApply();
}

class Hi {
    void say(TestAnnotation annotation) {
        System.out.println(annotation.myApply());
    }
}

public class Lambda {
    public static void main(String[] args) {

        Hi hi = new Hi();

        //輸出 Hello World
        hi.say(new TestAnnotation() {
            @Override
            public String myApply() {
                return "Hello World";
            }
        });

        // 或用lambda
        hi.say(() -> "Hello World");

    }
}