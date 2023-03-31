package ir.maktabsharif92.fruitshop;

import com.github.javafaker.Faker;
import ir.maktabsharif92.fruitshop.base.domain.Entity;
import ir.maktabsharif92.fruitshop.domain.Address;
import ir.maktabsharif92.fruitshop.domain.City;
import ir.maktabsharif92.fruitshop.repository.CityRepository;
import ir.maktabsharif92.fruitshop.util.ApplicationContext;
import ir.maktabsharif92.fruitshop.util.Datasource;

import java.sql.SQLException;
import java.util.Random;

public class FruitShopApplication {

    public static void main(String[] args) throws SQLException {

        CityRepository cityRepository = ApplicationContext.getCityRepository();

        Entity[] entities = cityRepository.getAll();
        for (Entity en : entities) {
            System.out.println(en);
        }
        System.out.println("--------------------------------");

        cityRepository.save(new City("natanz", 2L));

        entities = cityRepository.getAll();
        for (Entity en : entities) {
            System.out.println(en);
        }

        Datasource.getConnection().close();

    }

    private static void initAddress() throws SQLException {
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
