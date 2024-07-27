public class MethodReferenceClass {
    public static void showMsg(){
        System.out.println("Msg from static method");
    }

    public void showInstanceMsg(){
        System.out.println("Msg from instance method");
    }
    public static int add(int a, int b){
        return a+b;
    }
}
