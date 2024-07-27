import java.util.function.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Method Reference
//        type 1
        StaticInterface staticInterface = MethodReferenceClass::showMsg;
        staticInterface.show();

//        type 2
        MethodReferenceClass methodReferenceClass = new MethodReferenceClass();
        InstanceInterface instanceInterface = methodReferenceClass::showInstanceMsg;
        instanceInterface.show();

//        type 3
        ConsumerInterface consumerInterface = System.out::println;
        consumerInterface.show("Test msg from Consumer");

//        type 4
        ConstructorInterface constructorInterface = ClassWithConstructor::new;
        constructorInterface.show();

//    examples
        OperationInterface operationInterface = MethodReferenceClass::add;
        consumerInterface.show(operationInterface.operate(5, 6) + "");

        LenInterface lenInterface = String::length;
        consumerInterface.show(lenInterface.len("test string for length") + "");

        SubStringInterface subStringInterface=String::substring;
        consumerInterface.show(subStringInterface.sub("test string for substring", 5));

//        functional method examples

        Runnable runnable=MethodReferenceClass::showMsg;
        runnable.run();

        Consumer<String> consumer=System.out::println;
        consumer.accept("tset msg for consumer");

        Supplier<Integer> supplier=()->20;
        consumer.accept(String.valueOf(supplier.get()));

        BiConsumer<String,Integer> biConsumer=(s,i)-> System.out.println(s+i);

        Function<String,Integer> function=String::length;
        function.apply("MyName");

        BiFunction<Integer,Integer,Integer> biFunction= MethodReferenceClass::add;
        System.out.println(biFunction.apply(5,89));


        Predicate<String> predicate= s-> s.length()>0;
        System.out.println(predicate.test("testing string"));

        BiPredicate<String,Integer> biPredicate=(s,i)-> s.length()==i;
        System.out.println(biPredicate.test("String",6));




        BiFunction<Integer, Integer, Integer> composite1 = (a, b) -> a + b;
        composite1 = composite1.andThen(a -> 2 * a);
        System.out.println("Composite1 = " + composite1.apply(2, 3));


        BiFunction<Integer, Integer, Integer> composite2 = (a, b) -> a * b;
        composite2 = composite2.andThen(a -> 3 * a);
        System.out.println("Composite2 = " + composite2.apply(2, 3));


    }

    interface StaticInterface {
        void show();
    }

    interface InstanceInterface {
        void show();
    }

    interface ConsumerInterface {
        void show(String s);
    }

    interface ConstructorInterface {
        void show();
    }

    interface OperationInterface {
        int operate(int a, int b);
    }

    interface LenInterface {
        int len(String s);
    }
    interface SubStringInterface{
        String sub(String s, int start);
    }
}