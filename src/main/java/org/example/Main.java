package org.example;

import com.microsoft.playwright.*;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://demoqa.com/automation-practice-form");

            page.getByPlaceholder("First Name").fill("Marat");
            page.getByPlaceholder("Last Name").fill("Mkhitaryan");
            page.getByPlaceholder("name@example.com").fill("marat@mkhitaryan.pw");

            page.getByText("Male", new Page.GetByTextOptions().setExact(true)).click();




            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }
}