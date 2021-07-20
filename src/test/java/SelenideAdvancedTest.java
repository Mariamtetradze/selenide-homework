import com.codeborne.selenide.*;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.SoftAsserts;
import com.gargoylesoftware.htmlunit.javascript.host.Screen;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideAdvancedTest {
    @Test

    public void matchingTitles() {
        startMaximized=true;
        reportsFolder="src/main/resources/Reports";
        screenshots=true;
        savePageSource=false;

        Selenide.open("https://demoqa.com/books");

        ElementsCollection booksList = $(".rt-tbody").findAll(".rt-tr-group").filterBy(text("O'Reilly Media")).filterBy(text("JavaScript"));
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(booksList.size(), 10);

        SelenideElement firstMatch = booksList.first();
        Assert.assertTrue(firstMatch.has(text("Learning JavaScript Design Patterns")));

        booksList.stream().forEach(el -> {actions().moveToElement(el.scrollTo().$(".action-buttons")).keyDown(Keys.CONTROL).click().perform();
});

        soft.assertAll();
    }}
