package ir.maktabsharif92.fruitshop.repository;

import ir.maktabsharif92.fruitshop.base.repository.BaseRepository;
import ir.maktabsharif92.fruitshop.domain.Province;

import java.sql.SQLException;

public interface ProvinceRepository extends BaseRepository {

    Province getByName(String name) throws SQLException;

}
