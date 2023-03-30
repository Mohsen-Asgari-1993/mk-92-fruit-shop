package ir.maktabsharif92.fruitshop;

import com.github.javafaker.Faker;
import ir.maktabsharif92.fruitshop.domain.Address;
import ir.maktabsharif92.fruitshop.util.ApplicationContext;

import java.util.Random;

public class FruitShopApplication {

    public static void main(String[] args) {

        initAddress();

        Address address = (Address) ApplicationContext.getAddressRepository().getById(1L);

        Address[] customerAddress = ApplicationContext.getAddressRepository()
                .findAllByCustomerId(address.getCustomerId());

        for (Address a : customerAddress) {
            System.out.println(a);
        }

    }

    private static void initAddress() {
        Faker faker = new Faker();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Address address = new Address();
            address.setTitle(faker.address().cityName());
            address.setAddress(faker.address().fullAddress());
            address.setPostalCode(faker.address().zipCode());
            address.setCustomerId((long) (random.nextInt(10)));
            ApplicationContext.getAddressRepository()
                    .save(address);
        }
    }
}
