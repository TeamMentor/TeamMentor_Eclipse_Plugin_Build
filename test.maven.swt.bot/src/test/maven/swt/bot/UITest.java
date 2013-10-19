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
		assertNotNull(text);
		//assertEquals("Java - Eclipse SDK", text); // its 'Resource - Eclipse Platform' when running from eclipse				
	}
	
	//@Test
	public void SWTWorkbenchBot_ActionShell_ClickOnMenu() 
	{
		//SWTBotPreferences.PLAYBACK_DELAY = 100;
		SWTBotMenu sampleMenu =  bot.menu("Sample Menu");
		SWTBotMenu sampleAction = sampleMenu.menu("Sample Action");
		assertNotNull(sampleMenu);
		assertNotNull(sampleAction);
		sampleAction.click();		
		SWTBotShell shell = bot.shell("Swt");
		assertNotNull(shell);
		shell.activate();
		SWTBotButton button =  shell.bot().button("OK");
		assertNotNull(button);
		button.click();		
	}
	

	@Test
	public void SWTWorkbenchBot_ActionShell_NewProject()  
	{
		bot.menu("File").menu("Project...").click();
		SWTBotShell shell = bot.shell("New Project");
		assertNotNull(shell);
		shell.activate();
		bot.tree().expandNode("General").select("Project");
		bot.button("Next >").click();
		bot.textWithLabel("Project name:").setText("SWTBot Test Project");
		bot.button("Finish").click();
		
	}	
}
