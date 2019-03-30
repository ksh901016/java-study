package lamda.variable;

public class UsingThisExample {
    public static void main(String[] args) {
        UsingThis usingThis = new UsingThis();
        UsingThis.Ineer inner = usingThis.new Ineer();
        inner.method();
    }
}
