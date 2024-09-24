package lab2;

public class Main {
    public static void main(String[] args)  {
        try {
            TestClass testClass = new TestClass();
            InvokeMethodHandler handler = new InvokeMethodHandler();
            handler.invokeAnnotatedMethods(testClass);
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
