import org.junit.jupiter.api.Test;
import utils.RegistrationByCardInfo;
import utils.RegistrationDataGenerator;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestReplan {

    @Test
    public void testCardDelivery() {
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.now().plusDays(10);
        RegistrationByCardInfo generatedData = RegistrationDataGenerator.generateByCard();

        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue(generatedData.getCity());
        $("[data-test-id=date] input").setValue(String.valueOf(generatedData.getRegistrationDate()));
        $("[data-test-id=name] input").setValue(generatedData.getName());
        $("[data-test-id=phone] input").setValue(generatedData.getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $(withText("Запланировать")).click();
        $(withText("Запланировать")).click();
        $("[data-test-id=replan-notification]").shouldBe(visible, Duration.ofSeconds(15));
        $(withText("Перепланировать")).click();
        $("[data-test-id=success-notification] .notification__title").shouldBe(hidden, Duration.ofSeconds(15));
    }
}