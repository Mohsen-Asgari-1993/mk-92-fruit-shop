package ir.maktabsharif92.fruitshop.domain;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends BaseUser {

    public static final String CODE = "code";

    private String code;

    @Builder
    public Client(String firstName, String lastName, String username,
                  String password, Integer age, String userType,
                  String nationalCode, Boolean isActive, String code) {
        super(firstName, lastName, username, password, age, userType, nationalCode, isActive);
        this.code = code;
    }
}
