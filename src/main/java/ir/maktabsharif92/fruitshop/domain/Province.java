package ir.maktabsharif92.fruitshop.domain;

import ir.maktabsharif92.fruitshop.base.domain.Entity;

public class Province extends Entity {

    public static final String TABLE_NAME = "province";

    public static final String NAME = "name";


    //    @Column(name = NAME)
    private String name;

    public Province() {
    }

    public Province(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
