package Generics;

public class Seller implements UserType{
    private String name;

    public Seller(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                '}';
    }
}
