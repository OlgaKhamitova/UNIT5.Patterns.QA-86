package utils;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class RegistrationByCardInfo {
    private final String city;
    private final LocalDate registrationDate;
    private final String name;
    private final String phoneNumber;

    public RegistrationByCardInfo(String city, LocalDate registrationDate, String name, String phoneNumber) {
        this.city = city;
        this.registrationDate = registrationDate;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
