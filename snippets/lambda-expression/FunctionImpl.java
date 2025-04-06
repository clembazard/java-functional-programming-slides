public class MyClass {

    // new style anonymous implementation - lambda expression
    private final Function<String, String> greeter = who -> "hello ".concat(who);

}