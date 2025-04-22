// 2025.04.22 함수형 인터페이스
@FunctionalInterface
public interface Function<T,R> {

    R apply(T t); // 함수형 인터페이스의 추상 메소드
}
