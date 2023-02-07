package FactoriesAndBuilders;



import java.util.Date;

public class FactoryAndBuilderTest {

    public static void main(String[] args) {
        UserEntityObjectFactory objectFactory = new UserEntityObjectFactory();

        UserEntity shopper = objectFactory.getObject(Shopper.class, "Pesho - Shopper", 22, new Date());
        UserEntity cashier = objectFactory.getObject(Cashier.class, "Gosho - Cahshier", 40, new Date());
        System.out.println("Entities: " + shopper + " " + cashier);
        System.out.println("Now for the builder: ");

        Shopper builtShopper = new Shopper
                .ShopperBuilder()
                    .name("Built Name").age(30)
                    .dateCreated(new Date())
                    .build();
        System.out.println("Shopper with a builder: " + builtShopper);

        //For the custom equals method:
        User user1 = new User(1L, "John", "Johnson");
        User user2 = new User(2L, "Ben", "Affleck");
        System.out.println("Is user1 equal to user2? " + user1.equals(user2));

        user1 = user2;
        System.out.println("Is user1 equal to user2? " + user1.equals(user2));

        user1 = new User(2L, "Ben", "Affleck");
        System.out.println("Is user1 equal to user2? " + user1.equals(user2));

    }

}
