package test.maven.swt.bot;

import static org.junit.Assert.*;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class OpenProjectsToBuild 
{

	protected static SWTWorkbenchBot bot;
	
	@BeforeClass
	public final static void beforeClass() throws Exception 
	{				
		bot = new SWTWorkbenchBot();
		assertNotNull(bot);		
	}
	@Test
	public void test() 
	{
		
	}

}
