package test.maven.swt.bot;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.matchers.WidgetMatcherFactory;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
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
	
	@Test
	public void Check_that_ProjectExplorer_Is_Avaialble()
	{
		List<SWTBotView> views = bot.views(WidgetMatcherFactory.withPartName("Project Explorer"));
		assertNotNull(views);
		assertEquals(views.size(), 1);
	}
	@Test
	public void Test_Default_Views()
	{
		List<SWTBotView> views = bot.views();
		assertNotNull(views);
		assertTrue("There were no views in the current UI", views.size() > 0);
		System.out.println("*** CurrentViews (in Test_Default_Views)");
		for(SWTBotView view : views)
		{
			System.out.println(view.getTitle() + " :" + view.toString());
		}
		//return bot.views().collect { "\n" + it.getTitle()}
	}
}
