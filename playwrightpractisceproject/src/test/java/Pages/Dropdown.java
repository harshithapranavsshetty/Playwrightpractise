package Pages;

import java.util.Collections;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Playwright playwrite=Playwright.create()){
			Browser browser=playwrite.chromium().launch(new BrowserType.LaunchOptions()
					.setHeadless(false).setArgs(Collections.singletonList("--set-Maximized")));
			BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
			Page page=context.newPage();
			page.navigate("https://demo.automationtesting.in/Alerts.html");
page.locator("li").filter(new Locator.FilterOptions().
				   setHasText("SwitchTo Alerts Windows Frames")).locator("i").click();
   page.waitForTimeout(5000);
//			   Locator multi_list_DD = page.locator("#header > nav > div > div.navbar-collapse.collapse.navbar-right > ul > li.dropdown.active > i");
//	            multi_list_DD.selectOption(new String[] {"Alerts","Windows","Frames"});
 List<ElementHandle> options = page.locator("#header > nav > div > div.navbar-collapse.collapse.navbar-right > ul > li.dropdown.active > ul")
		.elementHandles();
     for (ElementHandle option : options) {
               String option1 = option.innerText();
               page.waitForTimeout(5000);
             System.out.println(option1);
                if (option1.contains("Alert")) {
                    option.click();
                }
         }
     
    page.selectOption("#dropdown-toggle","SwitchTo");
    /*
    Selecting dropdown using page.locator().selectOption()
     */
    page.locator("dropdown-menu").selectOption("Alert");
		}
	}
}
