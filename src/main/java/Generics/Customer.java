package Generics;

public class Customer implements UserType{

    private String name;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }

    public Customer(String name) {
        this.name = name;
    }
}
