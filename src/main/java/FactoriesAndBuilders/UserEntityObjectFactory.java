package FactoriesAndBuilders;

import java.util.Date;

public class UserEntityObjectFactory {

    public <T extends UserEntity> UserEntity getObject(Class<T> type, String name, Integer age, Date dateCreated) {
        if(type == Shopper.class){
            Shopper shopper = new Shopper();
            shopper.setName(name);
            shopper.setAge(age);
            shopper.setDateCreated(dateCreated);
            return shopper;
        }else if(type == Cashier.class){
            Cashier cashier = new Cashier();
            cashier.setName(name);
            cashier.setAge(age);
            cashier.setDateCreated(dateCreated);
            return cashier;
        }else{
            return null;
        }
    }

}
