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

        System.out.println("start");
        ApplicationContext.getUserService().getAll()
                .forEach(System.out::println);
        System.out.println();

        ApplicationContext.getManagerService().deleteById(2L);
        System.out.println("after manger service delete: 2L");
        ApplicationContext.getUserService().getAll()
                .forEach(System.out::println);
        System.out.println();

        ApplicationContext.getClientService().deleteById(4L);
        System.out.println("after client service delete: 4L");
        ApplicationContext.getUserService().getAll()
                .forEach(System.out::println);
        System.out.println();


        ApplicationContext.getManagerService().deleteById(4L);
        System.out.println("after manger service delete: 4L");

        ApplicationContext.getUserService().getAll()
                .forEach(System.out::println);
        System.out.println();

        ApplicationContext.getClientService().deleteById(2L);
        System.out.println("after client service delete: 2L");

        ApplicationContext.getUserService().getAll()
                .forEach(System.out::println);
        System.out.println();

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
