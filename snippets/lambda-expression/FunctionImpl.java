public class MyClass {

    // lambda expression (auto-return)
    private final Function<String, String> greeter = who -> "hello ".concat(who);

}