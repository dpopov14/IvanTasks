package Generics.AB;

public class A<T>
{
    private T t;

    public A(T t) {
        this.t = t;
    }

    public void  print(T t){
        System.out.println(t);
    }
}
