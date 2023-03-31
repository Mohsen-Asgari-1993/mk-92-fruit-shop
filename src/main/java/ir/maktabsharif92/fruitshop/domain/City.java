package ir.maktabsharif92.fruitshop.domain;

import ir.maktabsharif92.fruitshop.base.domain.Entity;

public class City extends Entity {

    public static final String TABLE_NAME = "city";

    public static final String NAME = "name";
    public static final String PROVINCE_ID = "province_id";

    private String name;

    private Long provinceId;

    public City() {
    }

    public City(String name, Long provinceId) {
        this.name = name;
        this.provinceId = provinceId;
    }

    public City(Long id, String name, Long provinceId) {
        super(id);
        this.name = name;
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", provinceId=" + provinceId +
                '}';
    }
}
