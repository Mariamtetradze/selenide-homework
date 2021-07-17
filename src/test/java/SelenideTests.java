import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {
    @Test
    public void checkBoxes() {
        Configuration.startMaximized = true;
        Selenide.open("http://the-internet.herokuapp.com/checkboxes");
        SelenideElement firstCheckBox = $("#checkboxes").$("input",0);
        SelenideElement secondCheckBox = $("#checkboxes").$("input",1);
        firstCheckBox.setSelected(true);
        firstCheckBox.shouldBe(Condition.checked);
        firstCheckBox.shouldHave(Condition.type("checkbox"));
        secondCheckBox.should(Condition.type("checkbox"));
    }

    @Test
    public void selectOption() {
        Configuration.startMaximized = true;
        Selenide.open("http://the-internet.herokuapp.com/dropdown");
        $("#dropdown").getSelectedOption().shouldHave(Condition.text("Please select an option"));
        $("#dropdown").selectOptionContainingText("Option 2");
        $("#dropdown").getSelectedOption().shouldHave(Condition.text("Option 2"));
    }

    @Test
    public void bookStoreTest() {
        Configuration.startMaximized = true;
        Selenide.open("https://demoqa.com/text-box");
        $("#userName").setValue("name");
        $("#userEmail-wrapper").$("input").setValue("test@gmail.com");
        $(byAttribute("placeholder", "Current Address")).setValue("current address");
        $("textarea", 1).setValue("perm address");
        $("#submit").scrollTo().click();
        $$("#output p").shouldHave(texts("name", "test@gmail.com","current address","perm address"));
        $$("#output p").shouldHave(size(4));

    }


}
