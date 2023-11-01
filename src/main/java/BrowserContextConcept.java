import com.microsoft.playwright.*;

public class BrowserContextConcept {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);

        Browser browser = playwright.chromium().launch(lp);

        BrowserContext browserContext = browser.newContext();
        Page p1 = browserContext.newPage();
        p1.navigate("https:www.orangehrm.com/orangehrm-30-day-trial");
        p1.fill("#Form_getForm_Name","Denys");
        System.out.println(p1.title());

        BrowserContext browserContext1 = browser.newContext();
        Page p2 = browserContext1.newPage();
        p2.navigate("https:www.google.com/");
        p2.fill("#APjFqb","Ukraine");
        System.out.println(p2.title());

        browserContext.close();
        p1.close();

        browserContext1.close();
        p2.close();
    }
}
