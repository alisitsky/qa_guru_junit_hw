package com.alisitsky.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DemoQASectionPage {

    SelenideElement sectionTitle = $("div.main-header");


    public DemoQASectionPage checkSectionTitle(String sectionName) {
        sectionTitle.shouldHave(text(sectionName));
        return this;
    }
}
