package test.maven.swt.bot;

import static org.junit.Assert.*;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class UITest {

	protected static SWTWorkbenchBot bot;

	@BeforeClass
	public final static void beforeClass() throws Exception 
	{		
		System.out.println("*** UI TESTS Executed via Maven");
		bot = new SWTWorkbenchBot();
		assertNotNull(bot);
		try
		{
			bot.viewByTitle("Welcome").close();
		}
		catch(WidgetNotFoundException ex) {}
	}
	@Test
	public void did_we_get_here() 
	{
		assertTrue(true);
		bot.captureScreenshot("screenshots/did_we_get_here.jpeg");
	}
	@Test
	public void SWTWorkbenchBot_OK() 
	{
		assertNotNull(bot);
		bot.captureScreenshot("screenshots/SWTWorkbenchBot_OK.jpeg");
	}
}
