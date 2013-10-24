package test.maven.swt.bot;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.helpers.SWTBotHelper;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class OpenPluginProjectTest 
{
	public static SWTWorkbenchBot bot;
	public String projectPath; 
	
	@BeforeClass
	public final static void beforeClass() throws Exception 
	{				
		bot = new SWTWorkbenchBot();
		assertNotNull(bot);		
	}
	
	public OpenPluginProjectTest()
	{
		projectPath = System.getProperty("user.home") + "/Fortify-Plugin/TeamMentor_Eclipse_Plugin";
	}

	@Test
	public void Check_That_Project_Folder() 
	{		
		System.out.println("Project path: " + projectPath);
		boolean fileExists = new File(projectPath).exists();
		assertTrue("Could not find Folder: " + projectPath, fileExists);
	}
	@Test
	public void open_Plugin_Project() 
	{		
		bot.resetWorkbench();
		new SWTBotHelper(bot).openProject(projectPath, 3)
							 .addDummyTaskToWorkspace();//, "TeamMentor.Eclipse.PlugIn.Fortify");		
		
		bot.captureScreenshot("screenshots/open_Test_Project.jpeg");
		
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for(IProject project : projects)
			System.out.println("Current projects: " + project.getName());
	}

	
	//Load test project
	//@Ignore @Test
	public void open_Test_Project() 
	{		
		String projectPath = "/Users/zen/Fortify-Plugin/Eclipses/workspaces/test_proj";
				
		new SWTBotHelper(bot).openProject(projectPath,1)
							 .addDummyTaskToWorkspace();		
		

		bot.captureScreenshot("screenshots/open_Test_Project.jpeg");
	}

}
