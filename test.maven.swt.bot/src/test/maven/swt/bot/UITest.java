package test.maven.swt.bot;

import static org.junit.Assert.*;

import org.eclipse.swtbot.eclipse.finder.SWTEclipseBot;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class UITest {

	@Test
	public void did_we_get_here() 
	{
		assertTrue(true);
	}
	@Test
	public void SWTWorkbenchBot_OK() 
	{
		
		SWTWorkbenchBot bot = new SWTWorkbenchBot();
		assertNotNull(bot);
		
	}
	@Test
	public void SWTWorkbenchBot_ActionShell_Text() 
	{
		
		SWTWorkbenchBot bot = new SWTWorkbenchBot();
		assertNotNull(bot);
		SWTBotShell shell = bot.activeShell();
		
		String text = shell.getText();
		assertEquals("Java - Eclipse SDK", text);
		
		SWTBotShell[] shells = bot.shells();
		
		assertNotNull(shells);
	}

}
