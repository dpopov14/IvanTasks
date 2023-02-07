package Generics;

public class User<UT extends UserType> {
    private String username;
    private String password;

    private Role role;

    private UT ut;

    public void addUserType(UT ut) {
        this.ut = ut;
        if(this.ut instanceof Customer) this.role = Role.CUSTOMER;
        if(this.ut instanceof Seller) this.role = Role.SELLER;
    }

    public UT get(){
        return this.ut;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", userType=" + ut +
                '}';
    }
}

class GenericsTester {

    public <Entity> boolean isValidEntity(Entity entity) {
        if(entity instanceof Customer || entity instanceof Seller) return true;
        return false;
    }
    class ValidityChecker {
        private static <T> void printer(T t) {
            System.out.println("This is: " + t);
        }

        public static <Entity> boolean IsValidEntityStatic(Entity entity) {
            return entity instanceof Customer || entity instanceof Seller;
        }

    }

    public static void main(String[] args) {

        User<Customer> customerUser = new User<>();
        User<Seller> sellerUser = new User<>();
        customerUser.addUserType(new Customer("Pesho - customer"));
        sellerUser.addUserType(new Seller("Gosho - seller"));

        //See that the generic class works:
        ValidityChecker.printer(customerUser);
        ValidityChecker.printer(sellerUser);

        //Check whether the type of user is valid
        GenericsTester gt = new GenericsTester();
        ValidityChecker.printer("Is customerUser a valid entity? : " + gt.isValidEntity(customerUser.get()));
        ValidityChecker.printer("Is sellerUser a valid entity? : " + gt.isValidEntity(sellerUser.get()));
        ValidityChecker.printer("Is GenericsTester a valid entity? : " + gt.isValidEntity(new GenericsTester()));

        //Check whether the static method works:
        ValidityChecker.printer("Static: Is customerUser a valid entity? : " +
                ValidityChecker.IsValidEntityStatic(customerUser.get()));
        ValidityChecker.printer("Static: Is GenericsTester a valid entity? : " +
                ValidityChecker.IsValidEntityStatic(new GenericsTester()));

        //Test the printer:
        ValidityChecker.printer(customerUser.get());
        ValidityChecker.printer(sellerUser.get());

//        String a = "abc";
//        String b = "abcujyboiyuunihiou" + "b" + "c";
////        b = "a" + "b" + "c";
//        b = b.substring(0,3);
//        System.out.println(a.hashCode() + " " + b.hashCode());
//        System.out.println(a + " b: " + b);
//        System.out.println(a == b);


    }
}
