package com.alisitsky.tests;

import com.alisitsky.page.TextBoxPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TextBoxParametrizedTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @CsvSource(value = {
            "Vasya Vasyok |  vasya@vasiliy.ru  | Moscow  | Tula",
            "Иван Иваныч  |  ivan@ivanich.com  | Москва  | Тула"
    },
            delimiter = '|')

    @DisplayName("Проверка заполнения формы")
    @ParameterizedTest
    public void fillFormTest(String userName, String userEmail, String currentAddress, String permanentAddress){

        textBoxPage.openPage()
                .checkMainHeaderHasText("Text Box")
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmitButton()

                .checkOutputVisibility()
                .checkOutputHasName(userName)
                .checkOutputHasEmail(userEmail)
                .checkOutputHasCurrentAddress(currentAddress)
                .checkOutputHasPermanentAddress(permanentAddress);
    }
}