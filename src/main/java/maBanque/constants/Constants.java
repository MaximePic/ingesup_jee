package maBanque.constants;

public final class Constants {
    public static final String PERSISTENCE_UNIT_NAME = "db_banque_jpa";
    public static final String EXPIRATION_COOKIE = "cookie";

    //Minimum eight characters, at least one uppercase letter, one lowercase letter and one number:
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
}
