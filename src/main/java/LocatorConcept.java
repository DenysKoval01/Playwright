import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public class LocatorConcept {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.orangehrm.com/30-day-free-trial");

/*        Locator contactSales = page.locator("text = CONTACT SALES").last();
        contactSales.hover();
        contactSales.click();*/


        Locator countryOption = page.locator("select#Form_getForm_Country option");
        System.out.println(countryOption.count());
/*
        for (int i=0; i<countryOption.count();i++) {
            String text = countryOption.nth(i).textContent();
            System.out.println(text);
        }*/

        List<String> optTextList = countryOption.allTextContents();
        optTextList.forEach(System.out::println);
    }
}
