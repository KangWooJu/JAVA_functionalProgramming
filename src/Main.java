import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*
        코드 상세설명
         */

        /*
        HelloWorld helloWord = new HelloWorld(){
            @Override
            public String sayHello(String name){
                return "Hello, "+ name + "!";
            }
        };


         */

        /*
        // 2025.04.22 : 함수형 인터페이스 연습
        Function<String,Integer> stringLength = str -> str != null ? str.length() : 0 ;
        Integer result = stringLength.apply("Hello, Function!");
        System.out.println(result);



        Consumer<String> println = str -> System.out.println(str);
        println.accept("Hello, Consumer");




        Supplier<Double> random = () -> Math.random();
        Double result = random.get();
        System.out.println(result);




        Predicate<Integer> over9000 = i -> i > 9_000;
        boolean result = over9000.test(12_345);
        System.out.println(result);




        Function<String,String> removeLowerCaseA = str -> str.replace("a","");
        Function<String,String> upperCase = String::toUpperCase;

        var input = "abcd";

        removeLowerCaseA.andThen(upperCase) // 1st. removeLowerCaseA 실행
                .apply(input);              // 2nd. 1st의 실행결과를 파라미터에 넣어 uppercase 실행
        // -> "BCD"

        upperCase.compose(removeLowerCaseA) // 1st. uppercase 실행
                .apply(input);              // 2nd. 1st의 실행결과를 파라미터에 넣어 removeLowerCaseA 실행
        // -> "BCD";

        // 2025.04.24 주석처리

         */

        // 자바의 Stream() 메소드 1.축소 예시 : reduce()
        List<String> words = Arrays.asList("java", "stream", "reduce", "example");
        String result = words.stream()
                .reduce(
                        "",                                      // identity
                        (partialResult, word) -> partialResult + word.toUpperCase() + " ", // accumulator
                        (result1, result2) -> result1 + result2   // combiner
                );

        System.out.println(result);

        // 자바의 Stream() 메소드 2. 요소수집 : collect()
        var strings = List.of("a","b","c","d","e");

        // (1) 스트림 컬렉터 - 사용자 정의
        var joiner = strings.stream()
                            .collect(Collector.of(() -> new StringJoiner(""), // Suplier<A>를 지정
                                    StringJoiner::add, // BiConsimer<A,T>를 지정
                                    StringJoiner::merge, // BinaryOperator<A,T>를 지정
                                    StringJoiner::toString)); // Function<A,R>

        System.out.println(joiner); // abcde 출력

        // (2) 스트림 컬렉터 - 사전 정의
        var collectWithCollectors = strings.stream()
                                           .collect(Collectors.joining());

        System.out.println(collectWithCollectors); // abcde 출력




    }

    /*
    HelloWorld helloWorld = name->"hello, "+name+"!";

    Function<String,Integer> stringTest = str -> str !=null ? str.length() : 0;
    Integer result = stringTest.apply("Test");


     */


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




