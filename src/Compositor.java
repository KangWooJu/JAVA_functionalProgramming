import java.util.Objects;

public final class Compositor {

    public static <T,R> Supplier<R> compose(Supplier<T> before,Function<T,R> function){
        Objects.requireNonNull(before);
        Objects.requireNonNull(function);

        return () ->{
            T result = before.get();
            return function.apply(result);
        };
    }

    public static <T,R> Consumer<T> compose(Function<T,R> function,Consumer<R> after){
        Objects.requireNonNull(function);
        Objects.requireNonNull(after);

        return (T t) -> {
            R result = function.apply(t);
            after.accept(result);
        };

    }
}
