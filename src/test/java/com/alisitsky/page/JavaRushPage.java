package com.alisitsky.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class JavaRushPage {

    SelenideElement siteHeader = $(".site-header__guest-nav"),
                    startButton = $(".start-button__label"),
                    cookieConsentButton = $("div.cookie-consent button.button--apply"),
                    langSwitchControl = $("button.language-switcher__control");
    ElementsCollection LangSwitchOptions = $$("a.language-switcher-item");


    public JavaRushPage checkButtonsLanguage(String reviewsNative, String aboutNative, String csNative, String beginNative) {
        siteHeader.shouldHave(text(reviewsNative))
                .shouldHave(text(aboutNative))
                .shouldHave(text(csNative));
        startButton.shouldHave(text(beginNative));
        return this;
    }

    public JavaRushPage changeLanguage(String language) {
        cookieConsentButton.click();
        langSwitchControl.scrollTo().click();
        LangSwitchOptions.findBy(text(language)).click();
        return this;
    }
}
