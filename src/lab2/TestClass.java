package lab2;


public class TestClass {
    @InvokeMethod(numberInvoking = 2)
    private void SayHello(CustomClass inf){
        System.out.println(inf.getInformation());
        //System.out.println("and invoken");

    }
    @InvokeMethod(numberInvoking = 2)
    public void firstPublicMethod(int arg1) {
        System.out.println("First Public Method that has arg " + arg1);
    }
    @InvokeMethod
    public void secondPublicMethod() {
        System.out.println("Second Public Method");
    }

    @InvokeMethod(numberInvoking = 2)
    public void thirdPublicMethod() {
        System.out.println("Third Public Method");
    }

    @InvokeMethod(numberInvoking = 3)
    protected void firstProtectedMethod(int arg1, int arg2) {
        System.out.println("First Protected Method that has args " + arg1 + " and " + arg2);
    }

    @InvokeMethod()
    protected void secondProtectedMethod() {
        System.out.println("Second Protected Method");
    }

    @InvokeMethod(numberInvoking = 2)
    protected void thirdProtectedMethod() {
        System.out.println("Third Protected Method");
    }

    @InvokeMethod
    private void firstPrivateMethod(String str1, String str2) {
        System.out.println("First Private Method that has args " + str1 + ' ' + str2);
    }

    @InvokeMethod
    private void secondPrivateMethod(String str) {
        System.out.println("Second Private Method that has arg " + str);
    }
}
