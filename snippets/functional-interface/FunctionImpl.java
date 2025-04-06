public class MyClass {

    // old style anonymous implementation
    private final Function<String, String> greeter = new Function<String, String>() {
        @Override
        public String apply(String who) {
            return "hello ".concat(who);
        }
    };

}