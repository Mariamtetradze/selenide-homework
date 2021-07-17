import com.codeborne.selenide.*;
import com.codeborne.selenide.junit.SoftAsserts;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
public class SelenideBasics2Test {
    @Test
    public void collectionAssertion() {
        Configuration.startMaximized = true;
        open("https://demoqa.com/books");
        ElementsCollection list = $(".rt-tbody").$$(".rt-tr-group").filterBy(text("O'Reilly Media")).filterBy(text("JavaScript"));
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(list.size(), 10);
        //list.shouldHave(size(10));
         ElementsCollection imgList = $(".ReactTable").$(".rt-table").$(".rt-tbody").$$(".rt-tr-group .rt-td img");
         //isDisplayed()??
         for(int i=0; i<imgList.size(); i++) {
             if(imgList.get(i).isImage()) {
                 System.out.println("true");

             } else {
                 System.out.println("false");
             }
         }
        soft.assertAll();
    }

}
