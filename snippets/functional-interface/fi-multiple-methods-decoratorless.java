// No decorator, still a FunctionalInterface ! 
public interface ShortToByteFunction {

    // Only method to implement
    byte applyAsByte(short s);

    default String isShort(){
        return "Already implemented";
    }

    static String a(){
        return "Also already implemented";
    }

}