package ir.maktabsharif92.fruitshop;

import com.github.javafaker.Faker;
import ir.maktabsharif92.fruitshop.domain.Client;
import ir.maktabsharif92.fruitshop.domain.Manager;
import ir.maktabsharif92.fruitshop.domain.enumeration.UserType;
import ir.maktabsharif92.fruitshop.util.ApplicationContext;
import ir.maktabsharif92.fruitshop.util.Datasource;

import java.sql.SQLException;

public class FruitShopApplication {

    private static final Faker faker = new Faker();

    public static void main(String[] args) throws SQLException {

//        1   client
        System.out.println(ApplicationContext.getClientService().getById(1L));
        System.out.println(ApplicationContext.getManagerService().getById(1L));
        System.out.println(ApplicationContext.getUserService().getById(1L));

//        3 manager
//        System.out.println(ApplicationContext.getClientService().getById(3L));
//        System.out.println(ApplicationContext.getManagerService().getById(3L));
//        System.out.println(ApplicationContext.getUserService().getById(3L));


        Datasource.getConnection().close();

    }

    private static Manager getMangerNewInstance() {
        return Manager.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .password(
                        faker.code().imei()
                )
                .age(faker.number().numberBetween(18, 100))
                .userType(UserType.MANAGER.name())
                .nationalCode(
                        faker.code().imei()
                )
                .isActive(true)
                .isSuperManager(
                        true
                )
                .build();
    }

    private static Client getClientNewInstance() {
        return Client.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .password(
                        faker.code().imei()
                )
                .age(faker.number().numberBetween(18, 100))
                .userType(UserType.CLIENT.name())
                .nationalCode(
                        faker.code().imei()
                )
                .isActive(true)
                .code(
                        faker.code().isbn10()
                )
                .build();
    }

}
