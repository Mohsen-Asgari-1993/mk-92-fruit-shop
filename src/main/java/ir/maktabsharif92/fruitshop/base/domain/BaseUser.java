package ir.maktabsharif92.fruitshop.base.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//  @Inheritance(strategy = SINGLE_TABLE)  *
//  @Inheritance(strategy = TABLE_PER_CLASS)
//  @Inheritance(strategy = JOIN)
public class BaseUser extends BaseEntity<Long> {

    public static final String TABLE_NAME = "base_user";

    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String AGE = "age";
    public static final String USER_TYPE = "user_type";
    public static final String NATIONAL_CODE = "national_code";
    public static final String IS_ACTIVE = "is_active";

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Integer age;

    private String userType;

    private String nationalCode;

    private Boolean isActive;

    @Override
    public String toString() {
        return "BaseUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                '}';
    }
}
