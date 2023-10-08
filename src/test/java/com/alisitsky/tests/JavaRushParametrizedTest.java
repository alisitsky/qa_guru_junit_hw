package com.alisitsky.tests;

import com.alisitsky.page.JavaRushPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.codeborne.selenide.Selenide.*;

public class JavaRushParametrizedTest extends TestBase {

    JavaRushPage javarushPage = new JavaRushPage();

    @CsvFileSource(resources = "/javaRushChangeLanguageTest.csv")
    @ParameterizedTest(name = "Смена языка на {5}")
    public void javaRushChangeLanguageTest(String url,
                                           String reviewsNative,
                                           String aboutNative,
                                           String csNative,
                                           String beginNative,
                                           String language,
                                           String reviewsChanged,
                                           String aboutChanged,
                                           String csChanged,
                                           String beginChanged) {
        open(url);
        javarushPage.checkButtonsLanguage(reviewsNative, aboutNative, csNative, beginNative)
                .changeLanguage(language)
                .checkButtonsLanguage(reviewsChanged, aboutChanged, csChanged, beginChanged);
        WebDriverRunner.clearBrowserCache();
    }
}