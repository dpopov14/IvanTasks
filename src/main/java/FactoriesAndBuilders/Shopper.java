package FactoriesAndBuilders;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shopper implements UserEntity{
    private String name;
    private Integer age;
    private Date dateCreated;

    /**
     * Here we have the static builder class:
     */
     static class ShopperBuilder {
        private String name;
        private Integer age;
        private Date dateCreated;

        public ShopperBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ShopperBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public ShopperBuilder dateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Shopper build(){
            return new Shopper(name, age, dateCreated);
        }
    }




}
