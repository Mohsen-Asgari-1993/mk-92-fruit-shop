package ir.maktabsharif92.fruitshop;

import ir.maktabsharif92.fruitshop.domain.Address;
import ir.maktabsharif92.fruitshop.util.ApplicationContext;

public class FruitShopApplication {

    public static void main(String[] args) {

        Address address = new Address();
        address.setTitle("عنوان");
        address.setPostalCode("1234567891");
        address.setAddress("تهران، آزادی");
        ApplicationContext.getAddressRepository().save(address);

        Address addressById = (Address) ApplicationContext.getAddressRepository().getById(1L);
        System.out.println(addressById);

    }
}
