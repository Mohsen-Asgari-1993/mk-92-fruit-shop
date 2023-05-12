package ir.maktabsharif92.fruitshop.domain;

import ir.maktabsharif92.fruitshop.base.domain.BaseUser;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Manager extends BaseUser {

    public static final String IS_SUPER_MANAGER = "is_super_manager";

    private Boolean isSuperManager;

    @Builder
    public Manager(String firstName, String lastName, String username, String password, Integer age,
                   String userType, String nationalCode, Boolean isActive, Boolean isSuperManager) {
        super(firstName, lastName, username, password, age, userType, nationalCode, isActive);
        this.isSuperManager = isSuperManager;
    }
}
