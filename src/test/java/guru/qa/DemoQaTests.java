package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTests {

    @BeforeAll
    static void preconditions() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTests() {
        open("/automation-practice-form");

        // удаление всплывающих окон
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        // тесты для Student Registration Form
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Test");

        $("#userEmail").setValue("test@yandex.ru");

        $(byText("Male")).click();

        $("#userNumber").setValue("8999111223");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $(byText("1")).click();

        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").sendKeys("C");
        $(byText("Computer Science")).click();

        $(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("test.png");

        $("#currentAddress").setValue("city Test, street Test, apartment 123");

        $("#state").click();
        $(byText("Rajasthan")).click();

        $("#city").click();
        $(byText("Jaiselmer")).click();

        $("#submit").click();

        $(".modal-content").shouldHave(
                text("Test Test"),
                text("test@yandex.ru"),
                text("Male"),
                text("8999111223"),
                text("01 January,2000"),
                text("Computer science"),
                text("Sports"),
                text("test.png"),
                text("city Test, street Test, apartment 123"),
                text("Rajasthan Jaiselmer")
        );
    }

}
