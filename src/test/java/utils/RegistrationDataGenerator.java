package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class RegistrationDataGenerator {
    public static RegistrationByCardInfo generateByCard() {
        Faker faker = new Faker(new Locale("ru"));
        return new RegistrationByCardInfo(
                faker.address().city(),
                LocalDate.now().plusDays(10),
                faker.name().fullName(),
                faker.phoneNumber().phoneNumber()
        );
    }
}
