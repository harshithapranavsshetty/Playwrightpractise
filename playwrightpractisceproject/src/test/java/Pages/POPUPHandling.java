package Pages;

import java.util.Collections;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class POPUPHandling {
	public static void main(String[] args) {
		

		
		// TODO Auto-generated method stub
		try(Playwright playwrite=Playwright.create()){
			Browser browser=playwrite.chromium().launch(new BrowserType.LaunchOptions()
					.setHeadless(false).setArgs(Collections.singletonList("--set-Maximized")));
			BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
			Page page=context.newPage();
			page.navigate("https://demo.automationtesting.in/Alerts.html");
			 page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Alert with Textbox")).click();
			 page.waitForTimeout(5000);
			 page.onDialog(dialog -> {
				 System.out.println(dialog.message());
	                dialog.accept("Hi");
			 });
	                page.waitForTimeout(5000);
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
		    		  .setName("click the button to demonstrate the prompt box ")).click();
		      page.waitForTimeout(5000);

}
}



}
