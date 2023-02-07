package Generics.AB;

public class B<T> extends A<Integer>{
    public B(Integer integer) {
        super(integer);
    }

    @Override
    public void print(Integer integer) {
        System.out.println("Boba u: " + integer);
    }

    public static void main(String[] args) {
        String string = "Leba";
        new A("Хляба").print(string);
        new B(2).print(1);
    }
}
