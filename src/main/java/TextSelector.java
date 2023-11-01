import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);

        Browser browser = playwright.chromium().launch(lp);

        //text locators
/*        Page page = browser.newPage();
        page.navigate("https:www.orangehrm.com/orangehrm-30-day-trial");
        page.locator("text=Contact Sales").last().click();*/

        Page page = browser.newPage();
        page.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
        String header = page.locator("div.card-body h2:has-text('New Customer')").textContent();
        System.out.println(header);

        page.locator("form button:has-text('Login')").click();

    }
}
