import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /*
        코드 상세설명
         */

        HelloWorld helloWord = new HelloWorld(){
            @Override
            public String sayHello(String name){
                return "Hello, "+ name + "!";
            }
        };


    }

    HelloWorld helloWorld = name->"hello, "+name+"!";

    interface HelloWorld{
        String sayHello(String name);
    }

    /* 함수형프로그래밍:바운드 비정적 메서드 참조 ( 2025.04.15 )
    public class SuperClass{
        public String doWork(String input){
            return "super: " + input;
        }

    }

    public class SubClass extends SuperClass{

        @Override
        public String doWork(String input){
            return "this: " + input;
        }

        public void superAndThis(String input){
            Function<String,String> thisWorker = this::doWork;
            var thisResult = thisWorker.apply(input);
            System.out.println(thisResult);

            Function<String,String> superWorker = SubClass.super::doWork;
            var superResult = superWorker.apply(input);
            System.out.println(superResult);
        }
    }

     */




}




