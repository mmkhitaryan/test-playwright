package org.example;

import com.microsoft.playwright.*;

import java.lang.annotation.ElementType;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://demoqa.com/automation-practice-form");

            Object borderColor = null;
            for (Locator element : page.locator("input").all()) {
                // getComputedStyle(document.querySelector("#userEmail")).getPropertyValue("border-color")
                // String ElementType = element.getAttribute("type");

                borderColor = element.first().evaluate("el => getComputedStyle(el).getPropertyValue(\"border-color\")");
                String test = (String) borderColor;

                switch (test) {
                    case ("rgb(40, 167, 69)"):
                        System.out.println("Gut");
                    case ("rgb(220, 53, 69)"):
                        System.out.println("Bad");
                    case ("rgb(51, 51, 51)"):
                        System.out.println("Neutral");
                    default:
                        System.out.println(test);
                }
            }
                
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }
}