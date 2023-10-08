package com.alisitsky.page;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DemoQAMainPage {

    ElementsCollection sectionCards = $$("div.card-body");

    public DemoQAMainPage openSection(String sectionName) {
        sectionCards.findBy(text(sectionName)).scrollTo().click();
        return this;
    }
}
