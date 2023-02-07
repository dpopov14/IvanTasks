package FactoriesAndBuilders;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cashier implements UserEntity{
    private String name;
    private Integer age;
    private Date dateCreated;
    private Double salary;
}
