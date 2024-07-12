
import com.github.javafaker.Faker;
import java.time.LocalDate;

public class DataGenerator {
    private DataGenerator() {
    }
    public static class Registration {
        private Registration() {
        }
        public static RegistrationByCardInfo generateByCard(String locale) {
            Faker faker = new Faker(new locale("ru"));
            return new RegistrationByCardInfo(
                    faker.country().capital(),
                    LocalDate.now().plusDays(10),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber()
            );
        }
    }
}
