package com.alisitsky.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DemoqaMainPage {

    ElementsCollection sectionCards = $$("div.card-body");
    SelenideElement sectionTitle = $("div.main-header");

    public DemoqaMainPage openSection(String sectionName) {
        sectionCards.findBy(text(sectionName)).scrollTo().click();
        return this;
    }
    public DemoqaMainPage checkSectionTitle(String sectionName) {
        sectionTitle.shouldHave(text(sectionName));
        return this;
    }
}
