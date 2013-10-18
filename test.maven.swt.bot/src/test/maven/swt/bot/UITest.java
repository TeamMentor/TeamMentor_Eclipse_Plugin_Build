package test.maven.swt.bot;

import static org.junit.Assert.*;

import org.eclipse.swtbot.eclipse.finder.SWTEclipseBot;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
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
	}
	@Test
	public void SWTWorkbenchBot_OK() 
	{
		assertNotNull(bot);
	}
	@Test
	public void SWTWorkbenchBot_ActionShell_Text() 
	{
		
		SWTBotShell shell = bot.activeShell();
		
		String text = shell.getText();
		assertEquals("Java - Eclipse SDK", text);
		
		SWTBotShell[] shells = bot.shells();
		
		assertNotNull(shells);
	}
	
	public void SWTWorkbenchBot_ActionShell_OpenProject() 
	{
			
	}

}
