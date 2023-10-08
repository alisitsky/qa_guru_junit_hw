package com.alisitsky.tests;

import com.alisitsky.page.DemoQAMainPage;
import com.alisitsky.page.DemoQASectionPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Selenide.*;

public class DemoQAParametrizedTest extends TestBase{

    DemoQAMainPage demoqaMainPage = new DemoQAMainPage();
    DemoQASectionPage demoQASectionPage = new DemoQASectionPage();

    static Stream<String> elementsString() {
        return Stream.of("Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store");
    }

    @DisplayName("Проверка переходов с главной в разделы сайта")
    @ParameterizedTest(name = "Переход в раздел {0}")
    @MethodSource("elementsString")
    public void demoQASwitchingWebsitesSectionsTest(String sectionName){
        open("https://demoqa.com/");
        demoqaMainPage.openSection(sectionName);
        demoQASectionPage.checkSectionTitle(sectionName);
    }
}